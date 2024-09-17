package TestJDBC.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchProcessing {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded Successfully....");
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "Rupesh@123";
        Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("INSERT INTO employees (name, job_title, salary) VALUES ('john', 'Frontend Developer', 72000);");
        statement.addBatch("INSERT INTO employees (name, job_title, salary) VALUES('Roman', 'Backend Developer', 93000.00);");
        int[] batchResult = statement.executeBatch();
        connection.commit();
        System.out.println("Batch insert successfully.....");
        System.out.println(Arrays.toString(batchResult));
    }
}
