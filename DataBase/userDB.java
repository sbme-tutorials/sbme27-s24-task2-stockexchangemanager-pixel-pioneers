package DataBase;

//import application.databaseController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import system.users;

public class userDB extends superDB{
    public static void insertUser(String username, String password, String email, String gender, double balance, String country) throws SQLException {
        statement = superDB.connect().createStatement();
        try{
//
            String query="INSERT INTO users (username, password, email, gender, balance, country) VALUES('" +
                    username + "', '" + password + "', '" + email + "', '" + gender + "', " + balance + ", '" + country + "')";
            superDB.statement.execute(query);
        }catch(SQLException e){

            e.printStackTrace();
        }
    }
    public static users getUser(String username) throws SQLException {
        users user = new users(); ;
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = superDB.connect().prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("ID");
                    String gender = rs.getString("gender");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    double balance = rs.getDouble("balance");
                    String country = rs.getString("country");
                    user = new users(id,username, password, email, gender, balance, country);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<users> getUsers() throws SQLException {
    ArrayList<users> userList = new ArrayList<>();
    String query = "SELECT * FROM users";
    Statement statement = null;
    ResultSet rs = null;
    try {
        statement = superDB.connect().createStatement();
        rs = statement.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("ID");
            String username = rs.getString("username");
            String gender = rs.getString("gender");
            String email = rs.getString("email");
            String password = rs.getString("password");
            double balance = rs.getDouble("balance");
            String country = rs.getString("country");
            users user = new users(id,username, password, email, gender, balance, country);
            userList.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (statement != null) {
            statement.close();
        }
    }
    return userList;
}
    public static void updateUser(String password, double balance, int id) throws SQLException {

        try {

            statement = connect().createStatement();
            String query = "UPDATE users SET password = '" + password + "', balance = " + balance + " WHERE ID = " + id;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception after logging it
        }
    }


    public static void deleteuser(String username) throws SQLException {
        statement = superDB.connect().createStatement();
        try {
            String query = "DELETE FROM users WHERE username = '" + username + "'";
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void change_password(String username, String password) throws SQLException {
        try{
            String query = "UPDATE users SET password = '" + password + "' WHERE username = " + username;
            statement = superDB.connect().createStatement();
            statement.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public static void updateBalance(int userid, double newbalance) throws SQLException {
        Statement statement = null;
        try {
            statement = superDB.connect().createStatement();
            String query = "UPDATE users SET balance = " + newbalance + " WHERE ID = " + userid;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public static double getBalance(int id) throws SQLException {
        users user = null;
        double balance =0;
        String query = "SELECT (balance) FROM users WHERE ID = "+id;
        try{
            statement = superDB.connect().createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                 balance = rs.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }
    public static void updatestockUser(int stockid ,int number) throws SQLException {
        Statement statement = null;
        try {
            statement = superDB.connect().createStatement();
            String query = "UPDATE userstocks SET number = " + number + " WHERE stockid = " + stockid;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    }
}
