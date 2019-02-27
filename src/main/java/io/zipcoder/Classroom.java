package io.zipcoder;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];

    }

    public Classroom(Student[] students){
        this.students = students;

    }

    public Classroom(){
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }

    public Integer getStudentsCountInClass() {
        return this.students.length;
    }

    public double getAverageExamScore() {
        Integer studentCount = getStudentsCountInClass();

        //Double sumOfExams =

        return 0;
    }


    public void add(Student newStudent) {

    }

    public void removeStudent(String fName, String lName) {

    }
}
