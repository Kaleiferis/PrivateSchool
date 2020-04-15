package classesScanner;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import project.classes.Course;

public class CourseScanner {

    public void createCourseByScanner() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        //               SC.COURSES
        System.out.println("Insert the courses");
        System.out.println("Enter the details as the example");

        System.out.println("Java,  Coding bootcamp,  full-time,  2020-10-15,  2020-12-31");
        System.out.println("How many courses would you like to create?");
        while (true) {
            System.out.println("Enter a number  ");
            String input2 = sc.next();
            String connect = "jdbc:mysql://localhost:3306/private_school_scanner?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";

            int numberCourses;
            try {
                Connection con = DriverManager.getConnection(connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                numberCourses = Integer.parseInt(input2);

                for (int j = 0; j < numberCourses; j++) {

                    System.out.println("Give the title of the course");
                    String title = sc1.nextLine();

                    System.out.println("Give the stream");
                    String stream = sc1.nextLine();
                    System.out.println("Give the type");
                    String type = sc1.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                    System.out.println("Give the start date of the course");

                    LocalDate startDate;
                    while (true) {
                        String startDate1 = sc.next();
                        try {

                            startDate = LocalDate.parse(startDate1, formatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("The format must be yyyy-MM-d");
                            System.out.println("Please try again");
                        }

                    }
                    System.out.println("Give the end date of the course");

                    LocalDate endDate;
                    while (true) {
                        String endDate1 = sc.next();
                        try {

                            endDate = LocalDate.parse(endDate1, formatter);
                            if (endDate.isAfter(startDate)) {   //ΕΛΕΓΧΟΣ ΓΙΑ endDate>startDate
                                break;
                            } else {
                                System.out.println("End date must be older than start date");
                                System.out.println("Please try again");
                            }
                        } catch (Exception e) {
                            System.out.println("The format must be yyyy-MM-d");
                            System.out.println("Please try again");
                        }

                    }
                    stmt.executeUpdate("Insert into course values ('" + (j + 1) + "','" + title + "','" + stream + "','" + type + "','" + startDate + "','" + endDate + "')");

                    System.out.println("Course " + (j + 1) + " is completed");

                }

                System.out.println("");
                System.out.println("    List of your courses");
                ResultSet rs = stmt.executeQuery("select * from course");

                System.out.println("id - " + " title - " + " stream - " + " type - " + " start date - " + " end date");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
                    System.out.println("");
                }
                con.close();

                break;
            } catch (NumberFormatException ne) {
                System.out.println("This is not a number");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
