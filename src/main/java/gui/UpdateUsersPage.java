package gui;

import Movies.MaintainMovie;
import Movies.Movie;
import OrderMaintainance.MaintainOrder;
import UserMaintainance.Login;
import UserMaintainance.MaintainUser;
import UserMaintainance.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UpdateUsersPage {
    private Login login;
    private JFrame frame;
    JTable table;
    JTextField searchField;
    final String path = "../project/src/main/java/database/users.csv";
    ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");
    MaintainUser maintainUser;
    private JButton addButton, removeButton, updateButton, backButton;
    private JTextField typeText, fnameText, lnameText, emailText, contactText,
            addressText, unameText, passwordText, idText, pointsText, balanceText;

    UpdateUsersPage(Login login) {
        this.login = login;
        maintainUser = new MaintainUser(path);
        frame = new JFrame("Update Users");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1800);

        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(Color.gray);
        tablePanel.setBounds(0, 100, 1800, 450);

        JPanel addUserInfoPanel = new JPanel();
        addUserInfoPanel.setBackground(Color.green);
        addUserInfoPanel.setBounds(0, 550, 1800, 250);

        JLabel typeLabel = new JLabel("Type");
        typeLabel.setForeground(Color.BLACK);
        typeLabel.setBounds(10, 0, 200, 25);
        addUserInfoPanel.add(typeLabel);

        typeText = new JTextField();
        typeText.setBounds(10, 25, 200, 25);
        addUserInfoPanel.add(typeText);
        addUserInfoPanel.add(typeText);

        JLabel fnameLabel = new JLabel("First Name");
        fnameLabel.setForeground(Color.BLACK);
        fnameLabel.setBounds(250, 0, 200, 25);
        addUserInfoPanel.add(fnameLabel);

        fnameText = new JTextField();
        fnameText.setForeground(Color.BLACK);
        fnameText.setBounds(250, 25, 200, 25);
        addUserInfoPanel.add(fnameText);

        JLabel lnameLabel = new JLabel("Last Name");
        lnameLabel.setForeground(Color.BLACK);
        lnameLabel.setBounds(490, 0, 200, 25);
        addUserInfoPanel.add(lnameLabel);

        lnameText = new JTextField();
        lnameText.setForeground(Color.BLACK);
        lnameText.setBounds(490, 25, 200, 25);
        addUserInfoPanel.add(lnameText);

        JLabel emailLabel = new JLabel("E-mail");
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setBounds(10, 50, 200, 25);
        addUserInfoPanel.add(emailLabel);

        emailText = new JTextField();
        emailText.setForeground(Color.BLACK);
        emailText.setBounds(10, 75, 200, 25);
        addUserInfoPanel.add(emailText);

        JLabel contactLabel = new JLabel("Contact No.");
        contactLabel.setForeground(Color.BLACK);
        contactLabel.setBounds(250, 50, 200, 25);
        addUserInfoPanel.add(contactLabel);

        contactText = new JTextField();
        contactText.setForeground(Color.BLACK);
        contactText.setBounds(250, 75, 200, 25);
        addUserInfoPanel.add(contactText);

        JLabel addressLabel = new JLabel("Genre");
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setBounds(490, 50, 200, 25);
        addUserInfoPanel.add(addressLabel);

        addressText = new JTextField();
        addressText.setForeground(Color.BLACK);
        addressText.setBounds(490, 75, 200, 25);
        addUserInfoPanel.add(addressText);

        JLabel unameLabel = new JLabel("Username");
        unameLabel.setForeground(Color.BLACK);
        unameLabel.setBounds(10, 100, 200, 25);
        addUserInfoPanel.add(unameLabel);

        unameText = new JTextField();
        unameText.setForeground(Color.BLACK);
        unameText.setBounds(10, 125, 200, 25);
        addUserInfoPanel.add(unameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(250, 100, 200, 25);
        addUserInfoPanel.add(passwordLabel);

        passwordText = new JTextField();
        passwordText.setForeground(Color.BLACK);
        passwordText.setBounds(250, 125, 200, 25);
        addUserInfoPanel.add(passwordText);

        JLabel idLabel = new JLabel("ID");
        idLabel.setForeground(Color.BLACK);
        idLabel.setBounds(490, 100, 200, 25);
        addUserInfoPanel.add(idLabel);

        idText = new JTextField();
        idText.setForeground(Color.BLACK);
        idText.setBounds(490, 125, 200, 25);
        addUserInfoPanel.add(idText);

        JLabel pointsLabel = new JLabel("Points");
        pointsLabel.setForeground(Color.BLACK);
        pointsLabel.setBounds(10, 150, 200, 25);
        addUserInfoPanel.add(pointsLabel);

        pointsText = new JTextField();
        pointsText.setForeground(Color.BLACK);
        pointsText.setBounds(10, 175, 200, 25);
        addUserInfoPanel.add(pointsText);

        JLabel balanceLabel = new JLabel("Balance");
        balanceLabel.setForeground(Color.BLACK);
        balanceLabel.setBounds(250, 150, 200, 25);
        addUserInfoPanel.add(balanceLabel);

        balanceText = new JTextField();
        balanceText.setForeground(Color.BLACK);
        balanceText.setBounds(250, 175, 200, 25);
        addUserInfoPanel.add(balanceText);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setBounds(0, 800, 1800, 400);

        addButton = new JButton("ADD");
        addButton.setBounds(600, 40, 200, 55);
        addButton.addActionListener(addListener);

        removeButton = new JButton("REMOVE");
        removeButton.setBounds(820, 40, 200, 55);
        removeButton.addActionListener(removeListener);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.lightGray);
        searchPanel.setBounds(0, 0, 1800, 100);

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(1040, 40, 200, 55);
        updateButton.addActionListener(updateListener);

        backButton = new JButton("BACK");
        backButton.setBounds(1540, 40, 200, 55);
        backButton.addActionListener(backListener);

        searchField = new JTextField(20);
        searchField.setBounds(400, 25, 800, 25);
        searchPanel.add(searchField);
        searchPanel.setLayout(null);

        JLabel searchLabel = new JLabel("SEARCH");
        searchLabel.setForeground(Color.white);
        searchLabel.setBounds(780, 60, 80, 25);
        searchLabel.setFont(new Font("Arial", 16, 20));
        searchPanel.add(searchLabel);

        maintainUser = new MaintainUser(path);
        Object[][] data = null;

        try {
            data = maintainUser.readDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] columns = {"Type", "First Name", "Last Name", "E-mail", "Contact", "Address", "Uname", "Password", "ID", "Points", "Balance"};


        table = new JTable(data, columns);
        table.setPreferredScrollableViewportSize(new Dimension(1700, 400));
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
        table.setBounds(20, 600, 1700, 200);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);

        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(120);
        table.getColumnModel().getColumn(7).setPreferredWidth(20);
        table.getColumnModel().getColumn(8).setPreferredWidth(20);
        table.getColumnModel().getColumn(9).setPreferredWidth(20);
        table.getColumnModel().getColumn(10).setPreferredWidth(20);


        TableModel model = new DefaultTableModel(data, columns);
        TableRowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);


        tablePanel.add(new JScrollPane(table));

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchField.getText());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchField.getText());

            }

            public void search(String s) {
                if (s.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + s));
                    if (sorter.getViewRowCount() == 0) {
                        JFrame popup = new JFrame("ERROR MESSAGE");
                        JLabel noMoviesFound = new JLabel("NO USERS FOUND");
                        noMoviesFound.setIcon(image3);
                        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        popup.setSize(300, 300);
                        popup.setBounds(700, 500, 300, 100);
                        popup.add(noMoviesFound);
                        popup.setVisible(true);

                    }
                }
            }
        });

        addUserInfoPanel.setLayout(null);
        buttonPanel.setLayout(null);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(backButton);
        frame.add(searchPanel);
        frame.add(tablePanel);
        frame.add(addUserInfoPanel);
        frame.add(buttonPanel);
        frame.setLayout(null);
        frame.setVisible(true);

        table.addMouseListener(clickListener);
    }

    private User getUserFromInput() {
        String type = typeText.getText();
        String fname = fnameText.getText();
        String lname = lnameText.getText();
        String email = emailText.getText();
        String contact = contactText.getText();
        String address = addressText.getText();
        String uname = unameText.getText();
        String password = passwordText.getText();
        String id = idText.getText();
        String points = pointsText.getText();
        String balance = balanceText.getText();

        return new User(type, fname, lname, email, contact, address,
                uname, password, id, points, balance, "Ontario");
    }

    private ActionListener addListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                try {
                    User user = getUserFromInput();
                    if (maintainUser.addUser(user)) {
                        System.out.println("User Added");
//                        frame.dispose();
//
//                        SystemAdminPage adminPage = new SystemAdminPage(login);
//
//                        JFrame popup = new JFrame("MOVIE ADDED");
//                        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//                        popup.setSize(300, 300);
//                        popup.setBounds(700, 500, 300, 100);
//                        popup.setVisible(true);
                    } else {
                        System.out.println("User already exists");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    };

    private ActionListener removeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == removeButton) {
                try {
                    User user = getUserFromInput();
                    if (maintainUser.removeUser(user)) {
                        System.out.println("User Removed");
//                        frame.dispose();
//
//                        SystemAdminPage adminPage = new SystemAdminPage(login);
//
//                        JFrame popup = new JFrame("MOVIE ADDED");
//                        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//                        popup.setSize(300, 300);
//                        popup.setBounds(700, 500, 300, 100);
//                        popup.setVisible(true);
                    } else {
                        System.out.println("User already exists");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    };

    private ActionListener updateListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == updateButton) {
                try {
                    User user = getUserFromInput();
                    if (maintainUser.updateUser(user)) {
                        System.out.println("User Updated");
//                        frame.dispose();
//
//                        SystemAdminPage adminPage = new SystemAdminPage(login);
//
//                        JFrame popup = new JFrame("MOVIE ADDED");
//                        popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//                        popup.setSize(300, 300);
//                        popup.setBounds(700, 500, 300, 100);
//                        popup.setVisible(true);
                    } else {
                        System.out.println("User already exists");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    };

    private ActionListener backListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            SystemAdminPage systemAdminPage = new SystemAdminPage(login);
        }
    };

    private MouseListener clickListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();

            String type = table.getValueAt(row, 0).toString();
            typeText.setText(type);

            String fname = table.getValueAt(row, 1).toString();
            fnameText.setText(fname);

            String lname = table.getValueAt(row, 2).toString();
            lnameText.setText(lname);

            String email = table.getValueAt(row, 3).toString();
            emailText.setText(email);

            String contact = table.getValueAt(row, 4).toString();
            contactText.setText(contact);

            String address = table.getValueAt(row, 5).toString();
            addressText.setText(address);

            String uname = table.getValueAt(row, 6).toString();
            unameText.setText(uname);

            String password = table.getValueAt(row, 7).toString();
            passwordText.setText(password);

            String id = table.getValueAt(row, 8).toString();
            idText.setText(id);

            String points = table.getValueAt(row, 9).toString();
            pointsText.setText(points);

            String balance = table.getValueAt(row, 10).toString();
            balanceText.setText(balance);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

}
