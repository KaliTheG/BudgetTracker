package org.example;
import java.time.LocalDate;//
import java.time.format.DateTimeParseException;//
import java.util.InputMismatchException;//
import java.util.Scanner;//

public class Main {
    private static User user;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your firstname: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your lastname: ");
        String lastName = scanner.nextLine();

        user = new User(firstName);
        System.out.printf("Welcome to the Budget App " + user.getfirstName(firstName) + user.getlastName(lastName) + "!");


        while (true) {
            System.out.println("\n Enter 1: for Income, 2: for Expense, 3: to Print Income, 4: to Print Expense, 5: to Exit: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option!");
                scanner.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    addIncome(scanner);
                    break;
                case 2:
                    addExpense(scanner);
                    break;
                case 3:
                    user.printAllIncome();
                    break;

                case 4:
                    user.printAllExpenses();
                    break;
                case 5: {
                    saveTofile();
                    System.out.println("Goodbye " + user.getfirstName(firstName) + " Thank you for using the Budget App!");
                    scanner.close();
                    return;

                }
                default: {
                    System.out.println("Please enter a valid option!");
                }

            }


        }
    }

    private static void addIncome(Scanner scanner) {
        try{
            System.out.println("Please enter the amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.println("Please enter the date (yyyy-mm-dd): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            System.out.println("Please enter the category of income: ");
            EIncomeCategory category = EIncomeCategory.valueOf(scanner.nextLine() .toUpperCase());

            Income income = new Income(amount, date, category);
            user.addIncome(income);
            System.out.println( "Income{ " + "amount= " + user.getTotalIncome() +" date= " + date + " category= " + category + '}');

        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Please enter a valid date!");
        }
    }


    private static void addExpense(Scanner scanner) {
        try{
            System.out.println("Please enter the amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.println("Please enter the date (yyyy-mm-dd): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            System.out.println("Please enter the category of expense: ");
            EExpenseCategory category = EExpenseCategory.valueOf(scanner.nextLine() .toUpperCase());

            Expense expense = new Expense(amount, date, category);
            user.addExpense(expense);
            System.out.println( "Expense [amount= " + user.getTotalExpense()  + ", date= " + date + ", category= " + category + "]");

        } catch ( NumberFormatException | DateTimeParseException e) {
            System.out.println("Please enter a valid option!");
        }
    }

    private static void saveTofile() {
        try {
            ExpenseStorage.saveToFile("expenses.json");
            IncomeStorage.saveToFile("incomes.json");
        } catch (Exception e) {
            System.out.println("Error saving expenses to file: " + e.getMessage());
        }
    }
}
