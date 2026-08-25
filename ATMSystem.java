
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account userAccount = new Account("123456", "2580", 1000.00);

        System.out.println("=== WELCOME TO THE ATM SYSTEM ===");
        System.out.print("Enter your 4-digit PIN: ");
        String enteredPin = scanner.nextLine();

        if (!userAccount.validatePin(enteredPin)) {
            System.out.println("Invalid PIN. Access Denied.");
            scanner.close();
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- ATM MAIN MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please choose an option (1-4): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.printf("Your current balance is: $%.2f%n", userAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: $");
                        double depAmount = Double.parseDouble(scanner.nextLine());
                        userAccount.deposit(depAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: $");
                        double withAmount = Double.parseDouble(scanner.nextLine());
                        userAccount.withdraw(withAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select options 1 through 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input type. Please enter numbers only.");
            }
        }
        scanner.close();
    }
}