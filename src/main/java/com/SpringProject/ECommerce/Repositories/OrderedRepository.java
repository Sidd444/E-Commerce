package com.SpringProject.ECommerce.Repositories;

import com.SpringProject.ECommerce.Models.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered,Integer> {
}
