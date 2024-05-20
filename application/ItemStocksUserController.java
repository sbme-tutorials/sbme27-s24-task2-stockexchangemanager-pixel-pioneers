package application;

import DataBase.ordersDB;
import DataBase.stockDB;
import DataBase.userDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import system.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemStocksUserController {
    private stocks stock1;
    @FXML
    public TextField Stock_Name;
    @FXML
    public Button Sell;
    @FXML
    public TextField Available_Stocks;
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));

    public void setStock(stocks stock1){
        this.stock1=stock1;
        if (stock1 != null) {
            Stock_Name.setText(stock1.getAvailableStocks()+"     "+" price:"+stock1.getTradingPrice());
        }
    }
    @FXML
    void sell(ActionEvent event) throws SQLException {
        UserSession session = SessionManager.getSession();
        if(Integer.parseInt(Available_Stocks.getText())>0&&Available_Stocks.getText()!=null&&Integer.parseInt(Available_Stocks.getText())<= stock1.getAvailableStocks()) {
            try {
                if(Integer.parseInt(Available_Stocks.getText())==stock1.getAvailableStocks()){
                    stockDB.deleteUserStocks(stock1.getId());
                }
                else {

                    userDB.updatestockUser(stock1.getId(), (stock1.getAvailableStocks() - Integer.parseInt(Available_Stocks.getText())));
                    ordersDB.addOrders(session.getUsername(), "sell", currentTime, stock1.getCompany(), Integer.parseInt(Available_Stocks.getText()),session.getUserId());
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
}
