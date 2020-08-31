package basic.container;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxExample extends Application {



	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPadding(new Insets(10, 10, 10, 10));
		// 컨트롤들
		ImageView iv = new ImageView();
		iv.setFitWidth(200);
		iv.setPreserveRatio(true);
		iv.setImage(new Image("/basic/images/sample.jpg"));

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(20);

		// 에이치박스안에 들어갈 컨테이너들
		Button btnPrev = new Button();
		btnPrev.setText("이전");
		Button btnNext = new Button("다음");
		HBox.setHgrow(btnNext, Priority.ALWAYS);
		btnNext.setMaxWidth(Double.MAX_VALUE);
		hbox.getChildren().add(btnPrev); //에이치박스에 담겠다 
		hbox.getChildren().add(btnNext);
		VBox.setMargin(hbox, new Insets(10));
		

		root.getChildren().add(iv); //vbox
		root.getChildren().add(hbox);
	//이때까지 컨테이너
		
		Scene scene =new Scene(root);  //신 담고 있는게 스테이지 => 스테이지(신(컨테이너))
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("VBox 예제");
		primaryStage.setResizable(false);
	
	}

	public static void main(String[] args) { // 매개값을 넣어서 실행하겠다
		Application.launch(args);
	}

}
