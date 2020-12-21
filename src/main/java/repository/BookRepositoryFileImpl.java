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
        private static repository.BookRepositoryFileImpl bookRepositoryFile;
        private final static File FILE_BOOKS = new File("booksRepositoryFile.txt");

        public BookRepositoryFileImpl() {
        }

        public static repository.BookRepositoryFileImpl getInstance() {
            if (bookRepositoryFile == null) {
                bookRepositoryFile = new repository.BookRepositoryFileImpl();
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
                    String nl1 = scanner.nextLine();
                    String[] fields = nl1.split("[\t]");
                    String[] date = fields[2].split("[-]");
                    int day = Integer.parseInt(date[2]);
                    int month = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[0]);
                    int numOfPages = Integer.parseInt(fields[4]);
                    Author author = new Author(fields[0], fields[1], LocalDate.of(year, month, day));

                    Book book = new Book(author, fields[3], numOfPages, fields[5]);
                    books.add(book);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return books;
        }

        @Override
        public Book addBook(Book book) {
            String bookInfo = book.getAuthor().getName()+"\t"+ book.getAuthor().getSurname()+ "\t"+ book.getAuthor().getBirthday() + "\t" + book.getTitle() + "\t" + book.getNumberOfPages() + "\t" + book.getCategory() + "\n";
            Author author = new Author(book.getAuthor().getName(), book.getAuthor().getSurname(), book.getAuthor().getBirthday());
            AuthorRepositoryFileImpl.getInstance().addAuthor(author);
            String fileName = FILE_BOOKS.getPath();
            try {
                FileWorkerUtils.writeToFile(fileName, bookInfo);
            } catch (IOException e) {
                throw new IllegalStateException();
            }
            return book;
        }
    }
