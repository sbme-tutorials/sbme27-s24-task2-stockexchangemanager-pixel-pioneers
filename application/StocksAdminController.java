package application;

import DataBase.stockDB;
import DataBase.userDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import system.stocks;
import system.users;

public class StocksAdminController<ItemController> implements Initializable {

    @FXML
    private VBox containerVBox;

    @FXML
    private Button Create_New_Stock;

    @Override
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


    @FXML
    private void handleCreate_New_Stock(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/NewStock.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
