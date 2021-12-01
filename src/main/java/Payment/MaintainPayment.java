package Payment;

import Movies.MaintainMovie;
import OrderMaintainance.MaintainOrder;
import OrderMaintainance.Order;
import UserMaintainance.Login;
import UserMaintainance.MaintainUser;


public class MaintainPayment {
    private String moviePath, orderPath;
    private Login login;
    private MaintainOrder maintainOrder;
    private MaintainMovie maintainMovie;
    private MaintainUser maintainUser;

    public MaintainPayment(String moviePath, String orderPath, String userPath, Login login) {
        this.login = login;
        maintainMovie = new MaintainMovie(moviePath);
        maintainOrder = new MaintainOrder(orderPath);
        maintainUser = new MaintainUser(userPath);
    }


    public boolean processPayment(Order order, String paymentMethod) throws Exception {


//        if (paymentMethod.equals("Loyalty Points")) {
//            maintainOrder.addOrderCart(order);
//            maintainOrder.payWithPoints(order);
//            maintainOrder.addProvinceCharge(order);
//            maintainOrder.incrementPoint(order);
//            maintainMovie.changeCopiesAfterRemove(order);
//            return true;
//        }

        if (paymentMethod.equals("Visa")) {
            maintainUser.readDatabase();
//            maintainMovie.readDatabaseList();

            maintainOrder.addOrderCart(order);
            maintainOrder.addProvinceCharge(order);
            maintainOrder.incrementPoint(order);
            maintainMovie.changeCopiesAfterRemove(order);
            return true;
        }
        return false;
    }

}


