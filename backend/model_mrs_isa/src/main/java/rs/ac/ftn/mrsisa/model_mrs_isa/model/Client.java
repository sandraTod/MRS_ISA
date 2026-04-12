package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends User {
	
	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reservation> reservations = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
		    name = "client_cottage_subscriptions",
		    joinColumns = @JoinColumn(name = "client_id"),
		    inverseJoinColumns = @JoinColumn(name = "cottage_id")
		)
	private Set<Cottage> subscribedCottages = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
		    name = "client_ship_subscriptions",
		    joinColumns = @JoinColumn(name = "client_id"),
		    inverseJoinColumns = @JoinColumn(name = "ship_id")
		)
	private Set<Ship> subscribedShips = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
		    name = "client_adventure_subscriptions",
		    joinColumns = @JoinColumn(name = "client_id"),
		    inverseJoinColumns = @JoinColumn(name = "adventure_id")
		)
	private Set<Adventure> subscribedAdventures = new HashSet<>();
	
	
	public Client() {}
	

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}


	public Set<Cottage> getSubscribedCottages() {
		return subscribedCottages;
	}


	public void setSubscribedCottages(Set<Cottage> subscribedCottages) {
		this.subscribedCottages = subscribedCottages;
	}


	public Set<Ship> getSubscribedShips() {
		return subscribedShips;
	}


	public void setSubscribedShips(Set<Ship> subscribedShips) {
		this.subscribedShips = subscribedShips;
	}


	public Set<Adventure> getSubscribedAdventures() {
		return subscribedAdventures;
	}


	public void setSubscribedAdventures(Set<Adventure> subscribedAdventures) {
		this.subscribedAdventures = subscribedAdventures;
	}
	
	
	
	
	

}
