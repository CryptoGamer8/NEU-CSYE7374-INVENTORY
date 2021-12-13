package edu.neu.csye7374.Order;

import edu.neu.csye7374.Personnel.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Order implements OrderAPI {
    private final String PATH = "order.csv";
    private static Order order;
    private PrintWriter pw;
    private InvoiceFactory factory;

    private Order(){
        factory = InvoiceFactory.getInstance();
    }

    public static Order getInstance(){
        if(order==null){
            order = new Order();
        }
        return order;
    }

    @Override
    public void appendInvoice(InvoiceAPI invoice) {
        try {
            pw = new PrintWriter(new FileOutputStream(new File(PATH), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(invoice.toString());
        pw.close();
    }

    @Override
    public boolean deleteInvoice(int id) {
        List<InvoiceAPI> list = getAllInvoice();
        int i = 0;
        for(;i<list.size();i++){
            if(list.get(i).getId()==id){
                break;
            }
        }
        if(i==list.size()){
            return false;
        }
        list.remove(i);
        // rewrite all
        addAllInvoice(list);
        return true;
    }

    @Override
    public InvoiceAPI getInvoice(int id) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(PATH)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if(Integer.parseInt(arr[0])==id){
                    InvoiceAPI invoice = factory.produceInvoice(id,Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),arr[4]);
                    return invoice;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Load all Invoice from .csv file to memory. 
     */
    @Override
    public List<InvoiceAPI> getAllInvoice() {
        List<InvoiceAPI> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(PATH)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                InvoiceAPI invoice = factory.produceInvoice(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),arr[4]);
                list.add(invoice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateInvoice(int id, InvoiceAPI newInvoice) {
        List<InvoiceAPI> list = getAllInvoice();
        for (int i = 0; i < list.size(); i++) {
            InvoiceAPI invoice = list.get(i);
            if(invoice.getId()==id){
                list.set(i, newInvoice);
                addAllInvoice(list);
                return;
            }
        }
        list.add(newInvoice);
        addAllInvoice(list);
    }

    @Override
    public void addAllInvoice(List<InvoiceAPI> list) {
        try {
            pw = new PrintWriter(new FileOutputStream(new File(PATH), false));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(InvoiceAPI invoice:list){
            pw.write(invoice.toString());
        }
        pw.close();
    }

    @Override
    public void clearAll() {
        try {
            pw = new PrintWriter(new FileOutputStream(new File(PATH), false));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write("");
        pw.close();
    }
}
