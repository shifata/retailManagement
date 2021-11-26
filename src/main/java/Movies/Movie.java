package Movies;

import Utils.IdGenerator;

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

        return other.title.equals(this.title) &&
                other.actor.equals(this.actor) && other.director.equals(this.director) &&
                this.description.equals(other.description) && other.genre.equals(this.genre) &&
                other.releaseDate.equals(this.releaseDate) && other.copiesAvailable.equals(this.copiesAvailable);


    }

}
