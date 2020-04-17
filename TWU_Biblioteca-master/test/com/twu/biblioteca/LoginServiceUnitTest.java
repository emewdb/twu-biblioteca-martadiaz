package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceUnitTest {

    @Test
    public void ifUserAndPasswordCorrectThenReturnTrue(){
        //Arrange
        LoginService testedClass = new LoginService();
        UserRepository repository = new UserRepository();
        User realUser = repository.list.get(0);
        //Act
        boolean loginSuccess = testedClass.login(realUser.getUserId(), realUser.getPassword());
        //Assert
        assertTrue(loginSuccess);
    }

    @Test
    public void ifUserAndPasswordWrongThenReturnFalse(){
        //Arrange
        LoginService testedClass = new LoginService();
        //Act
        boolean loginSuccess = testedClass.login("wronguser", "wrongpassword");
        //Assert
        assertFalse(loginSuccess);
    }
}
