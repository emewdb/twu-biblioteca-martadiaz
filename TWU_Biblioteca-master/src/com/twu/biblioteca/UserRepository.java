package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private User[] usersArray = {
            new User("Marta","marta.diaz@thoughtworks.com","662425691","1234","123-4567")
    };

    public List<User> list = Arrays.asList(usersArray);

    public User getUser(String userId){
        User user = null;
        for(User u : list){
            if(u.getUserId().equals(userId))
                user = u;
            //else throw exception ?
        }
        return user;
    }

    public User getEmptyUser(){
        return new User("","","","","");
    }
}
