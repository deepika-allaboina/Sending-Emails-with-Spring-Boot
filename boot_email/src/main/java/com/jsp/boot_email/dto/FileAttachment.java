package com.jsp.boot_email.dto;


public class FileAttachment {
	private String to;
	 private String subject;
	 private String body;
	 private String attachment;
	public FileAttachment(String to, String subject, String body, String attachment) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
		this.attachment = attachment;
	}
	public FileAttachment() {
		super();
	}
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
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "FileAttachmen [to=" + to + ", subject=" + subject + ", body=" + body + ", attachment=" + attachment + "]";
	}
	 
}

