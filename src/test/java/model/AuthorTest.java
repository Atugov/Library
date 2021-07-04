package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
    @Test
    public void authorArrayCreationExample(){
        Author[] authors = new Author[100];
        for (int i = 0; i < 100; i++){
            authors[i] = new Author();
        }
        authors[1] = new Author("Petr", "James", LocalDate.of(1700,2,2));
        authors[12] = new Author("Alex", "Cheng", LocalDate.of(1750,2,2));
        authors[23] = new Author("Fedr", "Dru", LocalDate.of(1800,2,2));
        authors[39] = new Author("Jame",  "Smith", LocalDate.of(1900,1,1));

        for (int i = 0; i < 100; i++){
            System.out.println("author is " + (i + 1) + " " + authors[i]);
        }
    }

}