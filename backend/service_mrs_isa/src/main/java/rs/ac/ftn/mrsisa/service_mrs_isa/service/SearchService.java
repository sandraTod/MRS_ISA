package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import java.util.Collection;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservableResource;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.SearchEntitiesDTO;

public interface SearchService {
	
	Collection<ReservableResource> search(SearchEntitiesDTO dto);

}
