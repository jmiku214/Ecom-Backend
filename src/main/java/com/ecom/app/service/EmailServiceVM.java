package com.ecom.app.service;

public interface EmailServiceVM {

	void sendNewWelcomeLetter(String subject, String email, String defaultPass, String name);

	void sendOtp(String subject, String email, String otp);

	void sendInvoice(String subject, String email, String pdfPath);
}
