package com.scalar.lld1.class3;

import java.util.LinkedList;

public class RecentlyViewedItem {
    private LinkedList<Item> recentlyViewedItems;

    public RecentlyViewedItem() {
        recentlyViewedItems = new LinkedList<>();
    }

    public void addRecentlyViewedItem(Item item) {
        if (recentlyViewedItems.contains(item)) {
            recentlyViewedItems.remove(item);
            recentlyViewedItems.addFirst(item);
        } else {
            if (recentlyViewedItems.size() < 10) {
                recentlyViewedItems.addFirst(item);
            } else {
                recentlyViewedItems.removeLast();
                recentlyViewedItems.addFirst(item);
            }
        }
    }
}
