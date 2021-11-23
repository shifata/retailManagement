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
                moviesList.add(new Movie(id, tile, actor, director, description, genre, releaseDate, copiesAvailable));
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


    public boolean addMovie(Movie movie) throws Exception {
        boolean exists = false;
        for (Movie m : moviesList) {
            if (m.equals(movie)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            CsvWriter writer = new CsvWriter(new FileWriter(path, true), ',');
            try {
                writer.write(movie.getId());
                writer.write(movie.getTitle());
                writer.write(movie.getActor());
                writer.write(movie.getDirector());
                writer.write(movie.getDescription());
                writer.write(movie.getGenre());
                writer.write(movie.getReleaseDate());
                writer.write(movie.getCopiesAvailable());
                writer.endRecord();
                writer.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean removeMovie(Movie movie) {
        return false;
    }

    public boolean updateMovie(Movie movie) {
        return false;
    }
}
