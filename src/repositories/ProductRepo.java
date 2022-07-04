package repositories;

import java.util.List;

import models.Product;

public interface ProductRepo {
	void saveProduct(Product product);
	
	void updateProduct(String id,Product product);
	
	List<Product> findProductByBrandId(String brandId);
	
	List<Product> findProductByCategoryId(String categoryId);
	
	List<Product> loadAllProduct();
	
	Product findById(String id);
	
	void deleteProduct(String id);
}
