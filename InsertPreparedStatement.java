package TestJDBC.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPreparedStatement {
    public static void main(String[] args) {
        // load the driver...
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded successfully....");
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //connection establish....
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "Rupesh@123";
        String sqlQuery = "INSERT INTO employees VALUES (?, ?, ?, ?);";
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            // Data entry - 1:
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "Jenifer");
            preparedStatement.setString(3, "FullStack Developer");
            preparedStatement.setDouble(4, 990000.0);
            // Data Entry - 2:
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Rajesh");
            preparedStatement.setString(3, "MernStack Developer");
            preparedStatement.setDouble(4, 90000.0);
            // Data Entry - 3;
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "Raja");
            preparedStatement.setString(3, "Devops");
            preparedStatement.setDouble(4, 80000.0);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Insertion Successfully..."+rowAffected+" row(s) affected.");
            }
            else{
                System.out.println("Insertion failed.....");
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
