import payment.CoinAcceptor;
import payment.PaymentAcceptor;

public class Main {
    public static void main(String[] args) {
        PaymentAcceptor coinAcceptor = new CoinAcceptor();
        AppRunner.run(coinAcceptor);
    }
}