package gui;

import Movies.Movie;
import OrderMaintainance.Order;
import Payment.MaintainPayment;
import UserMaintainance.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaymentPage {

    JButton CancelButton;
    JFrame frame;
    private Login login;
    private JButton confirmPaymentButton;
    private JComboBox paymentCombo;
    private Order order;
    final String[] paymentType = {"Visa", "MasterCard", "PayPal", "Loyalty Points"};
    private MaintainPayment maintainPayment;
    final String orderPath = "../project/src/main/java/database/orders.csv";
    final String moviePath = "../project/src/main/java/database/movies.csv";
    final String userPath = "../project/src/main/java/database/users.csv";

    PaymentPage(Login login) {
        order = MoviesDisplayPage.getOrderFromCart();
        maintainPayment = new MaintainPayment(moviePath, orderPath, userPath, login);

        ImageIcon image6 = new ImageIcon("../project/src/main/resources/images/card.png");

        frame = new JFrame("Payment Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel cardImagePanel = new JPanel();
        cardImagePanel.setBackground(Color.DARK_GRAY);
        cardImagePanel.setBounds(0, 0, 800, 160);

        JPanel paymentInfoPanel = new JPanel();
        paymentInfoPanel.setBackground(Color.gray);
        paymentInfoPanel.setBounds(0, 160, 800, 600);

        JLabel paymentImageLabel = new JLabel();
        paymentImageLabel.setIcon(image6);
        paymentImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        paymentImageLabel.setVerticalTextPosition(JLabel.TOP);
        paymentImageLabel.setForeground(Color.white);
        paymentImageLabel.setIconTextGap(15);
        paymentImageLabel.setBackground(Color.black);
        paymentImageLabel.setOpaque(true);

        JLabel paymentLabel = new JLabel("PAYMENT INFO");
        paymentLabel.setForeground(Color.white);
        paymentLabel.setFont(new Font("Arial", 24, 24));
        paymentLabel.setBounds(0, 180, 200, 20);


        JLabel priceLabel = new JLabel("PRICE:   " + "OR " + "LOYALTY POINTS:     ");
        priceLabel.setFont(new Font("Arial", 18, 18));
        priceLabel.setForeground(Color.white);
        priceLabel.setBounds(40, 20, 400, 30);

        JLabel nameLabel = new JLabel("Name on Card");
        nameLabel.setFont(new Font("Arial", 18, 18));
        nameLabel.setForeground(Color.white);
        nameLabel.setBounds(40, 80, 200, 30);

        JTextField nameText = new JTextField();
        nameText.setBounds(40, 120, 240, 30);

        JLabel cardLabel = new JLabel("Card Number");
        cardLabel.setFont(new Font("Arial", 18, 18));
        cardLabel.setForeground(Color.white);
        cardLabel.setBounds(40, 160, 200, 30);

        JTextField cardText = new JTextField();
        cardText.setBounds(40, 200, 240, 30);

        JLabel expirationLabel = new JLabel("Expiration Date");
        expirationLabel.setFont(new Font("Arial", 18, 18));
        expirationLabel.setForeground(Color.white);
        expirationLabel.setBounds(40, 240, 200, 30);

        JTextField expirationText = new JTextField();
        expirationText.setBounds(40, 280, 160, 30);

        JLabel ccvLabel = new JLabel("CCV/CV2");
        ccvLabel.setFont(new Font("Arial", 18, 18));
        ccvLabel.setForeground(Color.white);
        ccvLabel.setBounds(230, 240, 170, 30);

        JTextField ccvText = new JTextField();
        ccvText.setBounds(230, 280, 60, 30);

        confirmPaymentButton = new JButton("Confirm Payment");
        confirmPaymentButton.setBounds(50, 400, 180, 35);
        confirmPaymentButton.addActionListener(paymentListener);

        CancelButton = new JButton("Cancel");
        CancelButton.setBounds(250, 400, 180, 35);
        CancelButton.addActionListener(cancelListener);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(0, 0, 60, 30);


        paymentCombo = new JComboBox(paymentType);
        paymentCombo.setBounds(400, 200, 200, 30);

        cardImagePanel.add(paymentLabel);
        cardImagePanel.add(paymentImageLabel);
        cardImagePanel.add(logoutButton);
        paymentInfoPanel.add(priceLabel);
        paymentInfoPanel.add(nameLabel);
        paymentInfoPanel.add(nameText);
        paymentInfoPanel.add(cardLabel);
        paymentInfoPanel.add(cardText);
        paymentInfoPanel.add(expirationLabel);
        paymentInfoPanel.add(expirationText);
        paymentInfoPanel.add(ccvLabel);
        paymentInfoPanel.add(ccvText);
        paymentInfoPanel.add(paymentCombo);
        paymentInfoPanel.add(confirmPaymentButton);
        paymentInfoPanel.add(CancelButton);
        paymentInfoPanel.setLayout(null);
        frame.add(cardImagePanel);
        frame.add(paymentInfoPanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private ActionListener paymentListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                maintainPayment.processPayment(order, paymentCombo.getSelectedItem().toString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    };


    private ActionListener cancelListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            if (e2.getSource() == CancelButton) {
                CheckOutPage checkout = new CheckOutPage(login);
                frame.dispose();
            }
        }


    };
}
