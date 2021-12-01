package gui;

import Movies.Movie;
import UserMaintainance.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckOutPage {
    JButton proceedToPaymentButton;
    JFrame frame;
    private Login login;
    private ArrayList<Movie> cart;

    CheckOutPage(Login login) {
        this.login = login;
        cart = MoviesDisplayPage.getCart();

        frame = new JFrame("Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1800);

        ImageIcon image4 = new ImageIcon("../project/src/main/resources/images/checkout.png");

        JPanel cartCaptionPanel = new JPanel();
        cartCaptionPanel.setBackground(Color.CYAN);
        cartCaptionPanel.setBounds(0, 0, 1800, 280);

//        JPanel priceLabelPanel = new JPanel();
//        priceLabelPanel.setBackground(Color.yellow);
//        priceLabelPanel.setBounds(0,1300,50,50);

//        priceLabelPanel.setLayout(null);

        JLabel cartImageLabel = new JLabel();
        cartImageLabel.setIcon(image4);
        cartImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        cartImageLabel.setVerticalTextPosition(JLabel.TOP);
        cartImageLabel.setForeground(Color.white);
        cartImageLabel.setIconTextGap(15);
        cartImageLabel.setBackground(Color.black);
        cartImageLabel.setOpaque(true);

        JLabel priceLabel = new JLabel("Total: $" + (cart.size() * 10));
//        priceLabel.setBackground(Color.green);
        priceLabel.setBounds(1500, 5, 400, 100);
        priceLabel.setFont(new Font("Arial", 24, 24));
        priceLabel.setForeground(Color.black);
//        priceLabelPanel.add(priceLabel);


        JLabel checkOutLabel = new JLabel("CHECK OUT");
        checkOutLabel.setBackground(Color.black);
        checkOutLabel.setFont(new Font("Arial", 20, 28));
        checkOutLabel.setBounds(800, 300, 400, 200);

        JPanel table2Panel = new JPanel();
        table2Panel.setBackground(Color.gray);
        table2Panel.setBounds(0, 280, 1800, 540);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK);
        buttonPanel.setBounds(0, 800, 1800, 220);
        buttonPanel.add(priceLabel);
        buttonPanel.setLayout(null);

        JButton logOutButton = new JButton("Log Out");
        logOutButton.setBounds(800, 40, 100, 25);
        logOutButton.addActionListener(logOutListener);

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(1100, 40, 100, 25);

        JButton backButton = new JButton("Back");
        backButton.setBounds(800, 40, 100, 25);
        backButton.addActionListener(backListener);

        proceedToPaymentButton = new JButton("Proceed To Payment");
        proceedToPaymentButton.setBounds(900, 40, 200, 25);
        proceedToPaymentButton.addActionListener(paymentListener);

        buttonPanel.add(removeButton);
        buttonPanel.add(backButton);
        buttonPanel.add(proceedToPaymentButton);
        cartCaptionPanel.add(logOutButton);

        String[] columns = {"Name", "Price"};
        Object[][] data = new Object[cart.size()][2];

        for (int i = 0; i < cart.size(); i++) {
            data[i][0] = cart.get(i).getTitle();
            data[i][1] = "$10.00";
        }

        JTable table = new JTable(data, columns);
        table.setPreferredScrollableViewportSize(new Dimension(1700, 500));
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);

        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.setBounds(0, 100, 1700, 200);
        //table2Panel.setLayout(null);
        //cartCaptionPanel.setLayout(null);

        //table2Panel.add(priceLabel);
        table2Panel.add(new JScrollPane(table));
        //table2Panel.add(table);
        cartCaptionPanel.add(checkOutLabel);
        cartCaptionPanel.add(cartImageLabel);
        frame.add(cartCaptionPanel);
        frame.add(table2Panel);
//        frame.add(priceLabelPanel);
        frame.add(buttonPanel);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    private ActionListener paymentListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            PaymentPage payment = new PaymentPage(login);
            frame.dispose();

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
