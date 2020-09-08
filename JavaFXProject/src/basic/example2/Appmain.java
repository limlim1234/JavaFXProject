package basic.example2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Appmain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("Root.fxml"));
		BorderPane root = loader.load();
		
		
		PeopleController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene =new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}
}