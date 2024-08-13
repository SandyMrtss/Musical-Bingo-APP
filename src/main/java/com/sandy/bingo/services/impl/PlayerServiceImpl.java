package com.sandy.bingo.services.impl;

import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;
import com.sandy.bingo.model.mapper.PlayerDTOMapper;
import com.sandy.bingo.model.mapper.impl.PlayerDTOMapperImpl;
import com.sandy.bingo.repository.PlayerRepository;
import com.sandy.bingo.services.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerDTOMapper playerMapper = new PlayerDTOMapperImpl();

    public PlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDTO createPlayer(PlayerDTORequest playerDTORequest) {
        Player player = playerMapper.map(playerDTORequest);
        return playerMapper.map(playerRepository.save(player));
    }

    @Override
    public PlayerDTO updatePlayer(Integer id, PlayerDTORequest playerDTORequest) {
        Player player = getPlayer(id);
        player.updateFromDTORequest(playerDTORequest);
        return playerMapper.map(playerRepository.save(player));
    }
    @Override
    public PlayerDTO getPlayerDTO(Integer id) {
        return playerMapper.map(getPlayer(id));
    }

    @Override
    public List<PlayerDTO> getAllPLayersDTO() {
        List<Player> playersList = playerRepository.findAll();
        if(playersList.isEmpty()){
            throw new EntityNotFoundException();
        }
        List<PlayerDTO> playersDTOList = new ArrayList<>();
        playersList.forEach(player -> playersDTOList.add(playerMapper.map(player)));
        return playersDTOList;
    }

    @Override
    public PlayerDTO deletePlayer(Integer id) {
        Player player = getPlayer(id);
        playerRepository.delete(player);
        return playerMapper.map(player);
    }

    @Override
    public Player getPlayer(Integer id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isEmpty()){
            throw new EntityNotFoundException();
        }
        return player.get();
    }

}
