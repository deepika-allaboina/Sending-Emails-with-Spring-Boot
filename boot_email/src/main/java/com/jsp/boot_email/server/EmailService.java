package com.jsp.boot_email.server;



import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.Emails;
import com.jsp.boot_email.dto.FileAttachment;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	//Service method to send simple email
	public void sendMsg(Email email) {
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getBody());
		message.setFrom("deepikamudhiraj34@gmail.com");
		mailSender.send(message);
	}
	
	//Service method to send same email to mutliple Recepients
	public void sendMsgs(Emails emails) {
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setTo(emails.getTo());
		message.setSubject(emails.getSubject());
		message.setText(emails.getBody());
		message.setFrom("deepikamudhiraj34@gmail.com");
		mailSender.send(message);
	}
	
	
	//Service method to send simple attachment(attachment in program)
	public void sendAttachment(Email email) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(email.getTo());
		helper.setSubject(email.getSubject());
		helper.setText(email.getBody());
		helper.setFrom("deepikamudhiraj34@gmail.com");
		
		FileSystemResource file = new FileSystemResource(new File("C:\\Users\\Deepika\\OneDrive\\Pictures\\Wallpapers\\1.jpg"));
		helper.addAttachment("C:\\Users\\Deepika\\OneDrive\\Pictures\\Wallpapers\\1.jpg", file);

		mailSender.send(message);

	}
	//Service method to send simple attachment(attachment is also send in postman)
	public void sendAttachment(FileAttachment file) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(file.getTo());;
		helper.setSubject(file.getSubject());
		helper.setText(file.getBody());
		
		helper.setFrom("deepikamudhiraj34@gmail.com");
		
		FileSystemResource path = new FileSystemResource(new File(file.getAttachment()) );
		helper.addAttachment("attachment.jpg", path);

		mailSender.send(message);

	}
	
	//Service method to send simple html code template
	public void sendHtmlEmail(Email email) throws MessagingException {
	    MimeMessage message = mailSender.createMimeMessage();

	    message.setFrom(new InternetAddress("deepikamudhiraj34@gmail.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, email.getTo());
	    message.setSubject("sending HTML ");

	    String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
	                         "<p>It can contain <strong>HTML</strong> content.</p>";
	    
	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    mailSender.send(message);
	}
	
}
