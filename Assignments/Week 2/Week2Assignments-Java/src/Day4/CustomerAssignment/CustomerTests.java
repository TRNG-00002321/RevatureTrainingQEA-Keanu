package Day4.CustomerAssignment;

public class CustomerTests {

    public void main(){
        Customer c1 = new Customer("John");
        Customer c2 = new Customer("Joe", 1010);

        c1.CompleteOrder();
        c2.CompleteOrder(true);
    }
}
