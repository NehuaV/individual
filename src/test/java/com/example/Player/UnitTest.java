package com.example.Player;

//@Transactional
public class UnitTest {

//    @Autowired
//    ModelMapper modelMapper;
//
//
//    @Test
//    @Disabled
//    public void Test(){
//        var hey = 1;
//        Assertions.assertEquals(hey,1);
//    }
//
//    @Test
//    @Disabled
//    public void EntityPlaylistToDTO(){
//        Playlist given = new Playlist("name");
//        PlaylistDTO expected = new PlaylistDTO();
//        expected.setName("name");
//        PlaylistDTO actual = modelMapper.map(given, PlaylistDTO.class);
//        Assertions.assertEquals(expected,actual);
//
//    }
//    @Test
//    @Disabled
//    public void EntityProfileToDTO(){
//        User user = new User();
//        user.setEmail("test@test.com");
//        user.setUsername("test");
//        UserProfileDTO expected = new UserProfileDTO();
//        expected.setEmail("test@test.com");
//        expected.setUsername("test");
//        UserProfileDTO actual = modelMapper.map(user, UserProfileDTO.class);
//        Assertions.assertEquals(expected,actual);
//    }
//
//    @Test
//    @Disabled
//    public void EntityToDTO(){
//        User user = new User();
//        user.setEmail("test@test.com");
//        user.setUsername("test");
//        UserDTO expected = new UserDTO();
//        expected.setEmail("test@test.com");
//        expected.setUsername("test");
//        UserDTO actual = modelMapper.map(user, UserDTO.class);
//        Assertions.assertEquals(expected,actual);
//    }
//
//    @Test
//    public void GetUsersUsername(){
//
//        MockData m = new MockData();
//        List<User> u = m.getUserList();
//        UserManager um = new UserManager(u);
//
//        List<User> expected = new ArrayList<>();
//        for(User user: u){
//            if(user.getUsername().equals("Pablo")){
//                expected.add(user);
//            }
//        }
//        List<User> actual = um.getUserUsername("Pablo");
//
//        Assertions.assertEquals(expected,actual);
//    }
//
//    @Test
//    public void addUser(){
//
//        MockData m = new MockData();
//        List<User> u = m.getUserList();
//        UserManager um = new UserManager(u);
//
//        User d = new User(4L,"Werry","test5@email.com","12341234");
//
//        List<User> actual = m.getUserList();
//        actual.add(d);
//        um.addUser(d);
//        List<User> expected = um.GetAllUsers();
//
//        assertEquals(expected,actual);
//    }
//
//    @Test
//    public void updateUser(){
//
//        MockData m = new MockData();
//        List<User> u = m.getUserList();
//        UserManager um = new UserManager(u);
//
//        User d = new User(3L,"Berry","test4@email.com","12341234");
//
//        List<User> actual = m.getUserList();
//        actual.remove(3);
//        actual.add(d);
//        um.updateUser(d);
//        List<User> expected = um.GetAllUsers();
//
//        assertEquals(expected,actual);
//    }


}
