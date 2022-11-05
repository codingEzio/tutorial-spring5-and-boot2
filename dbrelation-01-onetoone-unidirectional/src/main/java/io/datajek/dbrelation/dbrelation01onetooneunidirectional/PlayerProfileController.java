package io.datajek.dbrelation.dbrelation01onetooneunidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class PlayerProfileController {
	@Autowired
	PlayerProfileService playerProfileService;

	@GetMapping
	public List<PlayerProfile> getAllPlayers() {
		return playerProfileService.allPlayerProfiles();
	}

	@GetMapping("/{id}")
	public PlayerProfile getPlayerProfile(@PathVariable int id) {
		return playerProfileService.getPlayerProfile(id);
	}

	@PostMapping
	public PlayerProfile addPlayerProfile(@RequestBody PlayerProfile playerProfile) {
		return playerProfileService.addPlayerProfile(playerProfile);
	}

	@DeleteMapping("/{id}")
	public void deletePlayerProfile(@PathVariable int id) {
		playerProfileService.deletePlayerProfile(id);
	}
}