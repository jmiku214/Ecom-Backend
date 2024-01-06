package com.ecom.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ecom.app.model.EmailOtp;

@Service
public interface EmailOtpRepository extends JpaRepository<EmailOtp, Long>{

	Optional<EmailOtp> findByEmail(String email);

}
