package service;

import exceptions.NoSuchAuthorException;
import model.Author;
import repository.AuthorRepository;
import repository.AuthorRepositoryFileImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthorService {
    private static AuthorRepository authorRepository;
    private static AuthorService authorService;

    private AuthorService() {
        authorRepository = AuthorRepositoryFileImpl.getInstance();
    }

    public static AuthorService getInstance() {
        if (authorService == null) {
            authorService = new AuthorService();
        }
        return authorService;
    }

    public List<Author> getAuthorsBySurname(String surname) {
        List<Author> authorsBySurname = new ArrayList<>();
        for (Author authors : authorRepository.getAllAuthors()) {
            if (authors.getSurname().equals(surname)) {
                authorsBySurname.add(authors);
            }
        }
        if (authorsBySurname.isEmpty()) {
            throw new NoSuchAuthorException("There are no users with surname " + surname);
        }
        return authorsBySurname;
    }


    public ArrayList<Author> getAuthorsOlderThan(LocalDate birthDate) {
        ArrayList<Author> authorsOlderThan = new ArrayList<>();
        for (Author a1 : authorRepository.getAllAuthors()) {
            if (a1.getBirthday().isAfter(birthDate)) {
                authorsOlderThan.add(a1);
            }
        }
        if (authorsOlderThan.isEmpty()) {
            throw new NoSuchAuthorException("There are no users older than " + birthDate);
        }
        return authorsOlderThan;
    }

    public ArrayList<Author> getAuthorsYoungerThan(LocalDate birthDate) {
        ArrayList<Author> authorsYoungerThan = new ArrayList<>();
        for (Author a3 : authorRepository.getAllAuthors()) {
            if (a3.getBirthday().isBefore(birthDate)) {
                authorsYoungerThan.add(a3);
            }
        }
        if (authorsYoungerThan.isEmpty()) {
            throw new NoSuchAuthorException("There are no users younger than " + birthDate);
        }
        return authorsYoungerThan;
    }

    public ArrayList<Author> getAuthorsByName(String name) {
        ArrayList<Author> authorsByName = new ArrayList<>();
        for (Author a2 : authorRepository.getAllAuthors()) {
            if (a2.getName().equals(name)) {
                authorsByName.add(a2);
            }
        }
        if (authorsByName.isEmpty()) {
            throw new NoSuchAuthorException("There are no users with name " + name);
        }
        return authorsByName;
    }
    public List<Author> getAllAuthors(){
        return authorRepository.getAllAuthors();
    }

    public Author addAuthor(Author author) {
        return authorRepository.addAuthor(author);

    }
}
