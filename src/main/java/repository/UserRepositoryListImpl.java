package repository;

import constants.Constants;
import model.user.LibraryUser;
import model.user.User;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepositoryListImpl implements UserRepository {

    private List<User> users;
    private List<LibraryUser> libraryUsers;
    private static UserRepositoryListImpl userRepositoryList;

    private UserRepositoryListImpl() {
        users = new ArrayList<>();
        libraryUsers = new ArrayList<>();
    }

    public static UserRepositoryListImpl getInstance() {
        if (userRepositoryList == null) {
            userRepositoryList = new UserRepositoryListImpl();
        }
        return userRepositoryList;
    }

    public void fillUserRepository() {
        try {
            Scanner scanner = new Scanner(Constants.FILE_USERS);
            while (scanner.hasNextLine()) {
                String nl2 = scanner.nextLine();
                String[] fields = nl2.split("[\t]");
                int id = Integer.parseInt(fields[0]);
                User user = new User(id, fields[1], fields[2]);
                users.add(user);
            }
            PrintWriter writer = new PrintWriter(Constants.FILE_USERS);
            while (scanner.hasNextLine()) {
                writer.print("");
                writer.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void fillLibraryUserRepository() {
        try {
            Scanner scanner = new Scanner(Constants.FILE_LIBRARY_USERS);
            while (scanner.hasNextLine()) {
                LibraryUser libraryUser;
                String nl3 = scanner.nextLine();
                String[] fields = nl3.split("[\t]");
                String[] date = fields[2].split("[-]");
                int id = Integer.parseInt(fields[0]);
                if (date.length > 1) {
                    int day = Integer.parseInt(date[2]);
                    int month = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[0]);

                    libraryUser = new LibraryUser(id, fields[1], fields[2], LocalDate.of(year, month, day));
                } else libraryUser = new LibraryUser(id, fields[1], fields[2], null);
                libraryUsers.add(libraryUser);
            }
            PrintWriter writer = new PrintWriter(Constants.FILE_LIBRARY_USERS);
            while (scanner.hasNextLine()) {
                writer.print("");
                writer.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<LibraryUser> getAllLibraryUsers() {
        return libraryUsers;
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        System.out.println(users);
        return user;
    }

    @Override
    public LibraryUser addLibraryUser(LibraryUser libraryUser) {
        libraryUsers.add(libraryUser);
        System.out.println(libraryUsers);
        return libraryUser;

    }

    @Override
    public LibraryUser changeDateOfBirthInProfile(LibraryUser libraryUser) {
        return null;
    }

    @Override
    public LibraryUser changeNameInProfile(LibraryUser libraryUser) {
        return null;
    }

    @Override
    public LibraryUser changeEmailInProfile(LibraryUser libraryUser) {
        return null;
    }
}
