package io.datajek.spring.basics.rest01;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

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

    public Player patch(int id, Map<String, Object> playerPatch) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isPresent()) {
            playerPatch.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Player.class, key);

                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, player.get(), value);
            });
        }

        return playerRepository.save(player.get());
    }
}
