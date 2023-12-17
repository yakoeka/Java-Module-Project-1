import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guests = Calculator.getAmountOfGuests(scanner);
        Calculator calc = new Calculator(guests);
        calc.sum = calc.addProductAndGetSum(calc, scanner);
        scanner.close();
        calc.printAllProducts(calc);
        calc.printResultingSum(calc);
    }
}