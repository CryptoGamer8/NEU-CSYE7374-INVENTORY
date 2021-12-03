package edu.neu.csye7374.Observer;

public interface Observable {
    public void register(Observer obs);
    public void updateAll();
    public void clearAll();
}
