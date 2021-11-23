package gui;

import OrderMaintainance.MaintainOrder;
import OrderMaintainance.Order;
import UserMaintainance.Login;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrderHistory {

    private Login login;
    private MaintainOrder maintainOrder;
    private final String path = "../project/src/main/java/database/orders.csv";


    OrderHistory(Login login) {
        this.login = login;
        ImageIcon image5 = new ImageIcon("../project/src/main/resources/images/orderHistory.png");

        JFrame frame = new JFrame("Order History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1800);

        JPanel orderCaptionPanel = new JPanel();
        orderCaptionPanel.setBackground(Color.CYAN);
        orderCaptionPanel.setBounds(0, 0, 1800, 200);

        JPanel orderHistoryTablePanel = new JPanel();
        orderHistoryTablePanel.setBackground(Color.yellow);
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

        JButton backButton = new JButton("Back");
        backButton.setBounds(1100, 140, 100, 25);

        JButton cancelPlacedOrderButton = new JButton("CANCEL ORDER");
        backButton.setBounds(1100, 140, 100, 25);

        maintainOrder = new MaintainOrder(path);
        Object[][] data = null;

        try {
            data = maintainOrder.getUserOrders(login.getUName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] columns = {"Order ID", "Order Type", "Order Placed", "Order Delivery Date", "Shipping Address", "Order Status", "Movie", "Username"};


        JTable table = new JTable(data, columns);
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



//    OrderHistory(Login login) {
//        this.login = login;
//
//        JFrame frame = new JFrame("Order History");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(1800, 1800);
//
//        JPanel orderCaptionPanel = new JPanel();
//        orderCaptionPanel.setBackground(Color.CYAN);
//        orderCaptionPanel.setBounds(0, 600, 200, 200);
//
//
//        JPanel orderHistoryTablePanel = new JPanel();
//        orderHistoryTablePanel.setBackground(Color.yellow);
//        orderHistoryTablePanel.setBounds(0, 800, 400, 300);
//
//        frame.add(orderHistoryTablePanel);
//        frame.add(orderCaptionPanel);
//        frame.setLayout(null);
//        frame.setVisible(true); //***always leave setVisible at the end of the class***
//
//
//    }
}
