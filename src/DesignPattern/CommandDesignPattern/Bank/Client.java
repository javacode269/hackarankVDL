package DesignPattern.CommandDesignPattern.Bank;

public class Client {

    public static void main(String[] args) {
        Account account = new Account("Javacode296  ");

        ICommand open = new OpenAccount(account);
        ICommand close = new CloseAccount(account);
        BankApp bankApp = new BankApp(open, close);

        bankApp.clickOpenAccount();
        bankApp.clickCloseAccount();
    }
}