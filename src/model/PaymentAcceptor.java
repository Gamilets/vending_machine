package model;

public interface PaymentAcceptor {
    void addAmount(int amount);
    int getAmount();
    void resetAmount();

}
