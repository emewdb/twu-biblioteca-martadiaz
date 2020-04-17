package com.twu.biblioteca;

public class LoginService {

    private UserRepository userRepository;

    public LoginService(){
        userRepository = new UserRepository();
    }

    public boolean login(String user, String password){
        boolean success = false;
        for(User u : userRepository.list){
            if(u.getUserId().equals(user) && u.getPassword().equals(password)){
                u.setLogged(true);
                success = true;
            }
        }
        return success;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
