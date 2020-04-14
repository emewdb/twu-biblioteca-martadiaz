package com.twu.biblioteca;

import java.util.Scanner;

public class OptionsMenu {

    private BookRepository bookRepository = new BookRepository();
    private Scanner input = new Scanner(System.in);
    private Scanner subinput = new Scanner(System.in);

    //Main menu
    public String getOptionsMenuSelection(){
        String selection;


        System.out.println("OPTIONS MENU");
        System.out.println("1 - List of Books");
        System.out.println("Press 0 for EXIT");
        selection = input.next();

        return selection;
    }

    public String goToSelection(String selection){
        String selected = "";
        String aux = selection;
        switch (aux){
            case "0":
                selected = "exit";
                System.exit(0);
                break;
            case "1":
                listBooks();
                selected = "list";
                String action = bookActionsMenu();
                if(action.equals("0"))
                    goToSelection("0");
                else
                    bookAction(action);
                break;
            default:
                System.out.println("Please select a valid option!");
                //break;
        }
        return selected;
    }

    private void listBooks(){
        System.out.printf("%-30s %-30s %-30s\n", "Name:", "Author:", "YearPublished:");
        System.out.printf("%-30s %-30s %-30s\n", "-", "-", "-");
        for(Book book : bookRepository.list){
            if(!book.getCheckStatus())
                System.out.printf("%-30s %-30s %-30s\n", book.getName(), book.getAuthor(), book.getYearPublished());
        }
    }
    private String bookActionsMenu(){
        Scanner input = new Scanner(System.in);

        System.out.println("BOOK ACTIONS");
        System.out.println("[c] - Checkout Book");
        System.out.println("[r] - Return Book");
        System.out.println("Press 0 for EXIT");

        return input.next();
    }
    private boolean bookAction(String action){
        boolean result = false;

        while(!result){
            //Checkout
            if(action.toLowerCase().equals("c")){
                System.out.println("Name of the book to checkout");
                String checkoutName = subinput.nextLine();
                result = bookRepository.checkoutBook(checkoutName);
            }
            //Return
            else if(action.toLowerCase().equals("r")){
                System.out.println("Name of the book to return");
                String returnName = subinput.nextLine();
                result = bookRepository.returnBook(returnName);
            }
        }
        return  result;
    }

}
