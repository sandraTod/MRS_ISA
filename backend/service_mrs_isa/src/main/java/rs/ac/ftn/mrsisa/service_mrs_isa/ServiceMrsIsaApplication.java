package rs.ac.ftn.mrsisa.service_mrs_isa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"rs.ac.ftn.mrsisa.model_mrs_isa.model"})
public class ServiceMrsIsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMrsIsaApplication.class, args);
	}

}
