package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Cottage;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.CottageRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.CottageService;

@Service
public class CottageServiceImpl implements CottageService {
	
	@Autowired
	CottageRepository cottageRepository;

	@Override
	public Collection<Cottage> getAll() {
		// TODO Auto-generated method stub
		return cottageRepository.findAll();
	}

}
