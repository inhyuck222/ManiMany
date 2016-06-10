package kr.ac.manymani.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
 
@Service("mailService")
public class MailService
{
	
	private MailSender mailSender;
 
	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}	
 
	public void sendMail(SimpleMailMessage message) {
		mailSender.send(message);
	}
}