package com.example.fetch7;


public class Item implements Comparable<Item> {
    private int id;
    private int listId;
    private String name;

    // Constructor, getters and setters
    public Item(int id, int listId, String name) {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public void setName(String name) {
        this.name = name;
    }

    // compareTo for sorting
    @Override
    public int compareTo(Item other) {
        int listIdComparison = Integer.compare(this.listId, other.listId);
        if (listIdComparison != 0) {
            return listIdComparison;
        } else {
            // Assuming name is not null because we filter out null names
            return this.name.compareTo(other.name);
        }
    }
}
