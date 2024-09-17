package TestJDBC.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletionPreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Class Loaded Successfully..");
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "Rupesh@123";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection Established Successfully....");
        String sqlQuery = "DELETE FROM employees WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, 5);
        int rowAffected = preparedStatement.executeUpdate();
        if(rowAffected > 0){
            System.out.println("Deletion Successfully..."+rowAffected+" row(s) affected.");
        }else{
            System.out.println("Deletion Failed....");
        }
        preparedStatement.close();
        connection.close();
    }
}
