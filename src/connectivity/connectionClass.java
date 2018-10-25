package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionClass {
    public Connection connection;
    public Connection getConnection() {
        String dbname="timetable";
        String username="root";
        String connectionURL = "jdbc:mysql://localhost:8889/timetable";
        String password="root";
        try {
            Class.forName("com.mysql.jdbc.Driver");


             connection= DriverManager.getConnection(connectionURL,username,password);
             System.out.print("connection successfull");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
