package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.User;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.UserType;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.VerificationToken;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ChangePasswordDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.RegisterRequestDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.UpdateUserDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.UserDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.UserRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.VerificationTokenRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.EmailService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	VerificationTokenRepository verificationTokenRepo;

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
		
		String token = UUID.randomUUID().toString();
		
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(newClient);
		verificationToken.setExpirationDate(LocalDateTime.now().plusHours(24));
		
		verificationTokenRepo.save(verificationToken);
		
		emailService.sendActivactionMail(newClient.getUsername(), token);
		
		
		
	}

	@Override
	public UserDTO getByUsername(String username) {
		
		User user =  userRepository.findByUsername(username);
	
		UserDTO currentUser = new UserDTO();
		
		currentUser.setUsername(user.getUsername());
		currentUser.setName(user.getName());
		currentUser.setLastname(user.getLastname());
		currentUser.setAddress(user.getAddress());
		currentUser.setCity(user.getCity());
		currentUser.setState(user.getState());
		currentUser.setPhoneNum(user.getPhoneNum());
		
		return currentUser;
		
		
	}

	@Override
	public UserDTO update(UpdateUserDTO updateUser, String username) {
		User user = userRepository.findByUsername(username);
		user.setName(updateUser.getName());
		user.setLastname(updateUser.getLastname());
		user.setAddress(updateUser.getAddress());
		user.setCity(updateUser.getCity());
		user.setState(updateUser.getState());
		user.setPhoneNum(updateUser.getPhoneNum());
		
		userRepository.save(user);
		
		return mapToDTO(user);
	}
	
	
	private UserDTO mapToDTO(User user) {
		
		UserDTO dto = new UserDTO();
		dto.setUsername(user.getUsername());
		dto.setName(user.getName());
		dto.setLastname(user.getLastname());
		dto.setAddress(user.getAddress());
		dto.setCity(user.getCity());
		dto.setState(user.getState());
		dto.setPhoneNum(user.getPhoneNum());
		
		return dto;
		
		
	}

	@Override
	public void changePassword(String username, ChangePasswordDTO dto) {
		
		User user = userRepository.findByUsername(username);
		
		if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
	        throw new RuntimeException("Old password is incorrect");
	    }
	    user.setPassword(passwordEncoder.encode(dto.getNewPassword()));

	    userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		User user = userRepository.getReferenceById(id);
		userRepository.delete(user);
		
	}

	
}
