package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Cottage;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Ship;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FilterDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.ShipService;

@RestController
@RequestMapping(value = "/api/ship")
public class ShipController {
	
	@Autowired
	ShipService shipService;
	
	@RequestMapping(
			value = "/getAllShips",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	ResponseEntity<Collection<Ship>> getAllShips(){
		Collection<Ship> cottages = shipService.getAll();
		return new ResponseEntity<>(cottages, HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value = "/filterShips",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	ResponseEntity<Collection<Ship>> filterShips(@RequestBody FilterDTO parameters){
		Collection<Ship> filtered = shipService.filter(parameters);
		return new ResponseEntity<>(filtered, HttpStatus.OK);
		
	}

}
