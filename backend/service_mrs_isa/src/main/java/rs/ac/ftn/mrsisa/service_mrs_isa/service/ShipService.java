package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import java.util.Collection;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Ship;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FilterDTO;

public interface ShipService {
	
	Collection<Ship> getAll();
	
	Collection<Ship> filter(FilterDTO parameters);

}
