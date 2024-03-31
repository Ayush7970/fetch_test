package com.example.fetch7;

// Defines a class that represents an item, including details like id, listId, and name.
// It implements Comparable to allow sorting of Item objects.
public class Item implements Comparable<Item> {
    private int id; // Unique identifier for the item.
    private int listId; // Identifier to group items into lists.
    private String name; // Name of the item.

    // Constructor to initialize an Item object with an id, listId, and name.
    public Item(int id, int listId, String name) {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }

    // Getter for the item's id.
    public int getId() {
        return id;
    }

    // Getter for the item's listId.
    public int getListId() {
        return listId;
    }

    // Getter for the item's name.
    public String getName() {
        return name;
    }

    // Setter for the item's id.
    public void setId(int id) {
        this.id = id;
    }

    // Setter for the item's listId.
    public void setListId(int listId) {
        this.listId = listId;
    }

    // Setter for the item's name.
    public void setName(String name) {
        this.name = name;
    }

    // Method to compare this item with another item to determine their order.
    // Sorting is primarily by listId, then by name alphabetically.
    @Override
    public int compareTo(Item other) {
        // First compare by listId.
        int listIdComparison = Integer.compare(this.listId, other.listId);
        if (listIdComparison != 0) {
            return listIdComparison; // If listIds are not equal, determine order by listId.
        } else {
            // If listIds are equal, compare by name. Assumes names are non-null.
            return this.name.compareTo(other.name);
        }
    }
}
