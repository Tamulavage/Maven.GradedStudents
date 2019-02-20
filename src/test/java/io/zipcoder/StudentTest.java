package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void constructorTest(){
        // Given
        String expectedFirstName = "Bob";
        String expectedLastName = "Dole";
        Double[] testScores = new Double[]{0.0, 13.0 , 66.5 };


        // When
        Student studentTest = new Student(expectedFirstName,expectedLastName, testScores);
        String actualFName = studentTest.getFirstName();
        String actualLName = studentTest.getLastName();

        // Then
        Assert.assertEquals(expectedFirstName, actualFName);
        Assert.assertEquals(expectedLastName, actualLName);

    }

    @Test
    public void getSetFirstNameTest(){
        // Given
        String expectedFirstName = "Not Me";
        Student studentTest = new Student(null,null, null);

        // When
        studentTest.setFirstName(expectedFirstName);
        String actualFName = studentTest.getFirstName();

        // Then
        Assert.assertEquals(expectedFirstName, actualFName);

    }

    @Test
    public void getSetLastNameTest(){
        // Given
        String expectedLasttName = "Not My Last Name";
        Student studentTest = new Student(null,null, null);

        // When
        studentTest.setLastName(expectedLasttName);
        String actualLName = studentTest.getLastName();

        // Then
        Assert.assertEquals(expectedLasttName, actualLName);

    }

    @Test
    public void getNumberOfExamsTakenTest(){
        // Given
        Double[] testScores = new Double[]{0.0, 13.0 , 66.5 };
        Integer expected = 3;
        Student studentTest = new Student(null,null, testScores);

        // When
        Integer actual = studentTest.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

}