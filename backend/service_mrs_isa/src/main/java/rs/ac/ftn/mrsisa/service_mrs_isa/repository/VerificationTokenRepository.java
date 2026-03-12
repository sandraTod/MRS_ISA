package rs.ac.ftn.mrsisa.service_mrs_isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long>{
	
	VerificationToken findByToken(String token);

}
