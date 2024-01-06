package com.ecom.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.CredentialMaster;

@Repository
public interface CredentialMasterRepository extends JpaRepository<CredentialMaster, Long> {

	Optional<CredentialMaster> findByEmail(String username);

	@Query(value = "select * from credential_master where phone_no=?1 or email=?2",nativeQuery = true)
	List<CredentialMaster> findAllByPhoneNoEmail(String phoneNo, String phoneNo2);

}
