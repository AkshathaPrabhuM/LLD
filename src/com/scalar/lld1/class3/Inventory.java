package com.scalar.lld1.class3;

import java.util.*;

public class Inventory<T extends Item> {

    private Map<String, T> items;

    public Inventory() {
        items = new HashMap<String, T>();
    }

    public void addItem(T item) {
        items.put(item.getId(), item);
    }

    public void removeItem(String id) {
        items.remove(id);
    }

    public T getItem(String id) {
        return items.get(id);
    }

    public List<T> getAllItems() {
        return new ArrayList<T>(items.values());
    }

}
