package rs.ac.ftn.mrsisa.service_mrs_isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.ftn.mrsisa.service_mrs_isa.dto.SubscriptionDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.SubscriptionService;

@RestController
@RequestMapping(value = "api/subscriptions")
public class SubscriptionsController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	
	@RequestMapping(
			value = "/subscribe/{type}/{id}",
			method = RequestMethod.POST
			
			)
	@PreAuthorize("hasAuthority('CLIENT')")
	ResponseEntity<?>subscribe (@PathVariable String type, @PathVariable Long  id){
		subscriptionService.subscribe(type, id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/unsubscribe/{type}/{id}",
			method = RequestMethod.DELETE
			
			)
	@PreAuthorize("hasAuthority('CLIENT')")
	ResponseEntity<?>unsubscribe (@PathVariable String type, @PathVariable Long  id){
		subscriptionService.unsubscribe(type, id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getAll",
			method = RequestMethod.GET
			
			)
	@PreAuthorize("hasAuthority('CLIENT')")
	ResponseEntity<List<SubscriptionDTO>> getAll(){
		List<SubscriptionDTO> result = subscriptionService.getAllSubscriptions();
		return new ResponseEntity<>(result, HttpStatus.OK);
		
		
	}

}
