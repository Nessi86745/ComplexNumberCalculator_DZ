package Ui;

import Logger.CalculatorLogger;
import Model.Calculator;
import Model.ComplexNumber;

import java.io.IOException;
import java.util.Scanner;

public class CalculatorUI {
    private Calculator calculator;
    private Scanner scanner;
    private CalculatorLogger calculatorLogger = new CalculatorLogger();

    public CalculatorUI() {
        calculator = new Calculator();
        scanner = new Scanner(System.in);
    }

    public void run() throws IOException {
        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Сложение");
            System.out.println("2. Умножение");
            System.out.println("3. Деление");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice > 3){
                System.out.println("Неверная операция! ");
                continue;
            }

            System.out.println("Введите первое комплексное число (в виде a + bi):");
            ComplexNumber num1 = getComplexNumberFromInput();

            System.out.println("Введите второе комплексное число (в виде a + bi):");
            ComplexNumber num2 = getComplexNumberFromInput();

            ComplexNumber result;
            switch (choice) {
                case 1:
                    result = calculator.add(num1, num2);
                    calculatorLogger.logAddition(num1, num2, result);
                    break;
                case 2:
                    result = calculator.multiply(num1, num2);
                    calculatorLogger.logMultiplication(num1, num2, result);
                    break;
                case 3:
                    result = calculator.divide(num1, num2);
                    calculatorLogger.logDivision(num1, num2, result);
                    break;
                default:
                    calculatorLogger.logError("Неверная операция! ");
                    continue;
            }

            System.out.println("Результат: " + result);
        }
    }

    private ComplexNumber getComplexNumberFromInput() {
        double real = scanner.nextDouble();
        double imaginary = scanner.nextDouble();
        return new ComplexNumber(real, imaginary);
    }

    public CalculatorUI(Calculator calculator, Scanner scanner) {
        this.calculator = calculator;
        this.scanner = scanner;
    }

    @Override
    public String toString() {
        try {
            return "CalculatorUI{" +
                    "calculator=" + calculator +
                    ", scanner=" + scanner +
                    '}';
        } catch (NumberFormatException e) {
            return "Нет строки!";
        }
    }
}

