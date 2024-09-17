package TestJDBC.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class InsertDataIntoDB {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully....");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        // Connection Establish....
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String userName = "root";
        String password = "Rupesh@123";
        String query = "INSERT INTO employees(id, name, job_title, salary)  VALUES (4, 'Puja', 'React Developer', 93000.0);";
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established successfully....");
            Statement stmt = conn.createStatement();
            /*
            executeQuery() : when data retrieve
            executeUpdate() : when data insert
             */
            int rowsAffected = stmt.executeUpdate(query);
            if(rowsAffected > 0) {
                System.out.println("Insertion successfully.... "+rowsAffected + " rows affected.");
            }
            else{
                System.out.println("Insertion Failed");
            }
            stmt.close();

            conn.close();
            System.out.println("Connection closed successfully....");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
