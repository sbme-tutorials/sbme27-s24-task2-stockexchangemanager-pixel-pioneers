
package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import system.users;

public class UserController {
	@FXML
	private AnchorPane dynamicContentPane;

	@FXML
	private AnchorPane borderPane;

	@FXML
	private Button WalletUser;

	@FXML
	private Button StocksUser;
	@FXML
	private Button HomeUser;
	@FXML
	private Button MarketUser;
	@FXML
	private Button ProfileUser;
	@FXML
	private Button Logout;

	public users currentUser ;

	@FXML
	void initialize() {
		// Load the initial content when the controller is initialized
		loadFXML("/gui/WalletUser.fxml");

	}


	public void setUser(users user) {
		currentUser=user;
	}
	private static final String LastStateFile="lastState.txt";
	@FXML
	public void switchform(ActionEvent event) {
		try {
			String lastState =new String(Files.readAllBytes(Paths.get(LastStateFile)));
			if (event.getSource() == WalletUser) {
				loadWalletUserFXML("/gui/WalletUser.fxml");

			} else if (event.getSource() == MarketUser&&"Start".equals(lastState)) {
				loadMarketUserFXML("/gui/MarketUser.fxml");
			}else if (event.getSource() == MarketUser&&"End".equals(lastState)) {
				loadFXML("/gui/MarketClose.fxml");
			} else if (event.getSource() == StocksUser) {
				loadFXML("/gui/StocksUser.fxml");
			} else if (event.getSource() == ProfileUser) {
				navigateToProfileUser();
			}
		}catch(IOException e) {

		}
	}

	private void loadFXML(String fxmlFileName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
			AnchorPane content = loader.load();
			dynamicContentPane.getChildren().setAll(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void loadWalletUserFXML(String fxmlFileName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
			AnchorPane content = loader.load();
			WalletUserController controller = loader.getController();
			controller.setUser(currentUser); // Pass the current user to the WalletUserController
			dynamicContentPane.getChildren().setAll(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleLogOut(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Log.fxml"));
			Parent root = loader.load();
			Stage stage = (Stage) Logout.getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void navigateToProfileUser() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ProfileUser.fxml"));
			AnchorPane content = loader.load();
			ProfileUserController controller = loader.getController();
			controller.initializeUserData(currentUser);
			dynamicContentPane.getChildren().setAll(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadMarketUserFXML(String fxmlFileName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
			AnchorPane content = loader.load();
			MarketUserController controller = loader.getController();
			controller.setUser(currentUser); // Pass the current user to the MarketUserController
			dynamicContentPane.getChildren().setAll(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
