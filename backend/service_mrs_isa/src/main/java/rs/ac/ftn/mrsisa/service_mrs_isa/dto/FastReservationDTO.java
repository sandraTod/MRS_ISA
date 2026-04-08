package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

import java.time.LocalDateTime;

public class FastReservationDTO {
	
	
	private Long id;
	
	private LocalDateTime from;
	
	private LocalDateTime to;
	
	private double price;
	
	private double discountPrice;
	
	private int maxPeople;
	
	private String resourceName;
	
	private String resourceType;
	
	
	
	public FastReservationDTO() {}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFrom() {
		return from;
	}

	public void setFrom(LocalDateTime from) {
		this.from = from;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		this.to = to;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	

	public int getMaxPeople() {
		return maxPeople;
	}


	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}


	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
	
	
	

}
