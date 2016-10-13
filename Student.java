package com.company;

/**
 * Created by enjoi on 10/6/16.
 */


import javax.swing.*;
import java.util.*;





public class Student extends JFrame {


    private JOptionPane Frame = new JOptionPane();
    private String studentName;
    private int studentID;
    private HashMap studentMap = new HashMap();
    private HashMap MajorMap = new HashMap();
    private HashMap gpaMap = new HashMap();
    private String major;
    private double GPA = 0.00;
    private int creditNumeric = 0;
    private double gradeNumeric = 0;
    private double gradeTemp;
    private double tempGPA;


    public Student() { // Empty constructor so methods can be accessed by creating one object in main


    }

    public void Insert(int studentID, String studentName, String major) { // INserts student into hashMap

        this.studentName = studentName;
        this.major = major;
        this.studentID = studentID;
        if (studentMap.containsKey(studentID)) {
            JOptionPane.showMessageDialog(Frame, "This key already exists in the DB");
        } else {
            studentMap.put(studentID, studentName);
        }

        if (MajorMap.containsKey(studentID)) {

        } else {
            MajorMap.put(studentID, major);
        }
    }

    public void courseCompleted(int studentID, String grade, int hours) { // Updates GPA
        //this.studentName = studentName;
        this.studentID = studentID;

        if (grade.equals("A")) {
            gradeTemp = 4.0;
        } else if (grade.equals("B")) {
            gradeTemp = 3.0;
        } else if (grade.equals("C")) {
            gradeTemp = 2.0;
        } else if (grade.equals("D")) {
            gradeTemp = 1.0;
        } else {
            gradeTemp = 0.0;
        }

        gradeNumeric = gradeTemp;

        creditNumeric = hours;

        tempGPA = (gradeTemp * creditNumeric) / creditNumeric;

    }



    public void delete(int key) { // Deletes user from hashmap
        if (studentMap.containsKey(key)) {
            studentMap.remove(key);
            JOptionPane.showMessageDialog(Frame, "The student ID " + key + " has been removed");
        } else {
            JOptionPane.showMessageDialog(Frame, "Student does not exist in db");
        }
        if (MajorMap.containsKey(key)) {
            MajorMap.remove(key);
        } else {

        }
    }

    public void find(int key) { // searches hashmap
        if (studentMap.containsKey(key)) {
            //studentName = studentMap.get(key).toString();
            // major = MajorMap.get(key).toString();
            JOptionPane.showMessageDialog(Frame, toString(key));
        } else {
            JOptionPane.showMessageDialog(Frame, "No key Found");
        }

    }

    public String toString(int key) { // returns name, gpa and major

        GPA = (gradeTemp * creditNumeric) / creditNumeric;
        if(gpaMap.containsKey(studentID)){
            gpaMap.remove(studentID);
        }
        else{
            gpaMap.put(studentID, GPA);
        }

        studentName = studentMap.get(key).toString();
        major = MajorMap.get(key).toString();

        return "Student Name: " + studentName + " Major: " + major + " Current GPA: " + GPA;
        }


    }




