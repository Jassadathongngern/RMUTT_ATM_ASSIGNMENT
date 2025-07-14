import java.util.Scanner;

public class ATM {
    private BankAccount[] accounts;
    private Scanner scanner;

    public ATM(BankAccount[] accounts) {
        this.accounts = accounts;
        this.scanner = new Scanner(System.in);
    }

    public BankAccount login() {
        System.out.println("        ATM ComputerThanyaburi Bank");
        
        System.out.print("Account ID       : ");
        String inputId = scanner.nextLine();
        
        System.out.print("Account Password : ");
        String inputPassword = scanner.nextLine();

        for(BankAccount account : accounts) {
            if(account.getAccountId().equals(inputId) && account.checkPassword(inputPassword)) {
                System.out.println("Login successful!");
                return account;
            }
        }

        System.out.println("Login failed: Invalid account ID or password.");
        return null;
    }

    public void showMenu(BankAccount account) {
        while(true) {
            System.out.println("\n=========================================");
            System.out.println("Account ID : " + account.getAccountId());
            System.out.println("Menu Service");
            System.out.println("1. Account Balance");
            System.out.println("2. Withdrawal");
            System.out.println("3. Exit");
            System.out.print("Choose : ");
            String choice = scanner.nextLine();

            switch(choice) {
                case "1":
                
                    System.out.println("Your current balance: " + account.getBalance() + " Baht");
                    break;
                case "2":
                    System.out.print("Enter amount to withdraw: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    if(account.withdraw(amount)) {
                        System.out.println("Withdrawal successful: " + amount + " Baht");
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case "3":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }
}
