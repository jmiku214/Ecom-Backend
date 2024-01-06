package com.ecom.app.serviceImpl;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ecom.app.service.EmailServiceVM;

@Service
public class EmailServiceVMImpl implements EmailServiceVM {

	@Autowired
	private JavaMailSender javaMailService;

//	@Value("${user.web.path}")
//	private String webPath;

	@Override
	public void sendNewWelcomeLetter(String subject, String email, String defaultPass, String name) {
		try {
			MimeMessage mailMessage = javaMailService.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
//            
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText("Here Is Your LoginDetails.." + " \n\nUsername: " + email + " \n\nPassword: " + defaultPass
					+ " \n\nThanks");
			javaMailService.send(mailMessage);
//           
			// send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendOtp(String subject, String email, String otp) {
		try {
			MimeMessage mailMessage = javaMailService.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
//            
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText("Here Is Your OTP(One Time Password).." + " \n\nUsername: " + email + " \n\nOTP: " + otp
					+ " \n\nThanks");
			javaMailService.send(mailMessage);
//           
			// send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendInvoice(String subject, String email, String pdfPath) {
		try {
			MimeMessage mailMessage = javaMailService.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
//            
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText("Here Is Your Invoice details!!!!!! " + "\n\n" + "Thanks");
			helper.addAttachment("Invoice.pdf", new File(pdfPath));
			javaMailService.send(mailMessage);
//           
			// send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
