package basic.database.console;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BoardController implements Initializable {
	@FXML
	TableView<Board> tableView;
	@FXML
	Button btnPlus, btnDelete, btnOrder, btnCancel;

	BoardDB db = new BoardDB();

	ObservableList<Board> list = FXCollections.observableArrayList();

	Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Board, ?> tc = tableView.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("productname"));

		tc = tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("productsize"));

		tc = tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("price"));
		list = db.listAdd();
		tableView.setItems(list);

		btnPlus.setOnAction(e -> handleBtnPlusAction());

		btnCancel.setOnAction(e -> Platform.exit());

		btnOrder.setOnAction(e -> handleBtnOrderAction());

		btnDelete.setOnAction(e -> {

			String id = tableView.getSelectionModel().getSelectedItem().getId();
			handleBtnDeleteAction(id);

		});

	}

	public void handleBtnDeleteAction(String id) {

		db.deleteBoard(id);

		tableView.setItems(db.listAdd());
	}

//	public void handleBtnAddAction() {
//		Stage stage = new Stage(StageStyle.UTILITY);
//		stage.initModality(Modality.WINDOW_MODAL);
//		stage.initOwner(btnAdd.getScene().getWindow());
//	}

	public void handleBtnPlusAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
//		stage.initOwner(btnPlus.getScene().getWindow());
		stage.initOwner(primaryStage);

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddForm2.fxml"));

			Scene scene = new Scene(parent);
			stage.setTitle("상품추가");
			stage.setScene(scene);
			stage.show();

			Button btnFormPlus = (Button) parent.lookup("#btnFormPlus");
			btnFormPlus.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println(">>>");
					TextField txtProductName = (TextField) parent.lookup("#txtProductName");
					TextField txtProductSize = (TextField) parent.lookup("#txtProductSize");
					TextField txtPrice = (TextField) parent.lookup("#txtPrice");

					Board board = new Board(txtProductName.getText(), txtProductSize.getText(),
							Integer.parseInt(txtPrice.getText()));
					db.insertBoard(board);
					stage.close();

					tableView.setItems(db.listAdd());

				}

			});
			Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(e -> {
				TextField txtProductName = (TextField) parent.lookup("#txtProductName");
				TextField txtProductSize = (TextField) parent.lookup("#txtProductSize");
				TextField txtPrice = (TextField) parent.lookup("#txtPrice");

				txtProductName.clear();
				txtProductSize.clear();
				txtPrice.clear();

			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void handleBtnOrderAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
//		stage.initOwner(btnOrder.getScene().getWindow());
		stage.initOwner(primaryStage);

		try {
			System.out.println("-----------");
			Parent parent = FXMLLoader.load(getClass().getResource("Root2.fxml"));
			Scene scene = new Scene(parent);
			stage.setTitle("주문창");
			stage.setScene(scene);
			stage.show();

			// Root2.fxml 컨트롤을 가져오려면...lookup()
			TableView<BoardOrder> tList = (TableView<BoardOrder>) parent.lookup("#tableView");
			TableColumn<BoardOrder, String> tcol = (TableColumn<BoardOrder, String>) tList.getColumns().get(0);
			tcol.setCellValueFactory(new PropertyValueFactory("id"));
			tcol = (TableColumn<BoardOrder, String>) tList.getColumns().get(1);
			tcol.setCellValueFactory(new PropertyValueFactory("name"));
			tcol = (TableColumn<BoardOrder, String>) tList.getColumns().get(2);
			tcol.setCellValueFactory(new PropertyValueFactory("productname"));
			tcol = (TableColumn<BoardOrder, String>) tList.getColumns().get(3);
			tcol.setCellValueFactory(new PropertyValueFactory("address"));
			tcol = (TableColumn<BoardOrder, String>) tList.getColumns().get(4);
			tcol.setCellValueFactory(new PropertyValueFactory("price"));

			tList.setItems(db.getBoardOrderList());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
