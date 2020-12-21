package repository;

import model.user.LibraryUser;
import model.user.User;
import utils.FileWorkerUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepositoryFileImpl implements UserRepository {
    private static UserRepositoryFileImpl userRepositoryFile;
    private final static File FILE_USERS = new File("usersRepositoryFile.txt");

    private UserRepositoryFileImpl() {

    }

    public static UserRepositoryFileImpl getInstance() {
        if (userRepositoryFile == null) {
            userRepositoryFile = new UserRepositoryFileImpl();
        }
        return userRepositoryFile;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(FILE_USERS);
            while (scanner.hasNextLine()) {
                String nl2 = scanner.nextLine();
                String[] fields = nl2.split("[\t]");
                int id = Integer.parseInt(fields[0]);
                User user = new User(id, fields[1], fields[2]);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<LibraryUser> getAllLibraryUsers() {
        return null;
    }

    @Override
    public User addUser(User user) {
        String userInfo = user.getUserId() + "\t" + user.getPassword() + "\t" + user.getLogin() + "\n";
        String file = FILE_USERS.getPath();
        try {
            FileWorkerUtils.writeToFile(file, userInfo);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
        return user;
    }
}
