package Movies;

import com.csvreader.CsvReader;

import java.io.FileReader;
import java.util.ArrayList;

public class MaintainMovie {
    private final String path;
    private ArrayList<Movie> collection;

    public MaintainMovie(String path) {
        this.path = path;
        collection = new ArrayList<>();
    }

    private ArrayList<Movie> readDatabase() throws Exception {
        FileReader fileReader = new FileReader(path);
        CsvReader reader = new CsvReader(fileReader);

        try {
            reader.readHeaders();
            while (reader.readRecord()) {
                String tile = reader.get("title");
                String actor = reader.get("actor");
                String director = reader.get("director");
                String description = reader.get("description");
                String genre = reader.get("genre");
                String releaseDate = reader.get("releaseDate");
                String copiesAvailable = reader.get("copiesAvailable");
                // Adding the movie to collection
                collection.add(new Movie(tile, actor, director, description, genre, releaseDate, copiesAvailable));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return collection;
    }

    private void writeToDatabase(Movie movie) {

    }

    public boolean addMovie(Movie movie) {
        return false;
    }

    public boolean removeMovie(Movie movie) {
        return false;
    }

    public boolean updateMovie(Movie movie) {
        return false;
    }
}
