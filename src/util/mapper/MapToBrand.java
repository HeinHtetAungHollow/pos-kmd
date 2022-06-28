package util.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Brand;

public class MapToBrand {
	public Brand mapBrand(Brand brand,ResultSet rs) {
		
		try {
			while(rs.next()) {
				brand.setBrand_id(rs.getInt("brand_id"));
				brand.setBrand_name(rs.getString("brandName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return brand;
	}
}
