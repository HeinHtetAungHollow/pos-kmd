package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db_config.Db_Config;
import models.Brand;
import repositories.BrandRepo;
import util.mapper.MapToBrand;

public class BrandServices implements BrandRepo {

	private Db_Config db_Config;
	private MapToBrand mapToBrand;

	public BrandServices() {
		this.db_Config = new Db_Config();
		this.mapToBrand = new MapToBrand();
	}

	@Override
	public void saveBrand(Brand brand) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("INSERT INTO brand(brandName) values (?)");
			pst.setString(1, brand.getBrand_name());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists!");
			}
		}
	}

	@Override
	public void updateBrand(String id, Brand brand) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("UPDATE brand SET brandName=? WHERE brand_id=?");
			pst.setString(1, brand.getBrand_name());
			pst.setString(2, id);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already exists");
			}
		}
		
	}

	@Override
	public List<Brand> loadAllBrand() {
		// TODO Auto-generated method stub
		List<Brand> brandList = new ArrayList<>();
		try (Statement st = this.db_Config.getConnection().createStatement()) {
			String query = "SELECT * FROM brand";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Brand brand = new Brand();
				brandList.add(this.mapToBrand.mapBrand(brand, rs));
			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return brandList;
	}

	@Override
	public Brand findById(String id) {
		// TODO Auto-generated method stub
		Brand brand=new Brand();
		try (Statement st=this.db_Config.getConnection().createStatement()){
			String query="SELECT * FROM brand WHERE brand_id='"+id+"'";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				
				brand=this.mapToBrand.mapBrand(brand, rs);
			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return brand;
	}

	@Override
	public void deleteBrand(String id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("DELETE FROM brand WHERE brand_id='"+id+"'");
			
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
