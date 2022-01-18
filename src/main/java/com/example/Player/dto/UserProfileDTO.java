package com.example.Player.dto;

import com.example.Player.model.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.List;
@Data
@AllArgsConstructor
public class UserProfileDTO {
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private List<PlaylistDTO> playlists;
}
