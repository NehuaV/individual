package com.example.Player.service;

import com.example.Player.dto.PlaylistDTO;
import com.example.Player.dto.SongDTO;
import com.example.Player.model.Playlist;
import com.example.Player.dalinterfaces.IPlaylistDAL;
import com.example.Player.model.Song;
import com.example.Player.service.Interfaces.IPlaylistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService implements IPlaylistService {

    IPlaylistDAL dal;
    @Autowired
    public PlaylistService(IPlaylistDAL dal) {
        this.dal = dal;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PlaylistDTO> getAllPlaylists() {
        return dal.GetAllPlaylist()
                .stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Playlist getPlaylistByName(String name) {
        return dal.getPlaylistByName(name);
    }

    @Override
    public void addPlaylist(Playlist playlist) {
        dal.addPlaylist(playlist);
    }

    private PlaylistDTO EntityToDTO(Playlist playlist){
        PlaylistDTO playlistDTO = modelMapper.map(playlist, PlaylistDTO.class);
        return playlistDTO;
    }
}