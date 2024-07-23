package com.jsp.boot_email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.Emails;
import com.jsp.boot_email.dto.FileAttachment;
import com.jsp.boot_email.server.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService service;

	
	//api to send simple email
	@PostMapping("/sendSimpleEmail")
	public String sendSimpleEmail(@RequestBody Email email) {
		System.out.println(email);
		try {
			service.sendMsg(email);

			return "msg send successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Internal issue try again";
		}
	}
	
	//api to send same email to mutliple Recepients
	@PostMapping("/sendEmail_MultiRecepiet")
	public String sendEmail_MultiRecepiet(@RequestBody Emails email) {
		System.out.println(email);
		try {
			service.sendMsgs(email);
			return "msg send successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Internal issue try again";
		}
	}
	
	//api to send same email to send html
	@PostMapping("/sendHtmlEmail")
	public String sendHtmlEmail(@RequestBody Email email) {
		System.out.println(email);
		try {
			service.sendHtmlEmail(email);
			return "msg send successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Internal issue try again";
		}
	}
	
	
	//Service method to send simple attachment
	@PostMapping("/sendAttachment")
	public String sendAttachment(@RequestBody FileAttachment file) {
		System.out.println(file);
		try {
			service.sendAttachment(file);
			return "msg send successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Internal issue try again";
		}
	}
}
