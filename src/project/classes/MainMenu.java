
package project.classes;

import classesScanner.AssignmentScanner;
import classesScanner.CourseScanner;
import classesScanner.StudentScanner;
import classesScanner.TrainerScanner;
import classesScannerExtra.StudentPerCourseScanner;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import project.classes.extra.StudentsPerCourse;
import java.util.ArrayList;
import java.util.Scanner;
import project.classes.extra.AssignmentPerCourse;
import project.classes.extra.AssignmentsPerStudent;
import project.classes.extra.TrainersPerCourse;


public class MainMenu {

    public static int NumberException() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String optionString = sc.next();
            int option;
            try {
                option = Integer.parseInt(optionString);
                return option;

            } catch (NumberFormatException e) {
                System.out.println("Please write only numbers");
                System.out.println("Choose again");
            }

        }

    }

    public static void createMenu() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Welcome to the private school");

        System.out.println("Press number 1 to see the data of my school");
        System.out.println("Press number 2 to input the data of your school");
        int option;
        option = MainMenu.NumberException();  //ΜΕΘΟΔΟΣ ΓΙΑ ΚΑΤΑΧΩΡΗΣΗ ΜΟΝΟ ΑΡΙΘΜΩΝ ΑΠΟ ΤΟΝ ΧΡΗΣΤΗ

        while (option > 2 || option < 1) {
            System.out.println("Please choose only 1 or 2");
            option = MainMenu.NumberException();

        }

        switch (option) {
            case 1:
                System.out.println("Please read the data");
                System.out.println("Press 1 to see the list of students");
                System.out.println("Press 2 to see the list of courses");
                System.out.println("Press 3 to see the list of assignments");
                System.out.println("Press 4 to see the list of trainers");
                System.out.println("Press 5 to see the list of students per course");
                System.out.println("Press 6 to see the list of trainers per Course");
                System.out.println("Press 7 to see the list of assignments per Course");
                System.out.println("Press 8 to see the list of assignments per student");
                System.out.println("Press 9 to exit");
                option = MainMenu.NumberException();

                while (option > 9 || option < 1) {
                    System.out.println("Please choose a right option");
                    option = MainMenu.NumberException();

                }

                while (option > 0 && option < 9) {

                    switch (option) {
                        case 1:
                            Student s = new Student();
                            s.getStudent(); //ΜΕΘΟΔΟΣ ΠΟΥ ΦΤΙΑΧΝΕΙ ΤΟΥΣ ΜΑΘΗΤΕΣ ΜΟΥ ΣΤΗΝ ΚΛΑΣΗ STUDENT
                            System.out.println("");

                            break;
                        case 2:
                            Course c = new Course();
                            c.getCourse();
                            System.out.println("");
                            break;
                        case 3:
                            Assignment a = new Assignment();
                            a.getAssignment();
                            System.out.println("");

                            break;
                        case 4:
                            Trainer t = new Trainer();
                            t.getTrainer();
                            System.out.println("");

                            break;
                        case 5:

                            System.out.println("");
                            System.out.println("Press 1 to see students per java");
                            System.out.println("Press 2 to see students per C#");
                            System.out.println("Press 3 to see students per both");
                            System.out.println("Press other to go to the main menu");
                            option = MainMenu.NumberException();

                            while (option > 0 && option < 4) {
                                switch (option) {
                                    case 1:
                                        StudentsPerCourse spc = new StudentsPerCourse();
                                        System.out.println("");
                                        spc.getStudentPerJava();
                                        System.out.println("");

                                        break;
                                    case 2:
                                        StudentsPerCourse spc1 = new StudentsPerCourse();
                                        System.out.println("");
                                        spc1.getStudentPerC();
                                        System.out.println("");
                                        break;
                                    case 3:
                                        StudentsPerCourse spc3 = new StudentsPerCourse();
                                        System.out.println("");
                                        spc3.getStudentPerJavaC();
                                        System.out.println("");
                                        break;
                                }
                                System.out.println("Press 1 to see students per java");
                                System.out.println("Press 2 to see students per C#");
                                System.out.println("Press 3 to see students per Java & C#");
                                System.out.println("Press other to go to the main menu");
                                option = MainMenu.NumberException();

                            }
                            break;
                        case 6:

                            System.out.println("");
                            System.out.println("Press 1 to see trainers per java");
                            System.out.println("Press 2 to see trainers per C#");
                            System.out.println("Press other to go to the main menu");

                            option = MainMenu.NumberException();

                            while (option > 0 && option < 3) {
                                switch (option) {
                                    case 1:
                                        TrainersPerCourse tpc = new TrainersPerCourse();
                                        System.out.println("");
                                        tpc.getTrainerPerJava();
                                        System.out.println("");
                                        break;
                                    case 2:
                                        TrainersPerCourse tpc1 = new TrainersPerCourse();
                                        System.out.println("");
                                        tpc1.getTrainerPerC();
                                        System.out.println("");
                                        break;

                                }
                                System.out.println("");
                                System.out.println("Press 1 to see trainers per java");
                                System.out.println("Press 2 to see trainers per C#");
                                System.out.println("Press other to go to the main menu");
                                option = MainMenu.NumberException();

                            }
                            break;
                        case 7:
                            System.out.println("");
                            System.out.println("Press 1 to see assignments per java");
                            System.out.println("Press 2 to see assignments per C#");
                            System.out.println("Press other to go to the main menu");
                            option = MainMenu.NumberException();

                            while (option > 0 && option < 3) {
                                switch (option) {
                                    case 1:
                                        AssignmentPerCourse apc = new AssignmentPerCourse();
                                        System.out.println("");
                                        apc.getAssignmentPerJava();
                                        System.out.println("");
                                        break;
                                    case 2:
                                        AssignmentPerCourse apc1 = new AssignmentPerCourse();
                                        System.out.println("");
                                        apc1.getAssignmentPerC();
                                        System.out.println("");
                                        break;

                                }
                                System.out.println("");
                                System.out.println("Press 1 to see assignments per java");
                                System.out.println("Press 2 to see assignments per C#");
                                System.out.println("Press other to go to the main menu");

                                option = MainMenu.NumberException();

                            }
                            break;

                        case 8:
                            System.out.println("");
                            System.out.println("Press 1 to see students per project java");
                            System.out.println("Press 2 to see students per project C#");
                            System.out.println("Press other to go to the main menu");
                            option = MainMenu.NumberException();

                            while (option > 0 && option < 3) {
                                switch (option) {
                                    case 1:
                                        AssignmentsPerStudent aps = new AssignmentsPerStudent();
                                        System.out.println("");
                                        aps.printStudentPerProjectJavaPartAnB();
                                        break;
                                    case 2:
                                        AssignmentsPerStudent aps1 = new AssignmentsPerStudent();
                                        System.out.println("");
                                        aps1.printStudentPerProjectCPartAnB();
                                        break;

                                }
                                System.out.println("");
                                System.out.println("Press 1 to see students per project java");
                                System.out.println("Press 2 to see students per project C#");
                                System.out.println("Press other number to go to the main menu");
                                option = MainMenu.NumberException();

                            }
                            break;

                    }
                    System.out.println("Please read the data");
                    System.out.println("Press 1 to see the list of students");
                    System.out.println("Press 2 to see the list of courses");
                    System.out.println("Press 3 to see the list of assignments");
                    System.out.println("Press 4 to see the list of trainers");
                    System.out.println("Press 5 to see the list of students per course");
                    System.out.println("Press 6 to see the list of trainers per Course");
                    System.out.println("Press 7 to see the list of assignments per Course");
                    System.out.println("Press 8 to see the list of assignments per student");
                    System.out.println("Press 9 to exit");

                    option = MainMenu.NumberException();

                    while (option > 9 || option < 1) {
                        System.out.println("Please choose a right option");

                        option = MainMenu.NumberException();

                    }
                }
                System.out.println("Have a nice day!");
                break;

            //DATA POY ΠΛΗΚΤΡΟΛΟΓΕΙ Ο ΧΡΗΣΤΗΣ
            case 2:
                System.out.println("Let's put your data");
                System.out.println("");
                System.out.println("Please follow the instructions");

                //               SC.STUDENTS
                StudentScanner st = new StudentScanner();
                st.createStudentByScanner();    //ΜΕΘΟΔΟΣ ΣΤΗΝ ΚΛΑΣΣΗ STUDENTSCANNER

                //               SC.COURSES
                CourseScanner cs = new CourseScanner();
                cs.createCourseByScanner();

                //               SC.TRAINERS
                TrainerScanner ts = new TrainerScanner();
                ts.createTrainerByScanner();

                //               SC.ASSIGNMENTS
                AssignmentScanner as = new AssignmentScanner();
                as.createAssignmentByScanner();

                //                 SC.StudentPerCourseScanner
                StudentPerCourseScanner spc = new StudentPerCourseScanner();
                spc.createStudentPerCourseByScanner();

                System.out.println("");
                System.out.println("-----------------------------------------------");
                System.out.println("You have just completed your lists!");

                System.out.println("Have a nice day!");
        }

    }

}
