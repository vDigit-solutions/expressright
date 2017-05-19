package com.express.service.email;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender, InitializingBean {

	@Autowired
	JavaMailSender mailSender;

	Logger logger = LogManager.getLogger(EmailSenderImpl.class);

	public void sendEmail(String toEmailIds, String subject, Object... data) {
		try {
			final InternetAddress[] toemailAddresss = InternetAddress.parse(toEmailIds);

			String message = String.format(mailMessageFormat, data);
			MimeMessage mailMessage = mailSender.createMimeMessage();
			logger.info("sendEmail  ------- :: " + toEmailIds + "  subject ::" + subject + " message --: " + message);

			String from = mailMessage.getSession().getProperty("mail.smtp.from");
			logger.info("Sender info  :: " + from);

			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true);
			messageHelper.setTo(toemailAddresss);
			messageHelper.setSubject(subject);
			messageHelper.setText(message, true);
			messageHelper.setFrom(from, from);

			mailSender.send(mailMessage);
		} catch (Exception e) {
			logger.error("error while sending email", e);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		sendEmail("manslogic@gmail.com", "hi", "nagesh", "hi");

	}

}
