package gui;

import Movies.MaintainMovie;
import OrderMaintainance.MaintainOrder;

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

public class UpdateOrdersPage {
    private JFrame frame;
    JTable table;
    JTextField searchField;
    final String path = "../project/src/main/java/database/orders.csv";
    MaintainMovie maintainMovie;
    ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");
    MaintainOrder maintainOrder;
    private JButton addButton, removeButton, updateButton, backButton;
//    private JTextField ;

    UpdateOrdersPage() {
        frame = new JFrame("Update Orders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1800);

        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(Color.gray);
        tablePanel.setBounds(0, 100, 1800, 465);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setBounds(0, 800, 1800, 400);

        JPanel updateOrderInfoPanel = new JPanel();
        updateOrderInfoPanel.setBackground(Color.PINK);
        updateOrderInfoPanel.setBounds(0,565,1800,236);

        JLabel orderID = new JLabel("Order ID");
        orderID.setForeground(Color.BLACK);
        orderID.setBounds(10, 0, 200, 25);
        updateOrderInfoPanel.add(orderID);

        JTextField orderIdText = new JTextField();
        orderIdText.setBounds(10, 25, 200, 25);
        updateOrderInfoPanel.add(orderIdText);

        JLabel orderTypeLabel = new JLabel("Order Type");
        orderTypeLabel.setForeground(Color.BLACK);
        orderTypeLabel.setBounds(250, 0, 200, 25);
        updateOrderInfoPanel.add(orderTypeLabel);

        JTextField orderTypeText = new JTextField();
        orderTypeText.setForeground(Color.BLACK);
        orderTypeText.setBounds(250, 25, 200, 25);
        updateOrderInfoPanel.add(orderTypeText);

        JLabel orderPlacedLabel = new JLabel("Order Placed Date");
        orderPlacedLabel.setForeground(Color.BLACK);
        orderPlacedLabel.setBounds(490, 0, 200, 25);
        updateOrderInfoPanel.add(orderPlacedLabel);

        JTextField orderPlacedText = new JTextField();
        orderPlacedText.setForeground(Color.BLACK);
        orderPlacedText.setBounds(490, 25, 200, 25);
        updateOrderInfoPanel.add(orderPlacedText);

        JLabel orderDeliveryDateLabel = new JLabel("Order Delivery Date");
        orderDeliveryDateLabel.setForeground(Color.BLACK);
        orderDeliveryDateLabel.setBounds(10, 50, 200, 25);
        updateOrderInfoPanel.add(orderDeliveryDateLabel);

        JTextField orderDeliveryDateText = new JTextField();
        orderDeliveryDateText.setForeground(Color.BLACK);
        orderDeliveryDateText.setBounds(10, 75, 200, 25);
        updateOrderInfoPanel.add(orderDeliveryDateText);

        JLabel shippingAddressLabel = new JLabel("Shipping Address");
        shippingAddressLabel.setForeground(Color.BLACK);
        shippingAddressLabel.setBounds(250, 50, 200, 25);
        updateOrderInfoPanel.add(shippingAddressLabel);

        JTextField shippingAddressText = new JTextField();
        shippingAddressText.setForeground(Color.BLACK);
        shippingAddressText.setBounds(250, 75, 200, 25);
        updateOrderInfoPanel.add(shippingAddressText);

        JLabel orderStatusLabel = new JLabel("Order Status");
        orderStatusLabel.setForeground(Color.BLACK);
        orderStatusLabel.setBounds(490, 50, 200, 25);
        updateOrderInfoPanel.add(orderStatusLabel);

        JTextField orderStatusText = new JTextField();
        orderStatusText.setForeground(Color.BLACK);
        orderStatusText.setBounds(490, 75, 200, 25);
        updateOrderInfoPanel.add(orderStatusText);

        JLabel movieLabel = new JLabel("Movie");
        movieLabel.setForeground(Color.BLACK);
        movieLabel.setBounds(10, 100, 200, 25);
        updateOrderInfoPanel.add(movieLabel);

        JTextField movieLabelText = new JTextField();
        movieLabelText.setForeground(Color.BLACK);
        movieLabelText.setBounds(10, 125, 200, 25);
        updateOrderInfoPanel.add(movieLabelText);

        JLabel unameLabel = new JLabel("Username");
        unameLabel.setForeground(Color.BLACK);
        unameLabel.setBounds(250, 100, 200, 25);
        updateOrderInfoPanel.add(unameLabel);

        JTextField unameText = new JTextField();
        unameText.setForeground(Color.BLACK);
        unameText.setBounds(250, 125, 200, 25);
        updateOrderInfoPanel.add(unameText);



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

        maintainOrder = new MaintainOrder(path);
        Object[][] data = null;

        try {
            data = maintainOrder.readDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] columns = {"Order ID", "Order Type", "Order Placed", "Order Delivery Date", "Shipping Address", "Order Status", "Movie", "Username"};


        JTable table = new JTable(data, columns);
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
        tablePanel.add(new JScrollPane(table));
//        table.addMouseListener(clickListener);                ///this

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

        updateOrderInfoPanel.setLayout(null);
        buttonPanel.setLayout(null);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(backButton);
        frame.add(searchPanel);
        frame.add(tablePanel);
        frame.add(updateOrderInfoPanel);
        frame.add(buttonPanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private ActionListener addListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    private ActionListener removeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    private ActionListener updateListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    private ActionListener backListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            SystemAdminPage systemAdminPage = new SystemAdminPage();
        }
    };
//    private MouseListener clickListener = new MouseListener() {           ///this
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            int row = table.getSelectedRow();
//
//            String id = table.getValueAt(row, 0).toString();
//            movieIdText.setText(id);
//
//            String title = table.getValueAt(row, 1).toString();
//            titleText.setText(title);
//
//            String actor = table.getValueAt(row, 2).toString();
//            actorText.setText(actor);
//
//            String director = table.getValueAt(row, 3).toString();
//            directorText.setText(director);
//
//            String description = table.getValueAt(row, 4).toString();
//            descriptionText.setText(description);
//
//            String genre = table.getValueAt(row, 5).toString();
//            genreText.setText(genre);
//
//            String releaseDate = table.getValueAt(row, 6).toString();
//            releaseDateText.setText(releaseDate);
//
//            String copies = table.getValueAt(row, 7).toString();
//            copiesAvailableText.setText(copies);
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//
//        }
//    };

}
