package com.twu.biblioteca;

public class Movie {

    private String name;
    private String year;
    private String director;
    private MovieRating rating;
    private boolean checkedOut;

    public  Movie(String name, String year, String director, Integer rate){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = new MovieRating(rate);
        this.checkedOut = false; //not checkout by default
    }

    //getters
    public String getName(){ return this.name; }
    public String getYear(){ return this.year; }
    public String getDirector(){ return this.director; }
    public MovieRating getRating() { return rating; }
    public boolean getCheckStatus() {
        return checkedOut;
    }

    //setters
    public void setCheckStatus(boolean status) {
        this.checkedOut = status;
    }
}