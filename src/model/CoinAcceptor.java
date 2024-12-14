package model;

public class CoinAcceptor implements PaymentAcceptor{
    private int amount;

    public CoinAcceptor(int amount) {
        this.amount = amount;
    }

    @Override
    public void addAmount(int amount) {

    }

    public int getAmount() {
        return amount;
    }

    @Override
    public void resetAmount() {

    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
