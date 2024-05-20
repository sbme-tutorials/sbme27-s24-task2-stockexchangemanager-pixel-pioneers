package application;

import DataBase.userDB;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewAccountController implements Initializable {
    @FXML
    public CheckBox Preimum;
    @FXML
    private TextField First_Name;

    @FXML
    private TextField Last_Name;

    @FXML
    private PasswordField Confirm_Password;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField Email;

    @FXML
    private ComboBox<Gender> Gender1;

    @FXML
    private ComboBox<Country> Country1;

    @FXML
    private TextField Acc_Balance;

    @FXML
    private Button Create_Account;

    @FXML
    private Label error_lbl;

    public enum Gender {
        MALE,
        FEMALE
    }

    public enum Country {
        EGYPT,
        USA,
        UK,
        CANADA,
        AUSTRALIA
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize combo boxes
        Gender1.getItems().addAll(Gender.values());
        Country1.getItems().addAll(Country.values());
        // Hide the error label initially
        error_lbl.setVisible(false);
    }

    @FXML
    private void Create_Account (ActionEvent event) {
        // Check if any text field is empty or if a ComboBox is not selected
        if (First_Name.getText().isEmpty() || Last_Name.getText().isEmpty() || Password.getText().isEmpty()
                || Confirm_Password.getText().isEmpty() || Email.getText().isEmpty() || Acc_Balance.getText().isEmpty()
                || Gender1.getValue() == null || Country1.getValue() == null) {
            // Display error message
            error_lbl.setText("* Please fill in all fields and select from both ComboBoxes.");
            error_lbl.setVisible(true);

        }else if(!Password.getText().equals(Confirm_Password.getText())) {
            error_lbl.setText("* Passwords do not match.");
            error_lbl.setVisible(true);

        }else if(!First_Name.getText().matches("[a-zA-Z]+") || !Last_Name.getText().matches("[a-zA-Z]+")) {
            error_lbl.setText("* First name and last name should contain only letters.");
            error_lbl.setVisible(true);

        }else if(!Acc_Balance.getText().matches("\\d+")) {
            error_lbl.setText("* Account balance should contain only numbers.");
            error_lbl.setVisible(true);

        }else if (!Email.getText().contains("@") || !Email.getText().endsWith(".com")) {
            // Check if Email contains @ character and ends with .com
            error_lbl.setText("* Email should contain '@' character and end with '.com'.");
            error_lbl.setVisible(true);

        }else {
            // Save the new account data
            try {
                userDB.insertUser(First_Name.getText()+" "+Last_Name.getText(), Password.getText(),Email.getText(), String.valueOf(Gender1.getValue()), Double.parseDouble(Acc_Balance.getText()), String.valueOf(Country1.getValue()));

            } catch (SQLException e) {
                e.printStackTrace();
                error_lbl.setText("* Failed to create account. Please try again.");
                error_lbl.setVisible(true);
                return;
            }

            // Close the New Account window
            Stage currentStage = (Stage) Create_Account.getScene().getWindow();
            currentStage.close();

        }
    }

// userDB.insertUser(First_Name.getText()+" "+Last_Name.getText(), Password.getText(),Email.getText(), Gender1.getPromptText(), Double.parseDouble(Acc_Balance.getText()), Country1.getPromptText());

//    public  void Create_Account (ActionEvent event) throws SQLException, SQLException {
//        userDB.insertUser(First_Name.getText()+" "+Last_Name.getText(), Password.getText(),Email.getText(), Gender1.getPromptText(), Double.parseDouble(Acc_Balance.getText()), Country1.getPromptText());
//
//    }


}
