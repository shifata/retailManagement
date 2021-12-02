package Utils;

import javax.swing.*;

public class Messages {

    public static JFrame addedMsg(String message) {
        ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");


        JFrame popup = new JFrame("ERROR MESSAGE");
        message = message + " added";
        JLabel noMoviesFound = new JLabel(message);
        noMoviesFound.setIcon(image3);
        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        popup.setSize(300, 300);
        popup.setBounds(700, 500, 500, 100);
        popup.add(noMoviesFound);
        popup.setVisible(true);
        return popup;
    }

    public static JFrame removedMsg(String message) {
        ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");
        JFrame popup = new JFrame("ERROR MESSAGE");
        message = message + " removed";
        JLabel noMoviesFound = new JLabel(message);
        noMoviesFound.setIcon(image3);
        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        popup.setSize(300, 300);
        popup.setBounds(700, 500, 500, 100);
        popup.add(noMoviesFound);
        popup.setVisible(true);
        return popup;
    }

    public static JFrame updatedMsg(String message) {
        ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");
        JFrame popup = new JFrame("ERROR MESSAGE");
        message = message + " updated";
        JLabel noMoviesFound = new JLabel(message);
        noMoviesFound.setIcon(image3);
        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        popup.setSize(300, 300);
        popup.setBounds(700, 500, 500, 100);
        popup.add(noMoviesFound);
        popup.setVisible(true);
        return popup;
    }


    public static JFrame doesNotExistMsg(String message) {
        ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");
        JFrame popup = new JFrame("ERROR MESSAGE");
        message = "No " + message + " found";
        JLabel noMoviesFound = new JLabel(message);
        noMoviesFound.setIcon(image3);
        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        popup.setSize(300, 300);
        popup.setBounds(700, 500, 500, 100);
        popup.add(noMoviesFound);
        popup.setVisible(true);
        return popup;
    }

    public static JFrame alreadyExistsMsg(String message) {
        ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");
        JFrame popup = new JFrame("ERROR MESSAGE");
        message = message + " already exists";
        JLabel noMoviesFound = new JLabel(message);
        noMoviesFound.setIcon(image3);
        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        popup.setSize(300, 300);
        popup.setBounds(700, 500, 500, 100);
        popup.add(noMoviesFound);
        popup.setVisible(true);
        return popup;
    }

    public static JFrame paymentSuccessMsg() {
        ImageIcon image13 = new ImageIcon("../project/src/main/resources/images/correct.jpg");
        JFrame popup = new JFrame("Payment Successful");
        JLabel noMoviesFound = new JLabel("Payment Successful!    Order has been added to your Order History!");
        noMoviesFound.setIcon(image13);
        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        popup.setSize(300, 300);
        popup.setBounds(700, 500, 800, 100);
        popup.add(noMoviesFound);
        popup.setVisible(true);
        return popup;
    }

    public static JFrame customMsg(String message) {
        ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");
        JFrame popup = new JFrame("ERROR MESSAGE");
        JLabel noMoviesFound = new JLabel(message);
        noMoviesFound.setIcon(image3);
        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        popup.setSize(300, 300);
        popup.setBounds(700, 500, 500, 100);
        popup.add(noMoviesFound);
        popup.setVisible(true);
        return popup;
    }
    public static JFrame customMsgGreen(String message) {
        ImageIcon image13 = new ImageIcon("../project/src/main/resources/images/correct.jpg");
        JFrame popup = new JFrame("SUCCESS MESSAGE");
        JLabel noMoviesFound = new JLabel(message);
        noMoviesFound.setIcon(image13);
        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        popup.setSize(300, 300);
        popup.setBounds(700, 500, 500, 100);
        popup.add(noMoviesFound);
        popup.setVisible(true);
        return popup;




}}
