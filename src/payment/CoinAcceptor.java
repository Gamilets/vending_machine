package payment;

public class CoinAcceptor implements PaymentAcceptor {
    private int balance;

    public CoinAcceptor() {
        this.balance = 0;
    }

    @Override
    public void addFunds(int amount) {
        balance += amount;
        System.out.println("Баланс пополнен на " + amount + " монет(ы). Текущий баланс: " + balance);
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void displayPaymentOptions() {
        System.out.println("1. Пополнить баланс на 30 монет");
        System.out.println("2. Пополнить баланс на 50 монет");
    }
}
