package app;

import java.util.Scanner;

class TemperatureOutOfRangeException extends Exception {
    public TemperatureOutOfRangeException(String message) {
        super(message);
    }
}

public class ExceptionsTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введіть число: ");
            int number = Integer.parseInt(scanner.nextLine());
            System.out.println("Ви ввели: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введено нечислове значення!");
        }

        try {
            double[] prices = {10.5, 20.3, 15.7, 30.0, 25.8};
            System.out.print("Введіть індекс ціни (від 0 до 4): ");
            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index < prices.length) {
                System.out.println("Ціна за індексом " + index + ": " + prices[index]);
            } else {
                System.out.println("Помилка: неправильний індекс!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введено нечисловий індекс!");
        }

        try {
            double availableFunds = 1000.0;
            System.out.print("Введіть суму для оплати: ");
            double paymentAmount = Double.parseDouble(scanner.nextLine());

            if (paymentAmount <= availableFunds) {
                System.out.println("Оплата прийнята.");
            } else {
                throw new IllegalArgumentException("Помилка: недостатньо коштів на карті!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введено некоректну суму для оплати!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            int minTemperature = -10;
            int maxTemperature = 35;

            System.out.print("Введіть фактичну температуру: ");
            int actualTemperature = Integer.parseInt(scanner.nextLine());

            if (actualTemperature >= minTemperature && actualTemperature <= maxTemperature) {
                System.out.println("Пристрій працює нормально при цій температурі.");
            } else {
                throw new TemperatureOutOfRangeException("Помилка: неможливо працювати за цією температурою!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введено некоректну температуру!");
        } catch (TemperatureOutOfRangeException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}