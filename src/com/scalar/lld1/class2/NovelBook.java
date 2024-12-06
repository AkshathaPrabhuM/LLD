package com.scalar.lld1.class2;

public class NovelBook extends Book {
    private String genre;

    public NovelBook(String isbn, String title, String author, String genre) {
        super(isbn, title, author, "Novel Book");
        this.genre = genre;
    }

    @Override
    public void displayBookDetails() {
        System.out.println("Novel Book Details");
        System.out.println("Book title" + title);
        System.out.println("Book author" + author);
        System.out.println("Book genre" + genre);
    }
}
