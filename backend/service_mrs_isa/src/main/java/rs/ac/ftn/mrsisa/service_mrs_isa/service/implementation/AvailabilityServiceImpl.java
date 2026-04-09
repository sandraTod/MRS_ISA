package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.AvailabilityPeriod;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Client;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.Reservation;
import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservationStatus;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FastReservationDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.AvailabilityRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ReservationRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AuthService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AvailabilityService;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.EmailService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
	
	@Autowired
	AvailabilityRepository availabilityRepo;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	EmailService emailService;

	@Override
	public Collection<FastReservationDTO> getFastReservationByType(Class<?> type) {
		// TODO Auto-generated method stub
		return mapToDTO(availabilityRepo.findByResourceType(type));
	}
	
	
	private Collection<FastReservationDTO> mapToDTO(Collection<AvailabilityPeriod> list){
		
		return list.stream().map(a -> {
			FastReservationDTO dto = new FastReservationDTO();
			dto.setId(a.getId());
			dto.setFrom(a.getAvailableFrom());
			dto.setTo(a.getAvailableTo());
			dto.setPrice(a.getPrice());
			dto.setDiscountPrice(a.getDicountPrice());
			dto.setMaxPeople(a.getMaxPeople());
			dto.setResourceName(a.getResource().getName());
			dto.setResourceType(a.getResource().getClass().getSimpleName());
			return  dto;
			
		}).toList();
		
	}


	@Override
	public void makeFastReservation(Long id) {
		
		Client client = authService.getLoggedInUser();
		
		
		AvailabilityPeriod ap = availabilityRepo.findById(id).orElseThrow();
		
		boolean alreadyBooked = reservationRepo.existsByClientAndStartDateTimeLessThanAndEndDateTimeGreaterThan(client,ap.getAvailableTo(),
			        ap.getAvailableFrom());

			if (alreadyBooked) {
			    throw new RuntimeException("You already have a reservation in this period!");
			}
		
		if(ap.isReserved()== true) {
			throw new RuntimeException("Already reserved!");
			
		}
		
		Reservation reservation = new Reservation();
		reservation.setClient(client);
		reservation.setStartDateTime(ap.getAvailableFrom());
		reservation.setEndDateTime(ap.getAvailableTo());
		reservation.setPrice(ap.getDicountPrice());
		reservation.setMaxNumPeople(ap.getMaxPeople());
		reservation.setResource(ap.getResource());
		reservation.setStatus(ReservationStatus.CREATED);
		
		ap.setReserved(true);
		
		reservationRepo.save(reservation);
		availabilityRepo.save(ap);
		
		emailService.sendReservationConfimationMail(reservation);
		
	} 

}
