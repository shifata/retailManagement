package Payment;

import OrderMaintainance.MaintainOrder;
import OrderMaintainance.Order;
import UserMaintainance.Login;


public class MaintainPayment {
    private String path;
    private Login login;
    private MaintainOrder maintainOrder;

    public MaintainPayment(String path, Login login) {
        this.path = path;
        this.login = login;
        maintainOrder = new MaintainOrder(path);
    }

    public boolean processPayment(Order order, String paymentMethod) {

        if (paymentMethod.equals("Loyalty Points")) {

        }

        if (paymentMethod.equals(paymentMethod)) {
            maintainOrder.addOrderCart(order);
            System.out.println();
            System.out.println("Done");
        }

        return false;
    }



}
