package TestJDBC.com;

import java.sql.*;
import java.util.Scanner;

public class BatchProcessingPrepared {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Class Loaded Successfully....");
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "Rupesh@123";
        String insertQuery = "INSERT INTO employees(name, job_title, salary) VALUES (?, ?, ?);";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established successfully....");
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("enter name: ");
            String name = sc.nextLine();
            System.out.print("enter job title :");
            String jobTitle = sc.nextLine();
            System.out.print("enter salary :");
            double salary = sc.nextDouble();
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, jobTitle);
            preparedStatement.setDouble(3, salary);
            preparedStatement.addBatch();
            System.out.println("Do you want insert again Y/N");
            char decision = sc.next().charAt(0);
            sc.nextLine();
            if(decision == 'N' || decision == 'n'){
                break;
            }
        }
        preparedStatement.executeBatch();
        connection.commit();
        System.out.println("Batch executed successfully....");
        preparedStatement.close();
        connection.close();

    }
}
