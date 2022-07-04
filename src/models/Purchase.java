package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Purchase {
	private int purchase_id;
	private LocalDateTime purchaseDateTime;
	private String description;
	private Employee employee;
	private Supplier supplier;
	private List<PurchaseDetail> purchaseList=new ArrayList<>();
	

	public Purchase() {
		
	}
	
	public Purchase(int purchase_id, LocalDateTime purchaseDateTime, String description, Employee employee,
			Supplier supplier,List<PurchaseDetail> purchaseList) {
		super();
		this.purchase_id = purchase_id;
		this.purchaseDateTime = purchaseDateTime;
		this.description = description;
		this.employee = employee;
		this.supplier = supplier;
		this.purchaseList=purchaseList;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public LocalDateTime getPurchaseDateTime() {
		return purchaseDateTime;
	}

	public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public List<PurchaseDetail> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<PurchaseDetail> purchaseList) {
		this.purchaseList = purchaseList;
	}

}
