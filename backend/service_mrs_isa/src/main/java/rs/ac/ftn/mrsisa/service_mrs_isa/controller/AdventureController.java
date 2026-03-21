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

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Adventure;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FilterDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AdventureService;

@RestController
@RequestMapping(value = "/api/adventure")
public class AdventureController {
	
	@Autowired
	AdventureService adventureService;
	
	
	@RequestMapping(
			value = "/getAllAdventures",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	ResponseEntity<Collection<Adventure>> getAllAdventures(){
		Collection<Adventure> adventures = adventureService.getAll();
		return new ResponseEntity<>(adventures, HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value = "/filterAdventures",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	ResponseEntity<Collection<Adventure>> filterCottages(@RequestBody FilterDTO parameters){
		Collection<Adventure> filtered = adventureService.filter(parameters);
		
		return new ResponseEntity<>(filtered, HttpStatus.OK);
		
	}

}
