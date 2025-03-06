package com.example.demo.Entity;

public class EmailRequest {
	
	
	private String title;
	private String subject;
	private String body;
	private String recipentEmail;
	
	public EmailRequest() {
		
	}
	
	
	public EmailRequest(String title, String subject, String body, String recipentEmail) {
		super();
		this.title = title;
		this.subject = subject;
		this.body = body;
		this.recipentEmail = recipentEmail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getRecipentEmail() {
		return recipentEmail;
	}
	public void setRecipentEmail(String recipentEmail) {
		this.recipentEmail = recipentEmail;
	}


	@Override
	public String toString() {
		return "EmailRequest [title=" + title + ", subject=" + subject + ", body=" + body + ", recipentEmail="
				+ recipentEmail + "]";
	}
	
	
	
	
}
