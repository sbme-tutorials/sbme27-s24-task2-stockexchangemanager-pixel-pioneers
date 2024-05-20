package application;
import DataBase.userDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.events.Event;
import system.stocks;
import system.users;

import java.sql.SQLException;

public class UpdateUsersAdmin {

    @FXML
    private TextField Acc_Balance;

    @FXML
    private TextField Country1;

    @FXML
    private TextField Email;

    @FXML
    private TextField First_Name;

    @FXML
    private TextField Gender1;

    @FXML
    private TextField Last_Name;

    @FXML
    private PasswordField Password;

    @FXML
    private CheckBox Premium_User;

    @FXML
    private Button Update_Account;

    @FXML
    private Label error_lbl;
    private users user;

    public void initializeUserData(users user) {
        this.user = user;
        if(user!=null){
            First_Name.setText(user.getUserName());
            Last_Name.setText(user.getUserName());
            Password.setText(user.getPassword());
           Email.setText(user.getEmail());
           Gender1.setText(user.getGender());
           Country1.setText(user.getCountry());
           Acc_Balance.setText(String.valueOf(user.getAccount_balance()));

        }


    }
    public void updateAccount(ActionEvent event) throws SQLException {
        userDB.updateUser(Password.getText(), Double.parseDouble(Acc_Balance.getText()),user.getId());

    }
}
