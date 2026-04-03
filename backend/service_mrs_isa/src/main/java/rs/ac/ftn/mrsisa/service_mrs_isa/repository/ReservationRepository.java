package rs.ac.ftn.mrsisa.service_mrs_isa.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.ftn.mrsisa.model_mrs_isa.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	@Query("""
		    SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END
		    FROM Reservation r
		    WHERE r.resource.id = :resourceId
		    AND (
		        r.startDateTime < :endDateTime AND
		        r.endDateTime > :startDateTime
		    )
		    """)
		    boolean existsOverlapping(LocalDateTime startDateTime, LocalDateTime endDateTime, Long resourceId);
	
	
}


