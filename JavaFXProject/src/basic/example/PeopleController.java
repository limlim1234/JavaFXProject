package basic.example;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;



public class PeopleController implements Initializable {
	@FXML
	BarChart barChart;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Data> list = FXCollections.observableArrayList();
		XYChart.Series<String, Integer> s1 = new XYChart.Series<>();
		s1.setData(getSeries1());
		s1.setName("남자");

		XYChart.Series<String, Integer> s2 = new XYChart.Series<>();
		s2.setData(getSeries2());
		s2.setName("여자");

		barChart.getData().add(s1);
		barChart.getData().add(s2);
		
	}
	
	
	public ObservableList<XYChart.Data<String, Integer>> getSeries1() {
		Connection conn = ConnectionDB.getDB();
		String sql = "select * from student";
		ObservableList<XYChart.Data<String, Integer>> list = FXCollections.observableArrayList();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new XYChart.Data<>(rs.getInt("korean"), rs.getInt("math"), rs.getInt("english");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}

