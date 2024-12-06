package com.scalar.lld1.class2;

public abstract class Book implements Lendable {
    private String isbn;
    protected String title;
    protected String author;
    private boolean isAvailable;

    private String type;

    public Book()
    {
        isAvailable = true;
    }

    public Book(String isbn, String title, String author, String type)
    {
        isAvailable = true;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.type = type;
    }

    public Book(Book book)
    {
        isAvailable = true;
        this.isbn = book.isbn;
        this.title = book.title;
        this.author = book.author;
    }

    public String getType() {
        return type;
    }



    @Override
    public boolean lend(User user) {
        if(isAvailable && user.canBorrowBooks()) {
            System.out.println("Book is available, lending it to user:" + user.getName());
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public void returnBook(User user) {
        System.out.println("Book returned by user " + user.getName());
        isAvailable = true;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public abstract void displayBookDetails();
}
