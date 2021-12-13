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

/**
 * 存在问题 - （future enhancements)
 * Date format: "xxxx-xx-xx"
 * File: create three file first "personnel.csv", "order.csv", "inventory.csv"
 * Id: 要自己手动输入，查询或删除不存在的id可能会出错. 没有验证。
 *
 * Design pattern used:
 * Singleton, factory, façade, observer, MVC
 *
 * GUI 可用 API 查看:
 * InventoryAPI, OrderAPI, PersonnelAPI, Observer包下的代码, 以及factory produce API
 *
 * To do list:
 * GUI, UML, ppt, presentation, test
 */

public class Demo {
    public static void demo() {
        Inventory inventory = Inventory.getInstance();
        inventory.clearAll();
        ItemFactory factory = ItemFactory.getInstance();
        ItemAPI item1 = factory.produceItem(1,"Cup","2012-09-30","2021-12-02",10.0,"Boston");
        ItemAPI item2 = factory.produceItem(2,"Tissue","2012-09-30","2025-08-10",5.0,"New York");
        inventory.appendItem(item1);
        inventory.appendItem(item2);
        ItemAPI item3 = factory.produceItem(2,"aaa","2013-09-30","2024-08-10",5.0,"New York");
        if (item3.getId() == -1) {
            System.out.println("id of item3 is already exist");
        }
        inventory.addLocationToItem(1,"New York");
        System.out.println(inventory.trackItem(1));
//        inventory.deleteItem(1);
//        inventory.updateItem(1,item2);
//        System.out.println(inventory.getItemAll());

        Personnel personnel = Personnel.getInstance();
        personnel.clearAll();
        PersonFactory personFactory = PersonFactory.getInstance();
        Employee e1 = personFactory.produceEmployee(1,30,"John",20000.0,"2021-11-20");
        Employee e2 = personFactory.produceEmployee(2,30,"Peter",40000.0,"2020-11-20");
        personnel.appendEmployee(e1);
        personnel.appendEmployee(e2);
//        personnel.deleteEmployee(2);
//        personnel.updateEmployee(1,e2);
//        System.out.println(personnel.getEmployee(1));
        System.out.println(personnel.getAllEmployee());

        TodayDate tdate = new TodayDate();
        TrackExp trackExp = new TrackExp();
        AnnualReview annualReview = new AnnualReview();
        tdate.register(trackExp);
        tdate.register(annualReview);
        tdate.setDate("2021-12-02");
//
        System.out.println(trackExp.getAllExpItem());
        System.out.println(annualReview.alertAnnualReview());

        Order order = Order.getInstance();
        order.clearAll();
        InvoiceFactory invoiceFactory = InvoiceFactory.getInstance();
        InvoiceAPI invoice1 = invoiceFactory.produceInvoice(1,1,1,1,"2020-12-20");
        InvoiceAPI invoice2 = invoiceFactory.produceInvoice(2,2,2,2,"2020-12-20");
        order.appendInvoice(invoice1);
        order.deleteInvoice(1);
        order.updateInvoice(1,invoice2);
        System.out.println(order.getAllInvoice());
    }
}
