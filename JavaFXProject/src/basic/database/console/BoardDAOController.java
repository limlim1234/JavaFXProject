package basic.database.console;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class BoardDAOController implements Initializable {
	@FXML
	TableView<BoardDAOController> tableView;
	
	Connection conn = ConnectionDB.getDB();
	ObservableList<BoardDAOController> list;
	
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
