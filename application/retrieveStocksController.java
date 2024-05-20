package application;


import DataBase.stockDB;
import DataBase.userDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import system.users;

import java.io.IOException;
import java.sql.SQLException;

import system.stocks;
public class retrieveStocksController {




        @FXML
        private TextField Dividends_Amount;

        @FXML
        private TextField Company_Name;

        @FXML
        private TextField initial_Price;

        @FXML
        private TextField Available_Stocks;

        @FXML
        private TextField Divided_Frequency;

        @FXML
        private TextField Trading_Price;

        @FXML

        private stocks stock;

        public void initializeStockData(stocks stock) {
            this.stock = stock;
            if (stock != null) {
                Company_Name.setText(stock.getCompany());
//                Dividends_Amount.setText(String.valueOf(stock.getDividendsAmount()));
                initial_Price.setText(String.valueOf(stock.getInitialPrice()));
                Available_Stocks.setText(String.valueOf(stock.getAvailableStocks()));
                Trading_Price.setText(String.valueOf(stock.getTradingPrice()));
//                Divided_Frequency.getText(stock.getDividends());
            }
        }
    }


