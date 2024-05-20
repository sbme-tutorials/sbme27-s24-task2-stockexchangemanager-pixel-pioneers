package application;

	import DataBase.ordersDB;
	import DataBase.stockDB;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.fxml.Initializable;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.VBox;
	import system.order;
	import system.stocks;

	import java.io.IOException;
	import java.net.URL;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.ResourceBundle;


public class StockOrderAdminController<ItemController> implements Initializable  {
	


	    @FXML
	    private VBox containerVBox;


	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
			try{
				ArrayList<order> orderList= ordersDB.getOrders();
				for(int i=0;i<orderList.size();i++){
					order order=orderList.get(i);
					addNewItem(order);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	    }

	    // Method to dynamically add new item
	    public void addNewItem(order order1) {
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ItemStockOrder.fxml"));
	            HBox item = loader.load();
	            containerVBox.getChildren().add(item);
				ItemStockOrderAdminController controller = loader.getController();
				controller.setorder(order1);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	}


