package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservableResource;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.SearchEntitiesDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.SearchService;

@RestController
@RequestMapping(value = "/api/search")
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@RequestMapping(
			value = "/searchEntities",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	@PreAuthorize("hasAuthority('CLIENT')")
	ResponseEntity<Collection<ReservableResource>> searchEntities(@RequestBody SearchEntitiesDTO dto){
		Collection<ReservableResource> searched = searchService.search(dto);
		return new ResponseEntity<>(searched, HttpStatus.OK);
		
	}

}
