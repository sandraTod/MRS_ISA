package rs.ac.ftn.mrsisa.service_mrs_isa.service;


import java.util.Collection;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Reservation;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ReservationRequestDTO;

public interface ReservationService {
	
	Reservation createReservation(ReservationRequestDTO reservation, Long clientId);
	
	double calculatePrice(ReservationRequestDTO dto);
	
	void cancelReservation(Long id);
	
	Collection<Reservation> getByClient(Long id);
}
