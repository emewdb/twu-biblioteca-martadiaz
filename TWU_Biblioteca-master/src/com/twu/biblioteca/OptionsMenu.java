package com.twu.biblioteca;

import java.util.Scanner;

public class OptionsMenu {

    private BookRepository bookRepository = new BookRepository();
    private Scanner input = new Scanner(System.in);
    private Scanner subinput = new Scanner(System.in);

    private enum Menu{
        mainMenu,
        bookList
    }

    private Menu currentMenu = Menu.mainMenu;

    public void getMenu(){
        String option = "";

        while(true){
            //drawing menu switch
            switch (currentMenu){
            case mainMenu:
                printOptionsMenuSelection();
                break;
            case bookList:
                printBookActionsMenu();
                break;
            }
            option = input.next().toLowerCase();
            //acting switch
            switch(option){
                //exit
                case "0":
                    System.exit(0);
                    //books
                case "1":
                    currentMenu = Menu.mainMenu;
                    break;
                case "l":
                    printBooks();
                    currentMenu = Menu.bookList;
                    break;
                case "c":
                    checkoutBook();
                    break;
                case "r":
                    returnBook();
                    break;
                default:
                    System.out.println("Choose a valid option!");
                    break;
            }

        }
    }


    //Main menu
    private void printOptionsMenuSelection(){
        System.out.println("OPTIONS MENU");
        System.out.println("[l] - list of Books");
        System.out.println("Press 0 for EXIT");
    }

    //Book
    private void printBooks(){
        System.out.printf("%-30s %-30s %-30s\n", "Name:", "Author:", "YearPublished:");
        System.out.printf("%-30s %-30s %-30s\n", "-", "-", "-");
        for(Book book : bookRepository.list){
            if(!book.getCheckStatus())
                System.out.printf("%-30s %-30s %-30s\n", book.getName(), book.getAuthor(), book.getYearPublished());
        }
    }
    private void printBookActionsMenu(){
        System.out.println("BOOK ACTIONS");
        System.out.println("[c] - Checkout Book");
        System.out.println("[r] - Return Book");
        System.out.println("Press 0 for EXIT");
        System.out.println("Press 1 to go back");
    }
    private void checkoutBook(){
        boolean checkedOut = false;

        System.out.println("Name of the book to checkout");
        String checkoutName = subinput.nextLine();
        checkedOut = bookRepository.checkoutBook(checkoutName);

        if(checkedOut)
            System.out.println("Thank you! Enjoy the book!");
        else
            System.out.println("Sorry, that book is not available");
    }
    private void returnBook(){
        boolean returned = false;

        System.out.println("Name of the book to return");
        String returnName = subinput.nextLine();
        returned = bookRepository.returnBook(returnName);

        if(returned)
            System.out.println("Thank you for returning the book!");
        else
            System.out.println("That is not a valid book to return");
    }

}
