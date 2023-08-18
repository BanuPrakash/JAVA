package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Product;

public interface ProductDao {
	void addProduct(Product p) throws DaoException;
	List<Product> getProducts() throws DaoException;
	Product getProduct(int id) throws DaoException;
	void updateProduct(Product p) throws DaoException;
}
