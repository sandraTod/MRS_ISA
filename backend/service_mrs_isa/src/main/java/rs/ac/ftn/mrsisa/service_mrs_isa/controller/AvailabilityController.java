package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Adventure;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Cottage;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Ship;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FastReservationDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AvailabilityService;

@RestController
@RequestMapping(value = "/api/availiability")
public class AvailabilityController {
	
	
	@Autowired
	AvailabilityService availabilityService;
	
	
	@RequestMapping(
			value = "/getFastReservations",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@PreAuthorize("hasAuthority('CLIENT')")
	ResponseEntity <Collection<FastReservationDTO>> getFastReservations(@RequestParam String type){
		Collection<FastReservationDTO> fastReservations;
		
		switch(type) {
			case "COTTAGE":
						fastReservations = availabilityService.getFastReservationByType(Cottage.class);
	 				    break;			
			case "SHIP":
				fastReservations = availabilityService.getFastReservationByType(Ship.class);
				break;
				
			case "ADVENTURE":
				fastReservations = availabilityService.getFastReservationByType(Adventure.class);
				break;	
			default:
				throw new RuntimeException("Invalid type");
		}
		
		return new ResponseEntity<>(fastReservations, HttpStatus.OK);
		
	}
}
