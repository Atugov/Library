package repository;

import model.Author;
import utils.FileWorkerUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorRepositoryFileImpl implements AuthorRepository {
    private static AuthorRepositoryFileImpl authorRepositoryFile;
    private final static File FILE_AUTHORS = new File("authorsRepositoryFilet.txt");
    private AuthorRepositoryFileImpl() {
    }

    public static AuthorRepositoryFileImpl getInstance() {
        if (authorRepositoryFile == null) {
            authorRepositoryFile = new AuthorRepositoryFileImpl();
        }
        return authorRepositoryFile;
    }

    @Override
    public String getAllAuthorsStr() {
        return null;
    }

    @Override
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(FILE_AUTHORS);
            while (scanner.hasNextLine()) {
                String nl = scanner.nextLine();
                String[] fields = nl.split("[\t]");
                String[] date = fields[2].split("[-]");
                int day = Integer.parseInt(date[2]);
                int month = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[0]);
                Author author = new Author(fields[0], fields[1], LocalDate.of(year, month, day));
                authors.add(author);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public Author addAuthor(Author author) {
        String authorInfo = author.getName() + "\t" + author.getSurname() + "\t" + author.getBirthday() + "\n";
        String fileName = FILE_AUTHORS.getPath();
        try {
            FileWorkerUtils.writeToFile(fileName, authorInfo);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return author;
    }
}
