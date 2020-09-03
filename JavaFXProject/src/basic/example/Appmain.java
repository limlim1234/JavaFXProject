package basic.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//UI: Root.fxml(기본) , AddForm.fxml(추가), BarChart.fxml(차트)
//Control:RootController.java
public class Appmain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("Root.fxml"));
		BorderPane root = loader.load();
		
		//basic.example. 같은 패키지라 생략가능
		RootController controller = loader.getController();
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
