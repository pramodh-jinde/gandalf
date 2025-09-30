import java.sql.Connection;
import java.sql.DriverManager;

public class DriverService {

    String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database name
    String username = "your_username"; // Replace with your MySQL username
    String password = "your_password"; // Replace with your MySQL password

    static Connection conn;

    private DriverService() {

    }

    public static Connection getConnection() {
        if(conn==null) {
            System.out.println("Attempting to connect to the database...");
            try (conn = DriverManager.getConnection(url, username, password)){
                System.out.println("Database connected successfully!");
            } catch (SQLException e) {
                System.err.println("Failed to connect to the database:");
                e.printStackTrace();
            }
        }
        return conn;
    }
}
