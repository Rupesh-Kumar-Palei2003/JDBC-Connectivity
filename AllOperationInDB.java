package TestJDBC.com;
import java.sql.*;

public class AllOperationInDB {
    public static Connection connectDB() {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String userName = "root";
        String password = "Rupesh@123";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void showDatabase(ResultSet rs) throws SQLException {
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("-------------------------------------");
                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("Job Title : "+job_title);
                System.out.println("Salary : "+salary);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Loaded Successfully......");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //connection Establish....


        try{

            System.out.println("connection established successfully....");
            Connection conn = connectDB();
            Statement stmt = conn.createStatement();
            String query= "select * from employees;";
            ResultSet rs = stmt.executeQuery(query);
            showDatabase(rs); // call showDatabase to show all the data entry.
            System.out.println("Insertion Operation Takes Place....");
            String insertQuery = "INSERT INTO employees(id, name, job_title, salary) VALUES (5, 'Jeneliya', 'MernStack Developer',98000.0);";
            int rowAffected1 =  stmt.executeUpdate(insertQuery);
            if(rowAffected1 > 0){
                System.out.println("Insertion Completed Successfully...."+rowAffected1+" row(s) affected.");
            }
            else{
                System.out.println("Insertion Operation Failed.");
            }
            ResultSet rs1 = stmt.executeQuery(query);
            showDatabase(rs1);

            System.out.println("Update Operation Takes Place.....");
            String updateQuery = "UPDATE employees SET name = 'Jenifer' WHERE id = 5;";
            int rowAffected2 = stmt.executeUpdate(updateQuery);
            if(rowAffected2 > 0){
                System.out.println("Update Completed Successfully...."+rowAffected2+" row(s) affected.");
            }else{
                System.out.println("UPDATE Operation Failed....");
            }
            showDatabase(rs);
            System.out.println("Deletion Operation Takes Place...");
            String deleteQuery = "DELETE FROM employees WHERE id = 5;";
            int rowAffected3 = stmt.executeUpdate(deleteQuery);
            if(rowAffected3 > 0){
                System.out.println("Deletion Completed Successfully...."+rowAffected3+" row(s) affected.");
            }
            else{
                System.out.println("Deletion Operation Failed.");
            }
            showDatabase(rs);
            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
