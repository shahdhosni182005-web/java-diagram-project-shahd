package model;

import java.time.LocalDate;

/** Employee paid a base salary plus a commission on sales. */
public class CommissionEmployee extends Employee {
    private double baseSalary;
    private double commissionRate; // e.g. 0.05 = 5%
    private double salesAmount;

    public CommissionEmployee(int id, String name, Gender gender, LocalDate hireDate,
                              double baseSalary, double commissionRate, double salesAmount) {
        super(id, name, gender, hireDate);
        this.baseSalary = baseSalary;
        this.commissionRate = commissionRate;
        this.salesAmount = salesAmount;
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    public double getCommissionRate() { return commissionRate; }
    public void setCommissionRate(double commissionRate) { this.commissionRate = commissionRate; }
    public double getSalesAmount() { return salesAmount; }
    public void setSalesAmount(double salesAmount) { this.salesAmount = salesAmount; }

    public double calculateCommission() {
        return salesAmount * commissionRate;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + calculateCommission();
    }

    @Override
    public String toString() {
        return "[Commission] " + super.toString()
                + String.format(", Base: %.2f, Commission: %.2f, Salary: %.2f",
                baseSalary, calculateCommission(), calculateSalary());
    }
}
