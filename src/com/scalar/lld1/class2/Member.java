package com.scalar.lld1.class2;

public class Member extends User{

    private int borrowedBooksCount;
    private final int MAX_BORROW_LIMIT = 5;

    public Member(String name, String contactNo)
    {
        super(name, contactNo);
        borrowedBooksCount = 0;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Member Dashboard");
        System.out.println("Books Borrowed: " + borrowedBooksCount);
    }

    @Override
    public boolean canBorrowBooks() {
        return borrowedBooksCount < MAX_BORROW_LIMIT;
    }
}
