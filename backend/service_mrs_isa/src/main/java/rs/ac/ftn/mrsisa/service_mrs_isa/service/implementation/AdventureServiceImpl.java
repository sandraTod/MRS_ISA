package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Adventure;
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
	
	

}
