package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Client;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Complaint;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ComplaintDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ComplaintRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ReservationRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AuthService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.ComplaintService;

@Service
public class ComplaintServiceImpl implements ComplaintService{
	
	
	@Autowired
	AuthService authService;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	ComplaintRepository complaintRepo;

	@Override
	public void createComplaint(ComplaintDTO dto) {
		
		Client client = authService.getLoggedInUser();
		

		boolean hasReservation = false;
		
		 if (dto.getType().contains("OWNER") || dto.getType().contains("INSTRUCTOR")) {
			 
			 hasReservation = reservationRepo.existsByClientId(client.getId());
			
		 }else {
			  hasReservation = reservationRepo.existsByClientIdAndResourceId(client.getId(), dto.getTargetId());
			 
		 }		
		
		 if(!hasReservation) {
			
			throw new RuntimeException("You can only complain if you had a reservation!");
			
		}
		
		Complaint complaint = new Complaint();
		complaint.setText(dto.getText());
		complaint.setType(dto.getType());
		complaint.setTargetId(dto.getTargetId());
		complaint.setClient(client);
		complaint.setResponded(false);
		
		complaintRepo.save(complaint);
		
	}

}
