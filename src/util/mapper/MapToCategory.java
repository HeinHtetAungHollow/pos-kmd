package util.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Category;

public class MapToCategory {
	public Category mapCategory(Category category,ResultSet rs) {
		
		try {
			while(rs.next()){
				category.setCategory_name(rs.getString("categoryName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return category;
	}
}
