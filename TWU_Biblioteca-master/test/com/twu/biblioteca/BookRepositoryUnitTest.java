package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookRepositoryUnitTest {

    // list
    @Test
    public void listExists() {
        //Arrange & Act
        BookRepository bookRepository = new BookRepository();
        //Assert
        assertNotNull(bookRepository.list);
    }
}
