package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AvailabilityPeriod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime avaibleFrom;
	
	@Column(nullable = false)
	private LocalDateTime avaibleTo;
	
	@ManyToOne
	@JoinColumn(name = "resource_id")
	private ReservableResource resource;
	
	public AvailabilityPeriod() {}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFrom() {
		return avaibleFrom;
	}

	public void setFrom(LocalDateTime avaibleFrom) {
		this.avaibleFrom = avaibleFrom;
	}

	public LocalDateTime getTo() {
		return avaibleTo;
	}

	public void setTo(LocalDateTime avaibleTo) {
		this.avaibleTo = avaibleTo;
	}

	public ReservableResource getResource() {
		return resource;
	}

	public void setResource(ReservableResource resource) {
		this.resource = resource;
	}
	
	
	

}
