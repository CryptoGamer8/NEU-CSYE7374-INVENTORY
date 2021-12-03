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
        item.setId(id);
        item.setName(name);
        item.setPD(PD);
        item.setExp(Exp);
        item.setPrice(price);
        item.setLocation(location);
        return item;
    }
}
