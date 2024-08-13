package com.sandy.bingo.services.impl;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.dto.SongDTO;
import com.sandy.bingo.model.domain.Song;
import com.sandy.bingo.model.dto.request.SongDTORequest;
import com.sandy.bingo.model.mapper.SongDTOMapper;
import com.sandy.bingo.model.mapper.impl.SongDTOMapperImpl;
import com.sandy.bingo.repository.SongRepository;
import com.sandy.bingo.services.SongService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final SongDTOMapper songMapper = new SongDTOMapperImpl();

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void createSong(SongDTORequest songDTORequest, Game game) {
        Song song = songMapper.map(songDTORequest, game);
        songRepository.save(song);
    }

    @Override
    public void updateSong(Integer id, SongDTORequest songDTORequest) {
        Song song = getSong(id);
        song.updateFromDTORequest(songDTORequest);
        songRepository.save(song);
    }

    @Override
    public List<SongDTO> getAllSongsGame(Game game) {
        List<Song> songList= songRepository.findByGame(game);
        if(songList.isEmpty()){
            throw new EntityNotFoundException();
        }
        List<SongDTO> songDTOList = new ArrayList<>();
        songList.forEach(song -> songDTOList.add(songMapper.map(song)));
        return songDTOList;
    }

    @Override
    public void deleteSong(Integer id) {
        songRepository.deleteById(id);
    }

    private Song getSong(Integer id){
        Optional<Song> song = songRepository.findById(id);
        if(song.isEmpty()){
            throw new EntityNotFoundException();
        }
        else{
            return song.get();
        }
    }
}
