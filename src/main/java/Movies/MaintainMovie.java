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
                collection.add(new Movie(id, tile, actor, director, description, genre, releaseDate, copiesAvailable));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        reader.close();
        return collection;
    }

    public Object[][] readDatabase() throws Exception {
        readDatabaseList();
        Object[][] output = new Object[collection.size()][7];

        for (int i = 0; i < collection.size(); i++) {
            Movie current = collection.get(i);
            output[i][0] = current.getTitle();
            output[i][1] = current.getActor();
            output[i][2] = current.getDirector();
            output[i][3] = current.getDescription();
            output[i][4] = current.getGenre();
            output[i][5] = current.getReleaseDate();
            output[i][6] = current.getCopiesAvailable();
//            System.out.println(Arrays.toString(output[i]));
        }

        return output;
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
