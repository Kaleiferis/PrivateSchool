package project.classes.extra;

import java.sql.*;
import java.util.ArrayList;
import project.classes.Course;
import project.classes.Student;

public class StudentsPerCourse {

    public void getStudentPerJava() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select first_name ,last_name,c.title from student join student_per_course USING (student_id) JOIN course c USING (course_id) WHERE c.title = 'Java'");) {
            System.out.println("First name  -  Last name  -  title  ");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + " " + rs.getString(3));
            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getStudentPerC() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select first_name ,last_name,c.title from student join student_per_course USING (student_id) JOIN course c USING (course_id) WHERE c.title = 'C#'");) {
            System.out.println("First name  -  Last name  -  Title");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + " " + rs.getString(3));
            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getStudentPerJavaC() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select first_name ,last_name from student WHERE student_id=7 or student_id=8");) {
            System.out.println("First name  -   Last name");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2));
            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
