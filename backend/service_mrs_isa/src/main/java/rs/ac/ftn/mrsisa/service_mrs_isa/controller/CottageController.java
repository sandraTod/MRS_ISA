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
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FilterDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.CottageService;

@RestController
@RequestMapping(value = "/api/cottage")
public class CottageController {
	
	@Autowired
	CottageService cottageService;
	
	
	@RequestMapping(
			value = "/getAllCottages",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	ResponseEntity<Collection<Cottage>> getAllCottages(){
		Collection<Cottage> cottages = cottageService.getAll();
		return new ResponseEntity<>(cottages, HttpStatus.OK);
		
	}
	@RequestMapping(
			value = "/filterCottages",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	ResponseEntity<Collection<Cottage>> filterCottages(@RequestBody FilterDTO parameters){
		Collection<Cottage> filtered = cottageService.filter(parameters);
		System.out.println(filtered.size());
		return new ResponseEntity<>(filtered, HttpStatus.OK);
		
	}

}
