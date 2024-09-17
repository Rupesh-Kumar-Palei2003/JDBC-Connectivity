package TestJDBC.com;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class DeleteDataFromDB {
    public static void main(String[] args) {
        // load the class.....
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully...");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        // establish the connection....
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String userName = "root";
        String password = "Rupesh@123";
        String query = "DELETE FROM employees where id = 1;";
        try{
            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established successfully......");
            Statement stmt = conn.createStatement();
            int rowAffected = stmt.executeUpdate(query);
            if(rowAffected > 0){
                System.out.println("Deletion Successful ..."+rowAffected+" row(s) affected");
            }
            else{
                System.out.println("Deletion Failed");
            }
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
