package basic.container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneExample extends Application {

/*	배열로 해보기
	@Override
	public void start(Stage primaryStage) throws Exception {
		TilePane root = new TilePane();
		root.setPrefTileHeight(100);
		root.setPrefTileWidth(100);
ImageView[] ary = new ImageView[5];
for(int i = 0; i<5; i++ {
ImageView iv = new ImageView();
iv.setImage(new Image("basic/images/fruit" + (i + 1)
ary[i] = iv;
root.getChildren().add(ary[i]);
}
Scene scene =new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();*/
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		TilePane root = new TilePane();
		root.setPrefTileHeight(100);
		root.setPrefTileWidth(100);
		
		ImageView iv = new ImageView();
		iv.setImage(new Image("/basic/images/fruit1.jpg"));
		ImageView iv2 = new ImageView();
		iv2.setImage(new Image("/basic/images/fruit2.jpg"));
		ImageView iv3 = new ImageView();
		iv3.setImage(new Image("/basic/images/fruit3.jpg"));
		ImageView iv4 = new ImageView();
		iv4.setImage(new Image("/basic/images/fruit4.jpg"));
		ImageView iv5 = new ImageView();
		iv5.setImage(new Image("/basic/images/fruit5.jpg"));
		
		root.getChildren().add(iv);
		root.getChildren().add(iv2);
		root.getChildren().add(iv3);
		root.getChildren().add(iv4);
		root.getChildren().add(iv5);
		
		Scene scene =new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("TilePane 예제");
	}

	public static void main(String[] args) { // 매개값을 넣어서 실행하겠다
		Application.launch(args);
	}
}
