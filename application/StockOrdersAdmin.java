package application;


import DataBase.stockDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import system.stocks;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StockOrdersAdmin {

    @FXML
    private VBox containerVBox;
//    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            ArrayList<stocks> stockList= stockDB.getstocks();
            for(int i=0;i<stockList.size();i++){
                stocks stock=stockList.get(i);
                addNewItem(stock);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to dynamically add new item
    public void addNewItem(stocks stock) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ItemStocksAdmin.fxml"));
            HBox item = loader.load();
            containerVBox.getChildren().add(item);
            ItemStocksAdminController controller = loader.getController(); // Get the controller instance
            controller.setStockname(stock);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

