package com.example.Player;

import com.example.Player.LogicLayer.UserManager;
import com.example.Player.Model.User;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UnitTest {
    @Test
    public void Test1(){

        Assertions.assertEquals(1,1);
    }
    @Test
    public void GetAllUsers(){

        UserManager um = new UserManager();

        var a = um.GetUsers();

        for(var us:a){
            System.out.println(us.getId());
        }

        Assertions.assertEquals(1,1);
    }
}
