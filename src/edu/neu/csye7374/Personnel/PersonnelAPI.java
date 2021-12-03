package edu.neu.csye7374.Personnel;

import java.util.List;

public interface PersonnelAPI {
    public static Personnel getInstance() {
        return null;
    }
    public void appendEmployee(Employee e);
    public boolean deleteEmployee(int id);
    public Employee getEmployee(int id);
    public List<Employee> getAllEmployee();
    public void updateEmployee(int id, Employee e);
    public void addAllEmployee(List<Employee> list);
    public void clearAll();
}
