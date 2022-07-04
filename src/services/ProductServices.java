package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db_config.Db_Config;
import models.Product;
import repositories.ProductRepo;
import util.mapper.MapToProduct;

public class ProductServices implements ProductRepo {

	private Db_Config db_Config;
	private MapToProduct mapToProduct;

	public ProductServices() {
		this.db_Config = new Db_Config();
		this.mapToProduct = new MapToProduct();
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = this.db_Config.getConnection().prepareStatement(
					"INSERT INTO product (productName,quantity,price,brand_id,category_id) values (?,?,?,?,?)");
			pst.setString(1, product.getProduct_name());
			pst.setInt(2, product.getQuantity());
			pst.setInt(3, (int) product.getPrice());
			pst.setInt(4, product.getBrand().getBrand_id());
			pst.setInt(5, product.getCategory().getCategory_id());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists!!");
			}
		}
	}

	@Override
	public void updateProduct(String id, Product product) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = this.db_Config.getConnection().prepareStatement(
					"UPDATE product SET productName=?,quantity=?,price=?,brand_id=?,category_id=? WHERE product_id='"
							+ id + "'");
			pst.setString(1, product.getProduct_name());
			pst.setInt(2, product.getQuantity());
			pst.setInt(3, (int) product.getPrice());
			pst.setInt(4, product.getBrand().getBrand_id());
			pst.setInt(5, product.getCategory().getCategory_id());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists!!");
			} else {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Product> findProductByBrandId(String brandId) {
		// TODO Auto-generated method stub
		List<Product> productlList = new ArrayList<>();
		try (Statement st = this.db_Config.getConnection().createStatement()) {
			String query = "SELECT * FROM product INNER JOIN category ON category.category_id=product.category_id"
					+ "INNER JOIN brand ON brand.brand_id=product.brand_id WHERE product.category_id='" + brandId + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Product product = new Product();
				productlList.add(mapToProduct.mapProduct(product, rs));

			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return productlList;
	}

	@Override
	public List<Product> findProductByCategoryId(String categoryId) {
		// TODO Auto-generated method stub
		List<Product> productlList = new ArrayList<>();
		try (Statement st = this.db_Config.getConnection().createStatement()) {
			String query = "SELECT * FROM product INNER JOIN category ON category.category_id=product.category_id"
					+ "INNER JOIN brand ON brand.brand_id=product.brand_id WHERE product.category_id='" + categoryId
					+ "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Product product = new Product();
				productlList.add(mapToProduct.mapProduct(product, rs));

			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return productlList;
	}

	@Override
	public List<Product> loadAllProduct() {
		// TODO Auto-generated method stub
		List<Product> productlList = new ArrayList<>();
		try (Statement st = this.db_Config.getConnection().createStatement()) {
			String query = "SELECT * FROM product INNER JOIN category ON category.category_id=product.category_id"
					+ "INNER JOIN brand ON brand.brand_id=product.brand_id";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Product product = new Product();
				productlList.add(mapToProduct.mapProduct(product, rs));

			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return productlList;
	}

	@Override
	public Product findById(String id) {
		// TODO Auto-generated method stub
		Product product = new Product();
		try (Statement st = this.db_Config.getConnection().createStatement()) {
			String query = "SELECT * FROM product INNER JOIN category ON category.category_id=product.category_id"
					+ "INNER JOIN brand ON brand.brand_id=product.brand_id WHERE product.category_id='" + id + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				product = mapToProduct.mapProduct(product, rs);
			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub

		try {

			PreparedStatement pst = this.db_Config.getConnection()
					.prepareStatement("DELETE FROM product WHERE product_id='" + id + "'");
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
