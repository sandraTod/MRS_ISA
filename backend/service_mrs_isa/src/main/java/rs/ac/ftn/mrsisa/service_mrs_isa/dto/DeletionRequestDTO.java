package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

public class DeletionRequestDTO {
	
	private Long id;
	
	private String text;
	
	private String response; 
	
	private String status;
	
	public DeletionRequestDTO() {}
	
	
	public DeletionRequestDTO(Long id, String text, String response, String status) {
		
		this.id = id;
		this.text = text;
		this.response = response;
		this.status = status;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
