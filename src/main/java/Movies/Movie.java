package Movies;

public class Movie {
    private String title, actor, director, description, genre, releaseDate, copiesAvailable;

    public Movie(String title, String
            actor, String director, String description, String genre, String releaseDate, String copiesAvailable) {
        this.title = title;
        this.actor = actor;
        this.director = director;
        this.description = description;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.copiesAvailable = copiesAvailable;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(String copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", copiesAvailable=" + copiesAvailable +
                '}';
    }
}