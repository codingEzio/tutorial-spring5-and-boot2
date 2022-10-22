package io.datajek.spring.basics.databaseexample02JPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class DatabaseExample02JpaApplication implements CommandLineRunner {

	@Autowired
	PlayerRepository playerRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DatabaseExample02JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		playerRepository.insertPlayer(new Player(
				"Djokovic",
				"Serbia",
				Date.valueOf("1987-05-22"),
				81
		));
		playerRepository.insertPlayer(new Player(
				"Thiem",
				"Austria",
				new Date(System.currentTimeMillis()),
				17
		));

		playerRepository.updatePlayer(new Player(
				2,
				"Thiem",
				"Austria",
				Date.valueOf("1993-09-03"),
				17
		));

		playerRepository.deleteById(2);

		playerRepository.getPlayerById(1);
	}
}