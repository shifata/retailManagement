package gui;

import UserMaintainance.MaintainUser;
import UserMaintainance.User;
import Utils.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends JFrame implements ActionListener {
    private JButton registerbutton, cancelRegbutton, okaybutton;
    private JTextField fnameText, lnameText, emailText, contactText, unameText, passwordText,
            addressText, idText, pointsText, balanceText;
    private JFrame frame;
    private JComboBox type;

    RegisterPage() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setTitle("Registration of New User");

        JPanel captionPanel = new JPanel();
        captionPanel.setBackground(new Color(53, 80, 84));
        captionPanel.setBounds(150, 0, 500, 200);

        JPanel registerPanel = new JPanel();
//        registerPanel.setBackground(Color.black);
        registerPanel.setBackground(Color.decode("#063970"));
        registerPanel.setBounds(150, 200, 500, 770);


        JLabel caption = new JLabel("Online Registration of new User of VideoCo");
        caption.setForeground(Color.white);
        caption.setBounds(0, 100, 500, 200);
        captionPanel.add(caption);
        caption.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        caption.setVerticalTextPosition(JLabel.TOP);
        caption.setForeground(Color.white);
        caption.setIconTextGap(15);
        caption.setBackground(new Color(53, 80, 84));
        caption.setOpaque(true); //displays background color
        //caption.setBorder(border); //displays border
        //caption.setBounds(200,50,400,300); //set x and y permanent position of the image
        caption.setFont(new Font("Arial", Font.BOLD, 22));
        caption.setVerticalAlignment(JLabel.TOP);
        caption.setHorizontalAlignment(JLabel.CENTER);

        JLabel fname = new JLabel("First Name");
        fname.setForeground(Color.white);
        fname.setBounds(0, 0, 80, 25);
        registerPanel.add(fname);

        fnameText = new JTextField(20);
        fnameText.setBounds(150, 0, 165, 25);
        registerPanel.add(fnameText);

        JLabel lname = new JLabel("Last Name");
        lname.setForeground(Color.white);
        lname.setBounds(0, 40, 80, 25);
        registerPanel.add(lname);

        lnameText = new JTextField(20);
        lnameText.setBounds(150, 40, 165, 25);
        registerPanel.add(lnameText);

        JLabel email = new JLabel("E-mail");
        email.setForeground(Color.white);
        email.setBounds(0, 80, 80, 25);
        registerPanel.add(email);

        emailText = new JTextField(20);
        emailText.setBounds(150, 80, 165, 25);
        registerPanel.add(emailText);

        JLabel contactinfo = new JLabel("Contact No");
        contactinfo.setForeground(Color.white);
        contactinfo.setBounds(0, 120, 80, 25);
        registerPanel.add(contactinfo);

        contactText = new JTextField(20);
        contactText.setBounds(150, 120, 165, 25);
        registerPanel.add(contactText);

        JLabel address = new JLabel("Address");
        address.setForeground(Color.white);
        address.setBounds(0, 160, 80, 25);
        registerPanel.add(address);

        addressText = new JTextField(20);
        addressText.setBounds(150, 160, 165, 25);
        registerPanel.add(addressText);

        JLabel uname = new JLabel("Username");
        uname.setForeground(Color.white);
        uname.setBounds(0, 200, 80, 25);
        registerPanel.add(uname);

        unameText = new JTextField(20);
        unameText.setBounds(150, 200, 165, 25);
        registerPanel.add(unameText);

        JLabel password = new JLabel("Password");
        password.setForeground(Color.white);
        password.setBounds(0, 240, 80, 25);
        registerPanel.add(password);

        passwordText = new JTextField(20);
        passwordText.setBounds(150, 240, 165, 25);
        registerPanel.add(passwordText);

        registerbutton = new JButton("Complete Registration");
        registerbutton.setBounds(140, 320, 180, 35);
        registerPanel.add(registerbutton);
        registerbutton.addActionListener(this);

        cancelRegbutton = new JButton("Cancel Registration");
        cancelRegbutton.setBounds(140, 420, 180, 35);
        registerPanel.add(cancelRegbutton);
        cancelRegbutton.addActionListener(logOutListener);

        String[] types = {"Customer, Operator, Admin"};
        type = new JComboBox(types);
//        type.setBounds();

        frame.add(captionPanel);

        registerPanel.setLayout(null); // **to make the objects move, make sure this line is included for panel**
        captionPanel.setLayout(null);


        frame.add(registerPanel);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e1) {
        final String path = "../project/src/main/java/database/users.csv";
        MaintainUser maintainer = new MaintainUser(path);
        String type = "customer";
        String inputFName = fnameText.getText();
        String inputLName = lnameText.getText();
        String inputEmail = emailText.getText();
        String inputContact = contactText.getText();
        String inputAddress = addressText.getText();
        String inputUName = unameText.getText();
        String inputPassword = passwordText.getText();
        String inputId = "";
        String inputPoints = "0";
        String inputBalance = "0";


        User newUser = new User(type, inputFName, inputLName, inputEmail, inputContact, inputAddress,
                inputUName, inputPassword, inputId, inputPoints, inputBalance, "Ontario");

        if (e1.getSource() == registerbutton) {

            if (fnameText.getText().isEmpty() || lnameText.getText().isEmpty() || emailText.getText().isEmpty()
                    || contactText.getText().isEmpty() || contactText.getText().isEmpty() || addressText.getText().isEmpty()
                    || unameText.getText().isEmpty() || passwordText.getText().isEmpty()) {
                Messages.customMsg("USER CANNOT BE ADDED! ALL FIELDS MUST BE TYPED IN");
            } else {
                try {
                    maintainer.addUserRegister(newUser);
                    Messages.customMsgGreen("USER REGISTERED SUCCESSFULLY");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }

    private ActionListener logOutListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            LoginPage lp = new LoginPage();
        }
    };
}


