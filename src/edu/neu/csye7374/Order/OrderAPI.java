package edu.neu.csye7374.Order;

import java.util.List;

public interface OrderAPI {
    public static Order getInstance() {
        return null;
    }
    public void appendInvoice(InvoiceAPI invoice);
    public boolean deleteInvoice(int id);
    public InvoiceAPI getInvoice(int id);
    public List<InvoiceAPI> getAllInvoice();
    public void updateInvoice(int id, InvoiceAPI newInvoice);
    public void addAllInvoice(List<InvoiceAPI> list);
    public void clearAll();
}
