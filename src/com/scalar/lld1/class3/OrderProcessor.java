package com.scalar.lld1.class3;

import java.util.PriorityQueue;

public class OrderProcessor {
    PriorityQueue<Order> orders;

    public OrderProcessor() {
        orders = new PriorityQueue<>();
    }

    void addOrder(Order order) {
        orders.add(order);
    }

    void processOrder() {
        if (!orders.isEmpty()) {
            Order order = orders.poll();
            // Do the task
            System.out.println(order);
        }
    }

    void processOrders() {
        while (!orders.isEmpty()) {
            Order order = orders.poll();
            // Do the task
            System.out.println(order);
        }
    }
}
