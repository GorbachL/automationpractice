package models;

public class ItemPrice {

	private String itemPrice;
	private String totalPrice;

	public ItemPrice(String itemPrice, String totalPrice) {
		this.itemPrice = itemPrice;
		this.totalPrice = totalPrice;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

}
