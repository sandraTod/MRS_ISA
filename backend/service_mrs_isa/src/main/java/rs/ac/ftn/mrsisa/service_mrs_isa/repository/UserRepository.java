package rs.ac.ftn.mrsisa.service_mrs_isa.repository;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
