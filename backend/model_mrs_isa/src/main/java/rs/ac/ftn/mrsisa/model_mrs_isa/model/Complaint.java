package rs.ac.ftn.mrsisa.model_mrs_isa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column
    private String response;

    @Column(nullable = false)
    private String type; 
    // COTTAGE, SHIP, ADVENTURE, COTTAGE_OWNER, SHIP_OWNER, INSTRUCTOR

    @Column(nullable = false)
    private Long targetId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column
    private boolean responded;

    
    public Complaint() {}


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


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public boolean isResponded() {
		return responded;
	}


	public void setResponded(boolean responded) {
		this.responded = responded;
	}
    
    
    
    
    
    
}
