package model.user;

import model.Book;

import java.time.LocalDate;

public class LibraryUser {
    private int userId;
    private String name;
    private String email;
    private LocalDate dateOfBirth;

    public LibraryUser() {
        name = "User";
        email = "a@b.com";
        dateOfBirth = LocalDate.of(1990, 1, 15);
    }

    public LibraryUser(int userId, String name, String email, LocalDate dateOfBirth) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public LibraryUser(String email, LocalDate dateOfBirth) {
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.name = "some user";
    }

    public void readBook() {
        System.out.println(name + " is reading some book");

    }

    public void readBook(Book b) {
        System.out.println(name + " is reading " + b.getTitle() + " which was written by " + b.getAuthor());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return userId + "\t" + name + "\t" + email + "\t" + dateOfBirth +"\n";
    }
}
