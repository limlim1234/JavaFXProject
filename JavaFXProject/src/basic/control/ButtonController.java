package basic.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;

public class ButtonController implements Initializable {
@FXML private CheckBox chk1;
@FXML private CheckBox chk2;
@FXML private CheckBox ImageView checkImageView;
@FXML private CheckBox ToggleGroup group;
@FXML private CheckBox ImageView radioImageView;
@FXML private CheckBox Button btnExit;



	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> obsevable, Toggle oldValue, Toggle newValue) {
				String imange = new Image(getClass().getResource("images/") + newValue.getUserData().toString() 
						+ ".png").toString());
		radioImageView.setImage(image);
				
			}
			
		});
		
		
	}
	public void handleChkAction(ActionEvent e) {
		if(chk1.isSelected() && chk2.isSelected()) {
			checkImageView.setImage(new Imange(
					getClass().getResource("/basic/images/fruit1.jpg").toString());
		} else if(chk1.isSelected()) {
			checkImageView.setImage(new Image(
					getClass().getResource("/basic/images/fruit2.jpg").toString());
		} else (chk2.isSelected()) {
			checkImageView.setImage(new Image(
					getClass().getResource("/basic/images/fruit3.jpg").toString());
		} 
	}
		public void handleBtnExitAction(ActionEvent e) {
			Platform.exit();
		}
			}


