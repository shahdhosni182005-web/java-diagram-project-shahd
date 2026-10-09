package model;

import java.time.LocalDate;
import java.time.Period;

/** Employee paid a fixed monthly salary plus a percentage bonus. */
public class MonthlyEmployee extends Employee {
    private double monthlySalary;
    private int vacationDays;
    private double bonusPercentage; // e.g. 10 = 10%
    private boolean hasHealthInsurance;

    public MonthlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                           double monthlySalary, int vacationDays,
                           double bonusPercentage, boolean hasHealthInsurance) {
        super(id, name, gender, hireDate);
        this.monthlySalary = monthlySalary;
        this.vacationDays = vacationDays;
        this.bonusPercentage = bonusPercentage;
        this.hasHealthInsurance = hasHealthInsurance;
    }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }
    public int getVacationDays() { return vacationDays; }
    public void setVacationDays(int vacationDays) { this.vacationDays = vacationDays; }
    public double getBonusPercentage() { return bonusPercentage; }
    public void setBonusPercentage(double bonusPercentage) { this.bonusPercentage = bonusPercentage; }
    public boolean isHasHealthInsurance() { return hasHealthInsurance; }
    public void setHasHealthInsurance(boolean hasHealthInsurance) { this.hasHealthInsurance = hasHealthInsurance; }

    /** One extra vacation day for every 2 full years of service. */
    public int calculateAdditionalVacation() {
        int years = Period.between(getHireDate(), LocalDate.now()).getYears();
        return years / 2;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + (monthlySalary * bonusPercentage / 100.0);
    }

    @Override
    public String toString() {
        return "[Monthly] " + super.toString()
                + String.format(", Monthly: %.2f, Bonus: %.1f%%, Vacation: %d (+%d), Insurance: %b, Salary: %.2f",
                monthlySalary, bonusPercentage, vacationDays, calculateAdditionalVacation(),
                hasHealthInsurance, calculateSalary());
    }
}
