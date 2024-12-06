package com.scalar.lld1.class2;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> bookInventory;
    private List<User> registeredUsers;

    LibraryManagementSystem() {
        bookInventory = new ArrayList<Book>();
        registeredUsers = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookInventory.add(book);
    }

    public void registerUser(User user) {
        registeredUsers.add(user);
    }

    public Book searchBook(String criteria) {
        for (Book book : bookInventory) {
            if (book.getAuthor().equalsIgnoreCase(criteria) || book.getTitle().equalsIgnoreCase(criteria)) {
                return book;
            }
        }
        return null;
    }

    public Book seachBook(String criteria, String type) {
        for (Book book : bookInventory) {
            if ((book.getAuthor().equalsIgnoreCase(criteria) || book.getTitle().equalsIgnoreCase(criteria)) && book.getType().equals(type)) {
                return book;
            }
        }
        return null;
    }
}
