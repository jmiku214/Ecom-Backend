package com.ecom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
