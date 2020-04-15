package classesScannerExtra;

import java.sql.*;
import java.util.ArrayList;
import project.classes.MainMenu;
import project.classes.extra.StudentsPerCourse;
import project.classes.extra.TrainersPerCourse;

public class StudentPerCourseScanner {

    public void createStudentPerCourseByScanner() {

        String connect = "jdbc:mysql://localhost:3306/private_school_scanner?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";

        try {
            Connection con = DriverManager.getConnection(connect, "root", "zympaaz99x");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            int id = 1;
            //SC.STUDENTSPERCOURSE
            while (rs.next()) {
                System.out.println("In which course does he/she participate in ?:" + rs.getString(2) + ", " + rs.getString(3));

                System.out.println("These are the courses, please choose a number");

                ResultSet rs1 = stmt.executeQuery("select * from course");
                int i = 0;
                while (rs1.next()) {
                    i = i + 1;
                    System.out.println(rs1.getString(1) + ". " + rs1.getString(2));
                }
                System.out.println("");
                int courseOption = MainMenu.NumberException();

                stmt.executeUpdate("Insert into student_per_course values ('" + id + "','" + courseOption + "')");

                System.out.println("Successfull entry");

                id = id + 1;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}
