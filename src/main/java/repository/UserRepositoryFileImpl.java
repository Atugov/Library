package repository;

import constants.Constants;
import model.user.LibraryUser;
import model.user.User;
import utils.FileWorkerUtils;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepositoryFileImpl implements UserRepository {
    private static UserRepositoryFileImpl userRepositoryFile;
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
            Scanner scanner = new Scanner(Constants.FILE_USERS);
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
        List<LibraryUser> libraryUsers = new ArrayList<>();
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return libraryUsers;
    }

    @Override
    public User addUser(User user) {
        String userInfo = user.getUserId() + "\t" + user.getPassword() + "\t" + user.getLogin() + "\n";
        String file = Constants.FILE_USERS.getPath();
        try {
            FileWorkerUtils.writeToFile(file, userInfo);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
        return user;
    }

    @Override
    public LibraryUser addLibraryUser(LibraryUser libraryUser) {
        String libraryUserInfo = libraryUser.getUserId() + "\t" + libraryUser.getName() + "\t" + libraryUser.getEmail() + "\t" + libraryUser.getDateOfBirth() + "\n";
        String file = Constants.FILE_LIBRARY_USERS.getPath();
        try {
            FileWorkerUtils.writeToFile(file, libraryUserInfo);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
        return libraryUser;
    }

    @Override
    public LibraryUser changeDateOfBirthInProfile(LibraryUser libraryUser) {
        String file = Constants.FILE_LIBRARY_USERS.getPath();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String strLine;
            String id = Integer.toString(libraryUser.getUserId());
            String date = libraryUser.getDateOfBirth() + "";
            while ((strLine = br.readLine()) != null && strLine.contains(id)) {
                sb.append(strLine.replace("null", date)).append("\r\n");
                //sb.append(strLine.replace("emptyName", libraryUser.getName())).append("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return libraryUser;
    }

    @Override
    public LibraryUser changeNameInProfile(LibraryUser libraryUser) {
        String file = Constants.FILE_LIBRARY_USERS.getPath();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String strLine;
            String id = Integer.toString(libraryUser.getUserId());
            while ((strLine = br.readLine()) != null && strLine.contains(id)) {
                sb.append(strLine.replace("emptyName", libraryUser.getName())).append("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return libraryUser;
    }

    @Override
    public LibraryUser changeEmailInProfile(LibraryUser libraryUser) {
        return null;
    }
}
