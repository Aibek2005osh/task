package task;

import task.db.Detabese;
import task.enoms.Genre;
import task.models.Actor;
import task.models.Movie;
import task.models.Producer;
import task.service.MovieService;
import task.service.impl.MovieServiceImpl;
import task.sort.Impl.SortMovieServiceImpl;
import task.sort.SortMovieService;

import java.time.LocalDate;

import java.util.*;

public class Main {
    static MovieService movieService = new MovieServiceImpl();

    public static void main(String[] args) {

        SortMovieServiceImpl serviceSort = new SortMovieServiceImpl();
        LinkedList<Actor> actors = new LinkedList<>(Arrays.asList(
                new Actor("Amir", " Бекерчи айылдык жигит"),
                new Actor("Kanbolot ", "Гангстер бала"),
                new Actor("Baiel ", " .Айылдык илимпоз")
        ));
        List<Actor> actors2 = new ArrayList<>();
        actors2.add(new Actor("Aibek ", "Hacker "));
        actors2.add(new Actor("Aisonun", "Moana "));


        Detabese.dateMovies.add(new Movie("рецепт счастья ", LocalDate.of(2022, 8, 13), Genre.LOVE, new Producer("Манас", "Халдаров "), actors2));
        Detabese.dateMovies.add(new Movie("Курманжан Датка", LocalDate.of(2014, 3, 2), Genre.DRAMA, new Producer(" Садык", "Шер-Нияз"), actors));
        Detabese.dateMovies.add(new Movie("Рэкетир", LocalDate.of(2007, 11, 4), Genre.CRIME, new Producer(" Эрмек", "Турсунов"), actors));
        Detabese.dateMovies.add(new Movie("Ак калпак", LocalDate.of(2019, 7, 1), Genre.MUSICAL, new Producer("Aibek", "Жусупов  "), actors));
        Detabese.dateMovies.add(new Movie("Оо, Кыргызстан", LocalDate.of(2011, 1, 1), Genre.DOCUMENTARY, new Producer("Болот ", "Шамшиев"), actors));
        Detabese.dateMovies.add(new Movie("Avatar", LocalDate.of(2011, 9, 12), Genre.FANTASY, new Producer(" Джеймс ", "Кэмерон"), actors));
        Detabese.dateMovies.add(new Movie("КАН УРСУН", LocalDate.of(2023, 12, 15), Genre.HORROR, new Producer(" Эрболот  ", "Тойгонбаев"), actors));
        Detabese.dateMovies.add(new Movie("Аяш 4", LocalDate.of(2024, 4, 29), Genre.COMEDY, new Producer("Бакыт", "Осмонканов"), actors));


        while (true) {
            System.out.print("""
                    Press to 1. getAllMovies
                    Press to 2. findMovieByFullNameOrPartName
                    Press to 3. findMovieByActorName
                    Press to 4. findMovieByYear
                    Press to 5. findMovieByProducer
                    Press to 6. findMovieByGenre
                    
                    Press to 7. sortMovieByName A - Z
                    Press to 8. sortMovieByName Z - A
                    Press to 9. sortByYear       1_9
                    Press to 10. sortByYear      9_1
                    Press to 11. sortByProducer
                    
                    """);
            switch (checkVaildCommand()) {
                case 1 -> {
                    System.out.println(movieService.getAllMovies());
                }
                case 2 -> {
                    System.out.println(movieService.findMovieByFullNameOrPartName(fullName()));
                }
                case 3 -> {
                    System.out.println(movieService.findMovieByActorName(actorName()));
                }
                case 4 -> {
                    System.out.println(movieService.findMovieByYear(movieByYear()));
                }
                case 5 -> {
                    System.out.println(movieService.findMovieByProducer(byProducer()));
                }
                case 6 -> {
                    Movie movieByGenre = movieService.findMovieByGenre(genre());
                    System.out.println(movieByGenre);

                }
                case 7 -> {
                    serviceSort.sortMovieByNameAZ();
                    System.out.println(movieService.getAllMovies());
                }
                case 8 -> {
                    serviceSort.sortMovieByNameZA();
                    System.out.println(movieService.getAllMovies());
                }
                case 9 -> {
                    serviceSort.sortByYear1_9();
                    System.out.println(movieService.getAllMovies());
                }
                case 10 -> {
                    serviceSort.sortByYear9_1();
                    System.out.println(movieService.getAllMovies());

                }
                case 11 -> {
                    serviceSort.sortByProducer();
                    System.out.println(movieService.getAllMovies());

                }
            }

        }

    }

    public static Genre genre() {
        System.out.println("""
                Press to 1. or Comedy.   {Комедия}
                Press to 2. or Horror.    (Ужас)
                Press to 3. or Fantasy.   (Фантастика)
                Press to 4. or Documentary  (Документалдык)
                Press to 5. or Drama (Драма)
                Press to 6. or LOVE  (Анимация)
                Press to 7. or  FANTASY  (фантастика)
                Press to 8. or Musical (Музыкалык)
                Press to 9. or Crime (Кылмыштуулук)
                """);
        while (true) {
            System.out.print("write the comand : ");
            String genre = new Scanner(System.in).nextLine().toUpperCase().trim();
            switch (genre) {
                case "1", "COMEDY" -> {
                    return Genre.COMEDY;
                }
                case "2", "HORROR" -> {
                    return Genre.HORROR;
                }
                case "3", "FANTASY" -> {
                    return Genre.FANTASY;
                }
                case "4", "DOCUMENTARY" -> {
                    return Genre.DOCUMENTARY;
                }
                case "5", "DRAMA" -> {
                    return Genre.DRAMA;
                }
                case "6", "LOVE" -> {
                    return Genre.LOVE;
                }
                case "7", "MUSICAL" -> {
                    return Genre.MUSICAL;
                }
                case "8", "CRIME" -> {
                    return Genre.CRIME;
                }
                default -> System.err.print("ERROR : KAIRA JAZ : ");
            }
        }
    }

    public static String byProducer() {
        System.out.print("write Producer :");
        return new Scanner(System.in).nextLine();

    }

    public static LocalDate movieByYear() {
        LocalDate localDate = null;
        boolean isblok = false;
        while (!isblok) {
            System.out.print("Write Movie Year : ");
            String year = new Scanner(System.in).nextLine();
            try {


                localDate = LocalDate.parse(year);
                isblok = true;

            } catch (task.LocalDate e) {
                System.out.print("ERROR ! : Movie Year:");
            }

        }

        return localDate;
    }

    public static String actorName() {
        System.out.print("Write Actor Name : ");
        String name = new Scanner(System.in).nextLine();
        return name.trim();
    }

    public static String fullName() {
        System.out.println("write Full Name Moive");
        String name = new Scanner(System.in).nextLine();
        return name.trim();
    }

    public static int checkVaildCommand() {
        int command = 0;
        boolean invalidComand;
        System.out.print("write the comand : ");

        do {
            try {
                command = new Scanner(System.in).nextInt();
                invalidComand = false;
            } catch (InputMismatchException e) {
                invalidComand = true;
                System.err.print("INVALID COMAAND, ENTER VALID COMAAND : ");

            }
        } while (invalidComand);
        return command;
    }

}



