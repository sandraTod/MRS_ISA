package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

public class ComplaintDTO {
	
	private Long id;
    private String text;
    private String response;
    private String type;
    private Long targetId;
    private boolean responded;
    
    
    
   public ComplaintDTO(){}
   
   public ComplaintDTO(Long id, String text, String response, String type, Long targetId, boolean responded) {
	   
	   this.id = id;
	   this.text = text;
	   this.response = response;
	   this.type = type;
	   this.targetId = targetId;
	   this.responded = responded;
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

	public boolean isResponded() {
		return responded;
	}

	public void setResponded(boolean responded) {
		this.responded = responded;
	}
    
	
    

}
