package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OptionsMenuTest {

    private String exitControlMessage = "exit";
    private String listControlMessage = "list";


    @Test
    public void optionZeroQuitsApp(){
        //Arrange
        OptionsMenu menu = new OptionsMenu();
        //Act
        String result = menu.goToSelection("0");
        //Assert
        assertEquals(exitControlMessage, result);
    }

    @Test
    public void optionOneListBooks(){
        //Arrange
        OptionsMenu menu = new OptionsMenu();
        //Act
        String result = menu.goToSelection("1");
        // Arrange
        assertEquals(listControlMessage, result);
    }


}
