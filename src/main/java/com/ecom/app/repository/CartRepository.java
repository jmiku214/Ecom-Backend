package com.ecom.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value = "select * from cart where user_id=?1", nativeQuery = true)
	List<Cart> findByUserId(Long id);

	@Query(value = "select * from cart where user_id=?1 and product_id=?2", nativeQuery = true)
	Cart findByUserIdAndProductId(Long userId, Long productId);

}
