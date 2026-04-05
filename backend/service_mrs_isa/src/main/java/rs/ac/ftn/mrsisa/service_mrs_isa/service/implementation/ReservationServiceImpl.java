package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.AvailabilityPeriod;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Client;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservableResource;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Reservation;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservationStatus;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.ReservationRequestDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.AvailabilityRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ClientRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ReservableResourceRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ReservationRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.EmailService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservableResourceRepository resourceRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	AvailabilityRepository availabilityRepo;
	
	@Autowired
	EmailService emailService;

	@Override
	public Reservation createReservation(ReservationRequestDTO dto, Long clientId) {
		
		if (!dto.getStartDate().isBefore(dto.getEndDate())) {
			throw new IllegalArgumentException("End date must be after start date");
	    }
		
		ReservableResource resource = resourceRepository.findById(dto.getResourceId())
				.orElseThrow(()-> new RuntimeException("Resource not Found"));
		
		Client client = clientRepository.findById(clientId)
				.orElseThrow(()-> new RuntimeException("Client is not found"));
		
		if(dto.getNumOfPeople()> resource.getCapacity()) {
			throw new RuntimeException("Too many people");	
			
		}
		//provera overlap
		boolean overlap = reservationRepo.existsOverlapping(dto.getStartDate(), dto.getEndDate(), dto.getResourceId());
		
		if(overlap) {
			throw new RuntimeException("Term already reserved!");
			
		}
		
		AvailabilityPeriod availability = availabilityRepo.findCoveringAvailability(dto.getStartDate(), dto.getEndDate(), dto.getResourceId())
				.orElseThrow(() -> new RuntimeException("No available slot!"));
		
		//brisemo stari
		availabilityRepo.delete(availability);
		
		//levi deo
		if(availability.getAvailableFrom().toLocalDate().isBefore(dto.getStartDate().toLocalDate())){
			AvailabilityPeriod left = new AvailabilityPeriod();
			left.setAvailableFrom(availability.getAvailableFrom());
			left.setAvailableTo(dto.getStartDate());
			left.setResource(availability.getResource());
			
			availabilityRepo.save(left);
		}
		
		//desni deo
		if(dto.getEndDate().toLocalDate().isBefore(availability.getAvailableTo().toLocalDate())) {
			
			 if (!dto.getEndDate().equals(availability.getAvailableTo())) {
				AvailabilityPeriod right = new AvailabilityPeriod();
				right.setAvailableFrom(dto.getEndDate());
				right.setAvailableTo(availability.getAvailableTo());
				right.setResource(availability.getResource());
			
				availabilityRepo.save(right);
			 }
			
		}
		
		//racunanje cene
		
		double totalPrice = calculatePrice(dto);
		
		//kreiranje rezervacije
		Reservation reservation = new Reservation();
		reservation.setStartDateTime(dto.getStartDate());
		reservation.setEndDateTime(dto.getEndDate());
		reservation.setNumOfPeople(dto.getNumOfPeople());
		reservation.setMaxNumPeople(dto.getMaxNumPeople());
		reservation.setPrice(totalPrice);
		reservation.setClient(client);
		reservation.setResource(resource);
		reservation.setSelectedServices(dto.getSelectedServices());
		reservation.setStatus(ReservationStatus.CREATED);
		
		reservationRepo.save(reservation);
		
		emailService.sendReservationConfimationMail(reservation);
		
		return reservation;
	}
	@Override
	public double calculatePrice(ReservationRequestDTO dto) {

	    ReservableResource resource = resourceRepository.findById(dto.getResourceId())
	        .orElseThrow(() -> new RuntimeException("Resource not found"));

	    long days =  ChronoUnit.DAYS.between(
	    	    dto.getStartDate().toLocalDate(),
	    	    dto.getEndDate().toLocalDate());
	    
	    System.out.println("Broj dana: "+ days);

	    return days * resource.getPricePerDay() * dto.getNumOfPeople();
	}
	

}
