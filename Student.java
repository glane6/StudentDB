package com.company;

/**
 * Created by enjoi on 10/6/16.
 */


import java.util.*;





public class Student{

    private String studentName;
    private int studentID;
    private HashMap studentMap = new HashMap();
    private HashMap MajorMap = new HashMap();
    private HashMap gradeMap = new HashMap();
    private HashMap creditMap = new HashMap();
    private HashMap gpaMap = new HashMap();
    private String major;
    private double GPA;
    private String grade;
    private String credit;
    private int creditNumeric;
    private double gradeNumeric;


    public Student(int studentID, String studentName, String major){
        this.studentName = studentName;
        this.major = major;
        this.studentID = studentID;
        studentMap.put(studentID, studentName);
        MajorMap.put(studentID, major);


    }

    public void courseCompleted(String studentName,String grade, int hours){
        this.studentName = studentName;
        GPA = 0.0;
        creditNumeric = 0;
        gradeNumeric = 0;


        if (grade.equals("A")){
            gradeNumeric = 4.0;
        }
        else if (grade.equals("B")){
            gradeNumeric = 3.0;
        }

        else if (grade.equals("C")){
            gradeNumeric = 2.0;
        }

        else if (grade.equals("D")){
            gradeNumeric = 1.0;
        }
        else{
            gradeNumeric = 0.0;
        }

        gradeNumeric = gradeNumeric + Double.parseDouble(gradeMap.get(studentName).toString());
            if (gradeMap.containsKey(studentName)){
                gradeMap.remove(studentName);
            }
            gradeMap.put(studentName, gradeNumeric);

            creditNumeric = hours;

        if (creditMap.containsKey(studentName)){
            creditMap.remove(studentName);

        }
        creditNumeric = creditNumeric + Integer.parseInt(creditMap.get(studentName).toString());

    }

    public void calculateGPA(String studentName){
        this.studentName = studentName;

        GPA = Integer.parseInt(creditMap.get(studentName).toString()) * Double.parseDouble(gradeMap.get(studentName).toString());
        if(gpaMap.containsKey(studentName)){
            gpaMap.remove(studentName);
        }
        gpaMap.put(studentName, GPA);

    }

   public void delete(int key){
       studentMap.remove(key);
       MajorMap.remove(key);
   }

   public void find(int key){
       studentName = studentMap.get(key).toString();
       major = MajorMap.get(key).toString();

   }

   public String toString(int key){
       studentName = studentMap.get(key).toString();
       major = MajorMap.get(key).toString();
       GPA = Double.parseDouble(gpaMap.get(key).toString());
       return "Student Name: " + studentName + " Major: " + major + " Current GPA: " + GPA;


   }




}



