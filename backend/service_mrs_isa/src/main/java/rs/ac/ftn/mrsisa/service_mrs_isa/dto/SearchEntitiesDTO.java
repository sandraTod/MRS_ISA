package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

import java.time.LocalDateTime;

public class SearchEntitiesDTO {
	
	private LocalDateTime dateFrom;
	
	private LocalDateTime dateTo;
	
	private String entity;
	
	private int numOfPeople;
	
	private String city;
	
	public SearchEntitiesDTO(){}
	
		
	
	public LocalDateTime getDateFrom() {
		return dateFrom;
	}


	public void setDateFrom(LocalDateTime dateFrom) {
		this.dateFrom = dateFrom;
	}



	public LocalDateTime getDateTo() {
		return dateTo;
	}



	public void setDateTo(LocalDateTime dateTo) {
		this.dateTo = dateTo;
	}



	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}



	public int getNumOfPeople() {
		return numOfPeople;
	}



	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}
