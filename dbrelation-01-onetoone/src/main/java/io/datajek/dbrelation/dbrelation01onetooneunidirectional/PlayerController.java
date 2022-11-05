package io.datajek.dbrelation.dbrelation01onetooneunidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@Autowired
	PlayerProfileService playerProfileService;

	@GetMapping
	public List<Player> allPlayers() {
		return playerService.allPlayers();
	}

	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable int id) {
		return playerService.getPlayer(id);
	}

	@PostMapping
	public Player addPlayer(@RequestBody Player player) {
		return playerService.addPlayer(player);
	}

	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable int id) {
		playerService.deletePlayer(id);
	}

	@PutMapping("/{id}/profiles/{profile_id}")
	public Player assignDetail(@PathVariable int id, @PathVariable int profile_id) {
		PlayerProfile playerProfile = playerProfileService.getPlayerProfile(profile_id);
		System.out.println(playerProfile);

		return playerService.assignProfile(id, playerProfile);
	}
}