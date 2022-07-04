package repositories;

import java.util.List;

import models.Category;

public interface CategoryRepo {
	void saveCategory(Category category);
	
	void updateCategory(String id,Category category);
	
	List<Category> loadAllCategory();
	
	Category findById(String id);
	
	void deleteCategory(String id);
}
