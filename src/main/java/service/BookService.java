package service;

import exceptions.NoSuchBookException;
import model.Author;
import model.Book;
import repository.BookRepository;
import repository.BookRepositoryListImpl;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static BookRepository bookRepository;
    private static BookService bookService;


    private BookService() {
        bookRepository = BookRepositoryListImpl.getInstance();
    }

    public static BookService getInstance() {
        if (bookService == null) {
            bookService = new BookService();
        }
        return bookService;
    }

    public ArrayList<Book> getBooksByAuthor(Author author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book b1 : bookRepository.getAllBooks()) {
            if (b1.getAuthor().equals(author)) {
                booksByAuthor.add(b1);
            }
        }
        if (booksByAuthor.isEmpty()) {
            throw new NoSuchBookException("There are no books with author " + author);
        }
        return booksByAuthor;

    }

    public ArrayList<Book> getBooksByTitle(String title) {
        ArrayList<Book> booksByTitle = new ArrayList<>();
        for (Book b1 : bookRepository.getAllBooks()) {
            if (b1.getTitle().equals(title)) {
                booksByTitle.add(b1);
            }
        }
        if (booksByTitle.isEmpty()){
            throw new NoSuchBookException("There are no books with title" + title);
        }
        return booksByTitle;
    }

    public ArrayList<Book> getBooksByNumberOfPage(int fromNumOfPage, int untilNumOfPages) {
        ArrayList<Book> booksByNumberOfPage = new ArrayList<>();
        for (Book b1 : bookRepository.getAllBooks()) {
            if (b1.getNumberOfPages() >= fromNumOfPage && b1.getNumberOfPages() <= untilNumOfPages) {
                booksByNumberOfPage.add(b1);
            }
        }
        if (booksByNumberOfPage.isEmpty()){
            throw new NoSuchBookException("There are no books with range of pages: since "
                    + fromNumOfPage + " until " + untilNumOfPages);
        }
        return booksByNumberOfPage;
    }

    public ArrayList<Book> getBooksByCategory(String category) {
        ArrayList<Book> booksByCategory = new ArrayList<>();
        for (Book b1 : bookRepository.getAllBooks()) {
            if (b1.getCategory().equals(category)) {
                booksByCategory.add(b1);
            }
        }
        if (booksByCategory.isEmpty()){
            throw new NoSuchBookException("There are no books with category " + category);
        }
        return booksByCategory;
    }

    public List<Book> showAllBooks() {
        return bookRepository.getAllBooks();

    }
    public Book addBook(Book book){
        return bookRepository.addBook(book);
    }
}
