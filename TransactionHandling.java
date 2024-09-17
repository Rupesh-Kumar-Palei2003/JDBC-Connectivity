package TestJDBC.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionHandling {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Load Driver Successfully....");
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "Rupesh@123";
        String sqlWithdraw = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
        String sqlDeposit = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
        Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        PreparedStatement creditPrepared = connection.prepareStatement(sqlWithdraw);
        creditPrepared.setDouble(1, 500.00);
        creditPrepared.setString(2, "account123");
        PreparedStatement debitPrepared = connection.prepareStatement(sqlDeposit);
        debitPrepared.setDouble(1, 500.00);
        debitPrepared.setString(2, "account456");
        int creditRowAffected = creditPrepared.executeUpdate();
        int debitRowAffected = debitPrepared.executeUpdate();
        if(creditRowAffected > 0 && debitRowAffected > 0){
            connection.commit();
            System.out.println("Transaction Successfully...");
        }
        else{
            connection.rollback();
            System.out.println("Transaction Failed.....");
        }


            }


    }


