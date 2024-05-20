package application;

import DataBase.ordersDB;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import system.SessionManager;
import system.UserSession;
import system.transactions;
import system.users;

public class WithdrawUserController {
users user1 = new users();
    @FXML
    private Label AmountLabel;

    @FXML
    private Label TimeLabel;
   private transactions trans;
    UserSession session = SessionManager.getSession();
    public void setWithdrawDetails(int id,int amount, String time,double balance) throws Exception {
        AmountLabel.setText("Withdraw:   " + amount +"$");
        TimeLabel.setText("Date&Time:    " + time);
        user1.withdraw(id, amount, time,balance);
        ordersDB.addOrder(id,"withdraw", amount, time);

    }
    public void settrans(transactions trans) {
        this.trans = trans;
        if (trans!=null){
        AmountLabel.setText(trans.getDeposite_withdrawel()+" "+trans.getMoney());
        TimeLabel.setText(trans.getDate());
    }}

}
