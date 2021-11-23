package gui;

import Movies.MaintainMovie;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class UpdateMoviePage {

    JTable table;
    JTextField searchField;
    final String path = "../project/src/main/java/database/movies.csv";
    MaintainMovie maintainMovie;
    ImageIcon image3 = new ImageIcon("../project/src/main/resources/images/error.jpg");
    UpdateMoviePage(){

        JFrame frame = new JFrame("Update Movies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1800);

        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(Color.gray);
        tablePanel.setBounds(0,100,1800,400);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setBounds(0,800,1800,400);


        //infopanel for adding movie
        JPanel addinfoPanel = new JPanel();
        addinfoPanel.setBackground(Color.CYAN);
        addinfoPanel.setBounds(0,500, 1800,300);


        JLabel movieLabel = new JLabel("Movie");
        movieLabel.setForeground(Color.BLACK);
        movieLabel.setBounds(10,0,200,25);

        JTextField movieText = new JTextField();
        movieText.setBounds(10,25,200,25);

        JLabel titleLabel = new JLabel("Title");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(250,0,200,25);

        JTextField titleText = new JTextField();
        titleText.setForeground(Color.BLACK);
        titleText.setBounds(250,25,200,25);

        JLabel actorLabel = new JLabel("Actor");
        actorLabel.setForeground(Color.BLACK);
        actorLabel.setBounds(490,0,200,25);

        JTextField actorText = new JTextField();
        actorText.setForeground(Color.BLACK);
        actorText.setBounds(490,25,200,25);

        JLabel directorLabel = new JLabel("Director");
        directorLabel.setForeground(Color.BLACK);
        directorLabel.setBounds(10,50,200,25);

        JTextField directorText = new JTextField();
        directorText.setForeground(Color.BLACK);
        directorText.setBounds(10,75,200,25);

        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setBounds(250,50,200,25);


        JTextField descriptionText = new JTextField();
        descriptionText.setForeground(Color.BLACK);
        descriptionText.setBounds(250,75,200,25);

        JLabel genreLabel = new JLabel("Genre");
        genreLabel.setForeground(Color.BLACK);
        genreLabel.setBounds(490,50,200,25);

        JTextField genreText = new JTextField();
        genreText.setForeground(Color.BLACK);
        genreText.setBounds(490,75,200,25);

        JLabel releaseDateLabel = new JLabel("Release Date");
        releaseDateLabel.setForeground(Color.BLACK);
        releaseDateLabel.setBounds(10,100,200,25);

        JTextField releaseDateText = new JTextField();
        releaseDateText.setForeground(Color.BLACK);
        releaseDateText.setBounds(10,125,200,25);

        JLabel copiesAvailableLabel = new JLabel("Copies Available");
        copiesAvailableLabel.setForeground(Color.BLACK);
        copiesAvailableLabel.setBounds(250,100,200,25);

        JTextField copiesAvailableText = new JTextField();
        copiesAvailableText.setForeground(Color.BLACK);
        copiesAvailableText.setBounds(250,125,200,25);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(600,40,200,55);

        JButton removeButton = new JButton("REMOVE");
        removeButton.setBounds(820,40,200,55);

        JButton updateButton = new JButton("UPDATE");
        updateButton.setBounds(1040,40,200,55);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(1540,40,200,55);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.lightGray);
        searchPanel.setBounds(0, 0, 1800, 100);


        searchField = new JTextField(20);
        searchField.setBounds(400, 25, 800, 25);
        searchPanel.add(searchField);
        searchPanel.setLayout(null);

        JLabel searchLabel = new JLabel("SEARCH");
        searchLabel.setForeground(Color.white);
        searchLabel.setBounds(780, 60, 80, 25);
        searchLabel.setFont(new Font("Arial", 16, 20));
        searchPanel.add(searchLabel);


        maintainMovie = new MaintainMovie(path);
        Object[][] data = null;
        String[] columns = {"Title", "Actor", "Director", "Description"
                , "Genre", "Release Date", "Copies Available"};
        try {
            data = maintainMovie.readDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable(data, columns);
        table.setPreferredScrollableViewportSize(new Dimension(1700, 300));
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
        table.setBounds(0,200,1700,300);



        TableModel model = new DefaultTableModel(data, columns);
        TableRowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);





        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(300);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(6).setPreferredWidth(20);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);
        tablePanel.add(new JScrollPane(table));


        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {search(searchField.getText());}

            @Override
            public void removeUpdate(DocumentEvent e) { search(searchField.getText());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {search(searchField.getText());

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
        //infoPanel
        addinfoPanel.add(movieLabel);
        addinfoPanel.add(movieText);
        addinfoPanel.add(titleLabel);
        addinfoPanel.add(titleText);
        addinfoPanel.add(actorLabel);
        addinfoPanel.add(actorText);
        addinfoPanel.add(directorLabel);
        addinfoPanel.add(directorText);
        addinfoPanel.add(descriptionLabel);
        addinfoPanel.add(descriptionText);
        addinfoPanel.add(genreLabel);
        addinfoPanel.add(genreText);
        addinfoPanel.add(releaseDateLabel);
        addinfoPanel.add(releaseDateText);
        addinfoPanel.add(copiesAvailableLabel);
        addinfoPanel.add(copiesAvailableText);

        addinfoPanel.setLayout(null);

        buttonPanel.setLayout(null);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(backButton);
        frame.add(searchPanel);
        frame.add(tablePanel);
        frame.add(addinfoPanel);
        frame.add(buttonPanel);
        frame.setLayout(null);
        frame.setVisible(true);




    }







}
