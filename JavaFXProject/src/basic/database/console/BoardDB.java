package basic.database.console;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import basic.common.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDB {
	Connection conn;

	public ObservableList<Board> listAdd() {
		conn = ConnectionDB.getDB();
		String sql = "select * from board";
		ObservableList<Board> bList = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board(rs.getString("PRODUCTNAME"), rs.getString("PRODUCTSIZE"), rs.getInt("PRICE"),
						rs.getString("ID"));
				bList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}

	public void deleteBoard(String id) {
		conn = ConnectionDB.getDB();
		String sql = "delete from board where id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertBoard(Board board) {
		String sql = "insert into board values(?,?,?,id.NEXTVAL)";
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

	////////////////////////////////////////////

	public ObservableList<BoardOrder> getBoardOrderList() {
		conn = ConnectionDB.getDB();
		String sql = "select * from board_order";
		ObservableList<BoardOrder> bList = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardOrder board = new BoardOrder(rs.getString("id"), rs.getString("name"), rs.getString("product_name"),
						rs.getString("address"), rs.getInt("price"));
				bList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}
}
