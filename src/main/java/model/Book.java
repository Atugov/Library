package model;

public class Book {
    private Author author;
    private String title;
    private int numberOfPages;
    private String category;

    public Book(){
        author = new Author();
        title = "Kniga";
        numberOfPages = 100;
        category = "Rasskaz";
    }

    public Book(Author author, String title, int numberOfPages, String category) {
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.category = category;
    }

    public void presentateBook(){
        System.out.println("Author is $" + author + "$," + " Title is #" +  title + "#," + " Number of pages is %" + numberOfPages + "%, " + "Category is @" + category + "@");
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return
                author.toString() +
                ", title is " + title +
                ", numberOfPages is " + numberOfPages +
                ", category is " + category;
    }
}

