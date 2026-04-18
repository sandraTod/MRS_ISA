package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DeletionRequest {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String text;

	    private String response;

	    @Enumerated(EnumType.STRING)
	    private RequestStatus status;

	    @ManyToOne
	    private User user;

	    
	    
	    public DeletionRequest() {}

	    public DeletionRequest(String text, User user) {
	        this.text = text;
	        this.user = user;
	        this.status = RequestStatus.PENDING;
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

		public RequestStatus getStatus() {
			return status;
		}

		public void setStatus(RequestStatus status) {
			this.status = status;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	    
	    
	    

}
