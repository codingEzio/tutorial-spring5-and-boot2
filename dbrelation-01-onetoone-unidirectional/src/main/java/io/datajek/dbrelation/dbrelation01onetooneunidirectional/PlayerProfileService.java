package io.datajek.dbrelation.dbrelation01onetooneunidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileService {
	@Autowired
	PlayerProfileRepository playerProfileRepository;

	public List<PlayerProfile> allPlayerProfiles () {
		return playerProfileRepository.findAll();
	}

	public PlayerProfile getPlayerProfile (int id) {
		return playerProfileRepository.findById(id).get();
	}

	public PlayerProfile addPlayerProfile(PlayerProfile playerProfile) {
		playerProfile.setId(0);

		return playerProfileRepository.save(playerProfile);
	}

	public void deletePlayerProfile(int id) {
		playerProfileRepository.deleteById(id);
	}
}