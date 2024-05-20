package application;

import DataBase.userDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import system.users;


public class UsersAdminController<ItemController> implements Initializable {

    @FXML
    private VBox containerVBox;

    @FXML
    private Button Create_New_User;


//    private userModel userModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        userModel = new userModel();
        try{
            ArrayList<users> userList=userDB.getUsers();
            for(int i=0;i<userList.size();i++){
                users user = userList.get(i);
                addNewItem(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Method to dynamically add new item
    public void addNewItem(users user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Item.fxml"));
            HBox item = loader.load();
            containerVBox.getChildren().add(item);
            ItemUserAdminController controller = loader.getController(); // Get the controller instance
            controller.setUseRName(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleCreate_New_User(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/NewAccount.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
