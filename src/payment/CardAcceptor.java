package payment;

import java.util.Scanner;

public class CardAcceptor implements PaymentAcceptor {
    private int balance;

    public CardAcceptor() {
        this.balance = 0;
    }

    @Override
    public void addFunds(int amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер карты: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Введите одноразовый пароль: ");
        String otp = scanner.nextLine();
        System.out.println("Карта " + cardNumber + " проверена, средства зачислены.");
        balance += amount;
        System.out.println("Карта пополнена на " + amount + ", Текущий баланс: " + balance);
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void displayPaymentOptions() {
        System.out.println("1. Пополнить на 100");
        System.out.println("2. Пополнить на 200");
    }
}