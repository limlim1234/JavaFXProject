package basic.database.console;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;
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

public class BoardOrderController implements Initializable {
	@FXML
	TableView<BoardOrder> tableView1;
	@FXML
	Button btnFormSave, btnFormAaa, btnOrder;

	Connection conn = ConnectionDB.getDB();
	ObservableList<BoardOrder> list;

	Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		TableColumn<BoardOrder, ?> tc = tableView1.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("id"));

		tc = tableView1.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));

		tc = tableView1.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("productname"));

		tc = tableView1.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("address"));

		tc = tableView1.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("price"));

		listAdd1();

		btnFormSave.setOnAction(e -> handleBtnbtnFormSaveAction());

		btnFormAaa.setOnAction(e -> Platform.exit());

	}

	public void listAdd1() {

		String sql = "select * from boardDAO";
		try {
			list = FXCollections.observableArrayList();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardOrder boarddao = new BoardOrder(rs.getString("ID"), rs.getString("NAME"),
						rs.getString("PRODUCTNAME"), rs.getString("ADDRESS"), rs.getInt("PRICE"));
				list.add(boarddao);
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tableView1.setItems(list);
	}

	public void handleBtnOrderAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnOrder.getScene().getWindow());
	}

	public void handleBtnbtnFormSaveAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnFormSave.getScene().getWindow());

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddForm.fxml"));

			Scene scene = new Scene(parent);
			stage.setTitle("주문창");
			stage.setScene(scene);
			stage.show();

			Button btnFormSave = (Button) parent.lookup("#btnFormSave");
			btnFormSave.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					TextField txtName = (TextField) parent.lookup("#txtName");
					TextField txtProductName = (TextField) parent.lookup("#txtProductName");
					TextField txtAddress = (TextField) parent.lookup("#txtAddress");
					TextField txtPrice = (TextField) parent.lookup("#txtPrice");

					String sql = "insert into board values(id.NEXTVAL?,?,?)";
					try {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, txtName.getText());
						pstmt.setString(2, txtProductName.getText());
						pstmt.setString(2, txtAddress.getText());
						pstmt.setInt(4, Integer.parseInt(txtPrice.getText()));

						pstmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					stage.close();
					listAdd1();
				}

			});
			Button btnFormAaa = (Button) parent.lookup("#btnForAaa");
			btnFormAaa.setOnAction(e -> {
				TextField txtName = (TextField) parent.lookup("#txtName");
				TextField txtProductName = (TextField) parent.lookup("#txtProductName");
				TextField txtAddress = (TextField) parent.lookup("#txtAddress");
				TextField txtPrice = (TextField) parent.lookup("#txtPrice");

				txtName.clear();
				txtProductName.clear();
				txtAddress.clear();
				txtPrice.clear();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		stage.close();
		listAdd1();
	}
}
