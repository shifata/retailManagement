package gui;

import Movies.MaintainMovie;
import OrderMaintainance.MaintainOrder;
import OrderMaintainance.Order;
import UserMaintainance.Login;
import Utils.Messages;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderHistory {

    private Login login;
    private MaintainOrder maintainOrder;
    private MaintainMovie maintainMovie;
    private final String path = "../project/src/main/java/database/orders.csv";
    private JFrame frame;
    private JButton cancelPlacedOrderButton;
    private JTable table;
    private Object[][] data;


    OrderHistory(Login login) {
        this.login = login;
        ImageIcon image5 = new ImageIcon("../project/src/main/resources/images/orderHistory.png");
        maintainMovie = new MaintainMovie("../project/src/main/java/database/movies.csv");
        frame = new JFrame("Order History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1800);

        JLabel loggedinAsLabel = new JLabel("LOGGED IN AS:" + "  " + login.getUName());
        loggedinAsLabel.setForeground(Color.white);
        loggedinAsLabel.setFont(new Font("Arial", 22, 22));
        loggedinAsLabel.setBounds(0, 0, 400, 200);

        JPanel orderCaptionPanel = new JPanel();
        orderCaptionPanel.setBackground(Color.BLACK);
        orderCaptionPanel.setBounds(0, 0, 1800, 200);
        orderCaptionPanel.add(loggedinAsLabel);


        JPanel orderHistoryTablePanel = new JPanel();
        orderHistoryTablePanel.setBackground(Color.lightGray);
        orderHistoryTablePanel.setBounds(0, 200, 1800, 800);

        JLabel orderHistoryImageLabel = new JLabel();
        orderHistoryImageLabel.setIcon(image5);
        orderHistoryImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        orderHistoryImageLabel.setVerticalTextPosition(JLabel.TOP);
        orderHistoryImageLabel.setForeground(Color.white);
        orderHistoryImageLabel.setIconTextGap(15);
        orderHistoryImageLabel.setBackground(Color.black);
        orderHistoryImageLabel.setOpaque(true);

        JLabel orderHistoryLabel = new JLabel("ORDER HISTORY");
        orderHistoryLabel.setBounds(0, 400, 400, 200);
        orderHistoryLabel.setFont(new Font("Arial", 20, 24));

        JButton logOutButton = new JButton("Log Out");
        logOutButton.setBounds(800, 100, 100, 25);
        logOutButton.addActionListener(logOutListener);

        JButton backButton = new JButton("Back");
        backButton.setBounds(1100, 140, 100, 25);
        backButton.addActionListener(backListener);

        cancelPlacedOrderButton = new JButton("CANCEL ORDER");
        backButton.setBounds(1100, 140, 100, 25);
        cancelPlacedOrderButton.addActionListener(cancelListener);

        maintainOrder = new MaintainOrder(path);
        Object[][] data = null;

        try {
            data = maintainOrder.getUserOrders(login.getUName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] columns = {"Order ID", "Order Type", "Order Placed", "Order Delivery Date", "Shipping Address", "Order Status", "Movie", "Username"};


        table = new JTable(data, columns);
        table.setPreferredScrollableViewportSize(new Dimension(1700, 600));
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
        table.setBounds(20, 600, 1700, 200);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);

        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(620);
        table.getColumnModel().getColumn(7).setPreferredWidth(20);

//        table.setAlignmentX(20);
//        table.setAlignmentY(900);

        orderHistoryTablePanel.add(new JScrollPane(table));
        orderHistoryTablePanel.add(cancelPlacedOrderButton);
        //table.setLayout(null);
//        orderHistoryTablePanel.add(table);
        orderCaptionPanel.add(logOutButton);
        orderCaptionPanel.add(backButton);
//        orderHistoryTablePanel.setLayout(null);
        orderCaptionPanel.add(orderHistoryLabel);
        orderCaptionPanel.add(orderHistoryImageLabel);
        frame.add(orderCaptionPanel);
        frame.add(orderHistoryTablePanel);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    private ActionListener cancelListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Order> tmp = new ArrayList<>();
            int row = table.getSelectedRow();
            String id = table.getValueAt(row, 0).toString();
            Order o = MaintainOrder.getOrderFromId(id);
            System.out.println(o);
            try {
                tmp = maintainOrder.getUserOrdersList(login.getUName());
                System.out.println("Cart size before remove: " + tmp.size());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            tmp.remove(o);
            System.out.println("Cart size after remove: " + tmp.size());
            data = new Object[tmp.size()][10];
            try {
                if (o.getStatus().equals("Placed")) {
                    maintainOrder.removeOrder(o);
                    maintainMovie.changeCopiesAfterRemove(o, true);

                    for (int i = 0; i < tmp.size(); i++) {
                        Order order = tmp.get(i);
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
                    frame.dispose();
                    OrderHistory orderHistory = new OrderHistory(login);
                    Messages.customMsgGreen("Order Removed");

                } else {
                    Messages.customMsg("Order is delivered");
                }
                System.out.println("HIIIT");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    };

    private ActionListener backListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            MoviesDisplayPage moviesDisplayPage = new MoviesDisplayPage(login);
        }
    };

    private ActionListener logOutListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            LoginPage lp = new LoginPage();
        }
    };
}
