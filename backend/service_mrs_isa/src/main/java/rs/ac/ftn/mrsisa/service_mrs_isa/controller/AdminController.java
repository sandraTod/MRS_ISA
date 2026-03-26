package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.User;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.UserService;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(
			value = "/getAllUsers",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity <Collection<User>> getAllUsers(){
		Collection<User> userList = userService.getAll();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/deleteUser/{id}",
			method = RequestMethod.DELETE
	)
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
	    userService.delete(id);
	    return  new ResponseEntity<>(HttpStatus.OK);
	}

}
