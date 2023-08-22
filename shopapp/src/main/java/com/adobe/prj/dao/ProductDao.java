package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adobe.prj.entity.Product;

// Product refers to which entity it needs CRUD, Integer --> type of primary integer
public interface ProductDao extends JpaRepository<Product, Integer> {
	// select * from products where quantity = ?
	List<Product> findByQuantity(int qty);
	
	// get products by price range
	// @Query("select * from products  where price >= :l and price <= :h", nativeQuery=true)
	@Query("from Product where price >= :l and price <= :h")
	List<Product> getByRange(@Param("l") double low, @Param("h") double high);
	
	
	// other than select sql we need @Modifying ==> executeUpdate() instead of executeQuery()
	@Modifying
	@Query("update Product set price = :pr where id = :id")
	void updateProductPrice(@Param("id") int id, @Param("pr") double price);
}
