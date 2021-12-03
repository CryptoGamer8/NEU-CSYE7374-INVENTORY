package edu.neu.csye7374.Inventory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryAPI{
    private final String PATH = "inventory.csv";
    private static Inventory inventory;
    private PrintWriter pw;
    private ItemFactory factory;

    private Inventory() {
        factory = ItemFactory.getInstance();
    }

    public static Inventory getInstance() {
        if (inventory == null) {
            inventory = new Inventory();
        }
        return inventory;
    }

    public void appendItem(ItemAPI item) {
        try {
            pw = new PrintWriter(new FileOutputStream(new File(PATH), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(item.toString());
        pw.close();
    }

    public boolean deleteItem(int id) {
       List<ItemAPI> list = getItemAll();
       int i = 0;
       for(;i<list.size();i++){
           if(list.get(i).getId()==id){
               break;
           }
       }
       if(i==list.size()){
           return false;
       }
       list.remove(i);
       // rewrite all
       addAllItem(list);
       return true;
    }


    public ItemAPI getItem(int id) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(PATH)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if(Integer.parseInt(arr[0])==id){
                    ItemAPI item = factory.produceItem(id,arr[1],arr[2],arr[3],Double.parseDouble(arr[4]),arr[5]);
                    return item;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ItemAPI> getItemAll() {
        List<ItemAPI> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(PATH)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                ItemAPI item = factory.produceItem(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3],Double.parseDouble(arr[4]),arr[5]);
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateItem(int id, ItemAPI newItem) {
        List<ItemAPI> list = getItemAll();
        for (int i = 0; i < list.size(); i++) {
            ItemAPI item = list.get(i);
            if(item.getId()==id){
                list.set(i, newItem);
                addAllItem(list);
                return;
            }
        }
        list.add(newItem);
        addAllItem(list);
    }

    public void addAllItem(List<ItemAPI> list){
        try {
            pw = new PrintWriter(new FileOutputStream(new File(PATH), false));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(ItemAPI item:list){
            pw.write(item.toString());
        }
        pw.close();
    }

    public void clearAll(){
        try {
            pw = new PrintWriter(new FileOutputStream(new File(PATH), false));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write("");
        pw.close();
    }

    @Override
    public String trackItem(int id) {
        ItemAPI item = getItem(id);
        if(item!=null){
            return item.getLocation();
        }
        return "Item is not found.";
    }

    @Override
    public void addLocationToItem(int id, String location) {
        ItemAPI item = getItem(id);
        if(item!=null){
            String s = item.getLocation();
            item.setLocation(s+" -- "+location);
            updateItem(id,item);
        }
    }
}
