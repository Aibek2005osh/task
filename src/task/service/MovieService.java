package task.service;

import task.enoms.Genre;
import task.models.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie findMovieByFullNameOrPartName(String name);

    Movie findMovieByActorName(String actorName);

    Movie findMovieByYear(LocalDate year);

    Movie findMovieByProducer(String producerFullName);

    Movie findMovieByGenre(Genre genre);

    Movie findMovieByRole(String role);


}
