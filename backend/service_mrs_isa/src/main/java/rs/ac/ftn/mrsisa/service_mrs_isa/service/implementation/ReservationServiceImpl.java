package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Client;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservableResource;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Reservation;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservationStatus;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ReservationRequestDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ClientRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ReservableResourceRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ReservationRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservableResourceRepository resourceRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ReservationRepository reservationRepo;

	@Override
	public Reservation createReservation(ReservationRequestDTO dto, Long clientId) {
		
		if (!dto.getStartDate().isBefore(dto.getEndDate())) {
			throw new IllegalArgumentException("End date must be after start date");
	    }
		
		ReservableResource resource = resourceRepository.findById(dto.getResourceId())
				.orElseThrow(()-> new RuntimeException("Resource not Found"));
		
		Client client = clientRepository.findById(clientId)
				.orElseThrow(()-> new RuntimeException("Client is not found"));
		
		if(dto.getMaxNumPeople()> resource.getCapacity()) {
			throw new RuntimeException("Too many people");	
			
		}
		//provera overlap
		boolean overlap = reservationRepo.existsOverlapping(dto.getStartDate(), dto.getEndDate(), dto.getResourceId());
		
		if(overlap) {
			throw new RuntimeException("Term already reserved!");
			
		}
		
		//racunanje cene
		long days = Duration.between(dto.getStartDate(), dto.getEndDate()).toDays();
		if(days== 0) days = 1;
		
		double totalPrice = days * resource.getPricePerDay();
		
		//kreiranje rezervacije
		Reservation reservation = new Reservation();
		reservation.setStartDateTime(dto.getStartDate());
		reservation.setEndDateTime(dto.getEndDate());
		reservation.setMaxNumPeople(dto.getMaxNumPeople());
		reservation.setPrice(totalPrice);
		reservation.setClient(client);
		reservation.setResource(resource);
		reservation.setSelectedServices(dto.getSelectedServices());
		reservation.setStatus(ReservationStatus.CREATED);
		
		reservationRepo.save(reservation);
		return reservation;
	}

}
