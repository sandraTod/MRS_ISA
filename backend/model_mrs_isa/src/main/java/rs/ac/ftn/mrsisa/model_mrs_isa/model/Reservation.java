package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime startDateTime;
	
	@Column(nullable = false)
	private LocalDateTime endDateTime;
	
	@Column(nullable = false)
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;
	
	@ManyToOne
	@JoinColumn(name = "resource_id")
	private ReservableResource resource;
	
	
	
	public Reservation() {}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}


	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}


	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}


	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public ReservationStatus getStatus() {
		return status;
	}


	public void setStatus(ReservationStatus status) {
		this.status = status;
	}


	public ReservableResource getResource() {
		return resource;
	}


	public void setResource(ReservableResource resource) {
		this.resource = resource;
	}
	
	
	
	

}
