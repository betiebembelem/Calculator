package calculatorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorM {

    public static void main(String[] args) {
        try{
            // Вводу выражения
            System.out.println("Калькулятор для выражений вида: \"Число1 Операция Число2\". Операции: + - * /");
            System.out.print("Введите выражение: ");
            // Чтение ввода пользователя
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            String calcString = bReader.readLine();

            // Создание объекта Calculator для вычисления
            Calculator calculator = new Calculator();
            String result = calculator.result(calcString);
            // Вывод результата
            System.out.println("Ответ: " + result);
        }
        // Обработка возможных исключений
        catch(CalcException | IOException ignored){
            // Игнорирование исключений
        }

    }

}
