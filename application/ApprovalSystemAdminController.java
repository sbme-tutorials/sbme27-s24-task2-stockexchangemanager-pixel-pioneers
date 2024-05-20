package application;

import DataBase.ordersDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import system.transactions;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ApprovalSystemAdminController implements Initializable {

	@FXML
	private VBox containerVBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {

			ArrayList<transactions> transList = ordersDB.getAlltrans();
			for (int i = 0; i < transList.size(); i++) {
				transactions trans = transList.get(i);
				addNewItem(trans);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Method to dynamically add new item
	public void addNewItem(transactions trans) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ItemApprovalSystem.fxml"));
			HBox item = loader.load();
			ItemApprovalSystemAdminController controller = loader.getController(); // Make sure this is the correct controller class
			controller.settransname(trans);
			containerVBox.getChildren().add(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
