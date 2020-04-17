package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieServiceUnitTest {

    // checkout
    @Test
    public void ifMovieExistsAndIsNotCheckedOutAlreadyThenChecksOutAndReturnsTrue(){
        //Arrange
        MovieService testedClass = new MovieService();
        //Act
        boolean result = testedClass.checkoutMovie(testedClass.getMovieRepository().list.get(0).getName());
        //Assert
        assertTrue(result);
    }

    @Test
    public void ifMovieExistsButIsCheckedOutAlreadyThenDontCheckOutAndReturnsFalse(){
        //Arrange
        MovieService testedClass = new MovieService();
        testedClass.getMovieRepository().list.get(0).setCheckStatus(true);
        //Act
        boolean result = testedClass.checkoutMovie(testedClass.getMovieRepository().list.get(0).getName());
        //Assert
        assertFalse(result);
    }

    @Test
    public void ifMovieExistsAndCheckOutWorksThenCheckStatusIsSetToTrue(){
        //Arrange
        MovieService testedClass = new MovieService();
        //Act
        testedClass.checkoutMovie(testedClass.getMovieRepository().list.get(0).getName());
        Movie checkedOutMovie = testedClass.getMovieRepository().list.get(0);
        //Assert
        assertTrue(checkedOutMovie.getCheckStatus());
    }

    @Test
    public void ifMovieDoesntExistThenDontCheckOutAndReturnsFalse(){
        //Arrange
        MovieService testedClass = new MovieService();
        //Act
        boolean result = testedClass.checkoutMovie("name not found");
        //Assert
        assertFalse(result);
    }

    // return
    @Test
    public void ifMovieExistsAndIsChekedOutThenReturnsAndReturnsTrue(){
        //Arrange
        MovieService testedClass = new MovieService();
        testedClass.getMovieRepository().list.get(0).setCheckStatus(true);
        //Act
        boolean result = testedClass.returnMovie(testedClass.getMovieRepository().list.get(0).getName());
        //Assert
        assertTrue(result);
    }

    @Test
    public void ifMovieExistsButIsNotChekedOutThenDontReturnAndReturnsFalse(){
        //Arrange
        MovieService testedClass = new MovieService();
        testedClass.getMovieRepository().list.get(0).setCheckStatus(false);
        //Act
        boolean result = testedClass.returnMovie(testedClass.getMovieRepository().list.get(0).getName());
        //Assert
        assertFalse(result);
    }

    @Test
    public void ifMovieExistsAndReturnThenCheckStatusIsSetToFalse(){
        //Arrange
        MovieService testedClass = new MovieService();
        testedClass.getMovieRepository().list.get(0).setCheckStatus(true);
        //Act
        testedClass.returnMovie(testedClass.getMovieRepository().list.get(0).getName());
        Movie checkedOutMovie = testedClass.getMovieRepository().list.get(0);
        //Assert
        assertFalse(checkedOutMovie.getCheckStatus());
    }

    @Test
    public void ifMovieDontExistThenDontReturnAndReturnsFalse(){
        //Arrange
        MovieService testedClass = new MovieService();
        //Act
        boolean result = testedClass.returnMovie("name not found");
        //Assert
        assertFalse(result);
    }
}
