package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ClassroomTest {

    @Test
    public void constructorNullTest() {
        // Given
        Integer expected = 30;

        // When
        Classroom classroom = new Classroom();
        Integer actual = classroom.getStudentsCountInClass();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void constructorMaxStudentsTest() {
        // Given
        Integer expected = 3;

        // When
        Classroom classroom = new Classroom(3);
        Integer actual = classroom.getStudentsCountInClass();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorStudentTest() {
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
    public void getStudentTest() {
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
    public void getActiveStudentCountInClassTest() {
        // Given
        int MaxNumberOfStudents = 4;
        Classroom classroom = new Classroom(MaxNumberOfStudents);
        Student student1 = new Student("New", null, null);
        Student student2 = new Student("one", null, null);
        Student student3 = new Student("two", null, null);
        classroom.add(student1);
        classroom.add(student2);
        classroom.add(student3);
        Integer expected = 3;


        // When
        Integer actual = classroom.getActiveStudentCountInClass();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};
        Student s1 = new Student("One", null, s1Scores);
        Student s2 = new Student("Two", null, s2Scores);
        Student[] students = new Student[]{s1, s2};
        Classroom classroom = new Classroom(students);
        double expected = 125.0;

        // When
        double actual = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, 0.05);

    }

    @Test
    public void addStudentTest() {

        Classroom classroom = new Classroom(1);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student expected = new Student("New", null, examScores);


        // When
        classroom.add(expected);
        Student[] students = classroom.getStudents();
        Student actual = students[0];


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
        classroom.removeStudent(fName, lName);
        Integer actual = classroom.getActiveStudentCountInClass();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeStudentMultiStudentTest() {
        // Given\
        String fName = "Bye";
        String lName = "Student";
        Student student1 = new Student("Should", "Stay", null);
        Student studentToRemove = new Student(fName, lName, null);
        Student student3 = new Student("Should", "Stay", null);
        Student[] students = new Student[]{student1, studentToRemove, student3};
        Classroom classroom = new Classroom(students);
        Student[] expected = new Student[]{student1, student3};

        // When
        classroom.removeStudent(fName, lName);
        Student[] actual = classroom.getStudents();
        System.out.println(classroom.getActiveStudentCountInClass());

        // Then
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeStudentNotFoundTest() {
        // Given\
        String fName = "Bye";
        String lName = "Student";
        // Mimic not found Student studentToRemove = new Student(fName, lName, null);
        Student[] students = new Student[]{};
        Classroom classroom = new Classroom(students);
        Integer expected = 0;


        // When
        classroom.removeStudent(fName, lName);
        Integer actual = classroom.getStudentsCountInClass();

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
        classroom.removeStudent(fName, lName);
        Integer actual = classroom.getStudentsCountInClass();

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getStudentsByScoreDiffScoresTest() {
        // Given
        Student student1 = new Student("Bob", "Jones", 100.0);
        Student student2 = new Student("Kevin", "Smith", 95.0);
        Student student3 = new Student("that", "Test", 105.0);
        Student[] students = new Student[]{student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] expected = new Student[]{student3, student1, student2};

        // When
        Student[] actual = classroom.getStudentsByScore();

        // Then
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void getStudentsByScoreSameScoresTest() {
        // Given
        Student student1 = new Student("Bob", "Jones", 100.0);
        Student student2 = new Student("Kevin", "Smith", 100.0);
        Student student3 = new Student("That", "Man", 100.0);
        Student[] students = new Student[]{student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] expected = new Student[]{student1, student3, student2};

        // When
        Student[] actual = classroom.getStudentsByScore();

        // Then
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void getGradeBookTest() {
        // Given
        Double[] examScoresC = new Double[]{99.0, 97.0};
        Student student1 = new Student("A", "Jones", 100.0);
        Student student2 = new Student("B", "Smith", 99.0);
        Student student3 = new Student("D", "Smith", 97.0);
        Student student4 = new Student("C", "Student", examScoresC);
        Student student5 = new Student("F", "Student", 96.0);
        Student[] students = new Student[]{student1, student2, student3, student4, student5};
        Classroom classroom = new Classroom(students);
        HashMap<Student, String> expected = new HashMap<>();
        expected.put(student1, "B");
        expected.put(student2, "C");
        expected.put(student4, "D");
        expected.put(student3, "D");
        expected.put(student5, "F");

        // When
        HashMap<Student, String> actual = classroom.getGradeBook();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
