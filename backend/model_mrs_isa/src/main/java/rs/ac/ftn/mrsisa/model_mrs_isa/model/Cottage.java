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
public class Cottage  extends ReservableResource{
	
	@Column(nullable = false)
	private int numOfRooms;
	
	@Column(nullable = false)
	private int numOfBeds;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private CottageOwner owner;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "cottage_images", joinColumns = @JoinColumn(name = "cottage_id"))
	@Column(name = "image_url")
	private Set<String> imageUrls;
	
	public Cottage() {}
	
	

	public int getNumOfRooms() {
		return numOfRooms;
	}

	public void setNumOfRooms(int numOfRooms) {
		this.numOfRooms = numOfRooms;
	}



	public int getNumOfBeds() {
		return numOfBeds;
	}



	public void setNumOfBeds(int numOfBeds) {
		this.numOfBeds = numOfBeds;
	}



	public Set<String> getImageUrls() {
		return imageUrls;
	}



	public void setImageUrls(Set<String> imageUrls) {
		this.imageUrls = imageUrls;
	}



	public CottageOwner getOwner() {
		return owner;
	}

	public void setOwner(CottageOwner owner) {
		this.owner = owner;
	}
	
	
	
	

}
