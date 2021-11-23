package Movies;

public class Movie {
    private String id, title, actor, director, description, genre, releaseDate, copiesAvailable;

    public Movie(String id, String title, String
            actor, String director, String description, String genre, String releaseDate, String copiesAvailable) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", copiesAvailable='" + copiesAvailable + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie other = (Movie) o;

        return other.getId().equals(id) && other.getTitle().equals(title) &&
                other.actor.equals(actor) && other.getDirector().equals(director) &&
                other.description.equals(description) && other.genre.equals(genre) &&
                other.releaseDate.equals(releaseDate) && other.copiesAvailable.equals(copiesAvailable);


    }


}
