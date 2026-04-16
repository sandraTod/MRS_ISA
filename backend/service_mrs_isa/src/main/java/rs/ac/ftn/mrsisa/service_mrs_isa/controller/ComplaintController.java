package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ComplaintDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.ComplaintService;

@RestController
@RequestMapping(value = "api/complaint")
public class ComplaintController {
	
	@Autowired
	ComplaintService complaintService;
	
	@RequestMapping(
			value = "/getAll",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<List<ComplaintDTO>> getAll(){
		List<ComplaintDTO> complaints = complaintService.getAll();
		return new ResponseEntity<>(complaints, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(
			value = "/create/",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE
			
			)
	@PreAuthorize("hasAuthority('CLIENT')")
	ResponseEntity<?> create(@RequestBody ComplaintDTO dto){
		System.out.println("Uslaaaaa");
		complaintService.createComplaint(dto);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
