
package project.classes;

import java.sql.*;
import java.util.ArrayList;


public class Trainer {

    public void getTrainer() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from trainer");) {
            System.out.println("id - " + " First name - " + " Last name - " + " subject - ");
            while (rs.next()) {
                System.out.println(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
