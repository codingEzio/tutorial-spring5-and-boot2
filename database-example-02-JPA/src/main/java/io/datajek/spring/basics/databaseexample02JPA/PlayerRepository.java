package io.datajek.spring.basics.databaseexample02JPA;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PlayerRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Player insertPlayer(Player player) {
		return entityManager.merge(player);
	}

	public Player updatePlayer(Player player) {
		return entityManager.merge(player);
	}

	public Player getPlayerById(int id) {
		return entityManager.find(Player.class, id);
	}

	public void deleteById(int id ) {
		Player player = entityManager.find(Player.class, id);

		entityManager.remove(player);
	}
}