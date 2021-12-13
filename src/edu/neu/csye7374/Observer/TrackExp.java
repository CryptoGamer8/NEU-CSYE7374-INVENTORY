package edu.neu.csye7374.Observer;

import edu.neu.csye7374.Inventory.Inventory;
import edu.neu.csye7374.Inventory.ItemAPI;

import java.util.ArrayList;
import java.util.List;

public class TrackExp implements Observer{
    private String date;

    public TrackExp(){
        date = "1970-01-01";
    }

    @Override
    public void update(String date) {
        this.date = date;
    }

    public List<ItemAPI> getAllExpItem(){
        Inventory inventory = Inventory.getInstance();
        List<ItemAPI> list = inventory.getItemAll();
        List<ItemAPI> res = new ArrayList<>();
        for(ItemAPI item:list){
            if(withinOneMonth(date, item.getExp())){
                res.add(item);
            }
        }
        return res;
    }

    /**
     * s2 - 30d <= s1 <= s2, return true
     * @param s1
     * @param s2
     * @return
     */
    private boolean withinOneMonth(String s1, String s2){
        String[] s1_arr = s1.split("-");
        int y1 = Integer.parseInt(s1_arr[0]);
        int m1 = Integer.parseInt(s1_arr[1]);
        int d1 = Integer.parseInt(s1_arr[2]);

        String[] s2_arr = s2.split("-");
        int y2 = Integer.parseInt(s2_arr[0]);
        int m2 = Integer.parseInt(s2_arr[1]);
        int d2 = Integer.parseInt(s2_arr[2]);

        if(y1==y2 && m1==m2){
            return d1<=d2;
        }
        else if(y2*12+m2 == y1*12+m1+1){
            return d2<=d1;
        }
        return false;
    }
}
