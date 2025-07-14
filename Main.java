import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxAccounts = 0;
        do {
            System.out.print("Enter amount of all account : ");
            maxAccounts = Integer.parseInt(scanner.nextLine());
        } while(maxAccounts < 1 || maxAccounts > 5);

        BankAccount[] accounts = new BankAccount[maxAccounts];

        for(int i = 0; i < maxAccounts; i++) {
            System.out.println("\nEnter details of each account #" + (i+1));

            String accountId;
            do {
                System.out.print("Account ID (13 digits): ");
                accountId = scanner.nextLine();
            } while(accountId.length() != 13);

            String accountName;
            do {
                System.out.print("Account Name (max 50 characters): ");
                accountName = scanner.nextLine();
            } while(accountName.length() == 0 || accountName.length() > 50);

            String password;
            do {
                System.out.print("Password (4 digits): ");
                password = scanner.nextLine();
            } while(password.length() != 4);

            double balance;
            do {
                System.out.print("balance : ");
                balance = Double.parseDouble(scanner.nextLine());
            } while(balance < 0 || balance > 1_000_000);

            accounts[i] = new BankAccount(accountId, accountName, password, balance);
        }

        ATM atm = new ATM(accounts);

        while(true) {
            BankAccount loggedInAccount = atm.login();
            if(loggedInAccount != null) {
                atm.showMenu(loggedInAccount);
            }
        }
    }
}
