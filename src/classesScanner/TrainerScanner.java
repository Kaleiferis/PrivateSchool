package classesScanner;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import project.classes.Trainer;

public class TrainerScanner {

    public void createTrainerByScanner() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        //               SC.TRAINERS
        System.out.println("Insert the trainers");
        System.out.println("Enter the details as the example");
        System.out.println("Onoma , Epitheto, subject");
        System.out.println("How many trainers would you like to create?");
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
                    System.out.println("Give the first name");
                    String firstName = sc1.nextLine();
                    System.out.println("Give the last name");
                    String lastName = sc1.nextLine();
                    System.out.println("Give the subject");
                    String subject = sc1.nextLine();
                    System.out.println("Trainer " + (j + 1) + " is completed");
               
                    stmt.executeUpdate("Insert into trainer values ('" + (j + 1) + "','" + firstName + "','" + lastName + "','" + subject + "')");

                }

                System.out.println("");
                System.out.println("    List of your trainers");
                ResultSet rs = stmt.executeQuery("select * from trainer");

                System.out.println("id - " + " First name - " + " Last name - " + " subject - ");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
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
