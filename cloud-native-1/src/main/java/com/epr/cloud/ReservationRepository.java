package com.epr.cloud;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Repo is what enables the app to perform CRUD operations.
 * 
 * Want to make this a Rest API, using spring-boot-starter-data-rest
 * 
 * Database is H2, that's included in the classpath
 * 
 * Use the REST API to see the reservations. To do that open a browser:
 * http://localhost:8010/reservations
 * 
 * Note the 8010 port number set in application.properties file
 * 
 * Reservations will be shown in JSON format using HATEOAS
 * 
 * @author developer
 *
 */
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@RestResource(path = "by-name")
	Collection<Reservation> findByReservationName(@Param("rn") String rn);
}
