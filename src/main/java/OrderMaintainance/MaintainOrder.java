package OrderMaintainance;

import Utils.IdGenerator;
import Utils.Sorter;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MaintainOrder {
    private String path;
    private ArrayList<Order> ordersList;

    public MaintainOrder(String path) {
        this.path = path;
        this.ordersList = new ArrayList<>();
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
            data[i][6] = order.getMovies();
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
        Object[][] data = new Object[list.size()][10];

        for (int i = 0; i < list.size(); i++) {
            Order order = list.get(i);

            data[i][0] = order.getOrderId();
            data[i][1] = order.getOrderType();
            data[i][2] = order.getOrderDate();
            data[i][3] = order.getDeliveryDate();
            data[i][4] = order.getAddress();
            data[i][5] = order.getStatus();
            data[i][6] = order.getMovies();
            data[i][7] = order.getUname();
            data[i][8] = order.getMovieId();
            data[i][9] = order.getProvince();
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
                String movieID = csvReader.get("movieID");
                String province = csvReader.get("Province");
                Order order = new Order(orderId, orderType, orderDate, deliveryDate,
                        address, status, movies, uname, movieID, province);
                ordersList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        csvReader.close();
        return ordersList;
    }

    public boolean writeToOrder() throws Exception {
        CsvWriter writer = new CsvWriter(new FileWriter(path, false), ',');
        try {
            writer.write("OrderID");
            writer.write("OrderType");
            writer.write("OrderPlacedDate");
            writer.write("OrderDeliveryDate");
            writer.write("ShippingAddress");
            writer.write("OrderStatus");
            writer.write("MovieTitle");
            writer.write("Uname");
            writer.write("movieID");
            writer.write("Province");
            writer.endRecord();
            writer.flush();

            Sorter.sortOrdersById(ordersList);

            for (Order o : ordersList) {
                writer.write(o.getOrderId());
                writer.write(o.getOrderType());
                writer.write(o.getOrderDate());
                writer.write(o.getDeliveryDate());
                writer.write(o.getAddress());
                writer.write(o.getStatus());
                writer.write(o.getMovies());
                writer.write(o.getUname());
                writer.write(o.getMovieId());
                writer.write(o.getProvince());
                writer.endRecord();
                writer.flush();
            }
            writer.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean writeToOrderCart() throws Exception {
        CsvWriter writer = new CsvWriter(new FileWriter(path, true), ',');
        try {
            Sorter.sortOrdersById(ordersList);

            for (Order o : ordersList) {
                writer.write(o.getOrderId());
                writer.write(o.getOrderType());
                writer.write(o.getOrderDate());
                writer.write(o.getDeliveryDate());
                writer.write(o.getAddress());
                writer.write(o.getStatus());
                writer.write(o.getMovies());
                writer.write(o.getUname());
                writer.write(o.getMovieId());
                writer.write(o.getProvince());
                writer.endRecord();
                writer.flush();
            }
            writer.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addOrder(Order order) {
        try {
            order.setOrderId(IdGenerator.getId(5));
            ordersList.add(order);
            writeToOrder();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addOrderCart(Order order) {
        try {
            order.setOrderId(IdGenerator.getId(5));
            ordersList.add(order);
            writeToOrderCart();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeOrder(Order o) throws Exception {
        boolean exists = orderExists(o);

        if (exists) {
            int index = getOrderIndex(o);
            ordersList.remove(index);
            writeToOrder();
            return true;
        }

        return false;
    }

    public boolean updateOrder(Order o) throws Exception {
        boolean exists = orderExists(o);

        if (exists) {
            for (int i = 0; i < ordersList.size(); i++) {
                if (ordersList.get(i).getOrderId().equals(o.getOrderId())) {
                    ordersList.remove(i);
                }
            }
            ordersList.add(o);
            writeToOrder();
            return true;
        }
        return false;
    }

    private boolean orderExists(Order order) {
        for (Order o : ordersList) {
            if (o.getOrderId().equals(order.getOrderId())) {
                return true;
            }
        }
        return false;
    }

    private int getOrderIndex(Order order) {
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).equals(order)) {
                return i;
            }
        }
        return -1;
    }


}
