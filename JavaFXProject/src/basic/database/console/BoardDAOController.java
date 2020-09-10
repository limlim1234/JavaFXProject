package basic.database.console;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BoardDAOController implements Initializable {
	@FXML
	TableView<BoardDAO> tableView;
	
	Connection conn = ConnectionDB.getDB();
	ObservableList<BoardDAO> list;
	
	Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TableColumn<BoardDAO, ?> tc = tableView.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		tc = tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		tc = tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("productname"));
		
		tc = tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("address"));
		
		tc = tableView.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("price"));

		
		listAdd();
	}

	public void listAdd() {
		
		
	}
}
