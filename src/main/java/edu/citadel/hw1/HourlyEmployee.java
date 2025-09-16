package edu.citadel.hw1;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {

    private double wageRate;
    private double hoursWorked;

    public HourlyEmployee(String name, LocalDate hireDate, double wageRate, double hoursWorked) {
        super(name, hireDate);
        this.wageRate = wageRate;
        this.hoursWorked = hoursWorked;
    }
    public double getWageRate() {
        return wageRate;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double getMonthlyPay() {
        return wageRate * hoursWorked;
    }

    public String toString() {
        return ("Hourly Employee[name=" + this.getName() + ", hireDate=" + this.getHireDate()
                + ", wageRate=" + this.getWageRate() + ", hoursWorked=" + this.getHoursWorked() + "]");
    }
    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HourlyEmployee);
    }

}
