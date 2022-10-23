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
        Optional<Player> player = playerRepository.findById(id);

        if (player.isEmpty()) {
            throw new PlayerNotFoundException("Player with id " + id + " does not exist for updating!");
        }

        newPlayer.setId(id);
        return playerRepository.save(newPlayer);
    }

    public Player patch(int id, Map<String, Object> partialPlayer) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isPresent()) {
            partialPlayer.forEach((key, value) -> {
                System.out.println("[KEY] " + key + " [VALUE]: " + value);

                Field field = ReflectionUtils.findField(Player.class, key);

                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, player.get(), value);
            });
        } else {
            throw new PlayerNotFoundException("Player with id " + id + " does not exist for patching!");
        }

        return playerRepository.save(player.get());
    }

    @Transactional
    public void updateTitles(int id, int titles) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isEmpty()) {
            throw new PlayerNotFoundException("Player with id " + id + " does not exist for updating titles!");
        }

        playerRepository.updateTitles(id, titles);
    }

    public void deletePlayer(int id) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isEmpty()) {
            throw new PlayerNotFoundException("Player with id " + id + " does not exist for deletion!");
        }

        playerRepository.delete(player.get());
    }
}