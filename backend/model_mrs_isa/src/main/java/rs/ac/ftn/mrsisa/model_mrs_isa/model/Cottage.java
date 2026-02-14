package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cottage  extends ReservableResource{
	
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private CottageOwner owner;
	
	public Cottage() {}

	public CottageOwner getOwner() {
		return owner;
	}

	public void setOwner(CottageOwner owner) {
		this.owner = owner;
	}
	
	
	
	

}
