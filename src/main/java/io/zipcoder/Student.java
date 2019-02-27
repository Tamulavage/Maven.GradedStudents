package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private   ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double... testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        if (testScores != null) {
            this.examScores = new ArrayList<>((Arrays.asList(testScores)));
        }
        else {
            // initialize with empty array to use size and isEmpty functions
            this.examScores = new ArrayList<>();
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
      //  System.out.println(examScores.isEmpty());
        return examScores.isEmpty() ? 0 : examScores.size();
    }

    public String getExamScores() {

        Integer numOfExams = getNumberOfExamsTaken();

        StringBuilder sb = new StringBuilder();
        if(numOfExams > 0)
        {
            sb.append("Exam Scores:\n");
            for(int i  = 1; i <= numOfExams; i++) {
                sb.append("\tExam "+i + " -> ");
                sb.append(String.format("%-2.0f", examScores.get(i-1)));
                sb.append("\n");


            }
        }
        else
        {
            sb.append("No Exams Taken");
        }

        return sb.toString();
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    // ** IF have time later - work on throw/catch and test */
  //  public void setExamScore(Integer examID, double examScore) throws Exception {
  public void setExamScore(Integer examID, double examScore)  {
       /* if(examID < 0 || examID >getNumberOfExamsTaken())
        {
            throw new Exception("Bad Index");
        }*/

        // use set and move index by 1
        examScores.set(examID-1, examScore);
    }

    public double getAverageExamScore() {
        Double sum = 0.0;
        for(Double ele: examScores)
        {
            sum=sum+ele;
        }
        return sum/getNumberOfExamsTaken();
    }

    public String toString(){
        String retVal = "Student Name: " + firstName +" " + lastName + "\n";
        retVal = retVal + "Average Score: " + getAverageExamScore() + "\n";
        retVal = retVal + getExamScores();

        return  retVal;
    }

}
