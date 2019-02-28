package io.zipcoder;

import java.util.*;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];

    }

    public Classroom(Student[] students) {
        this.students = students;

    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }

    public Integer getStudentsCountInClass() {
        return this.students.length;
    }

    public Integer getActiveStudentCountInClass() {
        int countOfActiveStudents = 0;
        for (Student ele : students) {
            if (ele != null) {
                countOfActiveStudents++;
            }
        }
        return countOfActiveStudents;
    }

    public double getAverageExamScore() {
        Integer studentCount = getActiveStudentCountInClass();
        Double sum = 0.0;
        for (Student ele : students) {
            if (ele != null) {
                sum = sum + ele.getAverageExamScore();
            }
        }

        return sum / studentCount;
    }


    public void add(Student newStudent) {
        for (int i = 0; i <= getActiveStudentCountInClass(); i++) {
            if (students[i] == null) {
                students[i] = newStudent;
                i = getActiveStudentCountInClass();
            }
        }

    }

    public void removeStudent(String fName, String lName) {
        Integer currentActiveStudentsIndex = getActiveStudentCountInClass() - 1;
        if (currentActiveStudentsIndex == 0 && fName.equals(students[0].getFirstName()) && lName.equals((students[0].getLastName()))) {
            students[0] = null;
        }


        for (int i = 0; i < currentActiveStudentsIndex; i++) {

            if (students[i] != null && fName.equals(students[i].getFirstName()) && lName.equals((students[i].getLastName()))) {
                students[i] = null;

            }
        }

        refreshArray();
    }


    private void refreshArray() {

        List<Student> list = new ArrayList<>();

        for (Student student : students) {
            if (student != null) {
                list.add(student);
            }
        }

        this.students = list.toArray(new Student[list.size()]);
    }


    public Student[] getStudentsByScore() {
        refreshArray();

        Student[] retVal = students;
        Arrays.sort(retVal);

        return retVal;
    }

    public HashMap<Student, String> getGradeBook() {
        Integer currentStudents = getActiveStudentCountInClass();
        Student[] sortedStudent = getStudentsByScore();
        // double aveScore = getAverageExamScore();
        HashMap<Student, String> retVal = new HashMap<>();
        String grade = "";
        for (int i = 1; i <= currentStudents; i++) {
            grade = getGrade(i, currentStudents);
            retVal.put(sortedStudent[i - 1], grade);
        }

        return retVal;
    }

    private String getGrade(int studentRank, Integer totalStudent) {
        String retVal = "F";
        double rank = (double) studentRank / totalStudent;
        if (rank < 0.1) {
            retVal = "A";
        } else if (rank < 0.3) {
            retVal = "B";
        } else if (rank < 0.5) {
            retVal = "C";
        } else if (rank < 0.9) {
            retVal = "D";
        }

        return retVal;
    }

}
