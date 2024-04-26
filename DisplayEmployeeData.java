/*DELIMITER //

CREATE PROCEDURE GetAllEmployees()
BEGIN
    SELECT Ename, esal FROM emp;
END //

DELIMITER ;*/
import java.sql.*;
public class DisplayEmployeeData {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?characterEncoding=utf8",
                    "root",
                    "");

            CallableStatement cstmt = conn.prepareCall("{CALL GetAllEmployees()}");

            ResultSet rs = cstmt.executeQuery();

            System.out.println("Employee Data:");
            System.out.println("Ename\tSalary");
            while (rs.next()) {
                String ename = rs.getString("Ename");
                double salary = rs.getDouble("esal");
                System.out.println(ename + "\t" + salary);
            }

            // Close resources
            rs.close();
            cstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
