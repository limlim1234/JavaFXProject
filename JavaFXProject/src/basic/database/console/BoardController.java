package basic.database.console;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BoardController implements Initializable {
	@FXML
	TableView<Board> tableView;

	ObservableList<Board> list;
	Connection conn = ConnectionDB.getDB();

	Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TableColumn<Board, ?> tc = tableView.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("productname"));

		tc = tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("size"));

		tc = tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("price"));

		listAdd();
	}

	public ObservableList<Board> getBoardList() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr", passwd = "hr";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch  (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "select * from board";
		ObservableList<Board> list = FXCollections.observableArrayList();
		try { 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getString("productname"),
						rs.getString("productsize"),
						rs.getInt("price"));
						
				list.add(board);
			}
	
		}
	}
	private ObservableList<Board> listAdd()  {
			String sql = "select * from board";
			ObservableList<Board> list = FXCollections.observableArrayList();
			try {
				PreparedStatement pstmt =conn.prepareStatement(sql);
				 ResultSet rs = pstmt.executeQuery();
				 while(rs.next()) {
					 Board board = new Board(rs.getString("PRODUCTNAME"), rs.getString("SIZE"),
		                     rs.getInt("PRICE"));
					 list.add(board);
				 } 
			} catch (SQLException e) {
					 e.printStackTrace();
				 } 
				 return list;
			
		} 
	}
