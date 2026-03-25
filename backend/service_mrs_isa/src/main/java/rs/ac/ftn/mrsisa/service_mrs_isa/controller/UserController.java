package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.User;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.VerificationToken;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ChangePasswordDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.RegisterRequestDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.UpdateUserDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.UserDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.UserRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.VerificationTokenRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VerificationTokenRepository verificationTokenRepo;
	
	@RequestMapping(
			value = "/getAll",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity <Collection<User>> getAll(){
		Collection<User> userList = userService.getAll();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value = "/registerUser",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	ResponseEntity<?> registerUser(@RequestBody RegisterRequestDTO request){
		userService.registerUser(request);
		
		return ResponseEntity.ok().build();
		
	}
	
	@RequestMapping(
			value = "/activate",
			method = RequestMethod.GET
			)
	ResponseEntity <?> activateAccount(@RequestParam String token){
		
		VerificationToken verificationToken = verificationTokenRepo.findByToken(token);
		
		if(verificationToken == null) {
			return new ResponseEntity<>("Invalid token", HttpStatus.BAD_REQUEST);
			
		}
		if(verificationToken.getExpirationDate().isBefore(LocalDateTime.now())) {
			return new ResponseEntity<>("Token expired", HttpStatus.BAD_REQUEST);
			
		}
		
		User client = verificationToken.getUser();
		client.setEnabled(true);
		
		userRepository.save(client);
		
		verificationTokenRepo.delete(verificationToken);
		
		return new ResponseEntity<>("Account successfully activated", HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value = "/getCurrentUser",
			method = RequestMethod.GET
			)
	@PreAuthorize("hasAuthority('CLIENT')")
	ResponseEntity<?> getCurrentUser(Authentication authentication){
		
		UserDTO currentUser = userService.getByUsername(authentication.getName());
		
		return new ResponseEntity<>(currentUser, HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value = "/updateUser",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@PreAuthorize("hasAuthority('CLIENT')")
	ResponseEntity<UserDTO> updateUser(Authentication authentication,@RequestBody UpdateUserDTO updateUser){
		
		UserDTO updated = userService.update(updateUser, authentication.getName());
		
		return new ResponseEntity<>(updated, HttpStatus.OK);
		
	}
	@RequestMapping(
			value = "/changePassword",
			method = RequestMethod.PATCH,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	@PreAuthorize("hasAuthority('CLIENT')")
	
	public ResponseEntity<?> changePassword(Authentication authentication, @RequestBody ChangePasswordDTO dto) {

	    String username = authentication.getName();

	    userService.changePassword(username, dto);

	    return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
