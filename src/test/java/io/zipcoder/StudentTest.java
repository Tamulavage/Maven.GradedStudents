package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void constructorTest() {
        // Given
        String expectedFirstName = "Bob";
        String expectedLastName = "Dole";
        Double[] testScores = new Double[]{0.0, 13.0, 66.5};


        // When
        Student studentTest = new Student(expectedFirstName, expectedLastName, testScores);
        String actualFName = studentTest.getFirstName();
        String actualLName = studentTest.getLastName();

        // Then
        Assert.assertEquals(expectedFirstName, actualFName);
        Assert.assertEquals(expectedLastName, actualLName);

    }

    @Test
    public void getSetFirstNameTest() {
        // Given
        String expectedFirstName = "Not Me";
        Student studentTest = new Student(null, null, null);

        // When
        studentTest.setFirstName(expectedFirstName);
        String actualFName = studentTest.getFirstName();

        // Then
        Assert.assertEquals(expectedFirstName, actualFName);

    }

    @Test
    public void getSetLastNameTest() {
        // Given
        String expectedLasttName = "Not My Last Name";
        Student studentTest = new Student(null, null, null);

        // When
        studentTest.setLastName(expectedLasttName);
        String actualLName = studentTest.getLastName();

        // Then
        Assert.assertEquals(expectedLasttName, actualLName);

    }

    @Test
    public void getNumberOfExamsTakenTest() {
        // Given
        Double[] testScores = new Double[]{0.0, 13.0, 66.5};
        Integer expected = 3;
        Student studentTest = new Student(null, null, testScores);

        // When
        Integer actual = studentTest.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTakenNoExamsTest() {
        // Given
        Integer expected = 0;
        Student studentTest = new Student(null, null, null);

        // When
        Integer actual = studentTest.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoreTest() {
        // Given
        String firstName = "George";
        String lastName = "Bush";
        Double[] examScores = {100.00, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);
        String expected1 = "Exam Scores:\n\tExam 1 -> 100\n\tExam 2 -> 95\n";
        String expected2 = "\tExam 3 -> 123\n\tExam 4 -> 96\n";
        String expected = expected1 + expected2;

        //When
        String actual = student.getExamScores();

        // THen
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoreNoExamsTest() {
        // Given
        Student student = new Student(null, null, null);
        String expected = "No Exams Taken";

        //When
        String actual = student.getExamScores();

        // THen
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addExamScoreTest() {
        // Given
        String expected = "Exam Scores:\n\tExam 1 -> 55\n";
        Student student = new Student(null, null, null);

        // When
        student.addExamScore(55.0);
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setExamScoreTest() {
        // Given
        Double[] examScores = {100.0};
        String expected = "Exam Scores:\n\tExam 1 -> 99\n";
        Student student = new Student(null, null, examScores);

        // When
        student.setExamScore(1, 99.0);
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getAverageExamScore() {
        // Given
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(null, null, examScores);
        Double expected = 125.0;

        // WHen
        double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, 0.0);

    }

    @Test
    public void toStringTest() {
        // Given
        String fName = "David";
        String lName = "Tee";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(fName, lName, examScores);
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: David Tee\n");
        sb.append("Average Score: 125.0\n");
        sb.append("Exam Scores:\n");
        sb.append("\tExam 1 -> 100\n");
        sb.append("\tExam 2 -> 150\n");
        sb.append("\tExam 3 -> 250\n");
        sb.append("\tExam 4 -> 0 \n");
        String expected = sb.toString();

        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }


}