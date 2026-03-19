package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

public class FilterDTO {
	
	private String name;
	
	private String city;
	
	private double minGrade;
	
	FilterDTO(){}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getMinGrade() {
		return minGrade;
	}

	public void setMinGrade(double minGrade) {
		this.minGrade = minGrade;
	}
	
	
	

}
