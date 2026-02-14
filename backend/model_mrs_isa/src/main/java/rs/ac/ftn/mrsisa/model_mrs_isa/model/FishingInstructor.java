package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class FishingInstructor extends User {
	
	@OneToMany(mappedBy = "instructor")
	private Set <Adventure> adventures = new HashSet<>();
	
	public FishingInstructor() {}

	
	
	
	public Set<Adventure> getAdventures() {
		return adventures;
	}

	public void setAdventures(Set<Adventure> adventures) {
		this.adventures = adventures;
	}
	
	
	
	
	
	
	

}
