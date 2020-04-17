package com.twu.biblioteca;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(){
        movieRepository = new MovieRepository();
    }

    public boolean checkoutMovie(String name){
        boolean found = false;
        for(Movie movie : movieRepository.list){
            if(movie.getName().toLowerCase().equals(name.toLowerCase()) && !movie.getCheckStatus()){
                movie.setCheckStatus(true);
                found = true;
            }
        }
        return found;
    }

    public boolean returnMovie(String name){
        boolean found = false;
        for(Movie movie : movieRepository.list){
            if(movie.getName().toLowerCase().equals(name.toLowerCase()) && movie.getCheckStatus()){
                movie.setCheckStatus(false);
                found = true;
            }
        }
        return found;
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }
}
