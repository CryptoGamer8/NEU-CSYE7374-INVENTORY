package edu.neu.csye7374.Order;

import java.util.List;

public interface InvoiceAPI {
    public void setId(int id);
    public int getId();
    public void setItemId(int id);
    public int getItemId();
    public void setClientId(int id);
    public int getClientId();
    public void setEmployeeId(int id);
    public int getEmployeeId();
    public void setPurchaseDate(String date);
    public String getPurchaseDate();
}
