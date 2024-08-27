// File: src/Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserSession userSession = UserSession.getInstance();
        
        while (true) {
            System.out.println("\nBanking Operations:");
            System.out.println("1. Login");
            System.out.println("2. View Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    userSession.login();
                    break;
                case 2:
                    if (userSession.isLoggedIn()) {
                        System.out.println("Viewing Balance...");
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;
                case 3:
                    if (userSession.isLoggedIn()) {
                        System.out.println("Depositing money...");
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;
                case 4:
                    if (userSession.isLoggedIn()) {
                        System.out.println("Withdrawing money...");
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;
                case 5:
                    userSession.logout();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

