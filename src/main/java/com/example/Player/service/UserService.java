package com.example.Player.service;

import com.example.Player.dalinterfaces.IPlaylistDAL;
import com.example.Player.dalinterfaces.IUserDAL;
import com.example.Player.dto.PlaylistDTO;
import com.example.Player.dto.UserDTO;
import com.example.Player.dto.UserProfileDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.User;
import com.example.Player.service.Interfaces.IUserService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    IUserDAL dal;
    @Autowired
    public UserService(IUserDAL dal){
        this.dal = dal;
    }

    @Autowired
    IPlaylistDAL playlistDAL;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Optional<User> findById(Long id) {
        return dal.findById(id);
    }

    @Override
    public User getUserByUsername(String Username){ return dal.getUserByUsername(Username);}

    @Override
    public UserDTO getByUsernameDTO(String username) {
        return EntityToDTO(dal.getUserByUsername(username));
    }

    @Override
    public User findUserByEmail(String email) {
        return dal.findUserByEmail(email);
    }

    @Override
    public User saveOrUpdate(User user) {
        return dal.SaveAndFlush(user);
    }

    @Override
    public UserProfileDTO getUserProfile(String username) {
        User user = dal.getUserByUsername(username);
        UserProfileDTO userDTO = EntityProfileToDTO(user);
        userDTO.setPlaylists(user.getPlaylist().stream().map(this::EntityPlaylistToDTO).collect(Collectors.toList()));
        return userDTO;
    }

    @Override
    public String deleteById(Long id) {
        JSONObject json = new JSONObject();
        try {
            dal.deleteById(id);
            json.put("message", "User deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    @Override
    public Collection<UserDTO> findAll() {
        return dal.findAll()
                .stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO EntityToDTO(User user){
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        return userDTO;
    }

    private PlaylistDTO EntityPlaylistToDTO(Playlist playlist){
        PlaylistDTO playlistDTO = modelMapper.map(playlist, PlaylistDTO.class);
        return playlistDTO;
    }

    private UserProfileDTO EntityProfileToDTO(User user){
        UserProfileDTO userDTO = modelMapper.map(user,UserProfileDTO.class);
        return userDTO;
    }
}
