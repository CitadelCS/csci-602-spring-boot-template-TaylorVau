package edu.citadel.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;


public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();

        HourlyEmployee johnDoe = new HourlyEmployee("John Doe",
                LocalDate.parse("2009-05-21"), 50.5, 160.0);
        empList.add(johnDoe);
        HourlyEmployee janeDoe = new HourlyEmployee("Jane Doe",
                LocalDate.parse("2005-09-01"), 150.5, 80.0);
        empList.add(janeDoe);

        SalariedEmployee moeHoward = new SalariedEmployee("Moe Howard",
                LocalDate.parse("2004-01-01"), 75000.0);
        empList.add(moeHoward);
        SalariedEmployee curlyHoward = new SalariedEmployee("Curly Howard",
                LocalDate.parse("2018-01-01"), 105000.0);
        empList.add(curlyHoward);


        System.out.println("List of Employees (before sorting)");
        for (Employee emp : empList) {
            System.out.println(emp.toString());
        }
        System.out.println();

        Collections.sort(empList);

        System.out.println("List of Employees (after sorting)");
        for (Employee emp : empList) {
            System.out.println(emp.toString());
        }

        System.out.print(" \n Monthly Pay \n ");

        double totalPay = 0;
        for(Employee emp : empList){
            System.out.printf(emp.getName());
            System.out.printf(": $%,.2f%n", emp.getMonthlyPay());
            totalPay += emp.getMonthlyPay();
        }
        System.out.printf("Total Monthly Pay: $%,.2f%n ", totalPay);
    }
}