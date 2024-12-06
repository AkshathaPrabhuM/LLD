package com.scalar.lld1.class2;

public class TextBook extends Book {
    private String subject;
    private int edition;

    public TextBook(String isbn, String title, String author, String subject, int edition) {
        super(isbn, title, author);
        this.subject = subject;
        this.edition = edition;
    }

    @Override
    public void displayBookDetails() {
        System.out.println("Text Book Details");
        System.out.println("Book title:" + title);
        System.out.println("Book author:" + author);
        System.out.println("Book subject:" + subject);
        System.out.println("Book edition:" + edition);
    }
}
