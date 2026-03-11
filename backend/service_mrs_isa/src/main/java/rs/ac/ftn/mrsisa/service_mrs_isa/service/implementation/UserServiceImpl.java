package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.User;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.UserType;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.RegisterRequestDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.UserRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Collection<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void registerUser(RegisterRequestDTO registerReq) {
		// TODO Auto-generated method stub
		User newClient = new User();
		System.out.println("Ime novog klijenta: "+ registerReq.getName());
		newClient.setUsername(registerReq.getUsername());
		newClient.setPassword(passwordEncoder.encode(registerReq.getPassword()));
		newClient.setName(registerReq.getName());
		newClient.setLastname(registerReq.getLastname());
		newClient.setAddress(registerReq.getAddress());
		newClient.setCity(registerReq.getCity());
		newClient.setState(registerReq.getState());
		newClient.setPhoneNum(registerReq.getPhoneNum());
		newClient.setRole(UserType.CLIENT);
		
		userRepository.save(newClient);
		
	}

	
}
