package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import java.util.Collection;

import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FastReservationDTO;

public interface AvailabilityService {
	
	Collection<FastReservationDTO> getFastReservationByType(Class<?> type);

}
