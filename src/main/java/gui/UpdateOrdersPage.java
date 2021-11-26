package gui;

import Movies.MaintainMovie;
import OrderMaintainance.MaintainOrder;
import OrderMaintainance.Order;
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
    private JTextField orderIdText, orderTypeText, orderPlacedText, orderDeliveryDateText,
            shippingAddressText, orderStatusText, movieLabelText, unameText, movieIdText,
            provinceText;

    private Login login;

    UpdateOrdersPage(Login login) {
        this.login = login;
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
        updateOrderInfoPanel.setBounds(0, 565, 1800, 236);

        JLabel orderID = new JLabel("Order ID");
        orderID.setForeground(Color.BLACK);
        orderID.setBounds(10, 0, 200, 25);
        updateOrderInfoPanel.add(orderID);

        orderIdText = new JTextField();
        orderIdText.setBounds(10, 25, 200, 25);
        updateOrderInfoPanel.add(orderIdText);

        JLabel orderTypeLabel = new JLabel("Order Type");
        orderTypeLabel.setForeground(Color.BLACK);
        orderTypeLabel.setBounds(250, 0, 200, 25);
        updateOrderInfoPanel.add(orderTypeLabel);

        orderTypeText = new JTextField();
        orderTypeText.setForeground(Color.BLACK);
        orderTypeText.setBounds(250, 25, 200, 25);
        updateOrderInfoPanel.add(orderTypeText);

        JLabel orderPlacedLabel = new JLabel("Order Placed Date");
        orderPlacedLabel.setForeground(Color.BLACK);
        orderPlacedLabel.setBounds(490, 0, 200, 25);
        updateOrderInfoPanel.add(orderPlacedLabel);

        orderPlacedText = new JTextField();
        orderPlacedText.setForeground(Color.BLACK);
        orderPlacedText.setBounds(490, 25, 200, 25);
        updateOrderInfoPanel.add(orderPlacedText);

        JLabel orderDeliveryDateLabel = new JLabel("Order Delivery Date");
        orderDeliveryDateLabel.setForeground(Color.BLACK);
        orderDeliveryDateLabel.setBounds(10, 50, 200, 25);
        updateOrderInfoPanel.add(orderDeliveryDateLabel);

        orderDeliveryDateText = new JTextField();
        orderDeliveryDateText.setForeground(Color.BLACK);
        orderDeliveryDateText.setBounds(10, 75, 200, 25);
        updateOrderInfoPanel.add(orderDeliveryDateText);

        JLabel shippingAddressLabel = new JLabel("Shipping Address");
        shippingAddressLabel.setForeground(Color.BLACK);
        shippingAddressLabel.setBounds(250, 50, 200, 25);
        updateOrderInfoPanel.add(shippingAddressLabel);

        shippingAddressText = new JTextField();
        shippingAddressText.setForeground(Color.BLACK);
        shippingAddressText.setBounds(250, 75, 200, 25);
        updateOrderInfoPanel.add(shippingAddressText);

        JLabel orderStatusLabel = new JLabel("Order Status");
        orderStatusLabel.setForeground(Color.BLACK);
        orderStatusLabel.setBounds(490, 50, 200, 25);
        updateOrderInfoPanel.add(orderStatusLabel);

        orderStatusText = new JTextField();
        orderStatusText.setForeground(Color.BLACK);
        orderStatusText.setBounds(490, 75, 200, 25);
        updateOrderInfoPanel.add(orderStatusText);

        JLabel movieLabel = new JLabel("Movie");
        movieLabel.setForeground(Color.BLACK);
        movieLabel.setBounds(10, 100, 200, 25);
        updateOrderInfoPanel.add(movieLabel);

        movieLabelText = new JTextField();
        movieLabelText.setForeground(Color.BLACK);
        movieLabelText.setBounds(10, 125, 200, 25);
        updateOrderInfoPanel.add(movieLabelText);

        JLabel unameLabel = new JLabel("Username");
        unameLabel.setForeground(Color.BLACK);
        unameLabel.setBounds(250, 100, 200, 25);
        updateOrderInfoPanel.add(unameLabel);

        unameText = new JTextField();
        unameText.setForeground(Color.BLACK);
        unameText.setBounds(250, 125, 200, 25);
        updateOrderInfoPanel.add(unameText);

        JLabel movieIDLabel = new JLabel("Movie ID");
        movieIDLabel.setForeground(Color.BLACK);
        movieIDLabel.setBounds(490, 100, 200, 25);
        updateOrderInfoPanel.add(movieIDLabel);

        movieIdText = new JTextField();
        movieIdText.setForeground(Color.BLACK);
        movieIdText.setBounds(490, 125, 200, 25);
        updateOrderInfoPanel.add(movieIdText);


        JLabel provinceLabel = new JLabel("Province");
        provinceLabel.setForeground(Color.BLACK);
        provinceLabel.setBounds(720, 100, 200, 25);
        updateOrderInfoPanel.add(provinceLabel);


        provinceText = new JTextField();
        provinceText.setForeground(Color.BLACK);
        provinceText.setBounds(720, 125, 200, 25);
        updateOrderInfoPanel.add(provinceText);


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
        table.addMouseListener(clickListener);
    }

    private ActionListener addListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                try {
                    Order order = getOrderFromInput();

                    if (maintainOrder.addOrder(order)) {
                        System.out.println("Order Added");
                    } else {
                        System.out.println("Order Already Exists");
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    };

    private Order getOrderFromInput() {
        String orderId = orderIdText.getText();
        String type = orderTypeText.getText();
        String placedDate = orderPlacedText.getText();
        String deiveryDate = orderDeliveryDateText.getText();
        String address = shippingAddressText.getText();
        String status = orderStatusText.getText();
        String movies = movieLabelText.getText();
        String uname = unameText.getText();
        String movieID = movieIdText.getText();
        String province = provinceText.getText();

        return new Order(orderId, type, placedDate, deiveryDate, address,
                status, movies, uname, movieID, province);
    }

    private ActionListener removeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == removeButton) {
                try {
                    Order order = getOrderFromInput();
                    if (maintainOrder.removeOrder(order)) {
                        System.out.println("Order Removed");
                    } else {
                        System.out.println("Order Does Not Exist");
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
                    Order order = getOrderFromInput();
                    if (maintainOrder.updateOrder(order)) {
                        System.out.println("Order Updated");
                    } else {
                        System.out.println("Order Already Exists");
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

            String orderId = table.getValueAt(row, 0).toString();
            orderIdText.setText(orderId);

            String orderType = table.getValueAt(row, 1).toString();
            orderTypeText.setText(orderType);

            String orderPlaced = table.getValueAt(row, 2).toString();
            orderPlacedText.setText(orderPlaced);

            String orderDeliveryDate = table.getValueAt(row, 3).toString();
            orderDeliveryDateText.setText(orderDeliveryDate);

            String shippingAddress = table.getValueAt(row, 4).toString();
            shippingAddressText.setText(shippingAddress);

            String orderStatus = table.getValueAt(row, 5).toString();
            orderStatusText.setText(orderStatus);

            String movieName = table.getValueAt(row, 6).toString();
            movieLabelText.setText(movieName);

            String uname = table.getValueAt(row, 7).toString();
            unameText.setText(uname);

            String movieId = table.getValueAt(row, 8).toString();
            movieIdText.setText(movieId);

            String province = table.getValueAt(row, 9).toString();
            provinceText.setText(province);
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
