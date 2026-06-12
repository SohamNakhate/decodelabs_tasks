package Task_04;

import java.util.Scanner;

public class DecodeLabs_Java_P4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n==============================");
            System.out.println("      CURRENCY CONVERTER");
            System.out.println("==============================");

            System.out.println("Available Currencies:");
            System.out.println("1. USD");
            System.out.println("2. INR");
            System.out.println("3. EUR");
            System.out.println("4. GBP");

            try {

                System.out.print("\nSelect Source Currency: ");
                int source = sc.nextInt();

                System.out.print("Select Target Currency: ");
                int target = sc.nextInt();

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                if (amount <= 0) {
                    System.out.println("Invalid amount! Amount must be greater than 0.");
                    continue;
                }

                double convertedAmount = convert(source, target, amount);

                if (convertedAmount == -1) {
                    System.out.println("Invalid currency selection.");
                } else {
                    System.out.printf(
                            "\nConverted Amount: %.2f %s\n",
                            convertedAmount,
                            getCurrencyName(target));
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numeric values.");
                sc.nextLine();
            }

            System.out.print("\nDo you want another conversion? (Y/N): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("Y")) {
                running = false;
            }
        }

        System.out.println("\nThank you for using Currency Converter!");
        sc.close();
    }

    public static double convert(int source, int target, double amount) {

        double amountInUSD = 0;

        switch (source) {
            case 1:
                amountInUSD = amount;
                break;
            case 2:
                amountInUSD = amount / 83.50;
                break;
            case 3:
                amountInUSD = amount / 0.92;
                break;
            case 4:
                amountInUSD = amount / 0.79;
                break;
            default:
                return -1;
        }

        switch (target) {
            case 1:
                return amountInUSD;
            case 2:
                return amountInUSD * 83.50;
            case 3:
                return amountInUSD * 0.92;
            case 4:
                return amountInUSD * 0.79;
            default:
                return -1;
        }
    }

    public static String getCurrencyName(int currency) {

        switch (currency) {
            case 1:
                return "USD";
            case 2:
                return "INR";
            case 3:
                return "EUR";
            case 4:
                return "GBP";
            default:
                return "";
        }
    }
}