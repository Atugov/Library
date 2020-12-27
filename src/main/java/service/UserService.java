package service;

import constants.Constants;
import exceptions.NoSuchUserException;
import model.user.LibraryUser;
import model.user.User;
import repository.UserRepository;
import repository.UserRepositoryFileImpl;
import repository.UserRepositoryListImpl;
import utils.FileWorkerUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private static UserRepository userRepository;
    private static UserRepositoryFileImpl userRepositoryFile;
    private static UserService userService;

    private UserService() {
        userRepository = UserRepositoryListImpl.getInstance();
        userRepositoryFile = UserRepositoryFileImpl.getInstance();
    }

    public static UserService getInstance() {
        if (userService == null) {
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
        for (int i = 0; i < userRepository.getAllLibraryUsers().size(); i++) {
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

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    public List<LibraryUser> getAllLibraryUsers(){
        return userRepository.getAllLibraryUsers();
    }

    public User addNewUser(User user) {
        return userRepository.addUser(user);
    }

    public LibraryUser addNewLibraryUser(LibraryUser libraryUser) {
        return userRepository.addLibraryUser(libraryUser);
    }

    public LibraryUser changeDateInProfileInfo(LibraryUser libraryUser) {
        return userRepository.changeDateOfBirthInProfile(libraryUser);
    }

    public LibraryUser changeNameInProfileInfo(LibraryUser libraryUser) {
        return userRepository.changeNameInProfile(libraryUser);
    }
    public LibraryUser changeEmailInProfileInfo(LibraryUser libraryUser) {
        return userRepository.changeEmailInProfile(libraryUser);
    }

    public void synchronizationData() {
        UserRepositoryListImpl.getInstance().fillUserRepository();
        UserRepositoryListImpl.getInstance().fillLibraryUserRepository();
    }

    public void preExitOperations() {
        List<User> users = UserRepositoryListImpl.getInstance().getAllUsers();
        Scanner scanner = new Scanner(users.toString());
        String userInfo = null;
        String file = Constants.FILE_USERS.getPath();
        while (scanner.hasNextLine()) {
            String nl = scanner.nextLine().replaceAll("^\\[|\\]$", "");
            if (nl.contains(",")) {
                nl = nl.substring(2);
            }
            if(nl.length()>1) {
                String[] fields = nl.split("[\t]");

                userInfo = fields[0] + "\t" + fields[1] + "\t" + fields[2] + "\n";
                try {
                    FileWorkerUtils.writeToFile(file, userInfo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        List<LibraryUser> libUsers = UserRepositoryListImpl.getInstance().getAllLibraryUsers();
        Scanner scanner2 = new Scanner(libUsers.toString());
        String libUserInfo = null;
        String file2 = Constants.FILE_LIBRARY_USERS.getPath();
        while (scanner2.hasNextLine()) {
            String nl2 = scanner2.nextLine().replaceAll("^\\[|\\]$", "");
            if (nl2.contains(",")) {
                nl2 = nl2.substring(2);
            }
            if(nl2.length()>1) {
                String[] fields = nl2.split("[\t]");

                libUserInfo = fields[0] + "\t" + fields[1] + "\t" + fields[2] +"\t" + fields[3]+ "\n";
                try {
                    FileWorkerUtils.writeToFile(file2, libUserInfo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}