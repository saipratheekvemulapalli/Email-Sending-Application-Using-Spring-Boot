package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.EmailRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public Boolean sendEmail(EmailRequest emailRequest) throws Exception {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("saipratheekvemulapalli@gmail.com", emailRequest.getTitle());
		helper.setTo(emailRequest.getRecipentEmail());
		helper.setSubject(emailRequest.getSubject());
		helper.setText(emailRequest.getBody(), true);
		mailSender.send(message);
		return true;
	}

	@Override
	public void sendEmailAndAttachment(String email, MultipartFile[] files) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		EmailRequest emailRequest = mapper.readValue(email, EmailRequest.class);

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom("saipratheekvemulapalli@gmail.com", emailRequest.getTitle());
		helper.setTo(emailRequest.getRecipentEmail());
		helper.setSubject(emailRequest.getSubject());
		helper.setText(emailRequest.getBody(), true);

		for (MultipartFile file : files) {
			if (file != null) {
				ByteArrayResource byteArrayResource = new ByteArrayResource(file.getBytes());
				helper.addAttachment(file.getOriginalFilename(), byteArrayResource);
			}
		}

		mailSender.send(message);

	}
}
