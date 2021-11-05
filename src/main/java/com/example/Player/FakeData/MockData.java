package com.example.Player.FakeData;

import com.example.Player.Model.Song;
import com.example.Player.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    private List<User> userList;
    private List<Song> songList;

    public MockData() {
        this.userList = new ArrayList<>();

        User a = new User(0L,"Pablo","test1@email.com","12341234");
        User b = new User(1L,"Tommy","test2@email.com","12341234");
        User c = new User(2L,"Jenny","test3@email.com","12341234");
        User d = new User(3L,"Lenny","test4@email.com","12341234");

        userList.add(a);
        userList.add(b);
        userList.add(c);
        userList.add(d);
        
        this.songList = new ArrayList<>();
        Song aa = new Song("Hey","Hey","/1230nvld23");
        Song bb = new Song("123","Way","/1230nvld23");
        Song cc = new Song("456","Jay","/1230nvld23");
        Song dd = new Song("789","Kay","/1230nvld23");

        songList.add(aa);
        songList.add(bb);
        songList.add(cc);
        songList.add(dd);

    }

    public List<User> getUserList() {
        return userList;
    }
    public List<Song> getSongList() {
        return songList;
    }
}
