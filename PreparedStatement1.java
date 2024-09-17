package TestJDBC.com;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PreparedStatement1 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver load successfully...");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        // establish the connection.....
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "Rupesh@123";
        String sqlQuery = "SELECT * FROM employees;";
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Establish Successfully....");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String jobTitle = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");
                System.out.println("ID - "+id+", name - "+name+", Job Title - "+jobTitle+", salary - "+salary);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
