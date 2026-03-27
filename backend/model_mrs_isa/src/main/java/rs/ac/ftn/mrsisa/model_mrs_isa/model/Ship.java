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
	
	@Column(name = "ship_type", nullable = false)
	private String shipType;
	
	@Column(name = "ship_length", nullable = false)
	private String shipLength;
	
	@Column(nullable = false)
	private String engineNum;
	
	@Column(nullable = false)
	private String enginePower;
	
	@Column(nullable = false)
	private String maxSpeed;
	
	@Column(nullable = false)
	private int maxCapacity;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "ship_navg_equipment", joinColumns = @JoinColumn(name = "resource_id"))
	@Column(name = "equipment")
	private Set<String>navigation_equipment;
	

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "ship_fish_equip", joinColumns = @JoinColumn(name = "resource_id"))
	@Column(name = "fishing_equip")
	private Set<String> fishing_equipment;
	
	@ManyToOne()
	@JoinColumn(name = "owner_id")
	private ShipOwner owner;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "ship_images", joinColumns = @JoinColumn(name = "ship_id"))
	@Column(name = "image_url")
	private Set<String> imageUrls;
	
	
	
	public Ship() {}
	

	public String getShipType() {
		return shipType;
	}


	public void setShipType(String shipType) {
		this.shipType = shipType;
	}


	public String getShipLength() {
		return shipLength;
	}


	public void setShipLength(String shipLength) {
		this.shipLength = shipLength;
	}


	public String getEngineNum() {
		return engineNum;
	}


	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}


	public String getEnginePower() {
		return enginePower;
	}


	public void setEnginePower(String enginePower) {
		this.enginePower = enginePower;
	}


	public String getMaxSpeed() {
		return maxSpeed;
	}


	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public int getMaxCapacity() {
		return maxCapacity;
	}


	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}


	public Set<String> getNavigation_equipment() {
		return navigation_equipment;
	}



	public void setNavigation_equipment(Set<String> navigation_equipment) {
		this.navigation_equipment = navigation_equipment;
	}



	public Set<String> getFishing_equipment() {
		return fishing_equipment;
	}



	public void setFishing_equipment(Set<String> fishing_equipment) {
		this.fishing_equipment = fishing_equipment;
	}


	public Set<String> getImageUrls() {
		return imageUrls;
	}


	public void setImageUrls(Set<String> imageUrls) {
		this.imageUrls = imageUrls;
	}


	public ShipOwner getOwner() {
		return owner;
	}

	public void setOwner(ShipOwner owner) {
		this.owner = owner;
	}


	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return this.maxCapacity;
	}
	
	
	
	

}
