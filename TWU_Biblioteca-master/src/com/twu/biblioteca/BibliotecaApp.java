package com.twu.biblioteca;

public class BibliotecaApp {

    private static Welcome welcome = new Welcome();
    private static OptionsMenu menu = new OptionsMenu();

    public static void main(String[] args) {

        System.out.println(welcome.WelcomeMessage);
        menu.showMenu();
    }
}

