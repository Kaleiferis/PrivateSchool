/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.classes.extra;

import project.classes.Student;

/**
 *
 * @author kwsta
 */
public class AssignmentsPerStudent {

    StudentsPerCourse spc = new StudentsPerCourse();
    Student s = new Student();

    public void printStudentPerProjectJavaPartAnB() {
        System.out.println("      Students per project Java part A and B");
        spc.getStudentPerJava();
    }

    public void printStudentPerProjectCPartAnB() {
        System.out.println("      Students per project C# part A and B");
        spc.getStudentPerC();
    }

}


