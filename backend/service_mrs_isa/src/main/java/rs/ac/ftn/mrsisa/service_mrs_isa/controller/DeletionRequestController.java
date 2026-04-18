package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

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
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.DeletionRequestDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.DeletionRequestService;

@RestController
@RequestMapping(value = "/api/deletionRequest")
public class DeletionRequestController {
	
	@Autowired
	DeletionRequestService deletionReqService;
	
	@RequestMapping(
			value = "/create/",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE
			
			)
	@PreAuthorize("hasAuthority('CLIENT') or hasAuthority('COTTAGE_OWNER') or hasAuthority('SHIP_OWNER') or hasAuthority('INSTRUCTOR')")
	ResponseEntity<?> create(@RequestBody DeletionRequestDTO dto){

		deletionReqService.create(dto);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value = "/getAll",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<List<DeletionRequestDTO>> getAll(){
		List<DeletionRequestDTO> requests = deletionReqService.getAll();
		return new ResponseEntity<>(requests, HttpStatus.OK);
		
	}

}
