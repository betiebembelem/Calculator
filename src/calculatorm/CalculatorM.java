package calculatorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorM {

    public static void main(String[] args) {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in))) {
            // Выводим приветственное сообщение и объясняем формат ввода
            System.out.println("Калькулятор для выражений вида: \"Число1 Операция Число2\". Операции: + - * /");
            // Бесконечный цикл для ввода и обработки выражений
            while (true) {
                System.out.print("Введите выражение или 'exit' для выхода: ");
                String calcString = bReader.readLine();
                if (calcString.equalsIgnoreCase("exit")) {
                    break; // Выход из цикла, если пользователь ввел 'exit'
                }
                Calculator calculator = new Calculator();
                String result = calculator.result(calcString);
                System.out.println("Ответ: " + result);
            }
        } catch (CalcException | IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
