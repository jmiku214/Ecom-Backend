package com.ecom.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	@Query(value = "SELECT * FROM city  where state_id=?1",nativeQuery = true)
	List<City> findByStateId(Long stateId);

}
