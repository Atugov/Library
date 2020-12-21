package utils;

import constants.Constants;
import controllers.ConsolController;
import model.Author;
import model.Book;
import model.user.LibraryUser;
import model.user.User;
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

    public LibraryUser logginingIn() {
        scanner = new Scanner(System.in);
        System.out.println("Введите логин:");
        String login = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        return UserService.getInstance().checkUserExist(login, password);
    }

    public static Author registerNewAuthor() {
        scanner = new Scanner(System.in);
        System.out.println("Введите имя  автора:");
        String name = scanner.next();
        while (!containsLettersOnly(name)) {
            System.out.println("Wrong name");
            System.out.println("Try again or enter -1 to out");
            name = scanner.next();
            if (name.equals("-1")) {
                ConsolController.getInstance().startApplication();
            }
        }

        System.out.println("Введите фамилию автора:");
        String surname = scanner.next();
        while (!containsLettersOnly(surname)) {
            System.out.println("Wrong surname");
            System.out.println("Try again or enter -1 to out");
            surname = scanner.next();
            if (name.equals("-1")) {
                ConsolController.getInstance().startApplication();
            }
        }
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
        return new Author(name, surname, LocalDate.of(year, month, day));
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

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    public static int enterYear() {
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

    public static int enterMonth() {
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

    public static int enterDay() {
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
        scanner = new Scanner(System.in);
        System.out.println("Введите название книги:");
        String title = scanner.next();
        while (!containsSymbolsOnly(title)) {
            System.out.println("Wrong name");
            System.out.println("Try again or enter -1 to out");
            title = scanner.next();
            if (title.equals("-1")) {
                ConsolController.getInstance().startApplication();
            }
        }
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
                System.out.println("Введите цифру");
                System.out.println("Или введите -1 чтобы выйти в меню");
            }
        }
        System.out.println("Введите  категорию книги:");
        String category = scanner.next();
        while (!containsSymbolsOnly(category)) {
            System.out.println("Wrong category");
            System.out.println("Try again or enter -1 to out");
            category = scanner.next();
            if (title.equals("-1")) {
                ConsolController.getInstance().startApplication();
            }
        }
        return new Book(authorForBook, title, pages, category);

    }

    ///////***        Добавление пользователя     ******//////////
    public static User registerNewUser() {
        int id = RandomDataGenerationUtils.getRandomNumber(1, 100000);
        scanner = new Scanner(System.in);
        System.out.println("Введите email:");
        String email = scanner.next();
        while (!containsLettersOnly(email)) {
            System.out.println("Wrong email");
            System.out.println("Try again or enter -1 to out");
            email = scanner.next();
            if (email.equals("-1")) {
                ConsolController.getInstance().startApplication();
            }
        }
        scanner = new Scanner(System.in);
        System.out.println("Введите password:");
        String password = scanner.next();
        while (!containsLettersOnly(password)) {
            System.out.println("Wrong password");
            System.out.println("Try again or enter -1 to out");
            password = scanner.next();
            if (password.equals("-1")) {
                ConsolController.getInstance().startApplication();
            }
        }
        return new User(id, email, password);

    }



    public void listPrinter(List<?> list) {

        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder(list.get(i).toString());
            System.out.println(sb.insert(1, i+1+"."));
        }


    }

}
