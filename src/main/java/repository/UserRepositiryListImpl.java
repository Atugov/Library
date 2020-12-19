package repository;

import model.user.LibraryUser;
import model.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepositiryListImpl implements UserRepository {
    private List<User> users;
    private List<LibraryUser> libraryUsers;
    private static UserRepositiryListImpl userRepositiryList;

    private UserRepositiryListImpl() {
        users = new ArrayList<User>();
        libraryUsers = new ArrayList<>();
        fillUserRepository();
        fillLibraryUserRepository();
    }

    public static UserRepositiryListImpl getInstance(){
        if (userRepositiryList == null) {
            userRepositiryList = new UserRepositiryListImpl();
        }
        return userRepositiryList;
    }

    public void fillUserRepository() {
        User user1 = new User(100, "Ivan1", "1a");
        User user2 = new User(200, "Petr2", "2b");
        User user3 = new User(300, "Dima3", "3c");
        User user4 = new User(400, "Alex4", "4d");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    public void fillLibraryUserRepository() {
        LibraryUser libraryUser1 = new LibraryUser(100, "Ivan", "a@gmail.com", LocalDate.of(2000, 1, 10));
        LibraryUser libraryUser2 = new LibraryUser(200, "Petr", "b@gmail.com", LocalDate.of(1990, 2, 11));
        LibraryUser libraryUser3 = new LibraryUser(300, "Dima", "c@gmail.com", LocalDate.of(1980, 3, 12));
        LibraryUser libraryUser4 = new LibraryUser(400, "Alex", "d@gmail.com", LocalDate.of(1970, 4, 13));
        libraryUsers.add(libraryUser1);
        libraryUsers.add(libraryUser2);
        libraryUsers.add(libraryUser3);
        libraryUsers.add(libraryUser4);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<LibraryUser> getAllLibraryUsers() {
        return libraryUsers;
    }
}
