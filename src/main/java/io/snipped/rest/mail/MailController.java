package io.snipped.rest.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

	@PostMapping(value="/mail/order_placed")
	public String sendEmail(@RequestParam String email) throws MessagingException, IOException {
		sendMailForOrderPlaced(email);
		return "Okay from shivamvk";
	}
	
	public void sendMailForOrderPlaced(String email) throws MessagingException, IOException{
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("snipped.in@gmail.com", "varunsnipped");
		      }
		   });
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("snipped.in@gmail.com", false));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Order Placed successfully!");
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Your order has been placed successfully.<br>We'll get back to you shortly regarding your order.", "text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		/*MimeBodyPart attachPart = new MimeBodyPart();
		multipart.addBodyPart(attachPart);*/
		msg.setContent(multipart);
		Transport.send(msg);   
	}
	
}
