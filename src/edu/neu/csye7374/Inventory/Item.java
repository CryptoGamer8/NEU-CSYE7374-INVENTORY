package edu.neu.csye7374.Inventory;

public class Item implements ItemAPI{
    private int id;
    private String name;
    private String PD;
    private String Exp;
    private double price;
    private String location;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPD(String date) {
        this.PD = date;
    }

    @Override
    public String getPD() {
        return this.PD;
    }

    @Override
    public void setExp(String date) {
        this.Exp = date;
    }

    @Override
    public String getExp() {
        return this.Exp;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId());
        sb.append(",");
        sb.append(this.getName());
        sb.append(",");
        sb.append(this.getPD());
        sb.append(",");
        sb.append(this.getExp());
        sb.append(",");
        sb.append(this.getPrice());
        sb.append(",");
        sb.append(this.getLocation());
        sb.append("\n");
        return sb.toString();
    }
}
