package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
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
	private String address;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private double pricePerDay;
	
	@Column(nullable = false)
	private double avgGrade;
	
	@OneToMany(mappedBy = "resource")
	private Set<Reservation> reservations = new HashSet<>();
	
	@OneToMany(mappedBy = "resource")
	private Set<AvailabilityPeriod> availablePeriods =  new HashSet<>();
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "resource_rules", joinColumns = @JoinColumn(name = "resource_id"))
	@Column(name = "rule")
	private Set<String> rules;
	
	@Column(length = 1000)
	private String additionalServices;
	
	@Column()
	private String cancellationCondition;
	
	
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
	
	

	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getAvgGrade() {
		return avgGrade;
	}



	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}



	public Set<String> getRules() {
		return rules;
	}



	public void setRules(Set<String> rules) {
		this.rules = rules;
	}



	public String getAdditionalServices() {
		return additionalServices;
	}



	public void setAdditionalServices(String additionalServices) {
		this.additionalServices = additionalServices;
	}



	public String getCencellationCondition() {
		return cancellationCondition;
	}



	public void setCencellationCondition(String cencellationCondition) {
		this.cancellationCondition = cencellationCondition;
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
