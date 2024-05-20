package application;

import DataBase.stockDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import system.transactions;

import java.io.IOException;
import java.sql.SQLException;
import DataBase.ordersDB;
import DataBase.userDB;
public class ItemApprovalSystemAdminController {

    @FXML
    private HBox Approval_System;

    @FXML
    private TextField Approve;

    private transactions trans;
    @FXML
    private void handle_approve(ActionEvent event) {
        if (trans != null) {
            try {
                ordersDB.updateOrder(trans.getOrderId(),"approved");
                updateUserBalance(trans.getUserid(), trans.getMoney(), true);
                // Remove the item from the UI, e.g., updating a TableView
            } catch (SQLException e) {
                // Handle the SQL exception, e.g., show an alert to the user
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    private void handle_reject(ActionEvent event) throws SQLException {
        if (trans != null) {
            try {
                ordersDB.updateOrder(trans.getOrderId(),"rejected");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void settransname(transactions trans){
        this.trans=trans;
        if (trans != null) {
           Approve.setText(trans.getOrderId()+"      "+trans.getDeposite_withdrawel());
        }
    }
    private void updateUserBalance(int userId, double amount, boolean isDeposit) throws SQLException {
        double currentBalance = userDB.getBalance(trans.getUserid());
        double newBalance = isDeposit ? currentBalance + amount : currentBalance - amount;
        userDB.updateBalance(userId, newBalance);


    }
}
