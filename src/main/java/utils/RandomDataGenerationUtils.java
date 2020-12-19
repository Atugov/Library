package utils;

import constants.Constants;
import model.Author;
import model.Book;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomDataGenerationUtils {
    static Random random = new Random();

    public static int getRandomNumber(int from, int to) {
        int randomNumber = from + random.nextInt(to - from);
        return randomNumber;
    }


    public static LocalDate getRandomDate() { ;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, RandomDataGenerationUtils.getRandomNumber(1700, 2020));
        calendar.set(Calendar.MONTH, RandomDataGenerationUtils.getRandomNumber(0, 12));
        calendar.set(Calendar.DAY_OF_MONTH, RandomDataGenerationUtils.getRandomNumber(0,30));
        LocalDate result = calendar.toZonedDateTime().toLocalDate();
        return result;
    }
    public static Author createRandomAuthor(){
        int randomOfNames = getRandomNumber(0, Constants.NAMES.length);
        int randomOfSurnames = getRandomNumber(0, Constants.SURNAMES.length);
        Author author = new Author(Constants.NAMES[randomOfNames], Constants.SURNAMES[randomOfSurnames], getRandomDate());
        return author;
    }
    public static Book createRandomBook(){
        int randomOfTitles = getRandomNumber(0, Constants.TITLES.length);
        int randomNumberOfPages = getRandomNumber(0, 1000);
        int randomOfCategories = getRandomNumber(0, Constants.CATEGORIES.length);
        Book book = new Book(createRandomAuthor(),Constants.TITLES[randomOfTitles], randomNumberOfPages,Constants.CATEGORIES[randomOfCategories]);
        return book;
    }
}