package com.example.demo.Service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.EmailRequest;

public interface EmailService {
	
	public Boolean sendEmail(EmailRequest emailRequest) throws Exception;

	public void sendEmailAndAttachment(String email, MultipartFile[] file) throws Exception;
}
