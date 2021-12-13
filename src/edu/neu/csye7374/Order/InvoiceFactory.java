package edu.neu.csye7374.Order;

import edu.neu.csye7374.Inventory.Inventory;
import edu.neu.csye7374.Inventory.Item;
import edu.neu.csye7374.Inventory.ItemAPI;
import edu.neu.csye7374.Personnel.PersonAPI;
import edu.neu.csye7374.Personnel.Personnel;

public class InvoiceFactory {
    private static InvoiceFactory factory;

    private InvoiceFactory(){};

    public static InvoiceFactory getInstance(){
        if(factory==null){
            factory = new InvoiceFactory();
        }
        return factory;
    }

    // will return an empty invoice with id = -1 if itemId or clientId do not exist
    public InvoiceAPI produceInvoice(int id, int itemId, int clientId, int employeeId, String purchaseDate){
        InvoiceAPI invoice = new Invoice();

        if (validationCheck(itemId, employeeId)) {
            invoice.setId(id);
            invoice.setItemId(itemId);
            invoice.setClientId(clientId);
            invoice.setEmployeeId(employeeId);
            invoice.setPurchaseDate(purchaseDate);
        } else {
            invoice.setId(-1);
        }

        return invoice;

    }

    private boolean validationCheck(int itemId, int employeeId) {
        Inventory inventory = Inventory.getInstance();
        Personnel personnel = Personnel.getInstance();
        boolean hasItem = false;
        boolean hasEmployee = false;
        for (ItemAPI i : inventory.getItemAll()) {
            if (i.getId() == itemId) {
                hasItem = true;
                break;
            }
        }
        for (PersonAPI p : personnel.getAllEmployee()) {
            if (p.getId() == employeeId) {
                hasEmployee = true;
                break;
            }
        }
        return hasEmployee && hasItem;
    }
}
