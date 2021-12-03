package edu.neu.csye7374.Personnel;

public class PersonFactory {
    private static PersonFactory factory;

    private PersonFactory(){

    }

    public static PersonFactory getInstance(){
        if(factory==null){
            factory = new PersonFactory();
        }
        return factory;
    }

    // Date format should be exactly as "xxxx-xx-xx"
    public Employee produceEmployee(int id, int age, String name, double wage, String hireDate){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setAge(age);
        employee.setName(name);
        employee.setWage(wage);
        employee.setHireDate(hireDate);
        return employee;
    }

    public Client produceClient(int id, int age, String name){
        Client client = new Client();
        client.setId(id);
        client.setAge(age);
        client.setName(name);
        return null;
    }
}
