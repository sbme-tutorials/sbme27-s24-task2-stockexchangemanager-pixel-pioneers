package application;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class HomeAdminController {



	@FXML
	private ToggleButton SessionButton;
	private static final String LastStateFile="lastState.txt";
	// private boolean isSessionActive = false;
	@FXML
	private void initialize() {
		try {
			String lastState=new String(Files.readAllBytes(Paths.get(LastStateFile)));
			if("Start".equals(lastState)) {
				SessionButton.setSelected(true);
				SessionButton.setText("End Session");
//	                  saveState("End");
			}else if("End".equals(lastState)) {
				SessionButton.setSelected(true);
				SessionButton.setText("Start Session");
//	                saveState("Start");
			}
		}catch(IOException e) {
			// SessionButton.setSelected(false);
			//  SessionButton.setText("End Session");
		}
		SessionButton.setOnAction(event->handleSession());
//	    	if(SessionButton.isSelected()) {
//	    	//	loadEnd();
//	    	}else {
//	    		//loadStart();
//	    	}
	}


	private void handleSession() {
		String lastState;
		try {
			lastState = new String(Files.readAllBytes(Paths.get(LastStateFile)));

			if (SessionButton.isSelected()&&("Start".equals(lastState))) {
				SessionButton.setText("Start Session");
				saveState("End");
			} else if(SessionButton.isSelected()&&("End".equals(lastState))){
				SessionButton.setText("End Session");
				saveState("Start");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveState(String state) {

		try {
			Files.write(Paths.get(LastStateFile), state.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void ToggleSession() {
	}

}