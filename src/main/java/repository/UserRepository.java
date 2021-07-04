package repository;

import model.user.LibraryUser;
import model.user.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    List<LibraryUser> getAllLibraryUsers();

    User addUser(User user);
    LibraryUser addLibraryUser(LibraryUser libraryUser);
    LibraryUser changeDateOfBirthInProfile(LibraryUser libraryUser);
    LibraryUser changeNameInProfile(LibraryUser libraryUser);
    LibraryUser changeEmailInProfile(LibraryUser libraryUser);
}
