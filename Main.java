package TestJDBC.com;
import java.sql.*; // import all packages related to sql....
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded Successfully !!!!!");
    /* Explanation: In com.mysql package all the drivers of mysql are there. so we have load
                 all the driver of mysql */
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        /*
        For connection with database we have 3 things:
            1. url
            2. username
            3. password.
         */
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Rupesh@123";
        // we have to do connection establish.
        try{
           Connection conn = DriverManager.getConnection(url, username, password);
           /*
           DriverManager is a class where getConnection is a method that consist 3 parameter
           url, username, & password.
           Connection is  a interface which instance is conn who hold the connection.
            */
            System.out.println("connection established successfully...");
            Statement stmt = conn.createStatement();
            /*
            Statement is a interface , that have one instance stmt that hold the connection statement.
            stmt helps to execute the query.
            by the help of conn instance we can call createStatement() method which doesn't contain any parameter.
             */
            ResultSet rs = stmt.executeQuery("select * from employees;");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("================================");
                System.out.println("ID - "+ id);
                System.out.println("Name - "+name);
                System.out.println("Job Title - "+job_title);
                System.out.println("Salary - "+salary);
                System.out.println("================================");
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Connection Closed Successfully.....");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
