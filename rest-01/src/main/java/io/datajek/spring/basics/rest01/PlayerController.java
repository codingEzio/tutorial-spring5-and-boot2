package io.datajek.spring.basics.rest01;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/welcome")
    public String welcome() {
        return "This is Houston.";
    }

    @GetMapping("/players")
    public List<Player> allPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        player.setId(0);

        return playerService.addPlayer(player);
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    @PatchMapping("/players/{id}")
    public Player partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> playerPatch) {
        return playerService.patch(id, playerPatch);
    }

    // Beware of the last line (it's an Integer)
    //  Some API testing software would add an extra pair of double quotes,
    //  which would turn the data into a String, then errors would be raised
    // curl -X "PATCH" "http://localhost:8080/players/1/titles" \
    //      -H 'Content-Type: application/json; charset=utf-8' \
    //      -d 21
    @PatchMapping("/players/{id}/titles")
    public void updateTitles(@PathVariable int id, @RequestBody int titles) {
        playerService.updateTitles(id, titles);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }
}