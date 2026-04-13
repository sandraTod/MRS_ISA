package rs.ac.ftn.mrsisa.service_mrs_isa.service;

public interface SubscriptionService {
	
	public void subscribe(String type, Long id);
	
	public void unsubscribe(String type, Long id);

}
