package basic.cotainer.eventhandle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class RootController implements Initializable {
@FXML Label label; //text이름
@FXML Slider slider;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override          //인터페이스
			public void changed(ObservableValue<? extends Number> observable, Number starValue, Number endValue) {
	System.out.println("startValue: " + starValue.doubleValue());
	System.out.println("endtValue: " + endValue.doubleValue());
				//슬라이드가 움직일때마다 라벨	
				label.setFont(new Font(endValue.doubleValue()));
				
			}
			
		}); //값이 바뀔때마다 어떤 처리를 해주세요가 에드리스너
		
	}



}
