package org.example;

import java.time.LocalDate;

 public class Income extends Transaction {
     private final IncomeStorage category = new IncomeStorage();

     public Income(double amount, LocalDate date, EIncomeCategory category) {
            super(amount, date);
        }

    public double getAmount() {

        return 0;
    }
    @Override
    public String toString() {
     return "Income{" + "amount=" + amount +" date=" + date + " category=" + category + '}';
    }
}
