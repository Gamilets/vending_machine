package payment;

public interface PaymentAcceptor {
    void addFunds(int amount);
    int getBalance();
    void displayPaymentOptions();
}
