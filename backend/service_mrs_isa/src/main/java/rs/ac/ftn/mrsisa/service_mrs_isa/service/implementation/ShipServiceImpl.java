package rs.ac.ftn.mrsisa.service_mrs_isa.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Ship;
import rs.ac.ftn.mrsisa.service_mrs_isa.repository.ShipRepository;
import rs.ac.ftn.mrsisa.service_mrs_isa.service.ShipService;

@Service
public class ShipServiceImpl implements ShipService {
	
	
	@Autowired
	ShipRepository shipRepository;

	@Override
	public Collection<Ship> getAll() {
		// TODO Auto-generated method stub
		return  shipRepository.findAll();
	}

}
