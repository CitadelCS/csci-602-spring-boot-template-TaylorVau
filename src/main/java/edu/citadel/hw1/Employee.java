package edu.citadel.hw1;


import java.time.LocalDate;


public abstract class Employee implements Comparable<Employee> {

    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public String  getHireDate() {
        return hireDate.toString();
    }

    public abstract double getMonthlyPay();

    public int compareTo(Employee other) {
        return Integer.compare((int) this.getMonthlyPay(), (int) other.getMonthlyPay());
    }
}

