package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/*
**********************************************************************************************************
Author: Greg Lane
Date: 10/06/16
Project: project 4 - Program that Queries a student database and allows the option of adding and deleting
**********************************************************************************************************
 */


public class Main extends JFrame {

    // Build GUI objects and vars


    private ArrayList<Student> al = new ArrayList<Student>();
    private String studentName;
    private String studentID;
    private String studentMajor;
    private String grade;
    private int credit;
    private String[] options1 = new String[]{"Insert", "Delete", "Find", "Update"};
    private String[] options2 = new String[] {"A", "B", "C", "D", "F"};
    private String[] options3 = new String[] {"3", "6"};
    private JOptionPane Frame = new JOptionPane();
    private JLabel id = new JLabel("id: ");
    private JLabel Name = new JLabel("Name: ");
    private JLabel Major = new JLabel("Major: ");
    private JLabel choose = new JLabel("Choose Selection: ");
    private JButton Process = new JButton("Process Request");
    private JComboBox choices = new JComboBox(options1);
    private JComboBox Grade = new JComboBox(options2);
    private JComboBox credits = new JComboBox(options3);
    private JTextField idField = new JTextField("");
    private JTextField nameField = new JTextField("");
    private JTextField majorField = new JTextField("");
    private Student theNewStudent = new Student();


    // display

    public void display(){
        setVisible(true);
    }

    //Frame set

    private void setFrame(int width, int height){
        setLocationRelativeTo(null);
        setSize(width, height);
    }

    public String getID(){
        try{
            return idField.getText();
        }

        catch(Exception e){
            return "Error: " + e.getMessage();
        }
    }

    public String getNameValue(){
        try{
            return nameField.getText();
        }

        catch(Exception e){
            return "Error: " + e.getMessage();
        }
    }

    public String getMajor(){
        try{
            return majorField.getText();
        }

        catch(Exception e){
            return "Error: " + e.getMessage();
        }
    }

    public void clearValue(){
        idField.setText("");
        nameField.setText("");
        majorField.setText("");
    }

    public void setValues(){
        this.studentName = getNameValue();
        this.studentMajor = getMajor();
        this.studentID = getID();
    }

    class ProcessButton implements ActionListener{ // Executes when button is clicked
        @Override

        public void actionPerformed(ActionEvent e){
            setValues();
            if(choices.getSelectedItem() == "Insert"){
                theNewStudent.Insert(Integer.parseInt(studentID.toString()),studentName, studentMajor);
                JOptionPane.showMessageDialog(Frame,"The student " + studentName + " Was entered successfully");

            }
            else if(choices.getSelectedItem() == "Delete"){

                theNewStudent.delete(Integer.parseInt(studentID));

            }
            else if(choices.getSelectedItem() == "Find"){
                theNewStudent.find(Integer.parseInt(studentID));
            }

            else if(choices.getSelectedItem() == "Update"){
                JOptionPane.showMessageDialog(Frame,Grade,"Please select the grade",JOptionPane.QUESTION_MESSAGE);
                grade = Grade.getSelectedItem().toString();
                JOptionPane.showMessageDialog(Frame,credits,"Please select the credits",JOptionPane.QUESTION_MESSAGE);
                credit = Integer.parseInt(credits.getSelectedItem().toString());
                theNewStudent.courseCompleted(Integer.parseInt(studentID.toString()),grade,credit);

            }

            clearValue();
        }
    }


    public Main(){
        super("Student DB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFrame(350,250);
        setResizable(false);
        JPanel pan = new JPanel();
        add(pan);
        pan.setLayout(new GridLayout(5,2,0,10));
        pan.add(id);
        pan.add(idField);
        pan.add(Name);
        pan.add(nameField);
        pan.add(Major);
        pan.add(majorField);
        pan.add(choose);
        pan.add(choices);
        pan.add(Process);
        Process.addActionListener(new ProcessButton());
        

    }

    public static void main(String[] args) {
	Main app = new Main();
     app.display(); // Makes the app appear
    }
}
