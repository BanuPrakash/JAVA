package com.adobe.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adobe.prj.entity.Product;

public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public void addProduct(Product p) throws DaoException {
		String SQL = "INSERT INTO products (id, name, price, quantity) VALUES (0, ?, ?, ?)";
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DaoException("unable to add product", e);
		} finally {
			DBUtil.closeConnection(con);
		}
	}

	@Override
	public List<Product> getProducts() throws DaoException {
		String SQL = "SELECT id, names, price, quantity FROM products";
		List<Product> products = new ArrayList<>();
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				products.add(new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getDouble("price"),
						rs.getInt("quantity")
					));
			}
			
		} catch (SQLException e) {
			throw new DaoException("unable to get products", e);
		} finally {
			DBUtil.closeConnection(con);
		}
		return products;
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		return null;
	}

	@Override
	public void updateProduct(Product p) throws DaoException {
		
	}

}
