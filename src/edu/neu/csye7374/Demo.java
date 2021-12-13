package edu.neu.csye7374;

import edu.neu.csye7374.Inventory.Inventory;
import edu.neu.csye7374.Inventory.ItemAPI;
import edu.neu.csye7374.Inventory.ItemFactory;
import edu.neu.csye7374.Observer.AnnualReview;
import edu.neu.csye7374.Observer.Observer;
import edu.neu.csye7374.Observer.TodayDate;
import edu.neu.csye7374.Observer.TrackExp;
import edu.neu.csye7374.Order.*;
import edu.neu.csye7374.Personnel.Employee;
import edu.neu.csye7374.Personnel.PersonFactory;
import edu.neu.csye7374.Personnel.Personnel;

import java.time.LocalDate;

public class Demo {
    public static void demo() {
        Inventory inventory = Inventory.getInstance(); // Singleton pattern.
        inventory.clearAll();
        ItemFactory factory = ItemFactory.getInstance(); // Singleton pattern and Factory pattern.
        ItemAPI item1 = factory.produceItem(1,"Cup","2012-09-30","2021-12-30",10.0,"Boston");
        ItemAPI item2 = factory.produceItem(2,"Tissue","2012-09-30","2025-08-10",5.0,"New York");
        inventory.appendItem(item1);
        inventory.appendItem(item2);
        ItemAPI item3 = factory.produceItem(2,"aaa","2013-09-30","2024-08-10",5.0,"New York"); // This will create an item with id -1.
        if (item3.getId() == -1) {
            System.out.println("id of item3 is already exist");
        }
        inventory.addLocationToItem(1,"New York"); // add " -- New York" to item location.
        System.out.println(inventory.trackItem(1));
//        inventory.deleteItem(1);
//        inventory.updateItem(1,item2);
//        System.out.println(inventory.getItemAll());
        System.out.println("-------------------------------------------------------------");

        Personnel personnel = Personnel.getInstance(); // Singleton pattern.
        personnel.clearAll();
        PersonFactory personFactory = PersonFactory.getInstance(); // Singleton pattern and Factory pattern.
        Employee e1 = personFactory.produceEmployee(1,30,"John",20000.0,"2021-12-20");
        Employee e2 = personFactory.produceEmployee(2,30,"Peter",40000.0,"2020-11-20");
        personnel.appendEmployee(e1);
        personnel.appendEmployee(e2);
//        personnel.deleteEmployee(2);
//        personnel.updateEmployee(1,e2);
//        System.out.println(personnel.getEmployee(1));
        System.out.println(personnel.getAllEmployee());
        System.out.println("-------------------------------------------------------------");

        TodayDate tdate = new TodayDate(); // Observable
        TrackExp trackExp = new TrackExp(); // Observer
        AnnualReview annualReview = new AnnualReview(); // Observer
        tdate.register(trackExp);
        tdate.register(annualReview);
        tdate.setDate("2021-12-14");
 		// It will alart all the item that is approaching the expire date (within 1 mounth)
		// For example, if the expire date is 2021-12-31, it will alert betweem 2021-12-01 to 2021-12-31
        System.out.println(trackExp.getAllExpItem()); 
		// It will alart all the employee that is approaching the hire date (within 1 mounth, neglect year)
		// For example, if the hire date is 2020-12-31, it will alert betweem xxxx-12-01 to xxxx-12-31
        System.out.println(annualReview.alertAnnualReview());
        System.out.println("-------------------------------------------------------------");

        Order order = Order.getInstance(); // Singleton pattern.
        order.clearAll();
        InvoiceFactory invoiceFactory = InvoiceFactory.getInstance(); // Singleton pattern and Factory pattern.
        // Parameters: (int id, int itemId, int clientId, int employeeId, String purchaseDate)
        InvoiceAPI invoice1 = invoiceFactory.produceInvoice(1,1,1,1,"2020-12-20");
        InvoiceAPI invoice2 = invoiceFactory.produceInvoice(2,2,2,2,"2020-12-20");
        order.appendInvoice(invoice1);
        order.deleteInvoice(1);
        order.updateInvoice(1,invoice2);
        System.out.println(order.getAllInvoice());
    }
}
