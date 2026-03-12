package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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

}
