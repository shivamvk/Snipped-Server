package io.snipped.rest.mail;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import io.snipped.rest.order.Order;
import io.snipped.rest.order.OrderRepository;
import io.snipped.rest.services.Services;

@RestController
public class MailController {

	@Autowired 
	private OrderRepository repository;
	
	@PostMapping(value="/mail/order_placed")
	public String sendEmail(@RequestParam String email, @RequestParam String orderId) throws MessagingException, IOException {
		Order order = repository.findById(orderId).get();
		sendMailForOrderPlaced(email, order);
		//sendMailToInternals("internals.snipped@gmail.com", order);
		return "Okay from shivamvk";
	}
	
	@PostMapping(value="/mail/order_cancelled")
	public String sendEmailForOrderCancelled(@RequestParam String email, @RequestParam String orderId) throws MessagingException, IOException {
		Order order = repository.findById(orderId).get();
		sendMailCancellation(email, order);
		return "Okay from shivamvk";
	}
	
	@GetMapping(value="/mail/{email}")
	public String ashishSendMail(@PathVariable String email) throws AddressException, MessagingException {
		return sendAshishEmail(email);
	}
	
	@GetMapping(value="/snipped")
	public RedirectView redirect() {
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("https://play.google.com/store/apps/details?id=in.mobileapp.snipped");
	    return redirectView;
	}
	
	public String sendAshishEmail(String email) throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("tohfldeveloper@gmail.com", "tohfl@6677");
		      }
		   });
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("tohfldeveloper@gmail.com", false));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Verify your email!");
		
		Random random = new Random();
		int otp = random.nextInt(10000);
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("<h3>Please open the app and enter the OTP: " + otp + "</h3>", "text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);
		Transport.send(msg);  
		
		return otp + "";
	}
	
	public void sendMailForOrderPlaced(String email, Order order) throws MessagingException, IOException{
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
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email+",operations.snipped@gmail.com"));
		msg.setSubject("Order Placed successfully!");
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(generateHtml(order, "Placed"), "text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);
		Transport.send(msg);   
	}
	
	public void sendMailCancellation(String email, Order order) throws MessagingException, IOException{
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
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email+",operations.snipped@gmail.com"));
		msg.setSubject("Order cancelled successfully!");
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(generateHtml(order, "Cancelled"), "text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);
		Transport.send(msg);   
	}

	
	public String generateHtml(Order order, String status) {
		String html =
				"<html"
				+ "<head>"
				+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">"
				+ "</head"
				+ "<body>"
				+ "<div class=\"container text-center\" style=\"text-align:center\">"
				+ "<span style=\"text-align:center\">"
				+ "<img src=\"https://res.cloudinary.com/cdnsnipped/image/upload/v1548677349/SALON_LOGO-03.jpg\" height=\"120px\" width=\"150px\">"
				+ "<br><p><h3>Your Order has been " + status + " succesfully!</h3></p><h4><p>We'll get back to you regarding your order shortly.</p></h4>"
				+ "</span>"
				+ "<h5>Your order details are;<br><br></h5>"
				+ "<table class=\"table table-striped\" border=\"1\">"
				+ "<tbody>"
				+ "    <tr>"
				+ "      <th scope=\"row\">Order Id : </th>\n" 
				+ "      <td>" + order.get_id() + "</td>\n" 
				+ "    </tr>"
				+ "    <tr>"
				+ "      <th scope=\"row\">Phone : </th>\n" 
				+ "      <td>" + order.getPhone() + "</td>\n" 
				+ "    </tr>"
				+ "    <tr>"
				+ "      <th scope=\"row\">Address : </th>\n" 
				+ "      <td>" + order.getAddress() + "</td>\n" 
				+ "    </tr>"
				+ "    <tr>"
				+ "      <th scope=\"row\">Services : </th>\n" 
				+ "      <td>" + getServicesNameString(order.getServices()) + "</td>\n" 
				+ "    </tr>"
				+ "    <tr>"
				+ "      <th scope=\"row\">Amount : </th>\n" 
				+ "      <td>Rs. " + order.getAmount() + "</td>\n" 
				+ "    </tr>"
				+ "    <tr>"
				+ "      <th scope=\"row\">Appointment: </th>\n" 
				+ "      <td>" + order.getAppointmentDate() + ", " + order.getAppointmentTime() + "</td>\n" 
				+ "    </tr>"
				+ "<tbody>"
				+ "</div>"
				+ "</body>"
				+ "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n"
				+ "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n" 
				+ "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>" 
				+ "</html>";
		return html;
	}
	
	public String getServicesNameString(List<Services> list) {
		String string = "";
		for(int i=0; i< list.size(); i++) {
			string = string + list.get(i).getName() + ", " + list.get(i).getSubcategory() + ", " + list.get(i).getCategory() + "(Rs. " + list.get(i).getPrice() + ", " + list.get(i).getGender()+ ")" ;
			if(i != list.size() - 1) {
				string = string + ", ";
			}
		}
		return string;
	}
	
}
