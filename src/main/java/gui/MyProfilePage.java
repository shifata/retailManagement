package gui;

import UserMaintainance.Login;
import UserMaintainance.User;

import javax.swing.*;
import java.awt.*;

public class MyProfilePage {

    private Login login;


    MyProfilePage(Login login) {
//        login = new Login("../project/src/main/java/database/users.csv");
        this.login = login;
        JFrame frame = new JFrame("My Profile");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1200);


        ImageIcon image4 = new ImageIcon("../project/src/main/resources/images/profile.png");

        JPanel captionPanel = new JPanel();
        captionPanel.setBackground(Color.blue);
        captionPanel.setBounds(0, 0, 1200, 270);

        JPanel profileFieldsPanel = new JPanel();
        profileFieldsPanel.setBackground(Color.red);
        profileFieldsPanel.setBounds(0, 270, 1200, 1200);

        JLabel myProfileCaption = new JLabel();
        myProfileCaption.setIcon(image4);

        JLabel myProfileLabel = new JLabel("MY PROFILE");
        myProfileLabel.setBounds(0, 300, 600, 200);
        myProfileLabel.setFont(new Font("Arial", 30, 25));
        myProfileLabel.setForeground(Color.white);

        JButton orderHistoryButton = new JButton("Order History");
        orderHistoryButton.setBounds(0, 340, 100, 25);

        JButton backButton = new JButton("Back");
        backButton.setBounds(0, 340, 100, 25);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(0, 340, 100, 25);

        JButton changeButton = new JButton("CHANGE");
        changeButton.setBounds(700, 340, 100, 25);
        profileFieldsPanel.add(changeButton);

        JLabel fname = new JLabel("First Name");
        fname.setForeground(Color.white);
        fname.setBounds(450, 10, 80, 25);
        profileFieldsPanel.add(fname);

        JTextField fnameText = new JTextField(20);
        fnameText.setBounds(550, 10, 165, 25);
        profileFieldsPanel.add(fnameText);
        try {
            User user = login.getCurrentUser(login.getUName(), login.getPass());
            fnameText.setText(user.getFname());

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lname = new JLabel("Last Name");
        lname.setForeground(Color.white);
        lname.setBounds(450, 50, 80, 25);
        profileFieldsPanel.add(lname);

        JTextField lnameText = new JTextField(20);
        lnameText.setBounds(550, 50, 165, 25);
        profileFieldsPanel.add(lnameText);

        JLabel email = new JLabel("E-mail");
        email.setForeground(Color.white);
        email.setBounds(450, 90, 90, 25);
        profileFieldsPanel.add(email);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(550, 90, 165, 25);
        profileFieldsPanel.add(emailText);

        JLabel contactinfo = new JLabel("Contact No");
        contactinfo.setForeground(Color.white);
        contactinfo.setBounds(450, 130, 80, 25);
        profileFieldsPanel.add(contactinfo);

        JTextField contactText = new JTextField(20);
        contactText.setBounds(550, 130, 165, 25);
        profileFieldsPanel.add(contactText);

        JLabel address = new JLabel("Address");
        address.setForeground(Color.white);
        address.setBounds(450, 170, 80, 25);
        profileFieldsPanel.add(address);

        JTextField addressText = new JTextField(20);
        addressText.setBounds(550, 170, 165, 25);
        profileFieldsPanel.add(addressText);

        JLabel uname = new JLabel("Username");
        uname.setForeground(Color.white);
        uname.setBounds(450, 210, 80, 25);
        profileFieldsPanel.add(uname);

        JTextField unameText = new JTextField(20);
        unameText.setBounds(550, 210, 165, 25);
        profileFieldsPanel.add(unameText);

        JLabel password = new JLabel("Password");
        password.setForeground(Color.white);
        password.setBounds(450, 250, 80, 25);
        profileFieldsPanel.add(password);

        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(550, 250, 165, 25);
        profileFieldsPanel.add(passwordText);


        profileFieldsPanel.setLayout(null);
        captionPanel.add(logoutButton);
        captionPanel.add(backButton);
        captionPanel.add(orderHistoryButton);
        captionPanel.add(myProfileCaption);
        captionPanel.add(myProfileLabel);
        frame.add(captionPanel);
        frame.add(profileFieldsPanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
