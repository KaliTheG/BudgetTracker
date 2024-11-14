package org.example;
import java.time.LocalDate;

public class Transaction {
    protected LocalDate date;
    protected double amount;

    public Transaction(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
    public double getAmount() {
        return amount;
    }
}
