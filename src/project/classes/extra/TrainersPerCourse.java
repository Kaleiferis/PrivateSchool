
package project.classes.extra;

import project.classes.Trainer;
import java.sql.*;


public class TrainersPerCourse {

    public void getTrainerPerJava() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select first_name ,\n"
                        + "	   last_name, \n"
                        + "	   c.course_id \n"
                        + "from trainer \n"
                        + "join trainer_per_course USING (trainer_id)\n"
                        + "join course c USING (course_id)\n"
                        + "WHERE course_id=1;");) {
            System.out.println("First name  -  Last name  ");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getTrainerPerC() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select first_name ,\n"
                        + "	   last_name, \n"
                        + "	   c.course_id \n"
                        + "from trainer \n"
                        + "join trainer_per_course USING (trainer_id)\n"
                        + "join course c USING (course_id)\n"
                        + "WHERE course_id=2;");) {
            System.out.println("First name  -  Last name  ");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
