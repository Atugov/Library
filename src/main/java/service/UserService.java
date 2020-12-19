package service;

import exceptions.NoSuchUserException;
import model.user.LibraryUser;
import model.user.User;
import repository.UserRepositiryListImpl;

import java.util.List;

public class UserService {
    private UserRepositiryListImpl userRepositiryListImpl;
    private static UserService userService;

    private UserService(){
        userRepositiryListImpl = UserRepositiryListImpl.getInstance();
    }

    public static UserService getInstance(){
        if (userService == null){
            userService = new UserService();
        }
        return userService;
    }
    public void getAllUsers() {
        userRepositiryListImpl =UserRepositiryListImpl.getInstance();
        List<User> allUsers = userRepositiryListImpl.getAllUsers();
        System.out.println(allUsers);
    }


    public LibraryUser checkUserExist(String login, String password) {
        List<User> allUsers = userRepositiryListImpl.getAllUsers();
        for (int i = 0; i < allUsers.size(); i++) {
            if (login.equals(allUsers.get(i).getLogin())
                    && password.equals(allUsers.get(i).getPassword())) {
                return getLibraryUserByUserId(allUsers.get(i).getUserId());
            }
        }
        throw new NoSuchUserException("There are no users with login " + login + " and password " + password);
    }

    public User getUserByLogin(String login) {
        for (int i = 0; i < userRepositiryListImpl.getAllUsers().size(); i++) {
            if (login.equals(userRepositiryListImpl.getAllUsers().get(i).getLogin())) {
                return userRepositiryListImpl.getAllUsers().get(i);
            }
        }
        throw new NoSuchUserException("There are no users with login " + login);
    }

    public LibraryUser getLibraryUserByUserId(int id) {
        for (int i = 0; i < userRepositiryListImpl.getAllUsers().size(); i++) {
            if (id == userRepositiryListImpl.getAllLibraryUsers().get(i).getUserId()) {
                return userRepositiryListImpl.getAllLibraryUsers().get(i);
            }
        }
        throw new NoSuchUserException("There are no libraryusers with id " + id);
    }

    public User getUserByUserId(int id) {
        for (int i = 0; i < userRepositiryListImpl.getAllUsers().size(); i++) {
            if (id == userRepositiryListImpl.getAllUsers().get(i).getUserId()) {
                return userRepositiryListImpl.getAllUsers().get(i);
            }
        }
        throw new NoSuchUserException("There are no users with id " + id);
    }
}