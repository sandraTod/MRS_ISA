package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.AvailabilityPeriod;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FastReservationDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.AvailabilityRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AvailabilityService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
	
	@Autowired
	AvailabilityRepository availabilityRepo;

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

}
