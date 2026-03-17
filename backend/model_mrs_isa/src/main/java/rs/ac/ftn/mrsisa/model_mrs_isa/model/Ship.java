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
public class Ship extends ReservableResource {
	
	@ManyToOne()
	@JoinColumn(name = "owner_id")
	private ShipOwner owner;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "ship_images", joinColumns = @JoinColumn(name = "ship_id"))
	@Column(name = "image_url")
	private Set<String> imageUrls;
	
	public Ship() {}
	
	

	public ShipOwner getOwner() {
		return owner;
	}

	public void setOwner(ShipOwner owner) {
		this.owner = owner;
	}
	
	

}
