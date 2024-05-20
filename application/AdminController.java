package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {


    @FXML
    private AnchorPane dynamicContentPane;

    @FXML
    private  AnchorPane borderPane;

    @FXML
    private Button UsersAd;

    @FXML
    private Button StocksOrdersAd;
    @FXML
    private Button StocksAd;
    @FXML
    private Button ApprovalSystem;

    @FXML
    private Button Logout;

    @FXML
    private Button Home;

    public void switchform(ActionEvent event) {
        if (event.getSource()==UsersAd) {
            loadFXML("/gui/UsersAdmin.fxml");
        }else  if (event.getSource()==StocksAd) {
            loadFXML("/gui/StocksAdmin.fxml");
        }else  if (event.getSource()==StocksOrdersAd) {
            loadFXML("/gui/StockOrdersAdmin.fxml");
        } if (event.getSource()==ApprovalSystem) {
            loadFXML("/gui/ApprovalSystemAdmin.fxml");
        } if (event.getSource()==Home) {
            loadFXML("/gui/HomeAdmin.fxml");
        }

    }



    @FXML
    void initialize() {
        loadFXML("/gui/HomeAdmin.fxml");
    }

    private void loadFXML(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            AnchorPane content = loader.load();
            dynamicContentPane.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleLog_Out(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Log.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) Logout.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
