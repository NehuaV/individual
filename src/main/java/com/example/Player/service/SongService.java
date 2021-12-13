package com.example.Player.service;

import com.example.Player.dto.SongDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.Song;
import com.example.Player.dalinterfaces.ISongDAL;
import com.example.Player.repository.ISongRepo;
import com.example.Player.service.Interfaces.ISongService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService implements ISongService {

    ISongDAL dal;

    @Autowired
    public SongService(ISongDAL dal) {
        this.dal = dal;
    }

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<SongDTO> getAllSongs() {
        return dal.GetAllSongs()
                .stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Song getSongByTitle(String title) {
        return dal.getSongByTitle(title);
    }

    @Override
    public void addSong(Song song) {
        dal.addSong(song);
    }

    @Override
    public List<Song> getAllByPlaylist(Playlist playlist) {
        return dal.GetAllByPlaylist(playlist);
    }

    @Override
    public List<SongDTO> getAllByPlaylistDTO(Playlist playlist) {
        return dal.GetAllByPlaylist(playlist)
                .stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
    }

    private SongDTO EntityToDTO(Song song) {
        SongDTO songDTO = modelMapper.map(song, SongDTO.class);
        return songDTO;
    }
}
