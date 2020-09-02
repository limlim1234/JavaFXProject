package basic.control;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InputController implements Initializable {
	@FXML
	TextField txtTitle;
	@FXML
	PasswordField txtPassword;
	@FXML
	ComboBox<String> comboPublic;
	@FXML
	DatePicker dateExit;
	@FXML
	TextArea txtContent;
	@FXML
	Button btnReg;
	@FXML
	Button btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		txtTitle.setText("안녕하세요");
//		comboPublic.setValue("공개");;
		// 팝업창 띄우기
		btnReg.setOnAction((ae) -> handleBtnRegAction());
	}

	public void handleBtnRegAction() {
		if (txtTitle.getText() == null || txtTitle.getText().equals("")) {
			showPopup("타이틀을 입력하세요");
		} else if (txtPassword.getText() == null || txtPassword.getText().equals("")) {
			showPopup("비밀번호르 입력하세요");
		} else if (comboPublic.getValue() == null || comboPublic.getValue().equals("")) {
			showPopup("공개여부를 지정하세요");
		} else if (dateExit.getValue() == null) {
			showCustomDialog("날짜를 입력하세요");
		} else {
			insetData();
		}

		// popup 타이틀등록
		/*
		 * HBox hbox = new HBox();
		 * 
		 * hbox.setStyle("-fx-background-color: black; -fx-background-radius: 20;");
		 * hbox.setAlignment(Pos.CENTER); ImageView iv = new ImageView();
		 * iv.setImage(new Image("basic/images/dialog-info.png"));
		 * 
		 * Label label = new Label(); label.setText("타이틀을 등록하세요!");
		 * label.setStyle("-fx-text-fill: yellow; ");
		 * 
		 * hbox.getChildren().addAll(iv, label);
		 * 
		 * Popup pop = new Popup(); pop.getContent().add(hbox); pop.setAutoHide(true);
		 * pop.show(btnReg.getScene().getWindow()); }
		 */

	}

	public void insetData() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr", passwd = "hr";
		Connection conn = null; // 데이터베이스 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // 예외처리
		}
		// 쿼리
		String sql = "insert into new_board values(?, ?, ?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, txtTitle.getText());
			pstmt.setNString(2, txtPassword.getText());
			pstmt.setNString(3, comboPublic.getValue());
			pstmt.setNString(4, dateExit.getValue().toString());
			pstmt.setNString(5, txtContent.getText());

			int r = pstmt.executeUpdate();
			System.out.println(r + " 건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}

	}

	public void showCustomDialog(String msg) {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnReg.getScene().getWindow());

		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(400, 150);

		ImageView iv = new ImageView();
		iv.setImage(new Image("basic/images/dialog-info.png"));
		iv.setFitWidth(50);
		iv.setFitHeight(50);
		iv.setLayoutX(15);
		iv.setLayoutY(15);
		iv.setPreserveRatio(true);

		Button btnOk = new Button("확인");
		btnOk.setLayoutX(336);
		btnOk.setLayoutY(104);
		btnOk.setOnAction((e) -> stage.close());

		Label label = new Label(msg);
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefSize(290, 15);

		ap.getChildren().addAll(iv, btnOk, label);

		Scene scene = new Scene(ap);
		stage.setScene(scene);
		stage.show();

	}

	public void showPopup(String msg) {
		HBox hbox = new HBox();

		hbox.setStyle("-fx-background-color: black; -fx-background-radius: 20;");
		hbox.setAlignment(Pos.CENTER);
		ImageView iv = new ImageView();
		iv.setImage(new Image("basic/images/dialog-info.png"));

		Label label = new Label();
		label.setText("타이틀을 등록하세요!");
		label.setStyle("-fx-text-fill: yellow; ");

		hbox.getChildren().addAll(iv, label);

		Popup pop = new Popup();
		pop.getContent().add(hbox);
		pop.setAutoHide(true);
		pop.show(btnReg.getScene().getWindow());
	}

}
