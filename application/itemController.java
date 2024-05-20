package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class itemController {

    @FXML
    private HBox root;

    @FXML
    private TextField User_Name;

    public void initialize() {
        // Initialization code can go here
    }

    public HBox getRoot() {
        return root;
    }

    public void setUserName(String userName) {
        User_Name.setText(userName);
    }

    public String getUserName() {
        return User_Name.getText();
    }
}