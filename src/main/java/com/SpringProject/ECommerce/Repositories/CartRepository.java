package com.SpringProject.ECommerce.Repositories;

import com.SpringProject.ECommerce.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

}
