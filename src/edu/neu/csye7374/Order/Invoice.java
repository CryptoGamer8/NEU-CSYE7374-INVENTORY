package edu.neu.csye7374.Order;

import java.util.ArrayList;
import java.util.List;

public class Invoice implements InvoiceAPI{
    private int id;
    private int itemId;
    private int clientId;
    private int employeeId;
    private String purchaseDate;

    public Invoice(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        sb.append(",");
        sb.append(getItemId());
        sb.append(",");
        sb.append(getClientId());
        sb.append(",");
        sb.append(getEmployeeId());
        sb.append(",");
        sb.append(getPurchaseDate());
        sb.append("\n");
        return sb.toString();
    }
}
