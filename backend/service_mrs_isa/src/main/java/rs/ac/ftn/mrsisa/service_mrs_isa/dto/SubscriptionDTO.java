package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

public class SubscriptionDTO {
	
	private Long id;
	
	private String name;
	
	private String type;
	
	private String address;
	
	private double rating;
	
	
	public SubscriptionDTO() {}
	
	 public SubscriptionDTO(Long id, String name, String type, String address, double rating) {
	        this.id = id;
	        this.name = name;
	        this.type = type;
	        this.address = address;
	        this.rating = rating;
	 }
	 
	 
	 

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	

}
