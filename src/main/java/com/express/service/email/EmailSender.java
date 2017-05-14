package com.express.service.email;

public interface EmailSender {

	String mailMessageFormat= "Dear %s,<br>"
			+ "&nbsp; Please note your password is %s<br>";
	
	
	public void sendEmail(String toEmailIds, String subject, Object... data);
	
}
