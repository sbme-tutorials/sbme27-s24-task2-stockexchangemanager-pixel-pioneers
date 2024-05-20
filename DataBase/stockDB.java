package DataBase;

//import application.databaseController;

import system.stocks;
import system.users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class stockDB extends superDB {
    public static void insertStock(String company, String company_initial_price, String trading_price, String quentity, double profit_percentage) throws SQLException {
        statement = superDB.connect().createStatement();
        try {
            String query = "INSERT INTO stocks (company,company_initial_price , trading_price, quentity, profit_percentage) VALUES('" + company + "', '" + company_initial_price + "', '" + trading_price + "', '" + quentity + "',' " + profit_percentage + "')";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<stocks> getstocks() throws SQLException {
        ArrayList<stocks> stockList = new ArrayList<>();
        String query = "SELECT * FROM stocks";
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = superDB.connect().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String company = rs.getString("company");
                String company_ib = rs.getString("company_initial_price");
                double trading_price = rs.getDouble("trading_price");
                int quentity = rs.getInt("quentity");
                String profitP = rs.getString("profit_percentage");
                int id = rs.getInt("id");
                stocks stock = new stocks(company, company_ib, trading_price, quentity, profitP, id);
                stockList.add(stock);
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
        return stockList;
    }

    public static void updateStock( double trading_price, double quentity, double profit_percentage, int id) throws SQLException {
        statement = superDB.connect().createStatement();
        try {
            String query = "UPDATE stocks SET (trading_price, quentity, profit_percentage) VALUES('"
                     + trading_price + "', '" + quentity + "',' " + profit_percentage + "')WHERE id = " + id;
            statement.execute(query);
        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public static void deleteStock(int stockId) throws SQLException {
        statement = superDB.connect().createStatement();
        try {
            String query = "DELETE FROM stocks WHERE id = '" + stockId + "'";
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    public static ArrayList<stocks> getuserStocks(int userid) throws SQLException {
        ArrayList<stocks> stockuserList = new ArrayList<>();
        String query = "SELECT * FROM userstocks WHERE userid = " + userid;
        ResultSet rs = null;
        try {

            Statement statement = superDB.connect().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {

                String company = rs.getString("company");
                int num = rs.getInt("number");
                int id = rs.getInt("id");
                stocks stock = new stocks(company, num,userid,id);
                stockuserList.add(stock);

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
        return stockuserList;
    }
    public static void deleteUserStocks(int stockid) throws SQLException {
        statement = superDB.connect().createStatement();
        try {
            String query = "DELETE FROM userstocks WHERE id = '" + stockid + "'";
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    public static ArrayList<stocks> getstockscompany(String conpany) throws SQLException {
        ArrayList<stocks> stockList = new ArrayList<>();
        String query = "SELECT * FROM stocks WHERE company = '" + conpany + "'";
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = superDB.connect().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String company = rs.getString("company");
                String company_ib = rs.getString("company_initial_price");
                double trading_price = rs.getDouble("trading_price");
                int quentity = rs.getInt("quentity");
                String profitP = rs.getString("profit_percentage");
                int id = rs.getInt("id");
                stocks stock = new stocks(company, company_ib, trading_price, quentity, profitP, id);
                stockList.add(stock);
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
        return stockList;
    }
    public static void addstockuser(String company, int num, int userid,int stockid) throws SQLException {
        String query = "INSERT INTO userstocks (company, number, userID,stockid) VALUES (?, ?, ?,?)";

        try {

            PreparedStatement preparedStatement = connect().prepareStatement(query);
            preparedStatement.setString(1, company);
            preparedStatement.setInt(2, num);
            preparedStatement.setInt(3, userid);
            preparedStatement.setInt(4, stockid);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception after logging it
        }
        }
        public static void updatestockNumber(int stockid ,int number) throws SQLException {
            Statement statement = null;
            try {
                statement = superDB.connect().createStatement();
                String query = "UPDATE stocks SET quentity = " + number + " WHERE id = " + stockid;
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

