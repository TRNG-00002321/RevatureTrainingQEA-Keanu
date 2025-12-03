package com.revature.expense.dao;

import com.revature.expense.model.Expenses;
import com.revature.expense.util.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExpensesImpl implements ExpensesDAO{
    //Get singleton connection utility class
    private final ConnectionUtil connectionUtil = ConnectionUtil.getInstance();
    private final Logger logger = LoggerFactory.getLogger(ExpensesImpl.class);

    @Override
    public List<Expenses> getPendingExpenses(){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Expenses> expensesList = new ArrayList<>();

        //Get connection to database
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensesDB", "root", "ppp444")){

            //SELECT query to get pending expenses data
            String query = "SELECT expenses.id, expenses.user_id, amount, description, expenses.date " +
                    "FROM expenses " +
                    "JOIN approvals " +
                    "ON expenses.id = approvals.expense_id " +
                    "WHERE approvals.status LIKE 'pending'";

            //execute prepared statement
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            //adds results to expenses list
            while(resultSet.next()){
                expensesList.add(new Expenses(resultSet.getInt("id"), resultSet.getInt("user_id"), resultSet.getDouble("amount"),
                                resultSet.getString("description"), resultSet.getObject("date", LocalDateTime.class)));
            }

            logger.info("Expenses found");
        }catch (SQLException e){
            logger.error("No expenses found:{}", e.getMessage());
        }

        //return list of expenses
        return expensesList;
    }

    @Override
    public boolean denyExpense(int expense_id, int manager_id, String comment){
        PreparedStatement preparedStatement = null;

        //connect to database
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensesDB", "root", "ppp444")){
            //query to update expense
            String query = "UPDATE approvals SET status = ?, reviewer = ?, comment = ?, review_date = ? " +
                           "WHERE expense_id = ?";

            preparedStatement = conn.prepareStatement(query);

            //set prepared statement values
            preparedStatement.setString(1, "denied");
            preparedStatement.setInt(2, manager_id);
            preparedStatement.setString(3, comment);
            preparedStatement.setObject(4, LocalDateTime.now());
            preparedStatement.setInt(5, expense_id);

            //execute query
            if(preparedStatement.executeUpdate() != 0){
                logger.info("Denied expense:{}", expense_id);
                return true;
            }
            else{
                logger.info("No expenses updated with ID:{}", expense_id);
                return false;
            }
        }catch (SQLException e){
            logger.error("Deny expense failed:{}", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean approveExpense(int expense_id, int manager_id, String comment){
        PreparedStatement preparedStatement = null;

        //connect to database
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensesDB", "root", "ppp444")){
            //query to update expense
            String query = "UPDATE approvals SET status = ?, reviewer = ?, comment = ?, review_date = ? " +
                    "WHERE expense_id = ?";

            preparedStatement = conn.prepareStatement(query);

            //set prepared statement values
            preparedStatement.setString(1, "approved");
            preparedStatement.setInt(2, manager_id);
            preparedStatement.setString(3, comment);
            preparedStatement.setObject(4, LocalDateTime.now());
            preparedStatement.setInt(5, expense_id);

            //execute query
            if(preparedStatement.executeUpdate() != 0){
                logger.info("Approved expense:{}", expense_id);
                return true;
            }
            else{
                //noinspection LoggingSimilarMessage
                logger.info("No expenses updated with ID:{}", expense_id);
                return false;
            }
        }
        catch (SQLException e){
            logger.error("Approve expense failed:{}", e.getMessage());
            return false;
        }
    }

    @Override
    public List<Expenses> getExpensesReport() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Expenses> expensesList = new ArrayList<>();

        //Get connection to database
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensesDB", "root", "ppp444")){

            //SELECT query to get pending expenses data
            String query = "SELECT expenses.id, expenses.user_id, amount, description, expenses.date, approvals.status " +
                    "FROM expenses " +
                    "JOIN approvals " +
                    "ON expenses.id = approvals.expense_id " +
                    "ORDER BY expenses.amount DESC";

            //execute prepared statement
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            //adds results to expenses list
            while(resultSet.next()){
                expensesList.add(new Expenses(resultSet.getInt("id"), resultSet.getInt("user_id"), resultSet.getDouble("amount"),
                        resultSet.getString("description"), resultSet.getObject("date", LocalDateTime.class),
                        resultSet.getString("status")));
            }

            logger.info("Expenses Report query successful");
        }catch (SQLException e){
            logger.error("No expenses found in ExpensesReport:{}", e.getMessage());
        }

        //return list of expenses
        return expensesList;
    }
}
