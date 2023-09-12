package DesignPattern.CommandDesignPattern.Bank;


public class BankApp {

    private ICommand openAccount;
    private ICommand closeAccount;

    public BankApp(ICommand openAccount, ICommand closeAccount) {
        this.openAccount = openAccount;
        this.closeAccount = closeAccount;
    }

    public void clickOpenAccount() {
        System.out.println("User click open an account");
        openAccount.execute();
    }

    public void clickCloseAccount() {
        System.out.println("User click close an account");
        closeAccount.execute();
    }
}
