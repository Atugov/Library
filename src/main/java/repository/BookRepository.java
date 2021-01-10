package repository;

import model.Book;

import java.util.List;

public interface BookRepository {

    String getAllBooksStr();

    List<Book> getAllBooks();

    void addBook(Book book);
}
