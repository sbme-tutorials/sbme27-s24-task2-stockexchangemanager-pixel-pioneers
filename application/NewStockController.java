package application;
import DataBase.userDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import DataBase.stockDB;
public class NewStockController {

	@FXML
	private Button Create_Stock  ;
	@FXML
	private TextField Available_Stocks;

	@FXML
	private TextField initial_Price;

	@FXML
	private TextField Company_Name;

	@FXML
	private TextField Dividends_Amount;

	@FXML
	private ComboBox<Frequency> Divided_Frequency;
	@FXML
	private Label error_lbl;



	enum Frequency {
		Quarterly,
		SemiAnnually,
		Annually
	}

	@FXML
	private void initialize() {

		Divided_Frequency.getItems().addAll(Frequency.values());

	}
	@FXML
	private void Create_stock(ActionEvent event) {

		if (Company_Name.getText().isEmpty() || initial_Price.getText().isEmpty() || Available_Stocks.getText().isEmpty()
				|| Dividends_Amount.getText().isEmpty() || Divided_Frequency.getValue() == null) {

			error_lbl.setText("* Please fill in all fields and select the ComboBox.");
			error_lbl.setVisible(true);

		}else if(!Company_Name.getText().matches("[a-zA-Z]+") ) {
			error_lbl.setText("* Company Name should contain only letters.");
			error_lbl.setVisible(true);

		}else if(!initial_Price.getText().matches("\\d+" )) {
			error_lbl.setText("*initial Price hould contain only numbers.");
			error_lbl.setVisible(true);

		}else if(!Dividends_Amount.getText().matches("\\d+" )){
			error_lbl.setText("*Dividends Amount should contain only numbers.");
			error_lbl.setVisible(true);

		}else if(!Available_Stocks.getText().matches("\\d+" )){
			error_lbl.setText("* Available Stocks should contain only numbers.");
			error_lbl.setVisible(true);
		}else {
			try {
				stockDB.insertStock(Company_Name.getText(), initial_Price.getText(), Available_Stocks.getText(), Available_Stocks.getText(), Divided_Frequency.getVisibleRowCount());
			}catch (SQLException e) {
				e.printStackTrace();
				error_lbl.setText("* Failed to create account. Please try again.");
				error_lbl.setVisible(true);
			}

		}
	}

}//String.valueOf(Divided_Frequency.getValue())
