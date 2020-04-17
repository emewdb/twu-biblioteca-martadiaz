package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookServiceUnitTest {

    // checkout
    @Test
    public void ifBookExistsAndIsNotCheckedOutAlreadyThenChecksOutAndReturnsTrue(){
        //Arrange
        BookService testedClass = new BookService();
        //Act
        boolean result = testedClass.checkoutBook(testedClass.getBookRepository().list.get(0).getName());
        //Assert
        assertTrue(result);
    }

    @Test
    public void ifBookExistsButIsCheckedOutAlreadyThenDontCheckOutAndReturnsFalse(){
        //Arrange
        BookService testedClass = new BookService();
        testedClass.getBookRepository().list.get(0).setCheckStatus(true);
        //Act
        boolean result = testedClass.checkoutBook(testedClass.getBookRepository().list.get(0).getName());
        //Assert
        assertFalse(result);
    }

    @Test
    public void ifBookExistsAndCheckOutWorksThenCheckStatusIsSetToTrue(){
        //Arrange
        BookService testedClass = new BookService();
        //Act
        testedClass.checkoutBook(testedClass.getBookRepository().list.get(0).getName());
        Book checkedOutBook = testedClass.getBookRepository().list.get(0);
        //Assert
        assertTrue(checkedOutBook.getCheckStatus());
    }

    @Test
    public void ifBookDoesntExistThenDontCheckOutAndReturnsFalse(){
        //Arrange
        BookService testedClass = new BookService();
        //Act
        boolean result = testedClass.checkoutBook("name not found");
        //Assert
        assertFalse(result);
    }

    // return
    @Test
    public void ifBookExistsAndIsChekedOutThenReturnsAndReturnsTrue(){
        //Arrange
        BookService testedClass = new BookService();
        testedClass.getBookRepository().list.get(0).setCheckStatus(true);
        //Act
        boolean result = testedClass.returnBook(testedClass.getBookRepository().list.get(0).getName());
        //Assert
        assertTrue(result);
    }

    @Test
    public void ifBookExistsButIsNotChekedOutThenDontReturnAndReturnsFalse(){
        //Arrange
        BookService testedClass = new BookService();
        testedClass.getBookRepository().list.get(0).setCheckStatus(false);
        //Act
        boolean result = testedClass.returnBook(testedClass.getBookRepository().list.get(0).getName());
        //Assert
        assertFalse(result);
    }

    @Test
    public void ifBookExistsAndReturnThenCheckStatusIsSetToFalse(){
        //Arrange
        BookService testedClass = new BookService();
        testedClass.getBookRepository().list.get(0).setCheckStatus(true);
        //Act
        testedClass.returnBook(testedClass.getBookRepository().list.get(0).getName());
        Book checkedOutBook = testedClass.getBookRepository().list.get(0);
        //Assert
        assertFalse(checkedOutBook.getCheckStatus());
    }

    @Test
    public void ifBookDontExistThenDontReturnAndReturnsFalse(){
        //Arrange
        BookService testedClass = new BookService();
        //Act
        boolean result = testedClass.returnBook("name not found");
        //Assert
        assertFalse(result);
    }
}
