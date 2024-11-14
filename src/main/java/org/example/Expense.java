package org.example;

import java.time.LocalDate;

public class Expense extends Transaction {
        public ExpenseStorage category = new ExpenseStorage();

        public Expense(double amount, LocalDate date, EExpenseCategory category) {
            super(amount, date);
            
        }


    public double getAmount() {
        return 0;

    }

    @Override
    public String toString() {
        return "Expense [amount=" + amount + ", date=" + date + ", category=" + category + "]";
    }

}

