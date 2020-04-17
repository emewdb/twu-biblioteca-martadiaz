package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private String yearPublished;
    private boolean checkedOut;
    private User user;

    public Book(String name, String author, String yearPublished){
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = false; //unchecked by default
        this.user = null; // unchecked = no user by default
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
    public User getUser(){ return  user;}
    // Setters
    public void setCheckStatus(boolean status) {
        this.checkedOut = status;
    }
    public void setUser(User user){ this.user = user; }

}
