package rs.ac.ftn.mrsisa.service_mrs_isa.service;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.ReservableResource;

public interface SubscriptionService {
	
	public void subscribe(String type, Long id);
	
	public void unsubscribe(String type, Long id);
	
	public void notifySubscribers (ReservableResource resource, String type);

}
