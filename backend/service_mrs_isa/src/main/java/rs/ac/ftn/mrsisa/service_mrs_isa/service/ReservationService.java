package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Reservation;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ReservationRequestDTO;

public interface ReservationService {
	
	Reservation createReservation(ReservationRequestDTO reservation, Long clientId);
	
	double calculatePrice(ReservationRequestDTO dto);
}
