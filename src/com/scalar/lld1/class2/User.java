package com.scalar.lld1.class2;

import java.util.Random;

public abstract class User {
    private String userId;
    String name;
    String contactNo;

    private static int totalUsers;

    public User() {
        this.userId = generateUniqueId();
        totalUsers = 0;
    }

    public User(String name, String contactNo) {
        super();
        this.name = name;
        this.contactNo = contactNo;
    }

    public User(User user) {
        super();
        this.name = user.name;
        this.contactNo = user.contactNo;
    }

    private final String generateUniqueId() {
        totalUsers++;
        return "User" + totalUsers;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public abstract void displayDashboard();

    public abstract boolean canBorrowBooks();

    public static int getTotalUsers() {
        return totalUsers;
    }
}
