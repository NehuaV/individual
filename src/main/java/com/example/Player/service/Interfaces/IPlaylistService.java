package com.example.Player.service.Interfaces;

import com.example.Player.dto.PlaylistDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.User;

import java.util.List;

public interface IPlaylistService {
    Playlist getById(Long Id);
    Playlist saveAndFlush(Playlist playlist);
    String deleteById(Long id);

    List<PlaylistDTO> getAllByUser(User user);
}
