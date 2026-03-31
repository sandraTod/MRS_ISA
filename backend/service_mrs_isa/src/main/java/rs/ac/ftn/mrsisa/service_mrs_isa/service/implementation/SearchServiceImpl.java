package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.AvailabilityPeriod;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservableResource;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.SearchEntitiesDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.AdventureRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.CottageRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ShipRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	CottageRepository cottageRepository;
	
	@Autowired
	ShipRepository shipRepository;
	
	@Autowired
	AdventureRepository adventureRepository;

	@Override
	public Collection<ReservableResource> search(SearchEntitiesDTO dto) {
		// TODO Auto-generated method stub
		List<ReservableResource> list;
		
		switch(dto.getEntity()) {
			
			case "Vikendice":
				list = new ArrayList<>(cottageRepository.findAll());
				break;
				
			case "Brodovi":
				System.out.println("ovde sam");
				list = new ArrayList<>(shipRepository.findAll());
				break;
			
			case "Avanture":
				list = new ArrayList<>(adventureRepository.findAll());
				break;
				
			default:
				System.out.println("Vracam praznu listu!");
				list = new ArrayList<>();
				
		}
		
		return list.stream()
				.filter(resource -> isAvailable(resource, dto))
				.filter(e -> dto.getNumOfPeople() == 0 || e.getCapacity()>= dto.getNumOfPeople())
				.filter(e -> dto.getCity() == "" || e.getCity().equalsIgnoreCase(dto.getCity())).toList();
	}
	
	
	
	// Could be replaced with stream().anyMatch(...) for conciseness
	
	/*return resource.getAvailablePeriods().stream()
			.anyMatch(ap-> !ap.getAvailableFrom().isAfter(dto.getDateFrom()) && !ap.getAvailableTo().isBefore(dto.getDateTo()));*/
	
	
	private boolean isAvailable(ReservableResource resource, SearchEntitiesDTO dto) {
		
		for(AvailabilityPeriod ap : resource.getAvailablePeriods()) {
			
			if(!ap.getAvailableFrom().isAfter(dto.getDateFrom()) && !ap.getAvailableTo().isBefore(dto.getDateTo())) {
				return true;
			}
		}
		return false;
		
	}
	
	

}
