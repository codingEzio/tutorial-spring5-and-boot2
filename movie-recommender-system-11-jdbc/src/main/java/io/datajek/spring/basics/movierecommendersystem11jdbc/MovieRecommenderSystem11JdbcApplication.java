package io.datajek.spring.basics.movierecommendersystem11jdbc;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderSystem11JdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// The concepts being mentioned were JDBC, Database, DAO (Data Access Object)
	// and the RowMapper. I'll try to explain the relations between them.

	// 1. User [request] the [data] stored in the [Database]
	// 2. The Request was forwarded to [JDBC]
	// 3. [JDBC] makes the actual request to the [Database]
	// 4. [Database] returns the [data [IMPURE Java Object]] to [JDBC]
	// 5. [JDBC] forward the [returned data] to [Row Mapper]
	// 6. [Row Mapper] transforms the [returned data] into [[PURE] Java Object]
	// 7. [JDBC] forward the [transformed data] from [RowMapper] back to User

	@Autowired
	PlayerDao playerDao;

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommenderSystem11JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(
				"Insert Player 4: {}",
				playerDao.insertPlayer(new Player(
						4,
						"Thor",
						"Austria",
						new Date(System.currentTimeMillis()),
						17)));
		logger.info(
				"Update Player 4: {}",
				playerDao.updatePlayer(new Player(
						4,
						"God of Thunder",
						"Australia",
						Date.valueOf("1972-11-23"),
						39)));

		logger.info("All Players Data: {}", playerDao.getPlayer(4));
		logger.info("All Players Data: {}", playerDao.getAllPlayers());
	}
}