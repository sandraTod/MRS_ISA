package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class CottageOwner extends User {
	
	
	@OneToMany(mappedBy = "owner")
	private Set<Cottage> cottages = new HashSet<>();
	
	public CottageOwner() {}


	public Set<Cottage> getCottages() {
		return cottages;
	}

	public void setCottages(Set<Cottage> cottages) {
		this.cottages = cottages;
	}
	
	

}
