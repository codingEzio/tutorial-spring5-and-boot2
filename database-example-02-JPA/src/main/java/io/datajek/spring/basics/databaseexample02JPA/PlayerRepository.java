package io.datajek.spring.basics.databaseexample02JPA;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

	public List<Player> getPlayerByTitles(int titles) {
		TypedQuery<Player> getByTitles = entityManager.createNamedQuery(
				"get_player_by_titles",
				Player.class
		);

		getByTitles.setParameter("titles", titles);

		return getByTitles.getResultList();
	}

	public List<Player> getAllPlayers() {
		TypedQuery<Player> getAll = entityManager.createNamedQuery(
				"get_all_players",
				Player.class
		);

		return getAll.getResultList();
	}

	public void deleteById(int id ) {
		Player player = entityManager.find(Player.class, id);

		entityManager.remove(player);
	}
}