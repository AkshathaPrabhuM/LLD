package com.scalar.lld1.class3;

import java.util.LinkedList;

public class RecentlyViewedItem {
    private LinkedList<Item> recentlyViewedItems;

    public RecentlyViewedItem() {
        recentlyViewedItems = new LinkedList<>();
    }

    public void addRecentlyViewedItem(Item item) {
        if (recentlyViewedItems.size() < 10) {
            recentlyViewedItems.add(item);
        } else {
            recentlyViewedItems.removeFirst();
            recentlyViewedItems.add(item);
        }
    }
}
