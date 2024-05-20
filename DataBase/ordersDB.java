package DataBase;

import system.order;
import system.users;

import java.sql.*;
import java.util.ArrayList;
import system.transactions;
public class ordersDB extends superDB {
    public static void addOrder(int id,String order_type, double money, String date) throws Exception {

        statement = superDB.connect().createStatement();
        try {
            String query = "INSERT INTO [user orders] ([user id],deposite_withdrawel, status, money, date) VALUES ('"
                    + id + "', '"
                    + order_type + "', '"
                    + "pending" + "', "
                    + money + ", '"
                    + date + "')";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    }

    public static void updateOrder(int id,String desision) throws Exception {
        statement = superDB.connect().createStatement();
        try {
            String query = "UPDATE [user orders] SET deposite_withdrawel='" + desision + "' WHERE [order id]='" + id + "'";
            statement.execute(query);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }


        public static ArrayList<transactions> gettrans(int userid) throws SQLException {
            ArrayList<transactions> transList = new ArrayList<>();
            String query = "SELECT * FROM [user orders] WHERE [user id] = ?";
            ResultSet rs = null;

            try (
                 PreparedStatement pstmt = connect().prepareStatement(query)) {

                if (connect() == null || connect().isClosed()) {
                    throw new SQLException("Unable to connect to the database.");
                }

                // Set the user id parameter
                pstmt.setInt(1, userid);

                rs = pstmt.executeQuery();

                while (rs.next()) {
                    String decision = rs.getString("status");
                    String order_type = rs.getString("deposite_withdrawel");
                    double money = rs.getDouble("money");
                    int order_id = rs.getInt("order id");
                    String date = rs.getString("date");
                    transactions transaction = new transactions(order_type, decision, order_id, money, date,userid);
                    transList.add(transaction);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    rs.close();
                }
            }
            return transList;
        }

    public static ArrayList<transactions> getAlltrans() throws SQLException {
        ArrayList<transactions> transList = new ArrayList<>();
        String query = "SELECT * FROM [user orders]";
        try (Statement statement = connect().createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                String decision = rs.getString("status");
                String order_type = rs.getString("deposite_withdrawel");
                double money = rs.getDouble("money");
                int order_id = rs.getInt("order id");
                String date = rs.getString("date");
                int userid= rs.getInt("user id");
                transactions transaction = new transactions(order_type, decision, order_id, money, date,userid);
                transList.add(transaction);
            }
        }
        return transList;
    }
    public static void addOrders(String username, String order_type, String date, String company, int number,int id) throws Exception {
        Statement statement = null;  // Declare statement in the method scope
        try {
            statement = superDB.connect().createStatement();
            String query = "INSERT INTO ordershistory (username, order_type, date, company, number,userid) VALUES ('"
                    + username + "', '"
                    + order_type + "', '"
                    + date + "', '"
                    + company + "', '"
                    + number + "', '"
                    + id + "')";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;  // Re-throw exception to inform the caller
        } finally {
            if (statement != null) {
                try {
                    statement.close();  // Close statement in a nested try-catch to avoid suppressing original exception
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static ArrayList<order> getOrders() throws SQLException {
        ArrayList<order> orderList = new ArrayList<>();
        String query = "SELECT * FROM ordershistory";  // Corrected the table name to match the one used in addOrders method
        try (Statement statement = connect().createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("username");
                String orderType = rs.getString("order_type");
                String date = rs.getString("date");
                String company = rs.getString("company");
                int number = rs.getInt("number");
                order order = new order(name, orderType, date, company, number);  // Corrected capitalization of Order class
                orderList.add(order);
            }
        }
        return orderList;
    }
    public static ArrayList<order> getuserOrders(int id) throws SQLException {
    ArrayList<order> orderuserList = new ArrayList<>();
    String query = "SELECT * FROM ordershistory WHERE userid= "+id;  // Corrected the table name to match the one used in addOrders method
        try (Statement statement = connect().createStatement();
    ResultSet rs = statement.executeQuery(query)) {
        while (rs.next()) {

            String orderType = rs.getString("order_type");
            String date = rs.getString("date");
            String company = rs.getString("company");
            int number = rs.getInt("number");
            order order = new order(company, orderType, date, company, number);  // Corrected capitalization of Order class
            orderuserList.add(order);
        }
    }
        return orderuserList;
}
}
