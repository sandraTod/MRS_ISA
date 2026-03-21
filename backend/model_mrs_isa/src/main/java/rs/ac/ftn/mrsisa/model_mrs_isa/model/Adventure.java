package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Adventure extends ReservableResource {
	
	
	@Column(nullable = false)
	private int maxNumPeople;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "adventure_fish_equip", joinColumns = @JoinColumn(name = "resource_id"))
	@Column(name = "adventure_fishing_equip")
	private Set<String> fishing_equipment;
	
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private FishingInstructor instructor;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "adventure_images", joinColumns = @JoinColumn(name = "adventure_id"))
	@Column(name = "image_url")
	private Set<String> imageUrls;
	
	public Adventure() {}
	
	

	public FishingInstructor getInstructor() {
		return instructor;
	}

	public void setInstructor(FishingInstructor instructor) {
		this.instructor = instructor;
	}
	
	
	
	

}
