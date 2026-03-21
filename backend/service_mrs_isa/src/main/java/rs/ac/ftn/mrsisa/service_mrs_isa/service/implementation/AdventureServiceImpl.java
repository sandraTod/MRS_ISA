package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Adventure;
import rs.ac.ftn.mrsisa.service_mrs_isa.dto.FilterDTO;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.AdventureRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.AdventureService;

@Service
public class AdventureServiceImpl implements AdventureService{
	
	@Autowired
	AdventureRepository adventureRepository;

	@Override
	public Collection<Adventure> getAll() {
		// TODO Auto-generated method stub
		return adventureRepository.findAll();
	}

	@Override
	public Collection<Adventure> filter(FilterDTO parameters) {
		Collection<Adventure> adventures = adventureRepository.findAll();
		
		return adventures.stream()
		        .filter(a -> parameters.getName() == null || a.getName().toLowerCase().contains(parameters.getName().toLowerCase()))
		        .filter(a -> parameters.getCity() == null || a.getCity().equalsIgnoreCase(parameters.getCity()))
		        .filter(a -> parameters.getMinGrade() == 0 || a.getAvgGrade() >= parameters.getMinGrade()) 
		        .toList();
	}
	
	

}
