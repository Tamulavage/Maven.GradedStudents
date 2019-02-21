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

    @Test
    public void getNumberOfExamsTakenNoExamsTest(){
        // Given
        Integer expected = 0;
        Student studentTest = new Student(null,null, null);

        // When
        Integer actual = studentTest.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoreTest(){
        // Given
        String firstName = "George";
        String lastName = "Bush";
        Double[] examScores = { 100.00, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);
        String expected1 = "Exam Scores:\n\tExam 1 -> 100\n\tExam 2 -> 95\n";
        String expected2 = "\tExam 3 -> 123\n\tExam 4 -> 96\n";
        String expected = expected1+expected2;

        //When
        String actual = student.getExamScores();

        // THen
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoreNoExamsTest(){
        // Given
        Student student = new Student(null, null, null);
        String expected = "No Exams Taken";

        //When
        String actual = student.getExamScores();

        // THen
        Assert.assertEquals(actual, expected);
    }

}