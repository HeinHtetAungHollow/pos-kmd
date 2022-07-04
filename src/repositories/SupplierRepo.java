package repositories;

import java.util.List;

import models.Supplier;

public interface SupplierRepo {
	void saveSupplier(Supplier supplier);
	
	List<Supplier> loadAllSupplier();
	
	Supplier findById(String id);
	
	void updateSupplier(String id,Supplier supplier);
	
	void deleteSupplier(String id);
}
