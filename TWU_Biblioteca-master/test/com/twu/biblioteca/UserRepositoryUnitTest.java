package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;


public class UserRepositoryUnitTest {

    @Test
    public void ifUserIsInRepositoryThenReturnUser(){
        //Arrange
        UserRepository testedClass = new UserRepository();
        User realUser = testedClass.list.get(0);
        //Act
        User returnedUser = testedClass.getUser(realUser.getUserId());
        //Assert
        assertEquals(realUser.getUserId(), returnedUser.getUserId());
    }

    @Test
    public void ifUserIsNotInRepositoryThenReturnNull(){
        //Arrange
        UserRepository testedClass = new UserRepository();
        //Act
        User returnedUser = testedClass.getUser("wrong user");
        //Assert
        assertNull(returnedUser);
    }
}
