package basic.container;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	public void start(Stage primaryStage) throws Exception { //stage에 대한 변수가 primaryStage 
		VBox root = new VBox();
		root.setPadding(new Insets(10, 10, 10, 10));
		// 컨트롤들
		ImageView iv = new ImageView();
		iv.setFitWidth(200);
		iv.setPreserveRatio(true);
		iv.setImage(new Image("/basic/images/fruit1.jpg"));

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(20);

		// 에이치박스안에 들어갈 컨테이너들
		Button btnPrev = new Button(); //btnprev랑 btnnext은 컨트롤
		btnPrev.setText("이전");
		Button btnNext = new Button("다음");

		HBox.setHgrow(btnNext, Priority.ALWAYS);
		btnNext.setMaxWidth(Double.MAX_VALUE);
		hbox.getChildren().add(btnPrev); //에이치박스에 담겠다 
		hbox.getChildren().add(btnNext);
		VBox.setMargin(hbox, new Insets(10));
		
		//이벤트 핸들러를 해당 컨트롤에 등록
		btnNext.setOnAction(new EventHandler<ActionEvent>() {
			int loc = 1;
			
			@Override
			public void handle(ActionEvent ae) {
				if(loc == 9)
					loc =1;
//사진 이름 7번이 없고 89가 있을 경우 if(loc == 7) loc =6; if(loc==10) loc=1;  				
//				System.out.println("handle: " + ae.getSource());
				//다음 누르면 이미지가 바꾸는거                                          //원랜 2
				iv.setImage(new Image("/basic/images/fruit" + loc++ + ".jpg"));
				
			}
			
		});
		
/*		btnNext.setOnAction((ae) -> {
			System.out.println("handle: " + ae.getSource());
		}); */

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
