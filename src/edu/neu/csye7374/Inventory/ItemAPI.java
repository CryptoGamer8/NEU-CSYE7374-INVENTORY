package edu.neu.csye7374.Inventory;

public interface ItemAPI {
    public void setId(int id);
    public int getId();
    public void setName(String name);
    public String getName();
    public void setPrice(double price);
    public double getPrice();
    public void setPD(String date);  // production date
    public String getPD();
    public void setExp(String date); // expiration date
    public String getExp();
    public void setLocation(String location);
    public String getLocation();
}
