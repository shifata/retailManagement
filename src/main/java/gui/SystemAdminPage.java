package gui;

import javax.swing.*;
import java.awt.*;

public class SystemAdminPage {

    SystemAdminPage(){

        ImageIcon image7 = new ImageIcon("../project/src/main/resources/images/systemAdmin.png");

        JFrame frame = new JFrame("System Admin Mode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 530);

        JPanel systemAdminImagePanel = new JPanel();
        systemAdminImagePanel.setBackground(Color.black);
        systemAdminImagePanel.setBounds(0,0,800,140);

        JPanel sysButtonPanel = new JPanel();
        sysButtonPanel.setBackground(Color.gray);
        sysButtonPanel.setBounds(0,140,800,60);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(40,10,80,25);

        JButton myProfileButton = new JButton("Profile");
        myProfileButton.setBounds(140,10,80,25);

        JButton changeMovie = new JButton("CHANGE MOVIE");
        changeMovie.setBounds(0,440,267,35);

        JButton changeUsers = new JButton("CHANGE USERS");
        changeUsers.setBounds(267,440,267,35);

        JButton changeOrders = new JButton("CHANGE ORDERS");
        changeOrders.setBounds(534,440,267,35);

        JPanel loggedinAsPanel = new JPanel();
        loggedinAsPanel.setBackground(Color.blue);
        loggedinAsPanel.setBounds(340,10,300,25);
//        loggedinAsPanel.setLayout(null);

        JLabel loggedinAsLabel = new JLabel("LOGGED IN AS" + "");
        loggedinAsLabel.setFont(new Font("Arial",18,18));
        loggedinAsLabel.setForeground(Color.white);
        loggedinAsLabel.setBounds(540,10,150,25);
        loggedinAsLabel.setLayout(null);


        JPanel moviesImagePanel = new JPanel();
        moviesImagePanel.setBackground(Color.green);
        moviesImagePanel.setBounds(0,140,267,300);

        JPanel usersImagePanel = new JPanel();
        usersImagePanel.setBackground(Color.red);
        usersImagePanel.setBounds(267,140,267,300);

        JPanel ordersImagePanel = new JPanel();
        ordersImagePanel.setBackground(Color.blue);
        ordersImagePanel.setBounds(534,140,264,300);


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
}
