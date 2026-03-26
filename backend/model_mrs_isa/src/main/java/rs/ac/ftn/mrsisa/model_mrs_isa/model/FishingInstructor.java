package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class FishingInstructor extends User {
	
	@Column(nullable = false)
	private String instructorBio;
	
	@JsonIgnore
	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Adventure> adventures = new HashSet<>();
	
	public FishingInstructor() {}
	
		
	
	public String getInstructorBio() {
		return instructorBio;
	}



	public void setInstructorBio(String instructorBio) {
		this.instructorBio = instructorBio;
	}


	public Set<Adventure> getAdventures() {
		return adventures;
	}

	public void setAdventures(Set<Adventure> adventures) {
		this.adventures = adventures;
	}
	
	
	
	
	
	
	

}
