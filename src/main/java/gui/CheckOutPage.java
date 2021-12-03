package gui;

import Movies.MaintainMovie;
import Movies.Movie;
import UserMaintainance.Login;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CheckOutPage {
    JButton proceedToPaymentButton, removeButton;
    JFrame frame;
    private JTable table;
    private Login login;
    private ArrayList<Movie> cart;
    Object[][] data;
    private final String[] columns = {"Name", "Price"};

    CheckOutPage(Login login) {
        this.login = login;
        cart = MoviesDisplayPage.getCart();

        frame = new JFrame("Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1800);

        ImageIcon image4 = new ImageIcon("../project/src/main/resources/images/checkout.png");


        JLabel loggedinAsLabel = new JLabel("LOGGED IN AS:" + "  " + login.getUName());
        loggedinAsLabel.setForeground(Color.white);
        loggedinAsLabel.setFont(new Font("Arial", 22, 22));
        loggedinAsLabel.setBounds(0, 0, 400, 200);

        JPanel cartCaptionPanel = new JPanel();
        //cartCaptionPanel.setBackground(Color.BLACK);
//        cartCaptionPanel.setBackground(Color.decode("#589863"));
        cartCaptionPanel.setBackground(Color.decode("#7ac186"));

        cartCaptionPanel.setBounds(0, 0, 1800, 280);
        cartCaptionPanel.add(loggedinAsLabel);

        JLabel cartImageLabel = new JLabel();
        cartImageLabel.setIcon(image4);
        cartImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        cartImageLabel.setVerticalTextPosition(JLabel.TOP);
        cartImageLabel.setForeground(Color.white);
        cartImageLabel.setIconTextGap(15);
        cartImageLabel.setBackground(Color.black);
        cartImageLabel.setOpaque(true);

        JLabel priceLabel = new JLabel("Total: $" + (cart.size() * 10));
        priceLabel.setForeground(Color.white);
//        priceLabel.setBackground(Color.green);
        priceLabel.setBounds(1500, 5, 400, 100);
        priceLabel.setFont(new Font("Arial", 24, 24));
        priceLabel.setForeground(Color.black);
//        priceLabelPanel.add(priceLabel);


        JLabel checkOutLabel = new JLabel("CHECK OUT");
        checkOutLabel.setBackground(Color.WHITE);
        checkOutLabel.setForeground(Color.white);
        checkOutLabel.setFont(new Font("Arial", 20, 28));
        checkOutLabel.setBounds(800, 300, 400, 200);

        JPanel table2Panel = new JPanel();
        table2Panel.setBackground(Color.gray);
        table2Panel.setBackground(Color.decode("#3e6a45"));
        table2Panel.setBounds(0, 280, 1800, 540);

        JPanel buttonPanel = new JPanel();
        //buttonPanel.setBackground(Color.lightGray);
        buttonPanel.setBackground(Color.decode("#2c4c32"));
        buttonPanel.setBounds(0, 800, 1800, 220);
        buttonPanel.add(priceLabel);
        buttonPanel.setLayout(null);

        JButton logOutButton = new JButton("Log Out");
        logOutButton.setBounds(800, 40, 100, 25);
        logOutButton.addActionListener(logOutListener);

        removeButton = new JButton("Remove");
        removeButton.setBounds(1100, 40, 100, 25);
        removeButton.addActionListener(removeListener);
//        removeButton.addMouseListener(removeListener);

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

        data = new Object[cart.size()][2];

        for (int i = 0; i < cart.size(); i++) {
            data[i][0] = cart.get(i).getTitle();
            data[i][1] = "$10.00";
        }

        table = new JTable(data, columns);
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

    private void clear() {
        cart.clear();
    }

    private ActionListener removeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            String name = table.getValueAt(row, 0).toString();
            Movie m = MaintainMovie.getMovieFromName(name);

            System.out.println("Cart size after before: " + cart.size());
            cart.remove(m);
            System.out.println("Cart size after remove: " + cart.size());

            data = new Object[cart.size()][2];
            int i = 0;

            for (Movie movie : cart) {
                data[i][0] = movie.getTitle();
                data[i][1] = "10.00";
                i++;
            }
            frame.dispose();
            CheckOutPage checkOutPage = new CheckOutPage(login);

        }
    };


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
