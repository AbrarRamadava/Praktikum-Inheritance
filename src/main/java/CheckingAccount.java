//Abrar Ramadava 20220040204 TI22M
public class CheckingAccount extends Account {
    private double overdraftProtection;

    public CheckingAccount(double balance, double protect) {
        super(balance);
        this.overdraftProtection = protect;
    }

    public CheckingAccount(double balance) {
        this(balance, -1.0); // Default overdraftProtection is -1.0
        this.balance += overdraftProtection;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return true;
        } else {
            if (overdraftProtection == -1.0 || overdraftProtection < (amount - balance)) {
                return false;
            } else {
                balance = 0.0;
                overdraftProtection -= (amount - balance);
                return true;
            }
        }
    }
}
