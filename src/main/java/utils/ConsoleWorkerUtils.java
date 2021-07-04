package utils;

import constants.Constants;
import controllers.ConsolController;
import model.Author;
import model.Book;
import model.user.LibraryUser;
import model.user.User;
import repository.UserRepositoryListImpl;
import service.UserService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleWorkerUtils {
    private static Scanner scanner;

    public static LibraryUser logginingIn() {
        scanner = new Scanner(System.in);
        System.out.println("Введите логин:");
        String login = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        return UserService.getInstance().checkUserExist(login, password);
    }

    public static Author registerNewAuthor() {
        System.out.println("Введите имя  автора:");
        String name = getSomeStringWithLetters("name");
        System.out.println("Введите фамилию автора:");
        String surname = getSomeStringWithLetters("surname");
        return new Author(name, surname, getSomeDate());
    }

    private static boolean containsLettersOnly(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher match = pattern.matcher(str);
        return match.matches();
    }

    private static boolean containsSymbolsOnly(String str) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher match = pattern.matcher(str);
        return match.matches();
    }

    private static boolean containsNumbesOnly(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher match = pattern.matcher(str);
        return match.matches();
    }

    private static LocalDate getSomeDate() {
        System.out.println("Введите год:");
        int year = enterYear();
        System.out.println("Введите месяц:");
        int month = enterMonth();
        System.out.println("Введите день:");
        int day = enterDay();
        String date = day + "-" + month + "-" + year;
        while (!isDateValid(date)) {
            System.out.println("There is no such day in this month in " + year + " year");
            System.out.println("Try again or enter -1 to out");
            day = scanner.nextInt();
            date = day + "-" + month + "-" + year;
            if (day == -1) {
                ConsolController.getInstance().startApplication();
            }
        }
        return LocalDate.of(year, month, day);
    }

    private static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    private static String getSomeStringWithLetters(String string) {
        scanner = new Scanner(System.in);
        string = scanner.next();
        while (!containsLettersOnly(string)) {
            System.out.println("Wrong " + string);
            System.out.println("Try again or enter -1 to out");
            string = scanner.next();
            if (string.equals("-1")) {
                ConsolController.getInstance().startApplication();
            }
        }
        return string;
    }

    private static String getSomeStringWithSymbols(String string) {
        scanner = new Scanner(System.in);
        string = scanner.next();
        while (!containsSymbolsOnly(string)) {
            System.out.println("Wrong " + string);
            System.out.println("Try again or enter -1 to out");
            string = scanner.next();
            if (string.equals("-1")) {
                ConsolController.getInstance().startApplication();
            }
        }
        return string;
    }

    private static int enterYear() {
        String strYear;
        int year;
        while (true) {
            strYear = scanner.next();
            if (containsNumbesOnly(strYear)) {
                year = Integer.parseInt(strYear);
                break;
            }
            if (strYear.equals("-1")) {
                ConsolController.getInstance().startApplication();
            } else {
                System.out.println("Введите год от 1500 до 2005");
                System.out.println("Или введите -1 чтобы выйти в меню");
            }
        }
        while (year < 1500 || year > 2005) {
            System.out.println("Range of a year is since 1500 up to 2005.");
            System.out.println("Try again or enter -1 to out");
            year = scanner.nextInt();
            if (year == -1) {
                ConsolController.getInstance().startApplication();
            }
        }
        return year;
    }

    private static int enterMonth() {
        int month;
        String strMonth;
        while (true) {
            strMonth = scanner.next();
            if (containsNumbesOnly(strMonth)) {
                month = Integer.parseInt(strMonth);
                break;
            }
            if (strMonth.equals("-1")) {
                ConsolController.getInstance().startApplication();
            } else {
                System.out.println("Введите номер месяца");
                System.out.println("Или введите -1 чтобы выйти в меню");
            }
        }
        while (month < 1 || month > 12) {
            System.out.println("Range of month is since 1 up to 12");
            System.out.println("Try again or enter -1 to out");
            month = scanner.nextInt();
            if (month == -1) {
                ConsolController.getInstance().startApplication();
            }
        }
        return month;
    }

    private static int enterDay() {
        int day;
        String strDay;
        while (true) {
            strDay = scanner.next();
            if (containsNumbesOnly(strDay)) {
                day = Integer.parseInt(strDay);
                break;
            }
            if (strDay.equals("-1")) {
                ConsolController.getInstance().startApplication();
            } else {
                System.out.println("Введите день");
                System.out.println("Или введите -1 чтобы выйти в меню");
            }
        }
        return day;
    }
    ///////***        Добавление книги     ******//////////

    public static Book registerNewBook() {
        Author authorForBook = registerNewAuthor();
        System.out.println("Введите название книги:");
        String title = getSomeStringWithSymbols("title");
        System.out.println("Введите количество страниц:");
        String numOfPages;
        int pages;
        while (true) {
            numOfPages = scanner.next();
            if (containsNumbesOnly(numOfPages)) {
                pages = Integer.parseInt(numOfPages);
                break;
            }
            if (numOfPages.equals("-1")) {
                ConsolController.getInstance().startApplication();
            } else {
                System.out.println("Введите цифру:");
                System.out.println("Или введите -1 чтобы выйти в меню");
            }
        }
        System.out.println("Введите  категорию книги:");
        String category = getSomeStringWithSymbols("category:");
        return new Book(authorForBook, title, pages, category);

    }

    ///////***        Добавление пользователя     ******//////////
    public static User registerNewUser() {
        int id = 1;
        for (User a : UserRepositoryListImpl.getInstance().getAllUsers()) {
            while (a.getUserId() == id) {
                id += 1;
            }
        }
        System.out.println("Введите login:");
        String login = getSomeStringWithLetters("login:");
        for (User a : UserRepositoryListImpl.getInstance().getAllUsers()) {
            while (a.getLogin().equals(login)) {
                System.out.println("Такой логин уже существует, введите другой");
                login = getSomeStringWithLetters("login:");
            }
        }
        System.out.println("Введите пароль:");
        String password = getSomeStringWithLetters("password:");
        String name = "emptyName";
        String email = "emptyEmail";
        UserService.getInstance().addNewLibraryUser(new LibraryUser(id, name, email, null));

        return new User(id, login, password);

    }

    public static LibraryUser changeDateOfBirthInProfile(LibraryUser libraryUser) {
        System.out.println("Введите вашу дату рождения:");
        libraryUser.setDateOfBirth(getSomeDate());
        return libraryUser;
    }

    public static LibraryUser changeNameInProfile(LibraryUser libraryUser) {
        System.out.println("Введите ваше имя:");
        libraryUser.setName(getSomeStringWithLetters("name:"));
        return libraryUser;
    }

    public static LibraryUser changeEmailInProfile(LibraryUser libraryUser) {
        System.out.println("Введите ваш email:");
        libraryUser.setEmail(getSomeStringWithSymbols("email:"));
        return libraryUser;
    }

    public static void listPrinter(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder(list.get(i).toString());
            if (isNumeric(list.get(i).toString().substring(0, 1)))
                System.out.println(sb.insert(1, "."));
            else {
                System.out.println(sb.insert(1, i + 1 + "."));
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d");  //match a number with optional '-' and decimal.
    }

}
