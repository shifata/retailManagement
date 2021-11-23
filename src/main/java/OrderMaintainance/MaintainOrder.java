package OrderMaintainance;

import com.csvreader.CsvReader;

import java.io.FileReader;
import java.util.ArrayList;

public class MaintainOrder {
    private String path;
    private ArrayList<Order> orders;

    public MaintainOrder(String path) {
        this.path = path;
        this.orders = new ArrayList<>();
    }

    public Object[][] getUserOrders(String uname) throws Exception {
        ArrayList<Order> allOrders = null, userOrders;
        userOrders = new ArrayList<>();

        try {
            allOrders = readDatabaseList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Order o : allOrders) {
            if (o.getUname().equals(uname)) {
                userOrders.add(o);
            }
        }

        Object[][] data = new Object[userOrders.size()][8];
        for (int i = 0; i < userOrders.size(); i++) {
            Order order = userOrders.get(i);
            data[i][0] = order.getOrderId();
            data[i][1] = order.getOrderType();
            data[i][2] = order.getOrderDate();
            data[i][3] = order.getDeliveryDate();
            data[i][4] = order.getAddress();
            data[i][5] = order.getStatus();
            data[i][6] = order.getTitle();
            data[i][7] = order.getUname();
        }

        return data;
    }

    public Object[][] readDatabase() throws Exception {
        ArrayList<Order> list = null;

        try {
            list = readDatabaseList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[list.size()][8];

        for (int i = 0; i < list.size(); i++) {
            Order order = list.get(i);

            data[i][0] = order.getOrderId();
            data[i][1] = order.getOrderType();
            data[i][2] = order.getOrderDate();
            data[i][3] = order.getDeliveryDate();
            data[i][4] = order.getAddress();
            data[i][5] = order.getStatus();
            data[i][6] = order.getTitle();
            data[i][7] = order.getUname();
        }

        return data;
    }

    private ArrayList<Order> readDatabaseList() throws Exception {
        FileReader fileReader = new FileReader(path);
        CsvReader csvReader = new CsvReader(fileReader);

        try {
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                String orderId = csvReader.get("OrderID");
                String orderType = csvReader.get("OrderType");
                String orderDate = csvReader.get("OrderPlacedDate");
                String deliveryDate = csvReader.get("OrderDeliveryDate");
                String address = csvReader.get("ShippingAddress");
                String status = csvReader.get("OrderStatus");
                String movies = csvReader.get("MovieTitle");
                String uname = csvReader.get("Uname");
                Order order = new Order(orderId, orderType, orderDate, deliveryDate,
                        address, status, movies, uname);
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        csvReader.close();
        return orders;
    }
}
