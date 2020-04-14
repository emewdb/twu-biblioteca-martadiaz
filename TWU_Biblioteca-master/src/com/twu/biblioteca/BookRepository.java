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

    public boolean checkoutBook(String name){
        boolean found = false;
        for(Book book : booksArray){
            if(book.getName().toLowerCase().equals(name.toLowerCase()) && !book.getCheckStatus()){
                book.setCheckStatus(true);
                found = true;
            }
        }
        if(found)
            System.out.println("Thank you! Enjoy the book!");
        else
            System.out.println("Sorry, that book is not available");

        return found;
    }

    public boolean returnBook(String name){
        boolean found = false;
        for(Book book : booksArray){
            if(book.getName().toLowerCase().equals(name.toLowerCase()) && book.getCheckStatus()){
                book.setCheckStatus(false);
                found = true;
            }
        }
        if(found)
            System.out.println("Thank you for returning the book!");
        else
            System.out.println("That is not a valid book to return");

        return found;
    }
}

