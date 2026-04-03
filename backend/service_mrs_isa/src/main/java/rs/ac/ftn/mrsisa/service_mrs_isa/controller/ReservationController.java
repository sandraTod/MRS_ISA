package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Reservation;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ReservationRequestDTO;

import rs.ac.ftn.mrsisa.service_mrs_isa.service.ReservationService;

@RestController
@RequestMapping(value = "/api/reservation")
public class ReservationController {
	
	
	@Autowired
	ReservationService reservationService;
	
	
	@RequestMapping(
			value = "/createReservation/{clientId}",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	@PreAuthorize("hasAuthority('CLIENT')")
	ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequestDTO dto,@PathVariable Long clientId){
		System.out.println("CLIENT_ID "+ clientId);
		Reservation created = reservationService.createReservation(dto, clientId);
		
		return new ResponseEntity<>(created, HttpStatus.OK);
		
	}

}
