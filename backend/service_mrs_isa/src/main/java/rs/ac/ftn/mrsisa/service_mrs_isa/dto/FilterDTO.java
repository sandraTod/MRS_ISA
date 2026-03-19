package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

public class FilterDTO {
	
	private String name;
	
	private String city;
	
	private int minGrade;
	
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

	public int getMinGrade() {
		return minGrade;
	}

	public void setMinGrade(int minGrade) {
		this.minGrade = minGrade;
	}
	
	
	

}
