package TestJDBC.com;

import java.sql.*;
public class UpdateDataInDB {
    public static void main(String[] args) throws ClassNotFoundException{
        // load all driver of sql;
        try {
            Class.forName("com.sql.jdbc.Driver");
            System.out.println("Driver Manager loaded successfully...");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        // establish the connection;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String userName = "root";
        String password = "Rupesh@123";
        String query = "UPDATE employees SET job_title = 'Devops' WHERE id = 4;";
        try{
            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established successfully.....");
            Statement stmt = conn.createStatement();
            int rowAffected = stmt.executeUpdate(query);
            if(rowAffected > 0){
                System.out.println("UPDATE successfully.... "+rowAffected+" row(s) affected..");
            }
            else{
                System.out.println("UPDATE failed.....");
            }
            stmt.close();
            conn.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
