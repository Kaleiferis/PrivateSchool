/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.classes;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author kwsta
 */
public class Course {

    public void getCourse() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
                Connection con = DriverManager.getConnection(
                        connect, "root", "zympaaz99x");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from course");) {
            System.out.println("id - " + " title - " + " stream - " + " type - " + " start date - " + " end date");
            while (rs.next()) {
                System.out.println(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
