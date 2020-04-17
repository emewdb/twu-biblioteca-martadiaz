package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class MovieRatingTest {

    @Test
    public void ifRateValueIsInsideLimitsThenRatedIsTrueAndRateIsSetToValue(){
        //Arrange & Act
        int valueInsideLimits = 5;
        MovieRating testedClass = new MovieRating(valueInsideLimits);
        //Assert
        assertTrue(testedClass.getIsRated());
        assertEquals(String.valueOf(valueInsideLimits), testedClass.getRate());
    }

    @Test
    public void ifRateValueIsOutOfLimitsThenPreviousRateDontChangeAndExceptionIsThrown(){
        //Arrange
        int originalRateValue = 1;
        MovieRating testedClass = new MovieRating(originalRateValue);
        //Act
        int valueInsideLimits = 20;
        boolean isRated = testedClass.setRate(valueInsideLimits);
        //Assert
        assertEquals(String.valueOf(originalRateValue), testedClass.getRate());
        //add exception control
    }

    @Test
    public void ifRateValueIsNullAtConstructorThenRatedIsFalseAndRateIsDefaultValue(){
        //Arrange & Act
        MovieRating testedClass = new MovieRating(null);
        String defaultRateValue = "unrated";
        //Assert
        assertFalse(testedClass.getIsRated());
        assertEquals(defaultRateValue, testedClass.getRate());

    }
}
