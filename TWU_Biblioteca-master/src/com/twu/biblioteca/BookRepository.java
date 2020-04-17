package com.twu.biblioteca;


import java.util.Arrays;
import java.util.List;

public class BookRepository {

    private Book[] booksArray = {
            new Book("Alice in Wonderland", "Lewis Carroll", "2010"),
            new Book("La persona incorrecta", "Sara Herranz", "2027"),
            new Book("L'etranger","Albert Camus","1971"),
            new Book("Le petit prince", "Antoine de Saint-Exupery","1946")
    };

    public  List<Book> list = Arrays.asList(booksArray);

}