package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class ReservationRequestDTO {
	
	private Long resourceId;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private int numOfPeople;
	
	private int maxNumPeople;
	
	private Set<String> selectedServices;
	
	public ReservationRequestDTO() {}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public int getMaxNumPeople() {
		return maxNumPeople;
	}

	public void setMaxNumPeople(int maxNumPeople) {
		this.maxNumPeople = maxNumPeople;
	}

	public Set<String> getSelectedServices() {
		return selectedServices;
	}

	public void setSelectedServices(Set<String> selectedServices) {
		this.selectedServices = selectedServices;
	}
	
	
	

}
