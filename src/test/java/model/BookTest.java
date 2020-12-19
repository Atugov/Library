package model;


import org.junit.jupiter.api.Test;

class BookTest {
    @Test
    public void BooksArray() {
        Book[] books = new Book[100];
        for (int i = 0; i < 100; i++) {
            books[i] = new Book();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("The book is " + (i + 1) + " " + books[i]);
        }

    }

    }

