package com.scalar.lld1.class3;

import java.util.PriorityQueue;

public class Order implements Comparable<Order> {
    private String orderID;
    private boolean isExpress;

    public Order(String orderID, boolean isExpress) {
        this.orderID = orderID;
        this.isExpress = isExpress;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setExpress(boolean express) {
        isExpress = express;
    }

    @Override
    public int compareTo(Order o) {
        if (this.isExpress && !o.isExpress) {
            return -1;
        } else if (!this.isExpress && o.isExpress) {
            return 1;
        }
        return this.orderID.compareTo(o.orderID);
    }
}
