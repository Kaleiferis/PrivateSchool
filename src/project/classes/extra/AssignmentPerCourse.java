
package project.classes.extra;

import java.sql.*;

import project.classes.Assignment;


public class AssignmentPerCourse {

    public void getAssignmentPerJava() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from assignment WHERE course_id = 1");) {
            System.out.println(" Title");
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getAssignmentPerC() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from assignment WHERE course_id = 2");) {
            System.out.println(" Title");
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
