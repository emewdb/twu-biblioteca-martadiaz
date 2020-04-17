package com.twu.biblioteca;

public class User {

    //info to show
    private String name;
    private String mail;
    private String phoneNumber;
    //info to manage user
    private String password;
    private String userId;
    private boolean isLogged;

    public User(String name, String mail, String phoneNumber, String password, String libraryNumber){
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userId = libraryNumber;
        this.isLogged = false; //not logged by default
    }

    //getters
    public String getName() {
        return name;
    }
    public String getMail() {
        return mail;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPassword() {
        return password;
    }
    public String getUserId() {
        return userId;
    }

    public boolean isLogged() {
        return isLogged;
    }

    //setters
    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
