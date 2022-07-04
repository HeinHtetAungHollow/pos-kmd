package util.mapper;

import java.sql.ResultSet;

import models.Brand;
import models.Category;
import models.Product;

public class MapToProduct {
	public Product mapProduct(Product product,ResultSet rs) {
		try {
			while(rs.next()) {
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("productName"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice((long)rs.getInt("price"));
				Brand brand=new Brand();
				brand.setBrand_id(rs.getInt("brand_id"));
				brand.setBrand_name(rs.getString("brandName"));
				Category category=new Category();
				category.setCategory_id(rs.getInt("category_id"));
				category.setCategory_name(rs.getString("category_name"));
				product.setBrand(brand);
				product.setCategory(category);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return product;
	}
}
