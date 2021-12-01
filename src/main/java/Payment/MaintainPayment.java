package Payment;

import Movies.MaintainMovie;
import OrderMaintainance.MaintainOrder;
import OrderMaintainance.Order;
import UserMaintainance.Login;


public class MaintainPayment {
    private String moviePath, orderPath;
    private Login login;
    private MaintainOrder maintainOrder;
    private MaintainMovie maintainMovie;

    public MaintainPayment(String moviePath, String orderPath, Login login) {
        this.moviePath = moviePath;
        this.orderPath = orderPath;
        this.login = login;
        maintainMovie = new MaintainMovie(moviePath);
        maintainOrder = new MaintainOrder(orderPath);
    }

    public boolean processPayment(Order order, String paymentMethod) {

        if (paymentMethod.equals("Loyalty Points")) {
            maintainOrder.payWithPoints(order);
            maintainOrder.incrementPoint(order);
            maintainOrder.addOrderCart(order);
        }

        if (paymentMethod.equals("Visa")) {
            maintainOrder.addOrderCart(order);
            maintainOrder.incrementPoint(order);
            try {
                maintainMovie.changeCopiesAfterRemove(order);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Done");

        }

        return false;
    }


}
