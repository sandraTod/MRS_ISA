package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import java.util.List;

import rs.ac.ftn.mrsisa.service_mrs_isa.dto.DeletionRequestDTO;

public interface DeletionRequestService {
	
	void create(DeletionRequestDTO dto);
	
	List<DeletionRequestDTO> getAll();
	
	void respond(Long id, DeletionRequestDTO dto);

}
