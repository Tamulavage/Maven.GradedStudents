package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void constructorNullTest(){
        // Given
        Integer expected = 30;

        // When
        Classroom classroom = new Classroom();
        Integer actual = classroom.getStudentsCountInClass();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void constructorMaxStudentsTest(){
        // Given
        Integer expected = 3;

        // When
        Classroom classroom = new Classroom(3);
        Integer actual = classroom.getStudentsCountInClass();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorStudentTest(){
        // Given
        Student studentOne = new Student("one", null, null);
        Student studentTwo = new Student("two", null, null);
        Student[] students = {studentOne, studentTwo};
        Integer expected = 2;

        // When
        Classroom classroom = new Classroom(students);
        Integer actual = classroom.getStudentsCountInClass();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentTest(){
        // Given
        Student studentOne = new Student("one", null, null);
        Student studentTwo = new Student("two", null, null);
        Student[] expected = {studentOne, studentTwo};
        Classroom classroom = new Classroom(expected);

        // When
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertSame(expected, actual);

    }

    @Test
    public void getAverageExamScoreTest(){
        // Given
        Double[] s1Scores = {100.0, 150.0 };
        Double[] s2Scores = {225.0, 25.0 };
        Student s1 = new Student("One", null, s1Scores);
        Student s2 = new Student( "Two", null, s2Scores);
        Student[] students = new Student[]{s1,s2};
        Classroom classroom = new Classroom(students);
        double expected = 125.0;

        // When
        double actual = classroom.getAverageExamScore();

        // Then
        Assert.assertSame(expected, actual);

    }

    @Test
    public void addStudentTest(){
        // Given
        int MaxNumberOfStudents =2;
        Classroom classroom = new Classroom( MaxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0};
        Student expected = new Student("New", null, examScores);


        // When
        classroom.add(expected);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertSame(expected, actual);

    }

    @Test
    public void removeStudentOnlyStudentTest() {
        // Given\
        String fName = "Bye";
        String lName = "Student";
        Student studentToRemove = new Student(fName, lName, null);
        Student[] students = new Student[]{studentToRemove};
        Classroom classroom = new Classroom(students);
        Integer expected = 0;

        // When
        classroom.removeStudent(fName,lName);
        Integer actual =  classroom.getStudentsCountInClass();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeStudentNoneExistsTest() {
        // Given\
        String fName = "Bye";
        String lName = "Student";
       // Mimic not found Student studentToRemove = new Student(fName, lName, null);
        Student[] students = new Student[]{};
        Classroom classroom = new Classroom(students);
        Integer expected = 0;


        // When
        classroom.removeStudent(fName,lName);
        Integer actual =  classroom.getStudentsCountInClass();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeStudentNotExistsTest() {
        // Given
        String fName = "Stay";
        String lName = "Student";
        Student studentToStay = new Student(null, null, null);
        Student[] students = new Student[]{studentToStay};
        Classroom classroom = new Classroom(students);
        Integer expected = classroom.getStudentsCountInClass();

        // When
        classroom.removeStudent(fName,lName);
        Integer actual =  classroom.getStudentsCountInClass();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest(){
        // Given

        // When

        // Then

    }

    @Test
    public void getGradeBookTest() {
        // Given

        // When

        // Tehn
    }
}
