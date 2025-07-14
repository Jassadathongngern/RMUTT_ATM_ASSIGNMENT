public class BankAccount {
    private String accountId;    
    private String accountName; 
    private String password;     
    private double balance;      

    public BankAccount(String accountId, String accountName, String password, double balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.password = password;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    } 

    public double getBalance() {
        return balance;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public boolean withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
