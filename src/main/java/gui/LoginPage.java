package gui;

import UserMaintainance.Login;
import Utils.Messages;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    private JButton regbutton, loginbutton;
    private JFrame frame;
    private JTextField userText;
    private JPasswordField passwordText;
    private Login login;

    LoginPage(Login login) {
        this.login = login;
    }

    LoginPage() {
        ImageIcon image = new ImageIcon("../project/src/main/resources/images/videoCo.png"); // imported wallpaper

        Border border = BorderFactory.createLineBorder(Color.white, 5);
        Border border1 = BorderFactory.createLineBorder(Color.black, 5);

        JPanel imagepanel = new JPanel();
        imagepanel.setBackground(Color.white);
        imagepanel.setBounds(0, 0, 900, 400);

        JPanel loginpanel = new JPanel();
        loginpanel.setBackground(Color.black);
        loginpanel.setBounds(200, 400, 400, 160);
        frame = new JFrame();
        frame.setLayout(null); //panel view
        //frame.setVisible(true); //panel view
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setTitle("Login Page");

        frame.add(loginpanel);
        frame.add(imagepanel);
        loginpanel.setLayout(null);
        imagepanel.setLayout(null);
        //
        JLabel label = new JLabel(); //create a label
        label.setText("VIDEOCO MANAGEMENT SYSTEM"); //set text of label
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.white);
        label.setIconTextGap(15);
        label.setBackground(Color.black);
        label.setOpaque(true); //displays background color
        label.setBorder(border); //displays border
        label.setBounds(200, 50, 400, 300); //set x and y permanent position of the image
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        //
        imagepanel.add(label);
        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(Color.white);
        userLabel.setBounds(10, 20, 80, 25);

        loginpanel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(150, 20, 165, 25);
        loginpanel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setBounds(10, 50, 80, 25);
        loginpanel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 50, 165, 25);
        loginpanel.add(passwordText);

        loginbutton = new JButton("Login");
        loginbutton.setBounds(90, 100, 100, 25);
        loginpanel.add(loginbutton);
        loginbutton.addActionListener(loginListener);

        regbutton = new JButton("Register");
        regbutton.setBounds(200, 100, 100, 25);
        loginpanel.add(regbutton);
        regbutton.addActionListener(registerListener);

        JLabel success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        loginpanel.add(success);

        frame.setVisible(true);

    }

    ActionListener loginListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            final String filePath = "../project/src/main/java/database/users.csv";

            String utype = "";
            String uname = userText.getText();
            String password = passwordText.getText();
            login = new Login(filePath);
            boolean verified = false;

            if (userText.getText().isEmpty() || passwordText.getText().isEmpty()) {
                Messages.customMsg("Username or Password field is empty! Please provide username and password");
            }

            try {

                verified = login.verify(uname, password);


                if (verified) {
                    System.out.println(login.getCurrentUser(uname, password));
                    utype = login.getUserType(uname, password);

                    if (utype.equals("customer")) {
                        frame.dispose();
                        MoviesDisplayPage displayPage = new MoviesDisplayPage(login);
                    }
                    if (utype.equals("operator")) {
                        frame.dispose();
                        OperatorPage operatorPage = new OperatorPage(login);
                    }
                    if (utype.equals("admin")) {
                        frame.dispose();
                        SystemAdminPage systemAdminPage = new SystemAdminPage(login);
                    }

                } else {
                    Messages.customMsg("Wrong credentials. Try again");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    ActionListener registerListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            RegisterPage register = new RegisterPage();
        }

    };


    public Login getLogin() {
        return login;
    }


}
