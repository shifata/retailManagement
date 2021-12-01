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
        popup.setBounds(700, 500, 300, 100);
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
        popup.setBounds(700, 500, 300, 100);
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
        popup.setBounds(700, 500, 300, 100);
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
        popup.setBounds(700, 500, 300, 100);
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
        popup.setBounds(700, 500, 300, 100);
        popup.add(noMoviesFound);
        popup.setVisible(true);
        return popup;
    }
}
