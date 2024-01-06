package com.ecom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.ParentProduct;

@Repository
public interface ParentProductRepository extends JpaRepository<ParentProduct, Long> {

}
