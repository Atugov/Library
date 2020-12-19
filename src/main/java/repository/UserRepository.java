package repository;

import model.user.LibraryUser;
import model.user.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
    List<LibraryUser> getAllLibraryUsers();
}
