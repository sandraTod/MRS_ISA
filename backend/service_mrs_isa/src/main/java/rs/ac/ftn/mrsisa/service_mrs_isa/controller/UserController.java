package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.User;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.RegisterRequestDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping(
			value = "/getAll",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity <Collection<User>> getAll(){
		Collection<User> userList = userService.getAll();
		return  ResponseEntity.ok().build();
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
	

}
