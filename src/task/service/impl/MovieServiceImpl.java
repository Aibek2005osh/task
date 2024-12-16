package task.service.impl;

import task.db.Detabese;
import task.enoms.Genre;
import task.models.Actor;
import task.models.Movie;
import task.service.MovieService;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MovieServiceImpl implements MovieService {

    @Override
    public List<Movie> getAllMovies() {
        return Detabese.dateMovies;

    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie dateMovie : Detabese.dateMovies) {
            if (dateMovie.getName().equals(name)) {
                return dateMovie;
            }

        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie dateMovie : Detabese.dateMovies) {
            for (Actor actor : dateMovie.getActors()) {
                if (actor.getActorFullName().contains(actorName)) {
                    return dateMovie;
                }

            }

        }
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie dateMovie : Detabese.dateMovies) {
            if (dateMovie.getYear().equals(year)){
                return dateMovie;
            }

        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie dateMovie : Detabese.dateMovies) {
            String fullName = dateMovie.getProducer().getFirstName() + " " + dateMovie.getProducer().getLastName();

            if (fullName .trim().equals(producerFullName)){
                return dateMovie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie dateMovie : Detabese.dateMovies) {
            if (dateMovie.getGenre().equals(genre)) {
                return dateMovie;
            }

        }
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {

        for (Movie dateMovie : Detabese.dateMovies) {
            for (Actor actor : dateMovie.getActors()) {
                if (actor.getRole().trim().equals(role)) {
                    return dateMovie;
                }
            }
        }
        return null;
    }
}
