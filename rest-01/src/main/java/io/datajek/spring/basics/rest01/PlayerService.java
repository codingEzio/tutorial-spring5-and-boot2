package io.datajek.spring.basics.rest01;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(int id) {
        Optional<Player> player = playerRepository.findById(id);
        Player p = null;

        if (player.isPresent()) {
            p = player.get();
        }

        return p;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(int id, Player newPlayer) {
        Player player = playerRepository.getById(id);

        player.setName(newPlayer.getName());
        player.setNationality(newPlayer.getNationality());
        player.setBirthDate(newPlayer.getBirthDate());
        player.setTitles(newPlayer.getTitles());

        return playerRepository.save(player);
    }
}
