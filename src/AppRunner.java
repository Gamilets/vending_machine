import enums.ActionLetter;
import model.*;
import payment.PaymentAcceptor;
import payment.CoinAcceptor;  // Для монетоприемника
import util.UniversalArray;
import util.UniversalArrayImpl;

import java.util.Scanner;

public class AppRunner {

    private final UniversalArray<Product> products = new UniversalArrayImpl<>();
    private final PaymentAcceptor paymentAcceptor;
    private static boolean isExit = false;

    private AppRunner(PaymentAcceptor paymentAcceptor) {
        this.paymentAcceptor = paymentAcceptor;

        products.addAll(new Product[]{
                new Water(ActionLetter.B, 20),
                new CocaCola(ActionLetter.C, 50),
                new Soda(ActionLetter.D, 30),
                new Snickers(ActionLetter.E, 80),
                new Mars(ActionLetter.F, 80),
                new Pistachios(ActionLetter.G, 130)
        });
    }

    public static void run(PaymentAcceptor coinAcceptor) {
        // Выбираем приемник (монетоприемник или картоприемник)
        PaymentAcceptor paymentAcceptor = new CoinAcceptor(); // можно поменять на CardAcceptor
        AppRunner app = new AppRunner(paymentAcceptor);

        while (!isExit) {
            app.startSimulation();
        }
    }

    private void startSimulation() {
        print("В автомате доступны:");
        showProducts(products);

        print("Монет на сумму: " + paymentAcceptor.getBalance());

        UniversalArray<Product> allowProducts = new UniversalArrayImpl<>();
        allowProducts.addAll(getAllowedProducts().toArray());
        chooseAction(allowProducts);
    }

    private UniversalArray<Product> getAllowedProducts() {
        UniversalArray<Product> allowProducts = new UniversalArrayImpl<>();
        for (int i = 0; i < products.size(); i++) {
            if (paymentAcceptor.getBalance() >= products.get(i).getPrice()) {
                allowProducts.add(products.get(i));
            }
        }
        return allowProducts;
    }

    private void chooseAction(UniversalArray<Product> products) {
        print(" a - Пополнить баланс");
        showActions(products);
        print(" h - Выйти");
        String action = fromConsole().substring(0, 1);
        if ("a".equalsIgnoreCase(action)) {
            paymentAcceptor.displayPaymentOptions();
            int amount = Integer.parseInt(fromConsole());
            paymentAcceptor.addFunds(amount);
            return;
        }

        try {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getActionLetter().equals(ActionLetter.valueOf(action.toUpperCase()))) {
                    paymentAcceptor.addFunds(-products.get(i).getPrice());
                    print("Вы купили " + products.get(i).getName());
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            if ("h".equalsIgnoreCase(action)) {
                isExit = true;
            } else {
                print("Недопустимая буква. Попробуйте еще раз.");
                chooseAction(products);
            }
        }
    }

    // Дополнительные методы
    private String fromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void showProducts(UniversalArray<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    private void showActions(UniversalArray<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(" " + products.get(i).getActionLetter() + " - " + products.get(i).getName());
        }
    }
}