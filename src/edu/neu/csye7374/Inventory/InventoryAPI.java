package edu.neu.csye7374.Inventory;

import java.util.List;

public interface InventoryAPI {
    public static Inventory getInstance() {
        return null;
    }
    /**
     * Add item to .csv file
     * @param item
     */
    public void appendItem(ItemAPI item);
    /**
     * Get all items from .csv file. Delete the one, then write back.
     * @param id
     * @return true if item exists, false if item doesn't exist.
     */
    public boolean deleteItem(int id);
    /**
     * Get the first item with this id from .csv file
     * @param id
     * @return item if there is a match. Otherwise, return null.
     */
    public ItemAPI getItem(int id);
    /**
     * Get all items from .csv file
     * @return
     */
    public List<ItemAPI> getItemAll();
    /**
     * If id exists, update the item. Otherwise, append this item.
     * @param id
     * @param newItem
     */
    public void updateItem(int id, ItemAPI newItem);
    /**
     * Rewrite .csv file with given items. This will clear the file first.
     * @param list
     */
    public void addAllItem(List<ItemAPI> list);
    public void clearAll();

    /**
     * @param id
     * @return The location of this item. If not exists, return "Item is not found."
     */
    public String trackItem(int id);

    /**
     * Append location to the item specified. If not exists, nothing happens.
     * @param id
     * @param location
     */
    public void addLocationToItem(int id, String location);
}
