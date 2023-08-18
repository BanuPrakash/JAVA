package com.adobe.prj.client;

import java.util.List;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class FetchClient {

	public static void main(String[] args) {

		ProductDao productDao = new ProductDaoJdbcImpl(); // use factory instead
		
		try {
			List<Product> products = productDao.getProducts();
			for(Product p : products) {
				System.out.println(p);
			}
		} catch (DaoException e) {
			e.printStackTrace(); // in development mode --> Why, What, Where
			//System.out.println(e.getMessage()); // in production mode
		}
	}

}
