package com.epr.cloud;


import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CloudNative1Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudNative1Application.class, args);
	}

	@Component
	class SampleDataCreator implements CommandLineRunner {

		private final ReservationRepository reservationRepo;

		@Autowired
		public SampleDataCreator(ReservationRepository reservationRepo) {
			this.reservationRepo = reservationRepo;
		}

		@Override
		public void run(String... args) throws Exception {
			Stream.of("John", "lyndon", "Richard", "Gerald", "Jimmy", "Ronald", "George", "Bill", "George", "Barack",
					"Donald").forEach(name -> reservationRepo.save(new Reservation(name)));
			reservationRepo.findAll().forEach(System.out::println);
		}

	}
}
