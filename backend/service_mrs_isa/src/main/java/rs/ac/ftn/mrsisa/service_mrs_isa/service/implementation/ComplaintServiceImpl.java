package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Client;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Complaint;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ComplaintDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ComplaintRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ReservationRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AuthService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.ComplaintService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.EmailService;

@Service
public class ComplaintServiceImpl implements ComplaintService{
	
	
	@Autowired
	AuthService authService;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	ComplaintRepository complaintRepo;
	
	@Autowired
	EmailService emailService;

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

	@Override
	public List<ComplaintDTO> getAll() {
		
		return complaintRepo.findAll()
		        .stream()
		        .map(c -> new ComplaintDTO(
		            c.getId(),
		            c.getText(),
		            c.getResponse(),
		            c.getType(),
		            c.getTargetId(),
		            c.isResponded()
		            
		        ))
		        .toList();
	}

	@Override
	public void respond(Long id, String responseText) {
		// TODO Auto-generated method stub
		Complaint complaint = complaintRepo.findById(id).orElseThrow(() -> new RuntimeException("Complaint not found"));
		
		complaint.setResponse(responseText);
		complaint.setResponded(true);
		
		complaintRepo.save(complaint);
		
		emailService.sendComplaintResponse(
		        complaint.getClient().getUsername(),
		        responseText);
		
	}

}
