package com.ecom.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.app.enums.OrderStatus;
import com.ecom.app.model.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

	@Query(value = "select * from order_details where user_id=?1", nativeQuery = true)
	List<OrderDetails> findAllByUserId(Long userId);

	@Query(value = "select o.* from order_details o join product p on p.id=o.product_id join user_data u on u.id=o.user_id join user_address_map uam on uam.id=o.address_id where o.id=?1", nativeQuery = true)
	OrderDetails getById(Long id);

	@Modifying
	@Query(value="UPDATE order_details SET order_status = ?2, cancelled_on = ?3 WHERE (id = ?1)",nativeQuery = true)
	void updateStatus(Long orderId, Integer orderStatus,Date cancelDate);

}
