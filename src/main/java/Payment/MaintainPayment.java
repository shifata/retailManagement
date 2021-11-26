package Payment;

import Movies.Movie;
import OrderMaintainance.MaintainOrder;
import OrderMaintainance.Order;
import UserMaintainance.Login;

import java.util.ArrayList;

public class MaintainPayment {
    private String path = "";
    private Login login;
    private MaintainOrder maintainOrder;

    public MaintainPayment(String path, Login login) {
        this.path = path;
        maintainOrder = new MaintainOrder(path);
        this.login = login;
    }

    public boolean processPayment(Order order, String paymentMethod) {

        if (paymentMethod.equals("Loyalty Points")) {

        }

        if (paymentMethod.equals("Visa")) {
            maintainOrder.addOrder(order);
            System.out.println("Done");
        }

        return false;
    }


}
