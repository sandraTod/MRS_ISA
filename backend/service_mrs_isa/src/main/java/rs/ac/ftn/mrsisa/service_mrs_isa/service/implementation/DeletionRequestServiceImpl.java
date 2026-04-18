package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.DeletionRequest;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.RequestStatus;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.User;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ComplaintDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.DeletionRequestDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.DeletionRequestRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AuthService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.DeletionRequestService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.EmailService;

@Service
public class DeletionRequestServiceImpl implements DeletionRequestService{
	
	@Autowired
	AuthService authService;
	
	@Autowired
	DeletionRequestRepository deletionReqRepo;
	
	@Autowired
	EmailService emailService;

	@Override
	public void create(DeletionRequestDTO dto) {
		// TODO Auto-generated method stub
		
		User user  = authService.getLoggedInUser();
		
		DeletionRequest dr  = new DeletionRequest();
		dr.setText(dto.getText());
		dr.setUser(user);
		dr.setStatus(RequestStatus.PENDING);
		
		deletionReqRepo.save(dr);
		
	}

	@Override
	public List<DeletionRequestDTO> getAll() {
		// TODO Auto-generated method stub
		return deletionReqRepo.findAll()
		        .stream()
		        .map(dr -> new DeletionRequestDTO(
		            dr.getId(),
		            dr.getText(),
		            dr.getResponse(),
		            dr.getStatus().toString()
		            
		        ))
		        .toList();
	}

	@Override
	public void respond(Long id, DeletionRequestDTO dto) {
		
		  DeletionRequest req = deletionReqRepo.findById(id)
			        .orElseThrow(() -> new RuntimeException("Not found"));

			    req.setResponse(dto.getResponse());
			    req.setStatus(RequestStatus.valueOf(dto.getStatus()));

			    deletionReqRepo.save(req);

			    emailService.sendDeletionResponse(
			        req.getUser().getUsername(), dto.getResponse());
		
	}

}
