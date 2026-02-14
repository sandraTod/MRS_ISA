package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ship extends ReservableResource {
	
	@ManyToOne()
	@JoinColumn(name = "owner_id")
	private ShipOwner owner;
	
	public Ship() {}
	
	

	public ShipOwner getOwner() {
		return owner;
	}

	public void setOwner(ShipOwner owner) {
		this.owner = owner;
	}
	
	

}
