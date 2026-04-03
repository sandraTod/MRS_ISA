package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends User {
	
	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reservation> reservations = new HashSet<>();
	
	public Client() {}
	

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	

}
