package util.mapper;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.Employee;
import models.Purchase;
import models.PurchaseDetail;
import repositories.ProductRepo;
import repositories.PurchaseRepo;

public class MapToPurchase {
	private ProductRepo productRepo;
	
	private PurchaseRepo purchaseRepo;
	
	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo=productRepo;
	}
	
	public void setPurchaseRepo(PurchaseRepo purchaseRepo) {
		this.purchaseRepo=purchaseRepo;
	}
	
	public Purchase mapPurchase(Purchase purchase,ResultSet rs) {
		try {
			purchase.setPurchase_id(rs.getInt("purchase_id"));
			purchase.setPurchaseDateTime(LocalDateTime.parse(rs.getString("purchaseDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
			purchase.setDescription(rs.getString("description"));
			Employee employee=new Employee();
			employee.setEmp_id(rs.getInt("employee_id"))
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return purchase;
	}
	
    public PurchaseDetail mapToPurchaseDetails(PurchaseDetail purchaseDetails, ResultSet rs) {
        try {
            purchaseDetails.setPurchaseDt_id(rs.getInt("pd_id"));
            purchaseDetails.setQuantity(rs.getInt("quantity"));
            purchaseDetails.setPrice(rs.getInt("price"));
            purchaseDetails.setProduct(
                    this.productRepo.findById(String.valueOf(rs.getInt("product_id")))
            );
            purchaseDetails.setPurchase(
                    this.purchaseRepo.findPurchaseById(String.valueOf(rs.getInt("purchase_id")))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return purchaseDetails;
    }
}
