package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Adventure;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Client;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Cottage;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservableResource;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Ship;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.AdventureRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ClientRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.CottageRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ShipRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AuthService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.EmailService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	CottageRepository cottageRepository;
	
	@Autowired
	ShipRepository shipRepository;
	
	@Autowired
	AdventureRepository adventureRepository;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	EmailService emailService;

	@Override
	public void subscribe(String type, Long id) {
		
		Client client = authService.getLoggedInUser();
		
		if(type.equals("COTTAGE")) {
			
			Cottage cottage = cottageRepository.findById(id).orElseThrow();
			client.getSubscribedCottages().add(cottage);
		}
		
		if(type.equals("SHIP")) {
			
			Ship ship = shipRepository.findById(id).orElseThrow();
			client.getSubscribedShips().add(ship);
			
		}
		if(type.equals("ADVENTURE")) {
			
			Adventure adventure = adventureRepository.findById(id).orElseThrow();
			client.getSubscribedAdventures().add(adventure);
			
		}
		clientRepository.save(client);
		
	}

	@Override
	public void unsubscribe(String type, Long id) {
		Client client  = authService.getLoggedInUser();
		
		if(type.equals("COTTAGE")) {
			
			Cottage cottage = cottageRepository.findById(id).orElseThrow();
			client.getSubscribedCottages().remove(cottage);	
		}
		
		if(type.equals("SHIP")) {
			
			Ship ship = shipRepository.findById(id).orElseThrow();
			client.getSubscribedShips().remove(ship);	
		}
		
		if(type.equals("ADVENTURE")) {
			Adventure adventure = adventureRepository.findById(id).orElseThrow();
			client.getSubscribedAdventures().remove(adventure);
			
		}
		clientRepository.save(client);
	}

	@Override
	public void notifySubscribers(ReservableResource resource, String type) {
		
		 List<Client> clients = clientRepository.findAll();

		    for (Client c : clients) {

		        boolean isSubscribed = false;

		        if (type.equals("COTTAGE")) {
		            isSubscribed = c.getSubscribedCottages().contains(resource);
		        }

		        if (type.equals("SHIP")) {
		            isSubscribed = c.getSubscribedShips().contains(resource);
		        }

		        if (type.equals("ADVENTURE")) {
		            isSubscribed = c.getSubscribedAdventures().contains(resource);
		        }

		        if (isSubscribed) {
		            emailService.sendDiscountEmail(c.getUsername(), type);
		        }
		    }
		
	}
	
	

}
