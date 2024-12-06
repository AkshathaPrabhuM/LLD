package com.scalar.lld1.class2;

public class Client {

    public static void main(String[] args) {

        Book book1 = new TextBook("123", "Title", "ABC", "Biology", 1);
        Book book2 = new NovelBook("234", "Tota;", "XYZ", "Romance");

        User user1 = new Member("Aks", "111");
        User user2 = new Member("Axe", "222");
        User librarian  = new Librarian("1","lib", "333");

        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        libraryManagementSystem.addBook(book1);
        libraryManagementSystem.addBook(book2);

        libraryManagementSystem.registerUser(user1);
        libraryManagementSystem.registerUser(user2);
        libraryManagementSystem.registerUser(librarian);

        if(book1.lend(user1))
        {
            System.out.println("Successfully Book Lend to user1");
        }

        if(book1.lend(user2))
        {
            System.out.println("Successfully Book Lend to user2");
        }
        else {
            System.out.println("Book Not Lend to user2");
        }

        book1.returnBook(user1);

        if(book1.lend(user2))
        {
            System.out.println("Successfully Book Lend to user2");
        }
        else {
            System.out.println("Book Not Lend to user2");
        }
        book1.returnBook(user2);


    }
}
