package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {

        private String firstName;
        private String lastName;
        private double totalIncome;
        private double totalExpense;
        private final List<Income> incomeList;
        private final List<Expense> expenseList;



        public User(String name) {
            this.firstName = name;
            this.lastName = name;
            this.totalIncome = 0;
            this.totalExpense = 0;
            this.incomeList = new ArrayList<>();
            this.expenseList = new ArrayList<>();

        }

        public void addIncome(Income income) {
            totalIncome += income.getAmount();
            incomeList.add(income);
        }
        public void addExpense(Expense expense) {
            totalExpense += expense.getAmount();
            expenseList.add(expense);
        }

        public double getTotalIncome() {
            return totalIncome;
        }
        public double getTotalExpense() {
            return totalExpense;
        }

        public String getfirstName(String firstName) {

            return this.firstName;
        }

        public String getlastName(String lastName) {
            return this.lastName;
        }

        public void printAllExpenses(){
            if (expenseList.isEmpty()){
                System.out.println("No expenses found");

            }
            else{
                for (Expense expense : expenseList) {
                    System.out.println(expense);
                }
            }
        }


        public void printAllIncome() {
            if(incomeList.isEmpty()){
                System.out.println("No incomes found");

            }
            else{
                for (Income income : incomeList) {
                    System.out.println(income);
                }
            }
        }



    }
