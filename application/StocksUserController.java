package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import application.NewAccoutController.Country;
//import application.NewAccoutController.Gender;
import DataBase.stockDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import system.SessionManager;
import system.UserSession;
import system.stocks;

public class StocksUserController implements Initializable {

    UserSession session = SessionManager.getSession();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            ArrayList<stocks> stockList= stockDB.getuserStocks(session.getUserId());
            for(int i=0;i<stockList.size();i++){
                stocks stock3=stockList.get(i);
                addnewItem(stock3);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private VBox containerVBox;

    // Method to dynamically add new item
    public void addnewItem(stocks stock) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ItemStocksUser.fxml"));
            HBox item = loader.load();
            containerVBox.getChildren().add(item);
            ItemStocksUserController controller = loader.getController();
            controller.setStock(stock);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

