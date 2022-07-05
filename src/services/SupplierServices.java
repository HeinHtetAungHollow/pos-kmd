package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db_config.Db_Config;
import models.Supplier;
import repositories.SupplierRepo;
import util.mapper.MapToSupplier;

public class SupplierServices implements SupplierRepo {

	private Db_Config db_Config;
	private MapToSupplier mapToSupplier;

	public SupplierServices() {
		this.db_Config = new Db_Config();
		this.mapToSupplier = new MapToSupplier();
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = this.db_Config.getConnection().prepareStatement(
					"INSERT INTO supplier (sup_name,sup_phone,sup_email,sup_address) values(?,?,?,?)");
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
			} else {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Supplier> loadAllSupplier() {
		// TODO Auto-generated method stub
		List<Supplier> supplierlList = new ArrayList<>();
		try (Statement st = this.db_Config.getConnection().createStatement()) {
			String query = "SELECT * FROM supplier";
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Supplier supplier = new Supplier();
				supplierlList.add(mapToSupplier.mapSupplier(supplier, rs));
			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return supplierlList;
	}

	@Override
	public Supplier findById(String id) {
		// TODO Auto-generated method stub
		Supplier supplier = new Supplier();

		try (Statement st = this.db_Config.getConnection().createStatement()) {
			String query = "SELECT * FROM supplier WHERE sup_id='" + id + "'";
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				supplier = mapToSupplier.mapSupplier(supplier, rs);
			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return supplier;
	}

	@Override
	public void updateSupplier(String id, Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = this.db_Config.getConnection().prepareStatement(
					"UPDATE supplier SET sup_name=?,sup_phone=?,sup_mail=?,sup_address=? WHERE sup_id='" + id + "'");
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
			} else {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteSupplier(String id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("DELETE FROM supplier WHERE sup_id='"+id+"'");
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
