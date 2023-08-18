package com.adobe.prj.client;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class InsertClient {

	public static void main(String[] args) {
		Product p = Product.builder()
				.name("LG AC")
				.price(45000.00)
				.quantity(100)
				.build();
		
		ProductDao productDao = new ProductDaoJdbcImpl(); // use factory instead
		
		try {
			productDao.addProduct(p);
			System.out.println("Product added!!!");
		} catch (DaoException e) {
			e.printStackTrace(); // in development mode --> Why, What, Where
			// System.out.println(e.getMessage()); // in production mode
		}
		
	}

}
