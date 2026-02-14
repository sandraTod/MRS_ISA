package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReservableResource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private double pricePerDay;
	
	@OneToMany(mappedBy = "resource")
	private Set<Reservation> reservations = new HashSet<>();
	
	@OneToMany(mappedBy = "resource")
	private Set<AvailabilityPeriod> availablePeriods =  new HashSet<>();
	
	
	public ReservableResource() {}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Set<AvailabilityPeriod> getAvailablePeriods() {
		return availablePeriods;
	}

	public void setAvailablePeriods(Set<AvailabilityPeriod> availablePeriods) {
		this.availablePeriods = availablePeriods;
	}
	
	
	
	
	
	

}
