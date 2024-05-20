package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import system.stocks;
import DataBase.stockDB;
import system.users;

public class ItemCompanyController {

    @FXML
    private VBox Content; // Main container VBox


    private boolean view = false;


    @FXML
    private Button stocks;

    @FXML
    private TextField companyName;
     users currentUser;
    public void setUser(users user) {  // Add a setUser method
        this.currentUser = user;
    }

    public void setCompanyName(String companies) {
        companyName.setText(companies);
    }

    // Method to add stock items to the VBox
    public void addStocks() throws SQLException {
        if(view){
        // Clear existing children to avoid duplicates
        Content.getChildren().clear();
       ArrayList<stocks> stocksConpany= stockDB.getstockscompany(companyName.getText());
            for (int i = 0; i < stocksConpany.size(); i++) {
            try {
                stocks stock1=stocksConpany.get(i);
                addStock(stock1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }}

    @FXML
    private void stocks(ActionEvent event) throws SQLException {
        view = !view;
        if (view) {
            addStocks(); // Populate with new items
            Content.setVisible(true);
        } else {
            Content.getChildren().clear();
            Content.setVisible(false);
        }
    }
    public void addStock(stocks stock ) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/StockCompany.fxml"));
        HBox stockItem = loader.load();
        StockCompanyController stocksController = loader.getController();
        stocksController.setStock(stock);

        // Add the stock item to the VBox
        Content.getChildren().add(stockItem);
    }


}
