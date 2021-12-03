package edu.neu.csye7374.Order;

public class InvoiceFactory {
    private static InvoiceFactory factory;

    private InvoiceFactory(){};

    public static InvoiceFactory getInstance(){
        if(factory==null){
            factory = new InvoiceFactory();
        }
        return factory;
    }

    public InvoiceAPI produceInvoice(int id, int itemId, int clientId, int employeeId, String purchaseDate){
        InvoiceAPI invoice = new Invoice();
        invoice.setId(id);
        invoice.setItemId(itemId);
        invoice.setClientId(clientId);
        invoice.setEmployeeId(employeeId);
        invoice.setPurchaseDate(purchaseDate);
        return invoice;
    }
}
