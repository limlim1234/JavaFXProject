package basic.example2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class People {
		private SimpleStringProperty id;
		private SimpleStringProperty name;  
		private SimpleIntegerProperty korean;
		private SimpleIntegerProperty math;
		private SimpleIntegerProperty english;
		
		public People(String id, String name, int korean, int math, int english) {
			this.id = new SimpleStringProperty(id);
			this.name = new SimpleStringProperty(name);
			this.korean = new SimpleIntegerProperty(korean);
			this.math = new SimpleIntegerProperty(math);
			this.english = new SimpleIntegerProperty(english);
			
		}
		
		
		public String getId() {
			return this.id.get();
		}
		public void setId(String id) {
			this.id.set(id);
		}
		public SimpleStringProperty idProperty() {
			return this.id;
		}
		public String getName() {
			return this.name.get();
		}
		public void setName(String name) {
			this.name.set(name);
		}
		public SimpleStringProperty nameProperty() {
			return this.name;
		}
		
		public int getKorean() {
			return this.korean.get();
		}
		public void setKorean(int korean) {
			this.korean.set(korean);
		}
		public SimpleIntegerProperty koreanProperty() {
			return this.korean;
		}
		
		public int getMath() {
			return this.math.get();
		}
		public void setMath(int math) {
			this.math.set(math);
		}
		public SimpleIntegerProperty mathProperty() {
			return this.math;
		}
		
		public int getEnglish() {
			return this.math.get();
		}
		public void setEnglish(int english) {
			this.english.set(english);
		}
		public SimpleIntegerProperty englishProperty() {
			return this.english;
		}
	
	}


