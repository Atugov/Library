package model;

import utils.RandomDataGenerationUtils;

import java.time.LocalDate;
import java.util.Objects;

public class Author {
    private String name;
    private String surname;
    private LocalDate birthday;

    public static int counter = 0;

    public Author(String n, String s, LocalDate b) {
        name = n;
        surname = s;
        birthday = b;
        counter++;
    }

    public Author() {
        name = "Author";
        surname = "Authorov";
        birthday = LocalDate.of(1900, 1, 1);
        counter++;
    }

    public Author(String n, String s) {
        name = n;
        surname = s;
        birthday = LocalDate.of(1900, 1, 1);
    }

    public Book writeBook() {
        Author aut = this;
        int numberOfPages = RandomDataGenerationUtils.getRandomNumber(0, 1200);
        String title = "SomeBook";
        String category = "abc";
        Book newBook = new Book(aut, title, numberOfPages, category);
        return newBook;
    }

    public Book createBook(String titleOfBook) {
        Author author = this;
        String title = "AnyBook";
        int numOfPages = RandomDataGenerationUtils.getRandomNumber(0, 1200);
        String category = "rasskaz";
        Book newBook1 = new Book(author, title, numOfPages, category);
        return newBook1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(surname, author.surname) &&
                Objects.equals(birthday, author.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday);
    }

    @Override
    public String toString() {
        return "\n Author " +
                "name " + name +
                ", surname " + surname +
                ", birthday " + birthday;
    }
}
