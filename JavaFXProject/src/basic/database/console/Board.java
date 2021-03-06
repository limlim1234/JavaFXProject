package basic.database.console;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Board {
	private SimpleStringProperty id;
	private SimpleStringProperty productname;
	private SimpleStringProperty productsize;
	private SimpleIntegerProperty price;

	public Board(String productname, String productsize, int price) {
		this.productname = new SimpleStringProperty(productname);
		this.productsize = new SimpleStringProperty(productsize);
		this.price = new SimpleIntegerProperty(price);

	}
	public Board(String productname, String productsize, int price, String id ) {
		this.productname = new SimpleStringProperty(productname);
		this.productsize = new SimpleStringProperty(productsize);
		this.price = new SimpleIntegerProperty(price);
		this.id = new SimpleStringProperty(id);

	}

	
	public String getProductName() {
		return this.productname.get();
	}

	public void setProductName(String productname) {
		this.productname.set(productname);
	}
	public SimpleStringProperty productnameProperty() {
		return this.productname;
	}
	
	
	
	public String getProductSize() {
		return this.productsize.get();
	}

	public void setProductSize(String productsize) {
		this.productsize.set(productsize);
	}
	
	public SimpleStringProperty productsizeProperty() {
		return this.productsize;
	}
	
	
	public int getPrice() {
		return this.price.get();
	}

	public void setPrice(int price) {
		this.price.set(price);
	}
	
	public SimpleIntegerProperty priceProperty() {
		return this.price;
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

	
}
