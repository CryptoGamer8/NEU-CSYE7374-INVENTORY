package edu.neu.csye7374.Observer;

import java.util.ArrayList;
import java.util.List;

public class TodayDate implements Observable{

    private String date;
    private List<Observer> list;

    public TodayDate(){
        list = new ArrayList<>();
    }
    @Override
    public void register(Observer obs) {
        list.add(obs);
    }

    @Override
    public void updateAll() {
        for(Observer obs:list){
            obs.update(getDate());
        }
    }

    @Override
    public void clearAll() {
        list.clear();
    }

    public void setDate(String date){
        this.date = date;
        updateAll();
    }

    public String getDate(){
        return this.date;
    }
}
