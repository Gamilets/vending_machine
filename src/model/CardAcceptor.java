package model;

import java.util.Scanner;

public class CardAcceptor implements PaymentAcceptor {
    private int amount;

    public CardAcceptor() {
        this.amount = 0;
    }

    @Override
    public void addAmount(int amount) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер карты: ");
        String cardNumber = sc.nextLine();
        System.out.print("Введите одноразовый пароль: ");
        String otp = sc.nextLine();

        System.out.println("Карточка найдена,вам добавлено: " + amount + " единиц");
        this.amount += amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void resetAmount() {
        this.amount = 0;
    }
}

