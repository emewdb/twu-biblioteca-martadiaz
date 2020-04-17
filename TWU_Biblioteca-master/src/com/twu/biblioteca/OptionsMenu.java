package com.twu.biblioteca;

import java.util.Scanner;

public class OptionsMenu {

    private BookService bookService;
    private MovieService movieService;
    private LoginService loginService;
    private Menu currentMenu;
    private boolean isLogged;
    private User loggedUser;

    private Scanner input = new Scanner(System.in);
    private Scanner subinput = new Scanner(System.in);

    private enum Menu{
        mainMenu,
        bookListUserUnlogged,
        bookListUserLogged,
        videoListMenu
    }

    public OptionsMenu(){
        this.bookService = new BookService();
        this.movieService = new MovieService();
        this.loginService = new LoginService();
        this.currentMenu = Menu.mainMenu;
        this.isLogged = false; //no login by default
        this.loggedUser = loginService.getUserRepository().getEmptyUser();
    }

    public void showMenu(){
        String option = new String();

        while(true){
            printMenus(currentMenu);
            option = input.nextLine().toLowerCase();
            actOnMenuOption(option);
        }
    }

    // switch draw & act menus
    private void printMenus(Menu selectedMenu){
        switch (currentMenu){
            case mainMenu:
                printOptionsMenuSelection();
                break;
            case bookListUserUnlogged:
                printBooksActionsNoLoggedUserMenu();
                break;
            case bookListUserLogged:
                printBookActionsLoggedUserMenu();
                break;
            case videoListMenu:
                printMovieActionsMenu();
                break;
        }
    }
    private void actOnMenuOption(String option){
        switch(option){
            //exit
            case "0":
                System.exit(0);
                //go to main menu
            case "1":
                currentMenu = Menu.mainMenu;
                break;
                //login
            case "2":
                login();
                currentMenu = getMenuOnLoginRequirement();
                break;
            case "p":
                printUserInfo(loggedUser.getUserId());
                break;
                //books
            case "b":
                printBooks();
                currentMenu = setBookMenu();
                break;
            case "cb":
                checkoutBook();
                break;
            case "rb":
                returnBook();
                break;
                //movies
            case "m":
                printMovies();
                break;
            case "cm":
                checkoutMovie();
                break;
            case "rm":
                returnMovie();
                break;
                //default
            default:
                System.out.println("Choose a valid option!");
                break;
        }
    }

    //Main menu
    private void printOptionsMenuSelection(){
        System.out.println("OPTIONS MENU");
        System.out.println("[b] - list of Books");
        System.out.println("[m] - list of Movies");
        System.out.println("Press 0 for EXIT");
    }

    //User
    private void printRequestLogin(){
        System.out.println("[2] - Register in order to checkout and return books");
    }
    private boolean login(){
        System.out.println("User:");
        String userId = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();
        isLogged = loginService.login(userId, password);
        if(isLogged)
            loggedUser = loginService.getUserRepository().getUser(userId);
        return isLogged;
    }
    private Menu getMenuOnLoginRequirement(){
        if(isLogged){
            return Menu.bookListUserLogged;
        }
        else {
            System.out.println("Sorry, user or password not valid!");
            return Menu.bookListUserUnlogged;
        }
    }
    private void printUserInfo(String userId){
        if(isLogged){
            User user = loginService.getUserRepository().getUser(userId);
            System.out.println("MY PROFILE");
            System.out.println("Name: ".concat(user.getName()));
            System.out.println("Email: ".concat(user.getMail()));
            System.out.println("Phone Number: ".concat(user.getPhoneNumber()));
            System.out.println("\n");
        }
    }

    //Book
    private void printBooks(){
        System.out.printf("%-30s %-30s %-30s\n", "Name:", "Author:", "YearPublished:");
        System.out.printf("%-30s %-30s %-30s\n", "-", "-", "-");
        for(Book book : bookService.getBookRepository().list){
            if(!book.getCheckStatus())
                System.out.printf("%-30s %-30s %-30s\n", book.getName(), book.getAuthor(), book.getYearPublished());
        }
    }
    private Menu setBookMenu(){
        if(isLogged)
            return Menu.bookListUserLogged;
        else
            return Menu.bookListUserUnlogged;
    }
    private void printBooksActionsNoLoggedUserMenu(){
        System.out.println("\n");
        System.out.println("BOOK ACTIONS");
        printRequestLogin();
        System.out.println("Press 0 for EXIT");
        System.out.println("Press 1 to go back");

    }
    private void printBookActionsLoggedUserMenu(){
        System.out.println("BOOK ACTIONS");
        System.out.println("[cb] - Checkout Book");
        System.out.println("[rb] - Return Book");
        System.out.println("[p] - View Profile");
        System.out.println("Press 0 for EXIT");
        System.out.println("Press 1 to go back");
    }
    private void checkoutBook(){
        boolean checkedOut = false;

        System.out.println("Name of the book to checkout");
        String checkoutName = subinput.nextLine();
        checkedOut = bookService.checkoutBook(checkoutName);

        if(checkedOut)
            System.out.println("Thank you! Enjoy the book!");
        else
            System.out.println("Sorry, that book is not available");
    }
    private void returnBook(){
        boolean returned = false;

        System.out.println("Name of the book to return");
        String returnName = subinput.nextLine();
        returned = bookService.returnBook(returnName);

        if(returned)
            System.out.println("Thank you for returning the book!");
        else
            System.out.println("That is not a valid book to return");
    }

    //Movie
    private void printMovies(){
        System.out.printf("%-35s %-35s %-35s %-35s\n", "Name:", "Year:", "Director:", "Movie Rating");
        System.out.printf("%-35s %-35s %-35s %-35s\n", "-", "-", "-", "-");
        for(Movie movie : movieService.getMovieRepository().list){
            if(!movie.getCheckStatus())
                System.out.printf("%-35s %-35s %-35s %-35s\n", movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating().getRate());
        }
    }
    private void printMovieActionsMenu(){
        System.out.println("MOVIE ACTIONS");
        System.out.println("[cm] - Checkout Movie");
        System.out.println("[rm] - Return Movie");
        System.out.println("Press 0 for EXIT");
        System.out.println("Press 1 to go back");
    }
    private void checkoutMovie(){
        boolean checkedOut = false;

        System.out.println("Name of the movie to checkout");
        String checkoutName = subinput.nextLine();
        checkedOut = movieService.checkoutMovie(checkoutName);

        if(checkedOut)
            System.out.println("Thank you! Enjoy the movie!");
        else
            System.out.println("Sorry, that movie is not available");
    }
    private void returnMovie(){
        boolean returned = false;

        System.out.println("Name of the movie to return");
        String returnName = subinput.nextLine();
        returned = movieService.returnMovie(returnName);

        if(returned)
            System.out.println("Thank you for returning the movie!");
        else
            System.out.println("That is not a valid movie to return");
    }

}
