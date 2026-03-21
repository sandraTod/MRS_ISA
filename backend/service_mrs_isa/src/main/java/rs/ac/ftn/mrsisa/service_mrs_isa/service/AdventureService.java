package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import java.util.Collection;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Adventure;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FilterDTO;

public interface AdventureService {
	
	Collection<Adventure> getAll();
	
	Collection<Adventure> filter(FilterDTO parameters);

}
