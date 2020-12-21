package repository;

import model.Book;
import utils.RandomDataGenerationUtils;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryListImpl implements BookRepository {

    private List<Book> books;
    private static BookRepositoryListImpl bookRepositoryListImpl;

    private BookRepositoryListImpl() {
        books = new ArrayList<>(100);
        fillBookRepository();
    }

    public static BookRepositoryListImpl getInstance() {
        if (bookRepositoryListImpl == null) {
            bookRepositoryListImpl = new BookRepositoryListImpl();
        }
        return bookRepositoryListImpl;
    }

    public void fillBookRepository() {
        for (int i = 0; i < 100; i++) {
            books.add(RandomDataGenerationUtils.createRandomBook());
        }
    }

    @Override
    public String getAllBooksStr() {
        StringBuilder sb = new StringBuilder("----- Books -----");
        for (Book b : books) {
            sb.append(b.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }
}

