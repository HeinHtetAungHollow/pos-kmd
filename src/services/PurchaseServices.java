package services;

import java.util.List;

import models.Purchase;
import models.PurchaseDetail;
import repositories.PurchaseRepo;

public class PurchaseServices implements PurchaseRepo{

	@Override
	public void savePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPurchaseDetail(List<PurchaseDetail> purchaseDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Purchase findPurchaseById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> findAllPurchase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> findPurchaseBySupplierId(String supId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> findPurchaseByEmployeeId(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PurchaseDetail> findPurchaseDetailByPurchaseId(String purId) {
		// TODO Auto-generated method stub
		return null;
	}

}
