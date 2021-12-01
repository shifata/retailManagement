package gui;

import OrderMaintainance.MaintainOrder;
import UserMaintainance.Login;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOrderStatusPage {
    private MaintainOrder maintainOrder;
    private final String path = "../project/src/main/java/database/orders.csv";
    JFrame frame;
    private Login login;

    CheckOrderStatusPage(Login login) {
        this.login = login;
        ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");
        ImageIcon image12 = new ImageIcon("../project/src/main/resources/images/checkOrderStatus.png");

        frame = new JFrame("Check Order Status");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1800);

        JPanel orderStatusImagePanel = new JPanel();
        orderStatusImagePanel.setBackground(Color.CYAN);
        orderStatusImagePanel.setBounds(0, 0, 1800, 470);

        JLabel orderStatusImageLabel = new JLabel();
        orderStatusImageLabel.setIcon(image12);
        orderStatusImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        orderStatusImageLabel.setVerticalTextPosition(JLabel.TOP);
        orderStatusImageLabel.setForeground(Color.white);
        orderStatusImageLabel.setIconTextGap(15);
        orderStatusImageLabel.setBackground(Color.black);
        orderStatusImageLabel.setOpaque(true);

        JPanel searchTablePanel = new JPanel();
        searchTablePanel.setBackground(Color.blue);
        searchTablePanel.setBounds(0, 600, 1800, 200);

        JPanel tablePanel = new JPanel();
        tablePanel.setSize(1700, 400);
        tablePanel.setBackground(Color.cyan);
        tablePanel.setBounds(0, 481, 1800, 400);


        JTextField searchField = new JTextField(20);
        searchField.setBounds(400, 125, 800, 45);
        searchTablePanel.add(searchField);
        searchTablePanel.setLayout(null);

        JLabel searchLabel = new JLabel("SEARCH");
        searchLabel.setForeground(Color.white);
        searchLabel.setBounds(270, 130, 120, 35);
        searchLabel.setFont(new Font("Arial", 22, 22));
        searchTablePanel.add(searchLabel);

        maintainOrder = new MaintainOrder(path);
        Object[][] data = null;

        try {
            data = maintainOrder.readDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] columns = {"Order ID", "Order Type", "Order Placed", "Order Delivery Date", "Shipping Address", "Order Status", "Movie", "Username"};


        JTable table = new JTable(data, columns);
        table.setPreferredScrollableViewportSize(new Dimension(1700, 200));
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
        table.setBounds(20, 800, 1700, 200);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);

        //search implementation
        TableModel model = new DefaultTableModel(data, columns);
        TableRowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);

        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(620);
        table.getColumnModel().getColumn(7).setPreferredWidth(20);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(720, 900, 250, 60);
        backButton.addActionListener(backListener);


        //search implementation listener
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
                        JLabel noMoviesFound = new JLabel("NO ORDERS FOUND");
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


        tablePanel.add(new JScrollPane(table));
        orderStatusImagePanel.add(orderStatusImageLabel);
        frame.add(orderStatusImagePanel);
        frame.add(searchTablePanel);
        frame.add(tablePanel);
        frame.add(backButton);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    private ActionListener backListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            OperatorPage op = new OperatorPage(login);
        }
    };
}
