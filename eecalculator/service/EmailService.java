package com.hylston.eecalculator.service;

import java.util.Date;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailService extends HtmlEmail {

	public static final String SMTP_SERVER = "smtp.gmail.com";

	public static final String EMAIL_USER = "hylston.email.sender@gmail.com";

	public static final String EMAIL_PASSWORD = "***";

	public static final Integer SMTP_PORT = 587;

	public EmailService() throws EmailException {

		super();

		this.setSentDate(new Date());

		this.setHostName(SMTP_SERVER);

		Integer smtpPorta = SMTP_PORT;

		if (smtpPorta != null) {

			this.setSmtpPort(smtpPorta);
		}

		configuracoesAdicionaisEmail();

		this.setAuthentication(EMAIL_USER, EMAIL_PASSWORD);

		this.setFrom(EMAIL_USER);
	}

	private void configuracoesAdicionaisEmail() {

		if ("smtp.gmail.com".equals(this.getHostName())) {

			this.setSmtpPort(587);

			this.setSslSmtpPort("587");

			this.setTLS(true);
		}
	}

	public void sendInThread() {

		final EmailService emailService = this;

		new Thread() {

			@Override
			public void run() {

				try {

					emailService.send();

				} catch (EmailException e) {

					e.printStackTrace();
				}
			}

		}.start();
	}

	public static void sendEmail(String emailTO, String subject, String html) throws EmailException {

		EmailService email = new EmailService();

		email.addTo(emailTO);

		email.setSubject(subject);

		email.setHtmlMsg(html);

		email.sendInThread();
	}
}