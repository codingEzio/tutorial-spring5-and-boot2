package io.datajek.spring.basics.rest01;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import io.datajek.spring.basics.rest01.exceptions.PlayerNotFoundException;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(int id) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isEmpty()) {
            throw new PlayerNotFoundException("Player with id " + id + " does not exist!");
        }

        return player.get();
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

    @Transactional
    public void updateTitles(int id, int titles) {
        playerRepository.updateTitles(id, titles);
    }

    public String deletePlayer(int id) {
        try {
            playerRepository.deleteById(id);
        } catch (Exception e) {
            return "Player with id " + id + " not found";
        }

        return "Deleted player with id: " + id;
    }
}
