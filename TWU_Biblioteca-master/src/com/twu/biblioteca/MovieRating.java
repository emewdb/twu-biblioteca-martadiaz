package com.twu.biblioteca;

public class MovieRating {

    private boolean rated;
    private String rate;
    private static final int MIN_RATE = 1;
    private static final int MAX_RATE = 10;

    public MovieRating(Integer rate){
        //no mandatory rated
        this.rated = false; // no rated by default
        if(rate != null)
            setRate(rate);
        else
            this.rate = "unrated";
    }
    //getters
    public boolean getIsRated(){ return this.rated; }
    public String getRate(){ return  this.rate; }

    //setters
    public boolean setRate(int rate){
        if(rate>=MIN_RATE && rate<=MAX_RATE){
            this.rated = true;
            this.rate = String.valueOf(rate);
        }
        else{
           // throw  new
        }
        return  rated;
    }
}
