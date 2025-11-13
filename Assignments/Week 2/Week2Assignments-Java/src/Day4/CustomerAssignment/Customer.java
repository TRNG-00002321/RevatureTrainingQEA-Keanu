package Day4.CustomerAssignment;

public class Customer {

    String name;
    int order_id;
    boolean order_complete = false;
    static int total_orders = 0;
    final String store = "Costco";

    public Customer(String name, int order_id)
    {
        this.name = name;
        this.order_id = order_id;
        total_orders++;
    }

    public Customer(String name){
        this.name = name;
        total_orders++;
        this.order_id = total_orders + 1000;
    }

    public void CompleteOrder(){
        this.order_complete = true;
    }

    public void CompleteOrder(boolean decrease_orders){
        this.order_complete = true;

        if(decrease_orders){
            total_orders--;
        }
    }
}
