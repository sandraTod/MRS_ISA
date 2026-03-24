package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import java.util.Collection;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.User;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.RegisterRequestDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.UserDTO;

public interface UserService {
	
	Collection<User> getAll();
	
	void registerUser(RegisterRequestDTO registerReq);
	
	UserDTO getByUsername(String username);
	

}
