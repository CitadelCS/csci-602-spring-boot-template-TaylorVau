package edu.citadel.hw1;

import java.time.LocalDate;

public class SalariedEmployee extends Employee{

    private double annualSalary;

    public SalariedEmployee(String name, LocalDate hireDate, double AnnualSalary) {
        super(name, hireDate);
        this.annualSalary = AnnualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double getMonthlyPay() {
        return this.getAnnualSalary()/12.00;
    }

    public String toString() {
        return "Salaried Employee[name=" + this.getName() + ", hireDate=" + this.getHireDate()
                + ",  annualSalary=" + annualSalary + "]";
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof SalariedEmployee);
    }
}
