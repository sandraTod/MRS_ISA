package rs.ac.ftn.mrsisa.service_mrs_isa.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.AvailabilityPeriod;

public interface AvailabilityRepository extends JpaRepository<AvailabilityPeriod, Long> {
	
	@Query("""
			SELECT a FROM AvailabilityPeriod a
			WHERE a.resource.id = :resourceId
			AND a.availableFrom <= :start
			AND a.availableTo >= :end
			""")
			Optional<AvailabilityPeriod> findCoveringAvailability(LocalDateTime start, LocalDateTime end,Long resourceId);
	
	@Query("""
			SELECT a FROM AvailabilityPeriod a
			WHERE a.isFastReservation = true
			AND a.isReserved = false
			AND TYPE(a.resource) = :type
			""")
	Collection<AvailabilityPeriod> findByResourceType(Class<?> type);

}
