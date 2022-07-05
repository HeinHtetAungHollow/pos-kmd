package util.mapper;

import java.sql.ResultSet;

import models.Supplier;

public class MapToSupplier {
	public Supplier mapSupplier(Supplier supplier,ResultSet rs) {
		
		try {
			supplier.setSupplier_id(rs.getInt("sup_id"));
			supplier.setSupplier_name(rs.getString("sup_name"));
			supplier.setSupplier_phone(rs.getString("sup_phone"));
			supplier.setSupplier_email(rs.getString("sup_mail"));
			supplier.setSupplier_address(rs.getString("sup_address"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return supplier;
	}
}
