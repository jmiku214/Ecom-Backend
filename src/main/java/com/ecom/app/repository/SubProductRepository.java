package com.ecom.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.SubProduct;

@Repository
public interface SubProductRepository extends JpaRepository<SubProduct, Long> {

	@Query(value = "select * from sub_product where sub_product_name=?1 and parent_product_id=?2", nativeQuery = true)
	List<SubProduct> findBySubProductName(String subProductName, Long parent_product_id);

	@Query(value = "select * from sub_product where parent_product_id=?1", nativeQuery = true)
	List<SubProduct> findByParentProductId(Long parentProductId);

}
