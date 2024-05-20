package application;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/gui/Log.fxml"));
			Scene scene = new Scene(root, 800, 700);
			scene.getStylesheets().add(getClass().getResource("/styles/Log.css").toExternalForm());
			primaryStage.setTitle("Stock Exchange Manger");
			Image image = new Image("icons8-user-100.png" );
			primaryStage.getIcons().add(image);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}

}
