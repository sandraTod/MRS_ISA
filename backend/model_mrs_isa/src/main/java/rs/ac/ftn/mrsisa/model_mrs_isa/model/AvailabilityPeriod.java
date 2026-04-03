package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private LocalDateTime availableFrom;
	
	@Column(nullable = false)
	private LocalDateTime availableTo;
	
	@Column()
	private double price;
	
	@Column(nullable = false)
	private boolean isFastReservation;
	
	@Column
	private double discountPrice;
	
	@ManyToOne
	@JsonIgnore
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
		return availableFrom;
	}

	public void setFrom(LocalDateTime availableFrom) {
		this.availableFrom = availableFrom;
	}

	public LocalDateTime getTo() {
		return availableTo;
	}

	public void setTo(LocalDateTime avaibleTo) {
		this.availableTo = avaibleTo;
	}
	
	

	public LocalDateTime getAvailableFrom() {
		return availableFrom;
	}


	public void setAvailableFrom(LocalDateTime availableFrom) {
		this.availableFrom = availableFrom;
	}


	public LocalDateTime getAvailableTo() {
		return availableTo;
	}


	public void setAvailableTo(LocalDateTime availableTo) {
		this.availableTo = availableTo;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isFastReservation() {
		return isFastReservation;
	}


	public void setFastReservation(boolean isFastReservation) {
		this.isFastReservation = isFastReservation;
	}


	public double getDicountPrice() {
		return discountPrice;
	}


	public void setDicountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}


	public ReservableResource getResource() {
		return resource;
	}

	public void setResource(ReservableResource resource) {
		this.resource = resource;
	}
	
	
	

}
