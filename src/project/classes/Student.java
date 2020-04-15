
package project.classes;


import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;



public class Student {

    
    public void getStudent() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try (
            Connection con = DriverManager.getConnection(
                    connect, "root", "zympaaz99x");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            ){
              System.out.println("id - "+" First name - " + " Last name - "+" Date of birth - "+" Tuition fees");
            while (rs.next()) {
                System.out.println(rs.getString(1)+". "+rs.getString("first_name") + " " + rs.getString("last_name")+" "+ rs.getString(4)+" "+ rs.getString(5));
            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    


    

}
