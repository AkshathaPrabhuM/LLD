package com.scalar.lld1.class2;


public class Librarian extends User {

    private String employeeNumber;

    public Librarian(String employeeNumber, String name, String contact) {
        super(name, contact);
        this.employeeNumber = employeeNumber;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Librarian Dashboard");
        System.out.println("Employee Number: " + employeeNumber);
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }

    public void addNewBook(Book book)
    {

    }

    public void removeBook(Book book)
    {

    }
}
