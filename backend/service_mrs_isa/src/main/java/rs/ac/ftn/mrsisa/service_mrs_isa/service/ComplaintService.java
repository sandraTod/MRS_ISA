package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import java.util.Collection;
import java.util.List;

import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ComplaintDTO;

public interface ComplaintService {
	
	void createComplaint(ComplaintDTO dto);
	
	List<ComplaintDTO> getAll();
	
	void respond(Long id, String responseText); 

}
