import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    int guests;
    double sum;
    ArrayList<Product> productsList = new ArrayList<>();

    Calculator(int guests) {
        this.guests = guests;
    }

    static int getAmountOfGuests(Scanner scanner) {
        int guests;
        System.out.println("Введите количество гостей:");
        while (true) {
            try {
                guests = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверный тип вводимого значения");
                // Очистка символа новой строки из буфера ввода
                scanner.nextLine();
                continue;
            }
            if (guests > 1) break;
            else System.out.println("Некорректное значение для подсчёта");
        }
        return guests;
    }

    double addProductAndGetSum(Calculator calculator, Scanner scanner) {
        double sum = 0;
        // Очистка символа новой строки из буфера ввода
        scanner.nextLine();
        while (true) {
            System.out.println("Введите название товара:");
            String name = scanner.nextLine();

            double price;
            do {
                System.out.println("Введите стоимость товара:");
                try {
                    price = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Неверный тип вводимого значения");
                    // Очистка символа новой строки из буфера ввода
                    scanner.nextLine();
                    continue;
                }
                break;
            } while (true);
            Product product = new Product(name, price);
            calculator.productsList.add(product);
            sum += price;
            System.out.println(String.format("Товар %s успешно добавлен", name));
            System.out.println("Хотите ли добавить еще один товар?");
            // Очистка символа новой строки из буфера ввода
            scanner.nextLine();
            String word = scanner.nextLine();
            if ("завершить".equalsIgnoreCase(word)) break;
        }
        return sum;
    }

    void printAllProducts(Calculator calculator) {
        System.out.println("Добавленные товары:");
        for (Product element : calculator.productsList) {
            System.out.println(element.name);
        }
    }

    void printResultingSum(Calculator calculator) {
        double resultSum = calculator.sum / calculator.guests;
        Formatter formatter = new Formatter();
        System.out.println(String.format("%.2f %s", resultSum, formatter.getDeclension(resultSum)));
    }
}
