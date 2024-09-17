package TestJDBC.com;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
public class UpdatePreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded Successfully");
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String name = "root";
        String password = "Rupesh@123";
        String sqlQuery = "UPDATE employees SET salary = ? WHERE id = 2";
        Connection connection = DriverManager.getConnection(url, name, password);
        System.out.println("Connection Established Successfully");
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setDouble(1, 79000.0);
        int rowAffected = preparedStatement.executeUpdate();
        if(rowAffected > 0){
            System.out.println("Update Completed..."+rowAffected+" row(s) affected.");
        }
        else{
            System.out.println("Update Failed...");
        }
        preparedStatement.close();
        connection.close();
    }
}
