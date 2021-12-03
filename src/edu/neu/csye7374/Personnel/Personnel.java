package edu.neu.csye7374.Personnel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Personnel implements PersonnelAPI{
    private final String PATH = "personnel.csv";
    private static Personnel personnel;
    private PrintWriter pw;
    private PersonFactory factory;

    private Personnel(){
        factory = PersonFactory.getInstance();
    }

    public static Personnel getInstance(){
        if(personnel==null){
            personnel = new Personnel();
        }
        return personnel;
    }

    public void appendEmployee(Employee employee){
        try {
            pw = new PrintWriter(new FileOutputStream(new File(PATH), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(employee.toString());
        pw.close();
    }

    public boolean deleteEmployee(int id){
        List<Employee> list = getAllEmployee();
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
        addAllEmployee(list);
        return true;
    }

    @Override
    public Employee getEmployee(int id) {
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
                    Employee employee = factory.produceEmployee(id,Integer.parseInt(arr[1]),arr[2], Double.parseDouble(arr[3]),arr[4]);
                    return employee;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(PATH)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                Employee employee = factory.produceEmployee(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), arr[2], Double.parseDouble(arr[3]), arr[4]);
                list.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateEmployee(int id, Employee e) {
        List<Employee> list = getAllEmployee();
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if(employee.getId()==id){
                list.set(i, e);
                addAllEmployee(list);
                return;
            }
        }
        list.add(e);
        addAllEmployee(list);
    }

    public void addAllEmployee(List<Employee> list){
        try {
            pw = new PrintWriter(new FileOutputStream(new File(PATH), false));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(Employee item:list){
            pw.write(item.toString());
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
