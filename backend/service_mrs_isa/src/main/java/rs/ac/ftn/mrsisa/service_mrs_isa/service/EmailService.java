package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Reservation;

@Service
public class EmailService {
	
	    @Autowired
	    private JavaMailSender mailSender;

	    
	    public void sendMail(String to){

	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("Test email");
	        message.setText("Ovo je test email iz aplikacije");

	        mailSender.send(message);
	    }
	    
	    
	    public void sendActivactionMail(String email, String token) {
	    	
	    	String activationLink = "http://localhost:8080/api/user/activate?token=" + token;
	    	
	    	SimpleMailMessage message = new SimpleMailMessage();
	    	message.setTo(email);
	    	message.setSubject("Account acctivation");
	    	message.setText(
	    			"Hello,\n\n" +
	                "Thank you for registering.\n" +
	                "Please click the link below to activate your account:\n\n" +
	                activationLink +
	                "\n\nBest regards");
	    	
	    	mailSender.send(message);
	    }
	    
	    public void sendReservationConfimationMail(Reservation reservation) {
	    	
	    	SimpleMailMessage message = new SimpleMailMessage();
	    	message.setTo(reservation.getClient().getUsername());
	    	message.setSubject("Reservation Confirmation");
	    	message.setText(
	    			 "Hello!\n\n" +
	    				        "Your reservation has been successfully created 🎉\n\n" +
	    				        "Resource: " + reservation.getResource().getName() + "\n" +
	    				        "From: " + reservation.getStartDateTime() + "\n" +
	    				        "To: " + reservation.getEndDateTime() + "\n" +
	    				        "Total price: " + reservation.getPrice() + "€\n\n" +
	    				        "Thank you for your trust! 😊"
	    			);
	    	
	    	mailSender.send(message);
	    }
	    
	    public void sendDiscountEmail(String to, String resourceName) {
	        System.out.println("Sending email to " + to + " for " + resourceName);
	    }
	    
	    
	    public void sendComplaintResponse(String to, String response) {

	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("Your complaint has been reviewed");
	        message.setText("Response: " + response);

	        mailSender.send(message);
	    }
	    public void sendDeletionResponse(String to, String response) {
	    	
	    	  	SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo(to);
		        message.setSubject("Your request has been reviewed");
		        message.setText("Response: " + response);

		        mailSender.send(message);
	    	
	    	
	    }

}
