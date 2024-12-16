package task.sort.Impl;

import task.db.Detabese;
import task.models.Movie;
import task.sort.SortMovieService;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;

public class SortMovieServiceImpl implements SortMovieService {

    @Override
    public void sortMovieByNameAZ() {
        Detabese.dateMovies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


    }

    @Override
    public void sortMovieByNameZA() {
        Detabese.dateMovies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });


    }

    @Override
    public void sortByYear1_9() {
        Detabese.dateMovies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getYear().compareTo(o2.getYear());
            }
        });

    }

    @Override
    public void sortByProducer() {


        Detabese.dateMovies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                String fullName1 = o1.getProducer().getFirstName() + " " + o1.getProducer().getLastName();
                String fullName2 = o2.getProducer().getFirstName() + " " + o2.getProducer().getLastName();

                return fullName1.compareTo(fullName2);
            }
        });

    }

    public void sortByYear9_1() {
        Detabese.dateMovies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o2.getYear().compareTo(o1.getYear());
            }
        });
    }
}