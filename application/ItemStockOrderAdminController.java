package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import DataBase.ordersDB;
import system.order;
public class ItemStockOrderAdminController {

    @FXML
    public TextField User_Name;
    @FXML
    public TextField Order_Type;
    @FXML
    public TextField Date;
    @FXML
    public TextField Company;
    @FXML
    public TextField Available_Stock;
    private order orderr;
    public void setorder(order orderr) {
        this.orderr = orderr;
        if(orderr != null) {
            User_Name.setText(orderr.getName());
            Order_Type.setText(orderr.getType());
            Date.setText(orderr.getDate());
            Company.setText(orderr.getCompany());
            Available_Stock.setText(String.valueOf(orderr.getNum()));
        }
    }
}
