import java.util.Scanner;

class bankaccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public bankaccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
}

public class onlinebankingsystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        System.out.print("Enter account holder name: ");
        String accHolder = scanner.next();
        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();

        bankaccount account = new bankaccount(accNumber, accHolder, initialBalance);

        System.out.println("\nWelcome to Online Banking System!");
        System.out.println("1. Deposit funds");
        System.out.println("2. Withdraw funds");
        System.out.println("3. View account details");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                account.displayAccountDetails();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
