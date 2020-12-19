package repository;

import model.Author;
import utils.RandomDataGenerationUtils;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryListImpl implements AuthorRepository {
    private static AuthorRepositoryListImpl listImplInstance;
    private List<Author> authors;

    private AuthorRepositoryListImpl() {
        authors = new ArrayList<>(100);
        fillAuthorsArray();
    }

    public static AuthorRepositoryListImpl getInstance() {
        if (listImplInstance == null) {
            listImplInstance = new AuthorRepositoryListImpl();
        }
        return listImplInstance;
    }

    private void fillAuthorsArray() {
        for (int i = 0; i < 100; i++) {
            authors.add(RandomDataGenerationUtils.createRandomAuthor());
        }
    }

    @Override
    public String getAllAuthorsStr() {
        StringBuilder sb = new StringBuilder("----- Authors ------\n");
        for (Author a : authors) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authors;
    }

    @Override
    public Author addAuthor(Author author) {
        authors.add(author);
        return author;
    }
}


