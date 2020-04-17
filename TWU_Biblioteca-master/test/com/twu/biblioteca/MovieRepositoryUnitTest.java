package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieRepositoryUnitTest {

    // list
    @Test
    public void listExists() {
        //Arrange & Act
        MovieRepository movieRepository = new MovieRepository();
        //Assert
        assertNotNull(movieRepository.list);
    }

}
