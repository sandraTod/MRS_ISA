package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Adventure extends ReservableResource {
	
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private FishingInstructor instructor;
	
	public Adventure() {}
	
	

	public FishingInstructor getInstructor() {
		return instructor;
	}

	public void setInstructor(FishingInstructor instructor) {
		this.instructor = instructor;
	}
	
	
	
	

}
