package models;

public class PurchaseDetail {
	private int purchaseDt_id;
	private Product product;
	private int quantity;
	private long price;
	private Purchase purchase;
	
	public PurchaseDetail() {
		
	}
	
	public PurchaseDetail(int purchaseDt_id, Product product, int quantity, long price, Purchase purchase) {
		super();
		this.purchaseDt_id = purchaseDt_id;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.purchase = purchase;
	}
	public int getPurchaseDt_id() {
		return purchaseDt_id;
	}
	public void setPurchaseDt_id(int purchaseDt_id) {
		this.purchaseDt_id = purchaseDt_id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	
}
