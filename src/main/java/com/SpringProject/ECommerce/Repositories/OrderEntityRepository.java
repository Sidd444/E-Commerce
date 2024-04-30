package com.SpringProject.ECommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringProject.ECommerce.Models.OrderEntity;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity,Integer> {
}
