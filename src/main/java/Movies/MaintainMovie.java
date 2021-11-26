package Movies;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MaintainMovie {
    private final String path;
    private ArrayList<Movie> moviesList;

    public MaintainMovie(String path) {
        this.path = path;
        moviesList = new ArrayList<>();
    }

    public ArrayList<Movie> getMoviesList() {
        return moviesList;
    }

    private boolean addToList(Movie m) {
        for (Movie movie : moviesList) {
            if (!m.equals(movie)) {
                moviesList.add(m);
                return true;
            }
        }
        return false;
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        reader.close();
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

    private void sortMoviesById(ArrayList<Movie> movies) {
        for (int i = 0; i < movies.size(); i++) {
            for (int j = 0; j < movies.size(); j++) {
                if (Integer.parseInt(movies.get(i).getId()) < Integer.parseInt(movies.get(j).getId())) {
                    swap(movies, i, j);
                }
            }
        }
    }

    private void swap(ArrayList<Movie> movies, int a, int b) {
        Movie tmp = movies.get(a);
        movies.set(a, movies.get(b));
        movies.set(b, tmp);
    }

    public boolean writeToMovie(ArrayList<Movie> movies) throws Exception {
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
            sortMoviesById(moviesList);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.close();
        return false;
    }

    public boolean addMovie(Movie movie) {
        boolean exists = movieExists(movie);
        try {
            if (!exists) {
                moviesList.add(movie);
                writeToMovie(moviesList);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateMovie(Movie movie) throws Exception {
        boolean exists = movieExists(movie);

        if (!exists) {
//            moviesList.remove(movie);
            for (int i = 0; i < moviesList.size(); i++) {
                if (moviesList.get(i).getId().equals(movie.getId())) {
                    moviesList.remove(i);
                }
            }
            moviesList.add(movie);
            writeToMovie(moviesList);
            return true;
        }
        return false;
    }


    public boolean removeMovie(Movie movie) throws Exception {
        boolean exists = movieExists(movie);

        if (exists) {
            int index = getMovieIndex(movie);
            moviesList.remove(index);
            writeToMovie(moviesList);
            return true;
        }

        return false;
    }

    private boolean movieExists(Movie movie) {
        for (Movie m : moviesList) {
            if (m.equals(movie)) {
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
}
