package classesScanner;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import project.classes.Assignment;
import project.classes.extra.StudentsPerCourse;

public class AssignmentScanner {

    public void createAssignmentByScanner() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Insert the assignments");
        System.out.println("");
        System.out.println("Enter the details as the example");

        System.out.println("How many Assignments would you like to create?");

        while (true) {
            System.out.println("Enter a number  ");
            String input = sc.next();
            int intInputValue = 0;
            String connect = "jdbc:mysql://localhost:3306/private_school_scanner?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";

            try {
                Connection con = DriverManager.getConnection(connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                intInputValue = Integer.parseInt(input);
                for (int j = 0; j < Integer.parseInt(input); j++) {
                    System.out.println("Give the title");
                    String title = sc1.nextLine();
                    System.out.println("Give the description");
                    String description = sc1.nextLine();
                    System.out.println("Give the sub date of this assignment ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                    LocalDate subDate;

                    while (true) {
                        String subDate1 = sc.next();
                        try {

                            subDate = LocalDate.parse(subDate1, formatter);

                            break;
                        } catch (Exception e) {
                            System.out.println("The format must be yyyy-MM-d");
                            System.out.println("Please try again");
                        }

                    }
                    int oralMark;
                    while (true) {
                        System.out.println("Give the oral mark of this assignment");
                        String oral = sc.next();
                        try {
                            oralMark = Integer.parseInt(oral);

                            break;
                        } catch (NumberFormatException ne) {
                            System.out.println("This is not a number");
                            System.out.println("Try again");
                        }

                    }

                    int totalMark;
                    while (true) {
                        System.out.println("Give the total mark of this assignment");
                        String total = sc.next();
                        try {
                            totalMark = Integer.parseInt(total);

                            break;
                        } catch (NumberFormatException ne) {
                            System.out.println("This is not a number");
                            System.out.println("Try again");
                        }

                    }

                    System.out.println("Assignment " + (j + 1) + " is completed");

                    stmt.executeUpdate("Insert into assignment values ('" + (j + 1) + "','" + title + "','" + description + "','" + subDate + "','" + oralMark + "','" + totalMark + "')");

                }

                System.out.println("");
                System.out.println("    List of your assignments");
                ResultSet rs = stmt.executeQuery("select * from assignment");

                System.out.println("id - " + " Title - " + " Description - " + " Sub date time - " + " Oral mark" + "-  Total mark");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
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
