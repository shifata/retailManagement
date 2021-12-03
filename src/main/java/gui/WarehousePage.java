package gui;

import OrderMaintainance.MaintainOrder;
import UserMaintainance.Login;
import Utils.Messages;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarehousePage {

    JButton backButton;
    JFrame frame;
    JTable table;
    JTextField searchField;
    final String path = "../project/src/main/java/database/orders.csv";
    MaintainOrder maintainOrder;
    private Login login;

    WarehousePage(Login login) {
        this.login = login;
        ImageIcon image14 = new ImageIcon("../project/src/main/resources/images/warehouse.jpg");

        frame = new JFrame("System Admin Mode - Warehouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1700);

        JPanel warehouseImagePanel = new JPanel();
        warehouseImagePanel.setBackground(Color.orange);
        warehouseImagePanel.setBounds(0, 0, 1800, 400);

        JLabel sysadminImageLabel = new JLabel();
        sysadminImageLabel.setIcon(image14);
        sysadminImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        sysadminImageLabel.setVerticalTextPosition(JLabel.TOP);
        sysadminImageLabel.setForeground(Color.white);
        sysadminImageLabel.setIconTextGap(15);
        sysadminImageLabel.setBackground(Color.black);
        sysadminImageLabel.setOpaque(true);

        backButton = new JButton("BACK");
        backButton.setBounds(1540, 40, 300, 155);
        backButton.addActionListener(backListener);
        warehouseImagePanel.add(backButton);

        JPanel warehouseCaptionPanel = new JPanel();
        warehouseCaptionPanel.setBackground(Color.yellow);
        warehouseCaptionPanel.setBounds(0,400,1800,50);

        JPanel placedOrderTablePanel = new JPanel();
        placedOrderTablePanel.setBackground(Color.green);
        placedOrderTablePanel.setBounds(0,550,1800,450);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.lightGray);
        searchPanel.setBounds(0, 450, 1800, 100);

        JLabel searchLabel = new JLabel("SEARCH");
        searchLabel.setForeground(Color.white);
        searchLabel.setBounds(780, 60, 80, 25);
        searchLabel.setFont(new Font("Arial", 16, 20));
        searchPanel.add(searchLabel);


        searchField = new JTextField(20);
        searchField.setBounds(100, 25, 1600, 25);
        searchPanel.add(searchField);
        searchPanel.setLayout(null);

        JLabel warehouseLabel = new JLabel("LIST OF PLACED ORDERS SENT TO WAREHOUSE");
        warehouseLabel.setForeground(Color.black);
        warehouseLabel.setFont(new Font("Arial",28,28));
        warehouseLabel.setFont((new Font("Dialog", Font.BOLD, 28)));
        warehouseLabel.setBounds(0,600,200,50);


        maintainOrder = new MaintainOrder(path);
        Object[][] data = null;

        try {
            data = maintainOrder.readDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] columns = {"Order ID", "Order Type", "Order Placed", "Order Delivery Date",
                "Shipping Address", "Order Status", "Movie", "Username", "MovieID", "Province"};


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
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(620);
        table.getColumnModel().getColumn(7).setPreferredWidth(20);


        TableModel model = new DefaultTableModel(data, columns);
        TableRowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);
        placedOrderTablePanel.add(new JScrollPane(table));

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
                        Messages.doesNotExistMsg("Order");
                    }
                }
            }
        });


        warehouseImagePanel.add(sysadminImageLabel);
        warehouseCaptionPanel.add(warehouseLabel);
        frame.add(warehouseImagePanel);
        frame.add(warehouseCaptionPanel);
        frame.add(searchPanel);
        frame.add(placedOrderTablePanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private ActionListener backListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            SystemAdminPage systemAdminPage = new SystemAdminPage(login);
        }
    };
}
