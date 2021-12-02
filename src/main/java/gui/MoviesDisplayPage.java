package gui;

import Movies.MaintainMovie;
import Movies.Movie;
import OrderMaintainance.Order;
import UserMaintainance.Login;
import Utils.Messages;
import Utils.IdGenerator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class MoviesDisplayPage {
    private static ArrayList<Movie> cart;
    private JButton myProfile, logout, proceedCheckout;
    private MaintainMovie maintainMovie;
    private JFrame frame;
    private JTable table;
    private JPanel tablePanel;
    final String path = "../project/src/main/java/database/movies.csv";
    private JTextField searchField;
    private static Login login;
    private JButton addMovieToCart;

    MoviesDisplayPage(Login login) {
        this.login = login;
        cart = new ArrayList<>();
        ImageIcon image2 = new ImageIcon("../project/src/main/resources/images/rentalPage.png");
        ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");

        frame = new JFrame();
        tablePanel = new JPanel();
        tablePanel.setSize(1800, 1000);
        tablePanel.setBackground(Color.blue);
        tablePanel.setBounds(0, 380, 1800, 450);

        //rentalImage Panel contains the image, caption, and command buttons myProfile and Logout
        JPanel rentalImage = new JPanel();
        rentalImage.setBackground(Color.black);
        rentalImage.setBounds(0, 0, 1800, 280);

        //rentalLabel is the object that holds the caption and image
        JLabel rentalLabel = new JLabel(); //create a label
        rentalLabel.setText("MOVIES FOR RENT"); //set text of label
        rentalLabel.setIcon(image2);
        rentalLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image
        rentalLabel.setVerticalTextPosition(JLabel.TOP);
        rentalLabel.setForeground(Color.white);
        rentalLabel.setIconTextGap(15);
        rentalLabel.setBackground(Color.black);
        rentalLabel.setOpaque(true); //displays background color
//        rentalLabel.setBorder(border); //displays border
        rentalLabel.setBounds(200, 50, 400, 300); //set x and y permanent position of the image
        rentalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        rentalLabel.setVerticalAlignment(JLabel.TOP);
        rentalLabel.setHorizontalAlignment(JLabel.CENTER);
        rentalImage.add(rentalLabel);


        myProfile = new JButton("My Profile");
        myProfile.setBounds(300, 100, 100, 25);
        rentalImage.add(myProfile);

        logout = new JButton("Log Out");
        myProfile.setBounds(300, 200, 100, 25);
        rentalImage.add(logout);

        //searchPanel Panel contains the search engine (command buttons: search by name and search by category)
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.red);
        searchPanel.setBounds(0, 280, 1800, 100);


        searchField = new JTextField(20);
        searchField.setBounds(400, 25, 800, 25);
        searchPanel.add(searchField);
        searchPanel.setLayout(null);

        JLabel searchLabel = new JLabel("SEARCH");
        searchLabel.setForeground(Color.white);
        searchLabel.setBounds(780, 60, 80, 25);
        searchLabel.setFont(new Font("Arial", 16, 20));
        searchPanel.add(searchLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setSize(100, 100);
        bottomPanel.setBackground(Color.green);
        bottomPanel.setBounds(0, 830, 1800, 200);
        bottomPanel.setLayout(null);

        addMovieToCart = new JButton("Add Order To Cart");
        addMovieToCart.setBounds(600, 100, 200, 25);
        bottomPanel.add(addMovieToCart);

        proceedCheckout = new JButton("Proceed to Checkout");
        proceedCheckout.setBounds(800, 100, 200, 25);
        bottomPanel.add(proceedCheckout);
        proceedCheckout.addActionListener(checkOutListener);

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
        table.setPreferredScrollableViewportSize(new Dimension(1700, 400));
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
        //tablePanel cannot be null
        //frame layout can be null
        myProfile.addActionListener(profileListener);
        logout.addActionListener(logoutListener);

        //search implementation
        TableModel model = new DefaultTableModel(data, columns);
        TableRowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);

        addMovieToCart.addMouseListener(cartListener);

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
                        Messages.doesNotExistMsg("MOVIE");
                    }
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1800);
        frame.setVisible(true);
        frame.add(rentalImage);
        frame.add(searchPanel);
        frame.add(tablePanel);
        frame.add(bottomPanel);
        //panel.setLayout(null);
        frame.setLayout(null);

    }

    public static ArrayList<Movie> emptyCart() {
        cart.clear();
        return cart;
    }

    public static ArrayList<Movie> getCart() {
        return cart;
    }

    public static Order getOrderFromCart() {
        String id = IdGenerator.getId(5);
        String type = "Online";
        String placedDate = "23-Nov-2021";
        String deliveryDate = null;
        String shippingAddress = login.getAddress();
        String status = "Placed";
        String title = "";
        String movieId = "";

        for (Movie m : cart) {
            title += m.getTitle() + ";";
            movieId += m.getId() + ";";
        }

        String uname = login.getUName();
        String[] provinces = {"Ontario", "Quebec", "Alberta"};
        Random random = new Random();
        int rand = random.nextInt(3);
        String province = provinces[rand];

        return new Order(id, type, placedDate, deliveryDate, shippingAddress,
                status, title, uname, movieId, province);
    }

    private MouseListener cartListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

            int row = table.getSelectedRow();
            String id = table.getValueAt(row, 0).toString();
            String name = table.getValueAt(row, 1).toString();
            String actor = table.getValueAt(row, 2).toString();
            String director = table.getValueAt(row, 3).toString();
            String description = table.getValueAt(row, 4).toString();
            String genre = table.getValueAt(row, 5).toString();
            String releaseDate = table.getValueAt(row, 6).toString();
            String copies = table.getValueAt(row, 7).toString();

            if (Integer.parseInt(copies) > 0) {
                cart.add(new Movie(id, name, actor, director, description, genre, releaseDate, copies));
            } else {
                Messages.customMsg("Movie out of stock");
            }

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

    private ActionListener checkOutListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (cart.size() != 0) {
                CheckOutPage checkOutPage = new CheckOutPage(login);
            } else {
                //todo: add error message
                Messages.customMsg("Cart Is Empty. Add movie to cart before proceeding to checkout");
            }
        }
    };

    private ActionListener profileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e1) {
            // todo
            frame.dispose();
            MyProfilePage myProfilePage = new MyProfilePage(login);
        }
    };

    private ActionListener logoutListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            if (e2.getSource() == logout) {
                LoginPage lp = new LoginPage();
                frame.dispose();
            }
        }
    };
}
