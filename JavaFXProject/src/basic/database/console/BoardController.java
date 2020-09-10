package basic.database.console;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;
import basic.example2.People;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BoardController implements Initializable {
	@FXML
	TableView<Board> tableView;
	@FXML
	Button btnAdd, btnPlus, btnCancel, btnDelete, btnOrder, btnFormCancel;

	Connection conn = ConnectionDB.getDB();
	ObservableList<Board> list;

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

		listAdd();

		btnPlus.setOnAction(e -> handleBtnPlusAction());

		btnCancel.setOnAction(e -> Platform.exit());
		
		btnDelete.setOnAction(e -> {
			
			String id =tableView.getSelectionModel().getSelectedItem().getId();
			handleBtnDeleteAction(id);
			
		});
		
		
	
	}
	
	
	
	

	public void  handleBtnDeleteAction(String id) {
		
		String sql = "delete from board where id = ?";
		
		
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		listAdd();
	}

	public void listAdd() {
		String sql = "select * from board";
		try {
			list = FXCollections.observableArrayList();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board(rs.getString("PRODUCTNAME"), rs.getString("PRODUCTSIZE"), rs.getInt("PRICE"),rs.getString("ID"));
				list.add(board);
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tableView.setItems(list);
	}

	public void handleBtnAddAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnAdd.getScene().getWindow());
	}
	
	public void handleBtnPlusAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnPlus.getScene().getWindow());

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
				

					String sql = "insert into board values(?,?,?,id.NEXTVAL)";
					try {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, txtProductName.getText());
						pstmt.setString(2, txtProductSize.getText());
						pstmt.setInt(3, Integer.parseInt(txtPrice.getText()));
						
						
						pstmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					stage.close();
					listAdd();

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
	
}
