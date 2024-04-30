package com.SpringProject.ECommerce.Repositories;

import com.SpringProject.ECommerce.Models.Product;
import com.SpringProject.ECommerce.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByProductCategory(ProductCategory productCategory);

    @Query(value = "select p from Product p where p.price > :price and p.productCategory=:category")
    List<Product> getProdByCategoryAndPriceGreaterThan(int price, ProductCategory category);
}
