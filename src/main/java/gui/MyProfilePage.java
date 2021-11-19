package gui;

import UserMaintainance.Login;
import UserMaintainance.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProfilePage {

    private Login login;
    private JTextField fnameText, lnameText, emailText, contactText, addressText, unameText, passwordText;

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

        JPanel pointsPanel = new JPanel();
        pointsPanel.setBackground(Color.green);
        pointsPanel.setBounds(820,155,200,100);
        pointsPanel.setLayout(null);

        JPanel balancePanel = new JPanel();
        balancePanel.setBackground(Color.yellow);
        balancePanel.setBounds(300,155,200,100);
        balancePanel.setLayout(null);

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
        changeButton.setBounds(550, 340, 160, 25);
        profileFieldsPanel.add(changeButton);
        changeButton.addActionListener(changeListener);

        JLabel fname = new JLabel("First Name");
        fname.setForeground(Color.white);
        fname.setBounds(450, 10, 80, 25);
        profileFieldsPanel.add(fname);

        fnameText = new JTextField(20);
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

        lnameText = new JTextField(20);
        lnameText.setBounds(550, 50, 165, 25);
        profileFieldsPanel.add(lnameText);
        try {
            User user = login.getCurrentUser(login.getUName(), login.getPass());
            lnameText.setText(user.getLname());

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel email = new JLabel("E-mail");
        email.setForeground(Color.white);
        email.setBounds(450, 90, 90, 25);
        profileFieldsPanel.add(email);

        emailText = new JTextField(20);
        emailText.setBounds(550, 90, 165, 25);
        profileFieldsPanel.add(emailText);

        try {
            User user = login.getCurrentUser(login.getUName(), login.getPass());
            emailText.setText(user.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel contactinfo = new JLabel("Contact No");
        contactinfo.setForeground(Color.white);
        contactinfo.setBounds(450, 130, 80, 25);
        profileFieldsPanel.add(contactinfo);

        contactText = new JTextField(20);
        contactText.setBounds(550, 130, 165, 25);
        profileFieldsPanel.add(contactText);

        try {
            User user = login.getCurrentUser(login.getUName(), login.getPass());
            contactText.setText(user.getContactNo());

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel address = new JLabel("Address");
        address.setForeground(Color.white);
        address.setBounds(450, 170, 80, 25);
        profileFieldsPanel.add(address);

        addressText = new JTextField(20);
        addressText.setBounds(550, 170, 165, 25);
        profileFieldsPanel.add(addressText);

        try {
            User user = login.getCurrentUser(login.getUName(), login.getPass());
            addressText.setText(user.getAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel uname = new JLabel("Username");
        uname.setForeground(Color.white);
        uname.setBounds(450, 210, 80, 25);
        profileFieldsPanel.add(uname);

        unameText = new JTextField(20);
        unameText.setBounds(550, 210, 165, 25);
        profileFieldsPanel.add(unameText);

        try {
            User user = login.getCurrentUser(login.getUName(), login.getPass());
            unameText.setText(user.getUname());

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel balanceDue = new JLabel("Balance Due");
        balanceDue.setForeground(Color.black);
        balanceDue.setBounds(60,10,100,25);
        balancePanel.add(balanceDue);
        balanceDue.setLayout(null);

        JLabel balanceDueLabel = new JLabel("balance");
        balanceDueLabel.setForeground(Color.black);
        balanceDueLabel.setFont(new Font("Arial",20,32));
        balanceDueLabel.setBounds(70, 50, 100, 25);
        balancePanel.add(balanceDueLabel);

        try {
            User user = login.getCurrentUser(login.getUName(), login.getPass());
            balanceDueLabel.setText(user.getBalance());

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel loyaltyPoints = new JLabel("Loyalty Points");
        loyaltyPoints.setForeground(Color.black);
        loyaltyPoints.setBounds(60,10,100,25);
        pointsPanel.add(loyaltyPoints);

        JLabel loyaltyPointsLabel = new JLabel("points");
        loyaltyPointsLabel.setFont(new Font("Arial",20,32));
        loyaltyPointsLabel.setForeground(Color.black);
        loyaltyPointsLabel.setBounds(70, 50, 80, 25);
        //captionPanel.add(loyaltyPoints);

        try {
            User user = login.getCurrentUser(login.getUName(), login.getPass());
            loyaltyPointsLabel.setText(user.getPoints());

        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel password = new JLabel("Password");
        password.setForeground(Color.white);
        password.setBounds(450, 250, 80, 25);
        profileFieldsPanel.add(password);

        passwordText = new JTextField(20);
        passwordText.setBounds(550, 250, 165, 25);
        profileFieldsPanel.add(passwordText);

        try {
            User user = login.getCurrentUser(login.getUName(), login.getPass());
            passwordText.setText(user.getPassword());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //captionPanel.setLayout(null);

        pointsPanel.add(loyaltyPointsLabel);
        profileFieldsPanel.setLayout(null);
        captionPanel.add(logoutButton);
        captionPanel.add(backButton);
        captionPanel.add(orderHistoryButton);
        captionPanel.add(myProfileCaption);
        captionPanel.add(myProfileLabel);
        frame.add(balancePanel);
        frame.add(pointsPanel);
        frame.add(captionPanel);
        frame.add(profileFieldsPanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private ActionListener changeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            User user = null;

        }
    };
}
