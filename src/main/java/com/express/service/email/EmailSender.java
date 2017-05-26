package com.express.service.email;

public interface EmailSender {

	String mailMessageFormat = "Dear %s,<br>"
			+ "&nbsp; Please note your temporary password is %s<br> &nbsp; Please change it immediatly.<br> &nbsp; Thanks&Regards,<br>&nbsp; ExpressRight Team";

	public void sendEmail(String toEmailIds, String subject, Object... data);

}
