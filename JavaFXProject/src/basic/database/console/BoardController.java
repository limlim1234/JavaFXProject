package basic.database.console;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;
import basic.example2.People;
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
	String sql = "";
	 Connection conn = ConnectionDB.getDB();
	  public ObservableList<Board> getBoard() {
		  sql = "select * from board";
		  ObservableList<Board> list = FXCollections.observableArrayList();
		  try {
			  PreparedStatement pstmt = conn.prepareStatement(sql);
			   ResultSet rs = pstmt.executeQuery();
			   while(rs.next()) {
				   Board board = new Board(rs.getString("productname"),
			                  rs.getString("productsize"),
			                  rs.getInt("price"));
			            list.add(board);
			   }
		  } catch (SQLException e) {
			   e.printStackTrace();
		  }
		  return list;
	  }
	  public void insertBoard(Board board) {
		  sql = "insert into board values(?, ?, ?)" ;
		  try {
			  PreparedStatement pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, board.getProductName());
		         pstmt.setString(2, board.getProductSize());
		         pstmt.setInt(3, board.getPrice());
		       
		         pstmt.executeUpdate();
		  } catch (SQLException e) {
			  e.printStackTrace();
		  }
	  }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

	public void setPrimaryStage(Stage primaryStage) {
	
		
	}

	

}