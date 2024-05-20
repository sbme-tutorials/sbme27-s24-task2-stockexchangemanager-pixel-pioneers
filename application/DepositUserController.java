package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import DataBase.ordersDB;
import system.users;

public class DepositUserController {

    @FXML
    private Label amountLabel;

    @FXML
    private Label timeLabel;
 users user = new users();
    public void setDepositDetails(int id,int amount, String time) throws Exception {
        amountLabel.setText("Deposit:    " + amount +"$");
        timeLabel.setText("Date&Time:    " + time);
        user.deposit(id, amount, time);

    }

}
