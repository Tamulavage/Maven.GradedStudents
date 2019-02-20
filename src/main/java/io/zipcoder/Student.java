package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private  ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double... testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        if (testScores != null) {
            this.examScores = new ArrayList<>((Arrays.asList(testScores)));
        }
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }
}
