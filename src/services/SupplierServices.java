package services;

import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.swing.JOptionPane;

import db_config.Db_Config;
import models.Supplier;
import repositories.SupplierRepo;

public class SupplierServices implements SupplierRepo{
	
	private Db_Config db_Config;
	
	public SupplierServices() {
		this.db_Config=new Db_Config();
	}
	@Override
	public void saveSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("INSERT INTO supplier (sup_name,sup_phone,sup_email,sup_address) values(?,?,?,?)");
			pst.setString(1, supplier.getSupplier_name());
			pst.setString(2, supplier.getSupplier_phone());
			pst.setString(3, supplier.getSupplier_email());
			pst.setString(4, supplier.getSupplier_address());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists!");
			}else {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Supplier> loadAllSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSupplier(String id, Supplier supplier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSupplier(String id) {
		// TODO Auto-generated method stub
		
	}

}
