package application;

import DataBase.stockDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import system.stocks;

import java.sql.SQLException;

public class UpdateStocksAdminController {

    @FXML
    private TextField Dividends_Amount;

    @FXML
    private TextField Company_Name;

    @FXML
    private TextField initial_Price;

    @FXML
    private TextField Available_Stocks;

//    @FXML
//    private TextField Stock_Name;
    public enum DividedFrequency {
        Quarterly,
        SemiAnnually,
        Annually
    }

    private stocks stock;

    public void initializeStockData(stocks stock) {
        this.stock = stock;
        if (stock != null) {

//            Dividends_Amount.setText(String.valueOf(stock.getDividendsAmount()));
            Company_Name.setText(stock.getCompany());
            initial_Price.setText(stock.getInitialPrice());
            Available_Stocks.setText(String.valueOf(stock.getAvailableStocks()));
        }
    }
//    public  void update_stock (ActionEvent event) throws SQLException, SQLException {
//        stockDB.updateStock();
//    }
}
