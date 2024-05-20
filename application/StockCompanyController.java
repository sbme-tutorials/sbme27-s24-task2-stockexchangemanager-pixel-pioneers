package application;

import DataBase.stockDB;
import DataBase.ordersDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import system.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockCompanyController {
private stocks stock2;
private users currentUser ;

    @FXML
    private Button buy;

    @FXML
    private TextField stock;
    @FXML
    public TextField Available_Stock;
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    stocks stockk1=new stocks();
    public void setUser(users currentUser) {
        this.currentUser = currentUser;


    }
    public void setStock(stocks stock2){
        this.stock2=stock2;
        if (stock2 != null) {
            stock.setText(" price:"+stock2.getInitialPrice()+" "+stock2.getAvailableStocks());
        }
    }
    @FXML
    void buy(ActionEvent event) throws SQLException {
        UserSession session = SessionManager.getSession();
        if (stock2.getAvailableStocks() > 0 && stock2.getTradingPrice() < session.getBalance() && Integer.parseInt(Available_Stock.getText()) <= stock2.getAvailableStocks()) {
            try {

                stockDB.addstockuser(stock2.getCompany(), Integer.parseInt(Available_Stock.getText()), session.getUserId(), stock2.getId());
                stockDB.updatestockNumber(stock2.getId(), stock2.getAvailableStocks()-Integer.parseInt(Available_Stock.getText()));
                ordersDB.addOrders(session.getUsername(), "buy", currentTime, stock2.getCompany(), Integer.parseInt(Available_Stock.getText()),session.getUserId() );

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }

    }

