package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookRepositoryTest {

    // list
    @Test
    public void listExists() {
        //Arrange & Act
        BookRepository bookRepository = new BookRepository();
        //Assert
        assertNotNull(bookRepository.list);
    }

    // checkout
    @Test
    public void ifBookExistsAndIsNotCheckedOutAlreadyThenChecksOutAndReturnsTrue(){
        //Arrange
        BookRepository bookRepository = new BookRepository();
        //Act
        boolean result = bookRepository.checkoutBook(bookRepository.list.get(0).getName());
        //Assert
        assertTrue(result);
    }

    @Test
    public void ifBookExistsButIsCheckedOutAlreadyThenDontCheckOutAndReturnsFalse(){
        //Arrange
        BookRepository bookRepository = new BookRepository();
        bookRepository.list.get(0).setCheckStatus(true);
        //Act
        boolean result = bookRepository.checkoutBook(bookRepository.list.get(0).getName());
        //Assert
        assertFalse(result);
    }

    @Test
    public void ifBookExistsAndCheckOutWorksThenCheckStatusIsSetToTrue(){
        //Arrange
        BookRepository bookRepository = new BookRepository();
        //Act
        bookRepository.checkoutBook(bookRepository.list.get(0).getName());
        Book checkedOutBook = bookRepository.list.get(0);
        //Assert
        assertTrue(checkedOutBook.getCheckStatus());
    }

    @Test
    public void ifBookDoesntExistThenDontCheckOutAndReturnsFalse(){
        //Arrange
        BookRepository bookRepository = new BookRepository();
        //Act
        boolean result = bookRepository.checkoutBook("name not found");
        //Assert
        assertFalse(result);
    }

    // return
    @Test
    public void ifBookExistsAndIsChekedOutThenReturnsAndReturnsTrue(){
        //Arrange
        BookRepository bookRepository = new BookRepository();
        bookRepository.list.get(0).setCheckStatus(true);
        //Act
        boolean result = bookRepository.returnBook(bookRepository.list.get(0).getName());
        //Assert
        assertTrue(result);
    }

    @Test
    public void ifBookExistsButIsNotChekedOutThenDontReturnAndReturnsFalse(){
        //Arrange
        BookRepository bookRepository = new BookRepository();
        bookRepository.list.get(0).setCheckStatus(false);
        //Act
        boolean result = bookRepository.returnBook(bookRepository.list.get(0).getName());
        //Assert
        assertFalse(result);
    }

    @Test
    public void ifBookExistsAndReturnThenCheckStatusIsSetToFalse(){
        //Arrange
        BookRepository bookRepository = new BookRepository();
        bookRepository.list.get(0).setCheckStatus(true);
        //Act
        bookRepository.returnBook(bookRepository.list.get(0).getName());
        Book checkedOutBook = bookRepository.list.get(0);
        //Assert
        assertFalse(checkedOutBook.getCheckStatus());
    }

    @Test
    public void ifBookDontExistThenDontReturnAndReturnsFalse(){
        //Arrange
        BookRepository bookRepository = new BookRepository();
        //Act
        boolean result = bookRepository.returnBook("name not found");
        //Assert
        assertFalse(result);
    }


}
