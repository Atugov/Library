package repository;

import model.Author;
import model.Book;
import utils.FileWorkerUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepositoryFileImpl implements BookRepository {
    private static BookRepositoryFileImpl bookRepositoryFile;
    public final static File FILE_BOOKS = new File("booksRepositoryFilet.txt");
    private BookRepositoryFileImpl() {
    }

    public static BookRepositoryFileImpl getInstance() {
        if (bookRepositoryFile == null) {
            bookRepositoryFile = new BookRepositoryFileImpl();
        }
        return bookRepositoryFile;
    }

    @Override
    public String getAllBooksStr() {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(FILE_BOOKS);
            while (scanner.hasNextLine()) {
                String nl = scanner.nextLine();
                String[] fields = nl.split("[\t]");
                String[] date = fields[2].split("[-]");
                int day = Integer.parseInt(date[2]);
                int month = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[0]);
                int numOfPages = Integer.parseInt(fields[2]);
                Author author = new Author(fields[0], fields[1], LocalDate.of(year, month, day));

                Book book = new Book(author, fields[1], numOfPages ,fields[3]);
                books.add(book);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book addBook(Book book) {
        String bookInfo = book.getAuthor() + "\t" + book.getTitle() + "\t" + book.getNumberOfPages() + "\t" + book.getCategory() + "\n";
        String fileName = FILE_BOOKS.getPath();
        try{
            FileWorkerUtils.writeToFile(fileName,bookInfo);
        }
        catch (IOException e){
            throw new IllegalStateException();
        }
        return book;
    }
}
