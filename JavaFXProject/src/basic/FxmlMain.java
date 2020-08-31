package basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FxmlMain extends Application {

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox =FXMLLoader.load(getClass().getResource("Root.fxml"));
		//parent root 임포트해야함                                                AnchorRoot.fxml
		Scene scene = new Scene(hbox); //hbox말고 root
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("FXML 화면");
	}

	public static void main(String[] args) {
		launch(args);

	}
}
