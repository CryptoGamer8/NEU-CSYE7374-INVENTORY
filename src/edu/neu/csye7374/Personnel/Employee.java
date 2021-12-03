package edu.neu.csye7374.Personnel;

public class Employee extends Person{
    private double wage;
    private String hireDate;

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setWage(double wage){
        this.wage = wage;
    }

    public double getWage(){
        return this.wage;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        sb.append(",");
        sb.append(getAge());
        sb.append(",");
        sb.append(getName());
        sb.append(",");
        sb.append(getWage());
        sb.append(",");
        sb.append(getHireDate());
        sb.append("\n");
        return sb.toString();
    }
}
