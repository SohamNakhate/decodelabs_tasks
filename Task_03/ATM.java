package Task_03;

import java.util.*;;

public class ATM {

    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    public void start() {

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("         ATM MENU");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        checkBalance();
                        break;

                    case 2:
                        depositMoney();
                        break;

                    case 3:
                        withdrawMoney();
                        break;

                    case 4:
                        System.out.println("\nThank you for using our ATM!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.printf("\nCurrent Balance: %.2f Rs.\n",
                account.getBalance());
    }

    private void depositMoney() {

        System.out.print("Enter amount to deposit: Rs. ");

        try {
            double amount = sc.nextDouble();
            account.deposit(amount);

        } catch (InputMismatchException e) {
            System.out.println("Invalid amount entered.");
            sc.nextLine();
        }
    }

    private void withdrawMoney() {

        System.out.print("Enter amount to withdraw: Rs. ");

        try {
            double amount = sc.nextDouble();
            account.withdraw(amount);

        } catch (InputMismatchException e) {
            System.out.println("Invalid amount entered.");
            sc.nextLine();
        }
    }
}
