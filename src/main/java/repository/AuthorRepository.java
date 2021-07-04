package repository;

import model.Author;

import java.util.List;

public interface AuthorRepository {

    String getAllAuthorsStr();

    List<Author> getAllAuthors();

    Author addAuthor(Author author);
}
