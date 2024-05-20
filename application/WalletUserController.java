package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DataBase.ordersDB;
import DataBase.userDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import system.SessionManager;
import system.UserSession;
import system.transactions;
import DataBase.ordersDB;
import system.users;

public class WalletUserController  implements Initializable {


    @FXML
    private TextField account;

    @FXML
    private Label expense;

    @FXML
    private Label impossible;

    @FXML
    private Label impossible1;

    @FXML
    private Label income;

    @FXML
    public VBox financial;

    @FXML
    private TextField decrease;

    @FXML
    private TextField increase;
    UserSession session = SessionManager.getSession();
    private int totalIncome = 0;
    private int totalExpense = 0;
    private double totalAccount = session.getBalance();
    private users user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account.setText(String.valueOf(session.getBalance()));
        impossible.setVisible(false);
        impossible1.setVisible(false);

    }

    @FXML
    void deposit(ActionEvent event) throws SQLException {
        impossible.setVisible(false);
        String input1 = increase.getText();
        if (check(input1)) {
            impossible1.setVisible(false);
            int amount = Integer.parseInt(input1);
            String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/DepositUser.fxml"));
                HBox deposit = loader.load();
                DepositUserController controller = loader.getController();
                controller.setDepositDetails(user.getId(),amount, currentTime);
                financial.getChildren().add(deposit); // Append the new view to the VBox
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            totalIncome += amount;
            income.setText("+$" + totalIncome);
            totalAccount += amount;
//            account.setText(userDB.getBalance(user.getId())+ "$");
            increase.clear();
        } else {
            impossible1.setVisible(true);
            impossible1.setText("*It's invaled input");
            increase.clear();
        }
    }

    @FXML
    void withdraw(ActionEvent event) throws Exception {

        impossible1.setVisible(false);
        String input = decrease.getText();
        if (check(input)) {
            int Amount = Integer.parseInt(input);
            String CurrentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
            totalAccount -= Amount;
            if (totalAccount >= 0) {

                        addNewItem(user.getId(),Amount,CurrentTime);
                totalExpense += Amount;
                    expense.setText("-$" + totalExpense);
//                    account.setText(totalAccount + "$");
                    impossible.setVisible(false);
                }
            else{
                    impossible.setVisible(true);
                    impossible.setText("*Sorry:You don't have money to Withdraw from :( ");
                    totalAccount += Amount;
                }
                decrease.clear();
            } else {
                impossible.setVisible(true);
                impossible.setText("*It's invaled input ");
                decrease.clear();
            }
        }
        private boolean check (String input2){
            try {
                Integer.parseInt(input2);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }


    private void addNewItem(int id,int Amount,String CurrentTime) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/WithdrawUser.fxml"));
        HBox withdraw = loader.load();
        WithdrawUserController controller = loader.getController();
        controller.setWithdrawDetails(id,Amount,CurrentTime,userDB.getBalance(user.getId()));
        financial.getChildren().add(withdraw);
    }
    private void additem(transactions tran) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/WithdrawUser.fxml"));
        HBox withdraw = loader.load();
        WithdrawUserController controller = loader.getController();
        controller.settrans(tran);
        financial.getChildren().add(withdraw);
    }
    public void setUser(users user){
        this.user=user;
        showprocess(user);
    }
    public void showprocess(users user){
        try {
            ArrayList<transactions> transLists = ordersDB.gettrans(user.getId());
            for (int i = 0; i < transLists.size(); i++) {
                transactions trans = transLists.get(i);
                additem(trans);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}



