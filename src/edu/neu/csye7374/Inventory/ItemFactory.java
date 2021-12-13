package edu.neu.csye7374.Inventory;

public class ItemFactory {
    private static ItemFactory factory;

    private ItemFactory(){
    }

    public static ItemFactory getInstance(){
        if(factory==null){
            factory = new ItemFactory();
        }
        return factory;
    }

    public ItemAPI produceItem(int id, String name, String PD, String Exp, double price, String location){
        ItemAPI item = new Item();
        if (validationCheck(id)) {
            item.setId(id);
            item.setName(name);
            item.setPD(PD);
            item.setExp(Exp);
            item.setPrice(price);
            item.setLocation(location);
        } else {
            item.setId(-1);
        }
        return item;
    }

    protected ItemAPI produceItemFromFile(int id, String name, String PD, String Exp, double price, String location){
        ItemAPI item = new Item();
        item.setId(id);
        item.setName(name);
        item.setPD(PD);
        item.setExp(Exp);
        item.setPrice(price);
        item.setLocation(location);
        return item;
    }

    private boolean validationCheck(int itemId) {
        Inventory inventory = Inventory.getInstance();
        boolean noItem = true;
        for (ItemAPI i : inventory.getItemAll()) {
            if (i.getId() == itemId) {
                noItem = false;
                break;
            }
        }
        return noItem;
    }
}
