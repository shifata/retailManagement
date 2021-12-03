package Movies;

import OrderMaintainance.Order;
import Utils.IdGenerator;
import Utils.Sorter;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MaintainMovie {
    private final String path;
    private static ArrayList<Movie> moviesList;

    public MaintainMovie(String path) {
        this.path = path;
        moviesList = new ArrayList<>();
    }

    public ArrayList<Movie> readDatabaseList() throws Exception {
        FileReader fileReader = new FileReader(path);
        CsvReader reader = new CsvReader(fileReader);

        try {
            reader.readHeaders();
            while (reader.readRecord()) {
                String id = reader.get("movieID");
                String tile = reader.get("title");
                String actor = reader.get("actor");
                String director = reader.get("director");
                String description = reader.get("description");
                String genre = reader.get("genre");
                String releaseDate = reader.get("releaseDate");
                String copiesAvailable = reader.get("copiesAvailable");
                // Adding the movie to collection
                moviesList.add(new Movie(id, tile, actor, director, description,
                        genre, releaseDate, copiesAvailable));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return moviesList;
    }

    public Object[][] readDatabase() throws Exception {
        readDatabaseList();
        Object[][] output = new Object[moviesList.size()][8];

        for (int i = 0; i < moviesList.size(); i++) {
            Movie current = moviesList.get(i);
            output[i][0] = current.getId();
            output[i][1] = current.getTitle();
            output[i][2] = current.getActor();
            output[i][3] = current.getDirector();
            output[i][4] = current.getDescription();
            output[i][5] = current.getGenre();
            output[i][6] = current.getReleaseDate();
            output[i][7] = current.getCopiesAvailable();
        }

        return output;
    }

    public boolean writeToMovie() throws Exception {
        CsvWriter writer = new CsvWriter(new FileWriter(path, false), ',');
        try {
            writer.write("movieID");
            writer.write("title");
            writer.write("actor");
            writer.write("director");
            writer.write("description");
            writer.write("genre");
            writer.write("releaseDate");
            writer.write("copiesAvailable");
            writer.endRecord();
            writer.flush();

            Sorter.sortMoviesById(moviesList);

            for (Movie m : moviesList) {
                writer.write(m.getId());
                writer.write(m.getTitle());
                writer.write(m.getActor());
                writer.write(m.getDirector());
                writer.write(m.getDescription());
                writer.write(m.getGenre());
                writer.write(m.getReleaseDate());
                writer.write(m.getCopiesAvailable());
                writer.endRecord();
                writer.flush();
            }
            writer.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private void clear() {
        moviesList.clear();
    }

    // TRUE adds a copy. FALSE removes a copy
    public void changeCopiesAfterRemove(Order order, boolean add) {
        clear();
        try {
            readDatabaseList();
        }catch (Exception e){
            e.printStackTrace();
        }
        String[] ids = order.getMovieId().split(";");

        try {
            for (Movie m : moviesList) {
                for (String id : ids) {
                    if (m.getId().equals(id)) {
                        Movie tmp = new Movie(m.getId(), m.getTitle(), m.getActor(), m.getDirector(),
                                m.getDescription(), m.getGenre(), m.getReleaseDate(), m.getCopiesAvailable());
                        String copies = "";

                        if (add) {
                            copies = (Integer.parseInt(m.getCopiesAvailable()) + 1) + "";
                        } else {
                            copies = (Integer.parseInt(m.getCopiesAvailable()) - 1) + "";
                        }

                        tmp.setCopiesAvailable(copies);
                        updateMovie(tmp);
                        System.out.println("UPDATED");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addMovie(Movie movie) {
        boolean exists = movieExists(movie);
        try {
            if (!exists) {
                movie.setId(IdGenerator.getId(4));
                moviesList.add(movie);
                writeToMovie();
                clear();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeMovie(Movie movie) throws Exception {
        boolean exists = movieExists(movie);

        if (exists) {
            int index = getMovieIndex(movie);
            moviesList.remove(index);
            writeToMovie();
            clear();
            return true;
        }

        return false;
    }

    public boolean updateMovie(Movie movie) throws Exception {
        boolean exists = movieExists(movie);

        if (exists) {
            for (int i = 0; i < moviesList.size(); i++) {
                if (moviesList.get(i).getId().equals(movie.getId())) {
                    moviesList.remove(i);
                }
            }
            moviesList.add(movie);
            writeToMovie();
            clear();
            return true;
        }
        return false;
    }


    private boolean movieExists(Movie movie) {
        for (Movie m : moviesList) {
            if (m.getId().equals(movie.getId())) {
                return true;
            }
        }
        return false;
    }

    private int getMovieIndex(Movie m) {
        for (int i = 0; i < moviesList.size(); i++) {
            if (moviesList.get(i).equals(m)) {
                return i;
            }
        }
        return -1;
    }

    public static Movie getMovieFromName(String name) {
        for (Movie m : moviesList) {
            if (m.getTitle().equals(name)) {
                return m;
            }
        }
        return null;
    }
}
