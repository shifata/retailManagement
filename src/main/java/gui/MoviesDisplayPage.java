package gui;

import Movies.MaintainMovie;

import javax.swing.*;
import java.awt.*;

public class MoviesDisplayPage {
        private MaintainMovie maintainMovie;
        final String path = "../project/src/main/java/database/movies.csv";
    MoviesDisplayPage(){
        ImageIcon image2 = new ImageIcon("../project/src/main/resources/images/rentalPage.png");

        JFrame frame = new JFrame();
        JPanel tablePanel = new JPanel();
        tablePanel.setSize(1800,1000);
        tablePanel.setBackground(Color.blue);
        tablePanel.setBounds(0,380,1800,450);

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


        JButton myProfile = new JButton("My Profile");
        myProfile.setBounds(300, 100, 100, 25);
        rentalImage.add(myProfile);

        JButton logout = new JButton("Log Out");
        myProfile.setBounds(300, 200, 100, 25);
        rentalImage.add(logout);

        //searchPanel Panel contains the search engine (command buttons: search by name and search by category)
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.red);
        searchPanel.setBounds(0, 280, 1800, 100);


        JTextField searchField = new JTextField(20);
        searchField.setBounds(320, 160, 100, 25);
        searchPanel.add(searchField);


        JButton searchByName = new JButton("Search by Name");
        searchByName.setBounds(520, 200, 200, 25);
        searchPanel.add(searchByName);

        JButton searchByGenre = new JButton("Search by Genre");
        searchByGenre.setBounds(740, 200, 200, 25);
        searchPanel.add(searchByGenre);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setSize(100,100);
        bottomPanel.setBackground(Color.green);
        bottomPanel.setBounds(0,830,1800,200);
        bottomPanel.setLayout(null);

        JButton addMovieToCart = new JButton("Add Order To Cart");
        addMovieToCart.setBounds(600, 100, 200, 25);
        bottomPanel.add(addMovieToCart);

        JButton proceedCheckout = new JButton("Proceed to Checkout");
        proceedCheckout.setBounds(800, 100, 200, 25);
        bottomPanel.add(proceedCheckout);

        maintainMovie = new MaintainMovie(path);
        Object[][] data = null;
        String[] columns = {"Title", "Actor", "Director", "Description"
                , "Genre", "Release Date", "Copies Available"};
        try {
            data = maintainMovie.readDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }

        JTable table = new JTable(data,columns);
        table.setPreferredScrollableViewportSize(new Dimension(1700,400));
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
        //tablePanel cannot be null
        //frame layout can be null


        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(300);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(6).setPreferredWidth(20);
        tablePanel.add(new JScrollPane(table));
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
}
