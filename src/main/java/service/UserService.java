package service;

import exceptions.NoSuchUserException;
import model.user.LibraryUser;
import model.user.User;
import repository.UserRepository;
import repository.UserRepositoryFileImpl;

import java.util.List;

public class UserService {
    private static UserRepository userRepository;
    private static UserService userService;

    private UserService(){
        userRepository = UserRepositoryFileImpl.getInstance();
    }

    public static UserService getInstance(){
        if (userService == null){
            userService = new UserService();
        }
        return userService;
    }


    public LibraryUser checkUserExist(String login, String password) {
        List<User> allUsers = userRepository.getAllUsers();
        for (int i = 0; i < allUsers.size(); i++) {
            if (login.equals(allUsers.get(i).getLogin())
                    && password.equals(allUsers.get(i).getPassword())) {
                return getLibraryUserByUserId(allUsers.get(i).getUserId());
            }
        }
        throw new NoSuchUserException("There are no users with login " + login + " and password " + password);
    }

    public User getUserByLogin(String login) {
        for (int i = 0; i < userRepository.getAllUsers().size(); i++) {
            if (login.equals(userRepository.getAllUsers().get(i).getLogin())) {
                return userRepository.getAllUsers().get(i);
            }
        }
        throw new NoSuchUserException("There are no users with login " + login);
    }

    public LibraryUser getLibraryUserByUserId(int id) {
        for (int i = 0; i < userRepository.getAllUsers().size(); i++) {
            if (id == userRepository.getAllLibraryUsers().get(i).getUserId()) {
                return userRepository.getAllLibraryUsers().get(i);
            }
        }
        throw new NoSuchUserException("There are no libraryusers with id " + id);
    }

    public User getUserByUserId(int id) {
        for (int i = 0; i < userRepository.getAllUsers().size(); i++) {
            if (id == userRepository.getAllUsers().get(i).getUserId()) {
                return userRepository.getAllUsers().get(i);
            }
        }
        throw new NoSuchUserException("There are no users with id " + id);
    }
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
    public User addNewUser(User user){
        return userRepository.addUser(user);
    }
}