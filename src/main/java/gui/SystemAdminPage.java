package gui;

import UserMaintainance.Login;
import javafx.css.converter.LadderConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemAdminPage {
    JButton changeMovie, changeOrders, changeUsers;
    JFrame frame;
    private Login login;



    SystemAdminPage() {
//        this.login = login;

        ImageIcon image7 = new ImageIcon("../project/src/main/resources/images/systemAdmin.png");
        ImageIcon image8 = new ImageIcon("../project/src/main/resources/images/changeMovie.PNG");
        ImageIcon image9 = new ImageIcon("../project/src/main/resources/images/changeOrder.png");
        ImageIcon image10 = new ImageIcon("../project/src/main/resources/images/changeUser.png");


        frame = new JFrame("System Admin Mode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel systemAdminImagePanel = new JPanel();
        systemAdminImagePanel.setBackground(Color.black);
        systemAdminImagePanel.setBounds(0, 0, 800, 140);

        JPanel sysButtonPanel = new JPanel();
        sysButtonPanel.setBackground(Color.gray);
        sysButtonPanel.setBounds(0, 140, 800, 60);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(40, 10, 80, 25);

        JButton myProfileButton = new JButton("Profile");
        myProfileButton.setBounds(140, 10, 80, 25);

        changeMovie = new JButton("CHANGE MOVIE");
        changeMovie.setBounds(0, 440, 267, 45);
        changeMovie.addActionListener(changeMovieListener);

        changeUsers = new JButton("CHANGE USERS");
        changeUsers.setBounds(267, 440, 267, 45);
        changeUsers.addActionListener(changeUserListener);

        changeOrders = new JButton("CHANGE ORDERS");
        changeOrders.setBounds(534, 440, 267, 45);
        changeOrders.addActionListener(changeOrderListener);

        JPanel loggedinAsPanel = new JPanel();
        loggedinAsPanel.setBackground(Color.blue);
        loggedinAsPanel.setBounds(340, 10, 300, 25);
//        loggedinAsPanel.setLayout(null);

        JLabel loggedinAsLabel = new JLabel("LOGGED IN AS" + "");
        loggedinAsLabel.setFont(new Font("Arial", 18, 18));
        loggedinAsLabel.setForeground(Color.white);
        loggedinAsLabel.setBounds(540, 10, 150, 25);
        loggedinAsLabel.setLayout(null);

        JLabel movieImageLabel = new JLabel();
        movieImageLabel.setIcon(image8);
        movieImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        movieImageLabel.setVerticalTextPosition(JLabel.TOP);
        movieImageLabel.setForeground(Color.white);
        movieImageLabel.setIconTextGap(15);
        movieImageLabel.setBackground(Color.black);
        movieImageLabel.setOpaque(true);
        movieImageLabel.setBounds(20, 100, 200, 140);

        JLabel userImageLabel = new JLabel();
        userImageLabel.setIcon(image10);
        userImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        userImageLabel.setVerticalTextPosition(JLabel.TOP);
        userImageLabel.setForeground(Color.white);
        userImageLabel.setIconTextGap(15);
        userImageLabel.setBackground(Color.black);
        userImageLabel.setOpaque(true);
        userImageLabel.setBounds(20, 100, 200, 140);

        JLabel ordersImageLabel = new JLabel();
        ordersImageLabel.setIcon(image9);
        ordersImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        ordersImageLabel.setVerticalTextPosition(JLabel.TOP);
        ordersImageLabel.setForeground(Color.white);
        ordersImageLabel.setIconTextGap(15);
        ordersImageLabel.setBackground(Color.black);
        ordersImageLabel.setOpaque(true);
        ordersImageLabel.setBounds(20, 100, 200, 140);


        JPanel moviesImagePanel = new JPanel();
        moviesImagePanel.setBackground(Color.green);
        moviesImagePanel.setBounds(0, 140, 267, 300);
        moviesImagePanel.setLayout(null);

        JPanel usersImagePanel = new JPanel();
        usersImagePanel.setBackground(Color.red);
        usersImagePanel.setBounds(267, 140, 267, 300);
        usersImagePanel.setLayout(null);

        JPanel ordersImagePanel = new JPanel();
        ordersImagePanel.setBackground(Color.blue);
        ordersImagePanel.setBounds(534, 140, 264, 300);
        ordersImagePanel.setLayout(null);


        JLabel sysadminImageLabel = new JLabel();
        sysadminImageLabel.setIcon(image7);
        sysadminImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        sysadminImageLabel.setVerticalTextPosition(JLabel.TOP);
        sysadminImageLabel.setForeground(Color.white);
        sysadminImageLabel.setIconTextGap(15);
        sysadminImageLabel.setBackground(Color.black);
        sysadminImageLabel.setOpaque(true);

        sysButtonPanel.setLayout(null);

        systemAdminImagePanel.add(sysadminImageLabel);
        sysButtonPanel.add(logoutButton);
        sysButtonPanel.add(myProfileButton);

        sysButtonPanel.add(loggedinAsPanel);
        loggedinAsPanel.add(loggedinAsLabel);
        moviesImagePanel.add(movieImageLabel);
        usersImagePanel.add(userImageLabel);
        ordersImagePanel.add(ordersImageLabel);
        frame.add(systemAdminImagePanel);

        frame.add(sysButtonPanel);
        frame.add(moviesImagePanel);
        frame.add(usersImagePanel);
        frame.add(ordersImagePanel);
        frame.add(changeOrders);
        frame.add(changeMovie);
        frame.add(changeUsers);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    private ActionListener changeMovieListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            if (e2.getSource() == changeMovie) {
                UpdateMoviePage um = new UpdateMoviePage();
                frame.dispose();
            }
        }

    };

    private ActionListener changeOrderListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            if (e2.getSource() == changeOrders) {
                UpdateOrdersPage up = new UpdateOrdersPage();
                frame.dispose();
            }
        }

    };

    private ActionListener changeUserListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            if (e2.getSource() == changeUsers) {
                UpdateUsersPage up = new UpdateUsersPage();
                frame.dispose();
            }
        }

    };
}
