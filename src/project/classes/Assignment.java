
package project.classes;

import java.sql.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Assignment {

    public void getAssignment() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from assignment");) {
            System.out.println("id - " + " Title - " + " Description - " + " Sub date time - " + " Oral mark" + "-  Total mark");
            while (rs.next()) {
                System.out.println(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
