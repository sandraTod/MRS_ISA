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
	
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private CottageOwner owner;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "cottage_images", joinColumns = @JoinColumn(name = "cottage_id"))
	@Column(name = "image_url")
	private Set<String> imageUrls;
	
	public Cottage() {}

	public CottageOwner getOwner() {
		return owner;
	}

	public void setOwner(CottageOwner owner) {
		this.owner = owner;
	}
	
	
	
	

}
