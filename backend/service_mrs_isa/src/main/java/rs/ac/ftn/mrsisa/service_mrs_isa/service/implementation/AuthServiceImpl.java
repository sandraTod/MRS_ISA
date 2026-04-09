package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Client;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ClientRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client getLoggedInUser() {
		
		Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
		
		String email = authentication.getName();
		System.out.println("Email je: "+ email);
		return clientRepository.findByUsername(email); 
	}

}
