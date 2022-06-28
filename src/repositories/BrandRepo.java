package repositories;

import java.util.List;

import models.Brand;

public interface BrandRepo {
	void saveBrand(Brand brand);
	
	void updateBrand(String id,Brand brand);
	
	List<Brand> loadAllBrand();
	
	Brand findById(String id);
	
	void deleteBrand(String id);
}
