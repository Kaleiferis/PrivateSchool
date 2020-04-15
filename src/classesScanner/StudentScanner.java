package classesScanner;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StudentScanner {

    public void createStudentByScanner() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Create your students");
        System.out.println("Enter the details as the example");

        System.out.println("Kostas, Aleiferis, 26/11/1993, 2500");
        System.out.println("How many students would you like to create?");
        while (true) {
            System.out.println("Enter a number  ");
            String input1 = sc.next();
            String connect = "jdbc:mysql://localhost:3306/private_school_scanner?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";

            int intInputValue1;
            try {
                Connection con = DriverManager.getConnection(connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();

                intInputValue1 = Integer.parseInt(input1);//ΕΛΕΓΧΟΣ ΑΝ ΕΔΩΣΕ ΑΡΙΘΜΟ
                for (int j = 0; j < Integer.parseInt(input1); j++) {

                    System.out.println("Write  first name");

                    String firstName = sc1.nextLine();

                    System.out.println("Write last name");
                    String lastName = sc1.nextLine();
                    System.out.println("Write the date of his/her birth ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                    LocalDate dateOfBirth;
                    while (true) {
                        String dateOfBirth1 = sc.next();
                        try {

                            dateOfBirth = LocalDate.parse(dateOfBirth1, formatter);//ΕΛΕΓΧΟΣ ΑΝ ΕΔΩΣΕ ΣΤΗ ΣΩΣΤΗ ΜΟΡΦΗ ΤΗΝ ΗΜΕΡΟΜΗΝΙΑ
                            break;
                        } catch (Exception e) {
                            System.out.println("The format must be yyyy-MM-d");
                            System.out.println("Please try again");
                        }

                    }
                    double doublefee;
                    while (true) {
                        System.out.println("Write the tution fee ");
                        String fee = sc.next();
                        try {
                            doublefee = Double.parseDouble(fee);

                            break;
                        } catch (NumberFormatException ne) {
                            System.out.println("This is not a number");
                        }

                    }

                    stmt.executeUpdate("Insert into student values ('" + (j + 1) + "','" + firstName + "','" + lastName + "','" + dateOfBirth + "','" + doublefee + "')");
                    System.out.println("Student " + (j + 1) + " is completed ");

                }
                System.out.println("");
                System.out.println("    List of your students");
                ResultSet rs = stmt.executeQuery("select * from student");

                System.out.println("id - " + " First name - " + " Last name - " + " Date of birth - " + " Tuition fees");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + ". " + rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString(4) + " " + rs.getString(5));
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
