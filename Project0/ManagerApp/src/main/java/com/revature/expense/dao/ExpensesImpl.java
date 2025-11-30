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
    private static final ConnectionUtil connectionUtil = ConnectionUtil.getInstance();
    private final Logger logger = LoggerFactory.getLogger(ExpensesImpl.class);

    @Override
    public List<Expenses> getPendingExpenses(){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Expenses> expensesList = new ArrayList<>();

        try(Connection conn = connectionUtil.getConnection()){
            String query = "SELECT expenses.id, amount, description, expenses.date " +
                    "FROM expenses " +
                    "JOIN approvals " +
                    "ON expenses.id = approvals.expense_id " +
                    "WHERE approvals.status LIKE 'pending'";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                expensesList.add(new Expenses(resultSet.getInt("id"), resultSet.getDouble("amount"),
                                resultSet.getString("description"), resultSet.getObject("date", LocalDateTime.class)));
            }

            logger.info("Expenses found");
        }catch (SQLException e){
            logger.error("No expenses found:{}", e.getMessage());
        }

        return expensesList;
    }

    @Override
    public void denyExpense(int expense_id, int manager_id, String comment){
        PreparedStatement preparedStatement = null;

        try(Connection conn = connectionUtil.getConnection()){
            String query = "UPDATE approvals SET status = ?, reviewer = ?, comment = ?, review_date = ? " +
                           "WHERE expense_id = ?";

            preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, "denied");
            preparedStatement.setInt(2, manager_id);
            preparedStatement.setString(3, comment);
            preparedStatement.setObject(4, LocalDateTime.now());
            preparedStatement.setInt(5, expense_id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("Denied expense:{}", expense_id);
        }catch (SQLException e){
            logger.error("Deny expense failed:{}", e.getMessage());
        }
    }

    @Override
    public void approveExpense(int expense_id, int manager_id, String comment){
        PreparedStatement preparedStatement = null;

        try(Connection conn = connectionUtil.getConnection()){
            String query = "UPDATE approvals SET status = ?, reviewer = ?, comment = ?, review_date = ? " +
                    "WHERE expense_id = ?";

            preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, "approved");
            preparedStatement.setInt(2, manager_id);
            preparedStatement.setString(3, comment);
            preparedStatement.setObject(4, LocalDateTime.now());
            preparedStatement.setInt(5, expense_id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("Approved expense:{}", expense_id);
        }catch (SQLException e){
            logger.error("Approve expense failed:{}", e.getMessage());
        }
    }
}
