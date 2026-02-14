package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class ShipOwner extends User {
	
	@OneToMany(mappedBy= "owner")
	private Set<Ship> ships = new HashSet<>();
	
	public ShipOwner() {}

	
	
	public Set<Ship> getShips() {
		return ships;
	}

	public void setShips(Set<Ship> ships) {
		this.ships = ships;
	}
	
	
	
	
	
	

}
