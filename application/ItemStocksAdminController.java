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
public class ItemStocksAdminController {


    @FXML
    private Label error_lbl;

    @FXML
    private Button update;
    
    @FXML
    private Button delete;
    @FXML
    private Button Retreive;
    @FXML
    private TextField Stock_Name;


    private stocks stock;

    @FXML
    private void handle_Update(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/UpdateStocksAdmin.fxml"));
            Parent root = loader.load();
            UpdateStocksAdminController controller = loader.getController();
            controller.initializeStockData(stock);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    @FXML
    private void handle_delete(ActionEvent event) throws SQLException {
        if (stock != null) {
            try {
                stockDB.deleteStock(stock.getId());
                // Remove the item from the UI, e.g., updating a TableView
            } catch (SQLException e) {
                // Handle the SQL exception, e.g., show an alert to the user
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void handle_Retreive(ActionEvent event) {
    	 try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/RetreiveStocksAdmin.fxml"));
             Parent root = loader.load();
             retrieveStocksController controller = loader.getController();
             controller.initializeStockData(stock);
             Stage stage = new Stage();
             stage.setScene(new Scene(root));
             stage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    public void setStockname(stocks stock){
        this.stock=stock;
        if (stock != null) {
            Stock_Name.setText(stock.getId()+" "+stock.getCompany());
        }
    }

}
