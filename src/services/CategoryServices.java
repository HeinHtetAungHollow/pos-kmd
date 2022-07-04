package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db_config.Db_Config;
import models.Category;
import repositories.CategoryRepo;
import util.mapper.MapToCategory;


public class CategoryServices implements CategoryRepo{

	private Db_Config db_Config;
	private MapToCategory mapToCategory;
	public CategoryServices() {
		this.db_Config=new Db_Config();
		this.mapToCategory=new MapToCategory();
	}
	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("INSERT INTO category(categoryName) values (?)");
			pst.setString(1, category.getCategory_name());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists!");
			}
		}
	}

	@Override
	public void updateCategory(String id, Category category) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("UPDATE category SET categoryName=? WHERE category_id='"+id+"'");
			pst.setString(1, category.getCategory_name());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists!");
			}
		}
	}

	@Override
	public List<Category> loadAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categoryList=new ArrayList<>();
		try(Statement st=this.db_Config.getConnection().createStatement()) {
			String query="SELECT * FROM category";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				Category category=new Category();
				categoryList.add(mapToCategory.mapCategory(category, rs));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return categoryList;
	}

	@Override
	public Category findById(String id) {
		// TODO Auto-generated method stub
		Category category=new Category();
		try (Statement st=this.db_Config.getConnection().createStatement()){
			String query="SELECT * FROM category WHERE category_id='"+id+"'";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				category=mapToCategory.mapCategory(category, rs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public void deleteCategory(String id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("DELETE FROM category WHERE category_id='"+id+"'");
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
