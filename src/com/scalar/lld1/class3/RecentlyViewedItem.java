package com.scalar.lld1.class3;

import java.util.LinkedList;

public class RecentlyViewedItem {
    private LinkedList<Item> recentlyViewedItems;
    private int capacity;

    public RecentlyViewedItem(int capacity) {
        recentlyViewedItems = new LinkedList<>();
        this.capacity = capacity;
    }

    public void addRecentlyViewedItem(Item item) {
        recentlyViewedItems.remove(item);
        recentlyViewedItems.addFirst(item);
        if (recentlyViewedItems.size() > capacity) {
            recentlyViewedItems.removeLast();
        }
    }
}
