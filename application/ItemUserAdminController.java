package application;

import DataBase.userDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import system.users;

import java.io.IOException;
import java.sql.SQLException;

import DataBase.userDB;


public class ItemUserAdminController {

    @FXML
    private Button update;
    
    @FXML
    private Button delete;
    @FXML
    private Button Retreive;
    @FXML
    private TextField User_Name;
    private users user;

    @FXML
    private void handle_Update(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/UpdateUsersAdmin.fxml"));
            Parent root = loader.load();
            UpdateUsersAdmin controller = loader.getController();
            controller.initializeUserData(user);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handle_delete(ActionEvent event) throws SQLException {
        if (user != null) {
            userDB.deleteuser(user.getUserName());
            // Remove the item from the UI

        }
    }
    public void setUseRName(users user){
        this.user= user;
        if (user != null) {
            User_Name.setText(user.getUserName());
        }
    }
    public String getUserName(){
        return User_Name.getText();
    }

    @FXML
    private void handle_Retreive(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/RetreiveUsersAdmin.fxml"));
            Parent root = loader.load();
            RetreiveUsersAdmin controller = loader.getController();
            controller.initializeupdateData(user);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
