package com.jsp.boot_email.dto;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class Email {

	
	 private String to;
	 private String subject;
	 private String body;
	 public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
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


	
	
	
	public Email() {
		super();
	}


	public Email(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}


	@Override
	public String toString() {
		return "Email [to=" + to + ", subject=" + subject + ", body=" + body + "]";
	}
}
