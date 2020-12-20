package controllers;

import model.user.LibraryUser;
import model.user.User;
import service.AuthorService;
import service.BookService;
import service.UserService;
import utils.ConsoleWorkerUtils;

import java.util.Scanner;

public class ConsolController {
    private Scanner scanner;
    private LibraryUser logedInLibUser;
    private User logedInUser;
    private BookService bookService;
    private UserService userService;
    private static ConsolController consolController;
    private AuthorService authorService;
    private ConsoleWorkerUtils consoleWorkerUtils;

    private ConsolController() {
        scanner = new Scanner(System.in);
        logedInLibUser = new LibraryUser();
        bookService = BookService.getInstance();
        userService = UserService.getInstance();
        authorService = AuthorService.getInstance();
        consoleWorkerUtils = new ConsoleWorkerUtils();
    }

    public static ConsolController getInstance() {
        if (consolController == null) {
            consolController = new ConsolController();
        }
        return consolController;
    }

    public void startApplication() {
        while (true) {
            System.out.println(logedInUser == null ? "You are not authorized" : "Hello " + logedInLibUser.getName());
            System.out.println("Choose your option :");
            System.out.println("1: Log in");
            System.out.println("2: Log out");
            System.out.println("3: Show all books");
            System.out.println("4: Show all authors");
            System.out.println("5: Register new user");
            System.out.println("6: Register new author");
            System.out.println("7: Register new book");
            System.out.println("8: Show all users");
            System.out.println("10: Turn off application");
            int optionNumber = scanner.nextInt();
            if (optionNumber == 1) {
                logIn();
            } else if (optionNumber == 2) {
                logOut();
            } else if (optionNumber == 3) {
                System.out.println(bookService.showAllBooks());
            }else if(optionNumber == 4){
                System.out.println(authorService.getAllAuthors());
            }else if(optionNumber == 5){
                registerNewUser();
            }
            else if (optionNumber == 6) {
                registerNewAuthor();
            }else if(optionNumber == 7){
                registerNewBook();
            }else if(optionNumber == 8){
                System.out.println(userService.getAllUsers());
            }
            else if (optionNumber == 10) {
                turnOffApplication();
            } else {
                System.out.println("Wrong option");
            }
        }
    }

    private void logIn() {
        logedInLibUser = consoleWorkerUtils.logginingIn();
        logedInUser =  userService.getUserByUserId(logedInLibUser == null ? -1 : logedInLibUser.getUserId());

    }

    private void logOut() {
        logedInUser = null;
        logedInLibUser = null;
    }

    private void turnOffApplication() {
        System.exit(1);
    }

    private void registerNewAuthor() {
        authorService.addAuthor(ConsoleWorkerUtils.registerNewAuthor());

    }
    private void registerNewBook(){
        bookService.addBook(ConsoleWorkerUtils.registerNewBook());
    }
    private void registerNewUser(){
        userService.addNewUser(ConsoleWorkerUtils.registerNewUser());
    }


}
