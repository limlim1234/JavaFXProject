package basic.database.console;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BoardOrder {
	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty productname;
	private SimpleStringProperty address;
	private SimpleIntegerProperty price;

	public BoardOrder(String name, String productname, String address, int price) {
		this.name = new SimpleStringProperty(name);
		this.productname = new SimpleStringProperty(productname);
		this.price = new SimpleIntegerProperty(price);
		this.address = new SimpleStringProperty(address);
	}

	public BoardOrder(String id, String name, String productName, String address, int price) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.productname = new SimpleStringProperty(productName);
		this.address = new SimpleStringProperty(address);
		this.price = new SimpleIntegerProperty(price);
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

	public String getProductName() {
		return this.productname.get();
	}

	public void setProductName(String productname) {
		this.productname.set(productname);
	}

	public SimpleStringProperty productnameProperty() {
		return this.productname;
	}

	public String getAddress() {
		return this.address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	public SimpleStringProperty addressProperty() {
		return this.address;
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

}
