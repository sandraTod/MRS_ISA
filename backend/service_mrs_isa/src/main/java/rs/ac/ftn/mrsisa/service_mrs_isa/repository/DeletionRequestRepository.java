package rs.ac.ftn.mrsisa.service_mrs_isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.DeletionRequest;

public interface DeletionRequestRepository extends JpaRepository<DeletionRequest, Long> {

}
