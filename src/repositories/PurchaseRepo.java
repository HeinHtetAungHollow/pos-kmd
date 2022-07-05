package repositories;

import java.util.List;

import models.Purchase;
import models.PurchaseDetail;

public interface PurchaseRepo {
	void savePurchase(Purchase purchase);
	
	void createPurchaseDetail(List<PurchaseDetail> purchaseDetails);
	
	Purchase findPurchaseById(String id);
	
	List<Purchase> findAllPurchase();
	
	List<Purchase> findPurchaseBySupplierId(String supId);
	
	List<Purchase> findPurchaseByEmployeeId(String empId);
	
	List<PurchaseDetail> findPurchaseDetailByPurchaseId(String purId);
}
