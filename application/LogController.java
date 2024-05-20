
package application;

import DataBase.login;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import system.SessionManager;
import system.UserSession;
import system.users;
import DataBase.userDB;

public class LogController {

    enum AccountType {
        ADMIN,
        USER
    }

    @FXML
    private ChoiceBox<AccountType> Acc_Selector;

    @FXML
    private TextField User_Name;

    @FXML
    private PasswordField Password;

    @FXML
    private Button Sign_in;

    @FXML
    private Button Sign_Up;

    @FXML
    private Label Error_lbl;

    @FXML
    public void initialize() {
        // Initialize ChoiceBox options
        Acc_Selector.getItems().addAll(AccountType.ADMIN, AccountType.USER);
        // Hide the error label initially
        Error_lbl.setVisible(false);
        User_Name.setDisable(true);
        Password.setDisable(true);
        Sign_in.setDisable(true);
        Sign_Up.setDisable(true);
    }

    @FXML
    public void handleSignIn() throws SQLException {
        String username = User_Name.getText();
        String pass = Password.getText();

        if (username.isEmpty() || pass.isEmpty()) {
            Error_lbl.setText("Error: Username or password is empty");
            Error_lbl.setVisible(true);
        } else {
            Error_lbl.setVisible(false);
            AccountType selectedAccountType = Acc_Selector.getValue();
            if (selectedAccountType == AccountType.ADMIN) {
                if (isValidAdminLogin(username, pass)) {
                    navigateToHomeAdmin();
                } else {
                    Error_lbl.setText("Error: Invalid admin credentials");
                    Error_lbl.setVisible(true);
                }
            } else if (selectedAccountType == AccountType.USER) {
                if (login.signIn(username, pass)) {
                    users user= userDB.getUser(username);
                    UserSession session = new UserSession(user.getId(), username,user.getAccount_balance());
                    SessionManager.setSession(session);
                    navigateToUserDashboard(user);
                    } else {
                        Error_lbl.setText("Error: User not found");
                        Error_lbl.setVisible(true);
                    }
                } else {
                    Error_lbl.setText("Error: Invalid user credentials");
                    Error_lbl.setVisible(true);
                }
            }
        }

    private boolean isValidAdminLogin(String username, String password) {
        return "Admin".equals(username) && "Admin".equals(password);
    }

    private void navigateToHomeAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Admin.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) Acc_Selector.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void navigateToUserDashboard(users user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/User.fxml"));
            Parent root = loader.load();
            UserController controller = loader.getController();
            controller.setUser(user);
            Stage stage = (Stage) Acc_Selector.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handleSignUp() {
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

    @FXML
    public void handleAccountTypeSelection() {
        AccountType selectedAccountType = Acc_Selector.getValue();
        if (selectedAccountType != null) {
            User_Name.setDisable(false);
            Password.setDisable(false);
            Sign_in.setDisable(false);
            Sign_Up.setDisable(false);
        } else {
            User_Name.setDisable(true);
            Password.setDisable(true);
            Sign_in.setDisable(true);
            Sign_Up.setDisable(true);
        }

        if (selectedAccountType == AccountType.ADMIN) {
            Sign_Up.setVisible(false);
            Sign_Up.setManaged(false);
        } else {
            Sign_Up.setVisible(true);
            Sign_Up.setManaged(true);
        }
    }
}
