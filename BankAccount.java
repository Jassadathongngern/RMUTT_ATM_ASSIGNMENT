public class BankAccount {
    private String accountId;    // Account ID, 13 characters
    private String accountName;  // Account holder's name, max 50 characters
    private String password;     // Password, 4 characters
    private double balance;      // Account balance, max 1,000,000 Baht

    public BankAccount(String accountId, String accountName, String password, double balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.password = password;
        this.balance = balance;
    }

    // Getters
    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    } 

    public double getBalance() {
        return balance;
    }

    // Check if the password matches
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Withdraw money if the balance is sufficient
    public boolean withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
