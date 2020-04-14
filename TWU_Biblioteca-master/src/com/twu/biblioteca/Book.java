package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private String yearPublished;
    private boolean checkedOut;

    public Book(String name, String author, String yearPublished){
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = false; //unchecked by default
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getYearPublished() {
        return yearPublished;
    }
    public boolean getCheckStatus() {
        return checkedOut;
    }
    // Setters
    public void setCheckStatus(boolean status) {
        this.checkedOut = status;
    }

}
