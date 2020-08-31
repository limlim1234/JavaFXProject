package basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Appmain extends Application {// 어플리케이션 추상클래스
//컨테이너: 컨트롤 모음거        scene:컨테이너 모은거 
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox(); // 컨테이너임
		hbox.setPadding(new Insets(10)); // 컨트롤 컨테이너 간격
		hbox.setSpacing(10); // 컨트롤 컨트롤 간격
		TextField tField = new TextField(); // 텍스트
		tField.setPrefWidth(200); // 텍스필드 폭 설정
		
		Button btn = new Button();
		btn.setText("확인");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit(); // 확인 누르면 종료됨

			}

		});

		// 컨테이너에 컨트롤 달기
		hbox.getChildren().add(tField);
		hbox.getChildren().add(btn);

		Scene scene = new Scene(hbox);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Appmain 화면");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
