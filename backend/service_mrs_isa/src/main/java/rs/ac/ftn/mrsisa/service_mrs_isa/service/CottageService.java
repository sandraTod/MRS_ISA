package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import java.util.Collection;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Cottage;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FilterDTO;

public interface CottageService {
	
	Collection<Cottage> getAll();
	
	Collection<Cottage> filter(FilterDTO parameters );

}
