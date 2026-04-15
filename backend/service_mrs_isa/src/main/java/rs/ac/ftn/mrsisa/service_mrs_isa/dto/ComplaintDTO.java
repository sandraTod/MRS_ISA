package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

public class ComplaintDTO {
	
	public Long id;
    public String text;
    public String response;
    public String type;
    public Long targetId;
    
    
    
    ComplaintDTO(){}
    

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}
    
    

}
