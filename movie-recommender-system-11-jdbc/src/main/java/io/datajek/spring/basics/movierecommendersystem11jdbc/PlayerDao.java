package io.datajek.spring.basics.movierecommendersystem11jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Player> getAllPlayers() {
		String sql = "SELECT * FROM PLAYER";

		return jdbcTemplate.query(
				sql,
				new BeanPropertyRowMapper<Player>(Player.class)
		);
	}

	public Player getPlayer(int id) {
		String sql = "SELECT * FROM PLAYER WHERE id = ?";

		return jdbcTemplate.queryForObject(
				sql,
				new BeanPropertyRowMapper<Player>(Player.class),
				new Object[] {id}
		);
	}
}