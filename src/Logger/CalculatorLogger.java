package Logger;

import Model.ComplexNumber;

import java.io.FileWriter;
import java.io.IOException;

public class CalculatorLogger {
    FileWriter fileWriter; {
        try {
            fileWriter = new FileWriter("log.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logAddition(ComplexNumber num1, ComplexNumber num2, ComplexNumber result) throws IOException {
        fileWriter.write("Сложение " + num1 + " и " + num2 + " = " + result + "\n");
        fileWriter.flush();
}

    public void logMultiplication(ComplexNumber num1, ComplexNumber num2, ComplexNumber result) throws IOException {
        fileWriter.write("Умножение " + num1 + " и " + num2 + " = " + result + "\n");
        fileWriter.flush();
}

    public void logDivision(ComplexNumber num1, ComplexNumber num2, ComplexNumber result) throws IOException {
        fileWriter.write("Деление " + num1 + " на " + num2 + " = " + result + "\n");
        fileWriter.flush();
}

    public void logError(String message) throws IOException {
        fileWriter.write("Ошибка: " + message + "\n");
        fileWriter.flush();
}

}
