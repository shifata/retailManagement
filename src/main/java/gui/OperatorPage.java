package gui;

import Movies.MaintainMovie;
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

public class OperatorPage {

    private MaintainMovie maintainMovie;
    final String path = "../project/src/main/java/database/movies.csv";
    private JTable table;
    JFrame frame;
    private Login login;

    OperatorPage(Login login) {
        this.login = login;
        ImageIcon image11 = new ImageIcon("../project/src/main/resources/images/operator.png");
        ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");

        frame = new JFrame("Operator Mode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1600);

        JPanel operatorImagePanel = new JPanel();
        operatorImagePanel.setBackground(Color.yellow);
        operatorImagePanel.setBounds(0, 0, 1800, 250);

        JLabel loggedinAsLabel = new JLabel("LOGGED IN AS:"+"  "+  login.getUName());
        loggedinAsLabel.setForeground(Color.white);
        loggedinAsLabel.setFont(new Font("Arial", 18,18));
        loggedinAsLabel.setBounds(510, 10, 450, 25);

        JPanel opsButtonPanel = new JPanel();
        opsButtonPanel.setBackground(Color.orange);
        opsButtonPanel.setBounds(0, 300, 1800, 80);
        opsButtonPanel.setLayout(null);

        JPanel captionPanel = new JPanel();
        captionPanel.setBackground(Color.yellow);
        captionPanel.setBounds(0, 250, 1800, 50);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.red);
        searchPanel.setBounds(0, 380, 1800, 100);

        JTextField searchField = new JTextField(20);
        searchField.setBounds(100, 25, 600, 25);
        searchPanel.add(searchField);
        searchPanel.setLayout(null);
        searchPanel.add(searchField);

        JLabel captionLabel = new JLabel("OPERATOR MODE");
        captionLabel.setBackground(Color.BLACK);
        captionLabel.setFont(new Font("Arial", 26, 26));
        captionLabel.setBounds(200, 260, 400, 40);
        captionPanel.add(captionLabel);


        JLabel searchLabel = new JLabel("SEARCH");
        searchLabel.setForeground(Color.white);
        searchLabel.setBounds(380, 60, 80, 25);
        searchLabel.setFont(new Font("Arial", 16, 20));
        searchPanel.add(searchLabel);

        JPanel tablePanel = new JPanel();
        tablePanel.setSize(1700, 400);
        tablePanel.setBackground(Color.orange);
        tablePanel.setBounds(0, 481, 1800, 250);

        JPanel infoPanel = new JPanel();
        infoPanel.setSize(1700, 100);
        infoPanel.setBackground(Color.blue);
        infoPanel.setBounds(0, 731, 1800, 100);
        infoPanel.setLayout(null);

        JLabel shippingLabel = new JLabel("Shipping Address");
        shippingLabel.setForeground(Color.white);
        shippingLabel.setFont(new Font("Arial", 20, 20));
        shippingLabel.setBounds(40, 10, 200, 30);
        infoPanel.add(shippingLabel);

        JTextField shippingAddressText = new JTextField();
        shippingAddressText.setBounds(240, 10, 500, 25);
        infoPanel.add(shippingAddressText);

        JLabel provinceLabel = new JLabel("Province");
        provinceLabel.setForeground(Color.white);
        provinceLabel.setFont(new Font("Arial", 20, 20));
        provinceLabel.setBounds(40, 40, 200, 30);
        infoPanel.add(provinceLabel);

        JTextField provinceText = new JTextField();
        provinceText.setBounds(240, 40, 200, 25);
        infoPanel.add(provinceText);

//        tablePanel.setLayout(null);


//        JPanel loggedinAsPanel = new JPanel();
//        loggedinAsPanel.setBackground(Color.blue);
//        loggedinAsPanel.setBounds(340, 10, 300, 45);
//        loggedinAsPanel.setLayout(null);


//        JLabel loggedinAsLabel = new JLabel("LOGGED IN AS" + "");
//        loggedinAsLabel.setFont(new Font("Arial", 18, 18));
//        loggedinAsLabel.setForeground(Color.BLACK);
//        loggedinAsLabel.setBounds(510, 10, 150, 25);
//        loggedinAsLabel.setLayout(null);
        // loggedinAsPanel.add(loggedinAsLabel);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(40, 10, 80, 25);
        logoutButton.addActionListener(logOutListener);

        JButton myProfileButton = new JButton("Profile");
        myProfileButton.setBounds(140, 10, 80, 25);
        myProfileButton.addActionListener(profileListener);

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.setBounds(180, 900, 250, 60);

        JButton checkOrderButton = new JButton("Check Order Status");
        checkOrderButton.setBounds(420, 900, 250, 60);
        checkOrderButton.addActionListener(checkStatusListener);


        JLabel operatorImageLabel = new JLabel();
        operatorImageLabel.setIcon(image11);
        operatorImageLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        operatorImageLabel.setVerticalTextPosition(JLabel.TOP);
        operatorImageLabel.setForeground(Color.white);
        operatorImageLabel.setIconTextGap(15);
        operatorImageLabel.setBackground(Color.black);
        operatorImageLabel.setOpaque(true);
        operatorImageLabel.setBounds(20, 100, 200, 140);

        maintainMovie = new MaintainMovie(path);
        Object[][] data = null;
        String[] columns = {"Movie ID", "Title", "Actor", "Director", "Description"
                , "Genre", "Release Date", "Copies Available"};
        try {
            data = maintainMovie.readDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable(data, columns);
        table.setPreferredScrollableViewportSize(new Dimension(1600, 200));
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
//        table.setBounds(0,490,700,300);

        //search implementation
        TableModel model = new DefaultTableModel(data, columns);
        TableRowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);

        table.getColumnModel().getColumn(0).setPreferredWidth(3);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(190);
        table.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.getColumnModel().getColumn(4).setPreferredWidth(400);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(5);
        table.getColumnModel().getColumn(7).setPreferredWidth(5);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setRowSelectionAllowed(true);
//        table.setColumnSelectionAllowed(true);
        tablePanel.add(new JScrollPane(table));

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
                        JLabel noMoviesFound = new JLabel("NO MOVIES FOUND");
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

        opsButtonPanel.add(loggedinAsLabel);
        opsButtonPanel.add(logoutButton);
        opsButtonPanel.add(myProfileButton);
        opsButtonPanel.add(loggedinAsLabel);
//        opsButtonPanel.add(loggedinAsPanel);

        operatorImagePanel.add(operatorImageLabel);
        frame.add(operatorImagePanel);
        frame.add(captionPanel);
        frame.add(opsButtonPanel);
        frame.add(searchPanel);
        frame.add(tablePanel);
        frame.add(placeOrderButton);
        frame.add(checkOrderButton);
        frame.add(infoPanel);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    private ActionListener checkStatusListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            CheckOrderStatusPage status = new CheckOrderStatusPage(login);
        }
    };

    private ActionListener logOutListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            LoginPage lp = new LoginPage();
        }
    };

    private ActionListener profileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            MyProfilePage profile = new MyProfilePage(login);
        }
    };
}
