package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class MovieRepository {
    private Movie[] moviesArray = {
            new Movie("Annie Hall","1977","Woody Allen", null),
            new Movie("Lolita","1997","Adrian Lyne", 7),
            new Movie("Star Wars: the return of the jedi","1983","George Lucas", 8),
            new Movie("Gone Girl","2014","David Fincher", 9)
    };

    public List<Movie> list = Arrays.asList(moviesArray);

}
