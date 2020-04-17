package com.twu.biblioteca;

public class BookService {

    private BookRepository bookRepository;

    public BookService(){
        bookRepository = new BookRepository();
    }

    public boolean checkoutBook(String name){
        boolean found = false;
        for(Book book : bookRepository.list){
            if(book.getName().toLowerCase().equals(name.toLowerCase()) && !book.getCheckStatus()){
                book.setCheckStatus(true);
                found = true;
            }
        }
        return found;
    }

    public boolean returnBook(String name){
        boolean found = false;
        for(Book book : bookRepository.list){
            if(book.getName().toLowerCase().equals(name.toLowerCase()) && book.getCheckStatus()){
                book.setCheckStatus(false);
                found = true;
            }
        }
        return found;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }
}
