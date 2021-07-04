package repository;

import model.Author;
import model.Book;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepositoryFileImpl implements BookRepository {
    private static repository.BookRepositoryFileImpl bookRepositoryFile;
    private final static File FILE_BOOKS = new File("booksRepositoryFile.xls");

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
//            FileInputStream fileInputStream = new FileInputStream(FILE_BOOKS);
//            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Scanner scanner = new Scanner(FILE_BOOKS);
//            Sheet sheet = workbook.getSheetAt(0);
//
//            Map<Integer, List<String>> data = new HashMap<>();
//            int i = 0;
//            for (Row row : sheet) {
//                data.put(i, new ArrayList<String>());
//                for (Cell cell : row) {
//                    switch (cell.getCellTypeEnum()) {
//                        case STRING: ...break;
//                        case NUMERIC: ...break;
//                        case BOOLEAN: ...break;
//                        case FORMULA: ...break;
//                        default:
//                            data.get(new Integer(i)).add(" ");
//                    }
//                }
//                i++;
//            }
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        try {
        FileInputStream fis = new FileInputStream(FILE_BOOKS);
        Workbook workbook = new HSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();
//        Author author = new Author(book.getAuthor().getName(), book.getAuthor().getSurname(), book.getAuthor().getBirthday());
//        AuthorRepositoryFileImpl.getInstance().addAuthor(author);
            Row row = sheet.createRow(sheet.getLastRowNum()+1);
//            DataFormat format = workbook.createDataFormat();
//            CellStyle dateStyle = workbook.createCellStyle();
//            dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
//            Cell birthdate = row.createCell(3);
//            birthdate.setCellStyle(dateStyle);
           row.createCell(1).setCellValue("aaaaaa");
//        row.createCell(0).setCellValue(book.getAuthor().getName());
//        row.createCell(1).setCellValue(book.getAuthor().getSurname());
//        row.createCell(2).setCellValue(book.getAuthor().getBirthday().toString());
//        row.createCell(3).setCellValue(book.getTitle());
//        row.createCell(4).setCellValue(book.getNumberOfPages());
//        row.createCell(5).setCellValue(book.getCategory());
            fis.close();
        FileOutputStream out = new FileOutputStream(FILE_BOOKS, true);
            workbook.write(out);
            workbook.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

