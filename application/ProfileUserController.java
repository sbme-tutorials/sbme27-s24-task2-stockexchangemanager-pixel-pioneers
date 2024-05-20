
package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import system.users;

import java.io.IOException;

public class ProfileUserController {
    @FXML
    public Button Add_another_account;
    @FXML
    private TextField name_fld;
    @FXML
    public TextField email_fld;
    @FXML
    private TextField gender_fld;
    @FXML
    private TextField country_fld;
    @FXML
    private TextField accbalance_fld;

    private users user;

    @FXML
    public void initialize() {
        // Initialization if needed
    }



    public void initializeUserData(users user ) {
        this.user = user;
        profile(user);
    }

    private void profile( users user) {
        if (user != null) {
            name_fld.setText(user.getUserName());
            email_fld.setText(user.getEmail());
            gender_fld.setText(user.getGender());
            country_fld.setText(user.getCountry());
            accbalance_fld.setText(String.valueOf(user.getAccount_balance()));

//            System.out.println(this.user.getUserName());
//            accbalance_fld.setText(String.valueOf(user.getAccount_balance()));
        }
    }
    @FXML
    public void handleAnother_Account() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/NewAccount.fxml"));
            Parent root = loader.load();
            Stage signUpStage = new Stage();
            signUpStage.setScene(new Scene(root));
            signUpStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}