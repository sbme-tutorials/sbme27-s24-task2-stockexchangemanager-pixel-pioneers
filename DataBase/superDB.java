package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class superDB {
    private static Connection connection = null;
    protected static Statement statement;

    public static Connection connect(){
        if(connection!=null)
            return connection;
        return getConnection();

    }
    private static Connection getConnection(){
        try {
            // Register JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Open a connection to the database
            String url = "jdbc:sqlite:data.db";
            connection = DriverManager.getConnection(url);

            System.out.println("Connected to SQLite database.");

            // Do your database operations here

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
