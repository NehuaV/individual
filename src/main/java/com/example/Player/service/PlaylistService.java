package com.example.Player.service;

import com.example.Player.dalinterfaces.IPlaylistDAL;
import com.example.Player.dto.PlaylistDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.User;
import com.example.Player.service.Interfaces.IPlaylistService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
    public Playlist getById(Long Id) {
        return dal.getById(Id);
    }

    @Override
    public Playlist getPlaylistByName(String name) {
        return dal.getPlaylistByName(name);
    }

    @Override
    public Playlist saveAndFlush(Playlist playlist) {
        return dal.saveAndFlush(playlist);
    }

    @Override
    public List<PlaylistDTO> getAllByUser(User user) {
        return dal.getAllByUser(user)
                .stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlaylistDTO> getAllPlaylistsDTO() {
        return dal.GetAllPlaylist()
                .stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            dal.deleteById(id);
            jsonObject.put("message", "Playlist has been deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    private PlaylistDTO EntityToDTO(Playlist playlist){
        PlaylistDTO playlistDTO = modelMapper.map(playlist, PlaylistDTO.class);
        return playlistDTO;
    }
}
