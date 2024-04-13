package calculatorm.parser;

import calculatorm.CalcException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    // Установка допустимых операторов в виде множества строк
    private static final Set<String> VALID_OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/", "^",
            "ln", "log10", "sqrt", "abs", "ceil", "floor", "cos", "sin", "tan", "cot", "sec", "csc", "asin", "acos",
            "atan", "acot", "asec", "acsc"));

    // Проверка корректности оператора
    public static boolean checkOperator(String op) {
        return VALID_OPERATORS.contains(op);
    }

    // Проверка, является ли строка числом
    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Проверка, является ли строка целым числом
    public static boolean isInteger(String str) {
        double value = Double.parseDouble(str);
        // Сравнение числа со своим значением после округления вниз
        return value == Math.floor(value);
    }

    // Валидация выражения (списка строк) на основе его размера
    public static void validateExpression(List<String> expItems) throws CalcException {
        if (expItems.size() == 2) {
            if (!isNumber(expItems.get(1))) {
                throw new CalcException("ОШИБКА. Введенное число '" + expItems.get(1) + "' не корректно.");
            }
            if (!checkOperator(expItems.get(0))) {
                throw new CalcException("ОШИБКА. Оператор '" + expItems.get(0) + "' не корректен, должен быть: + - * /...");
            }
        }
        else if (expItems.size() == 3) {
            if (!isNumber(expItems.get(0))) {
                throw new CalcException("ОШИБКА. Введенное число '" + expItems.get(0) + "' не корректно.");
            }
            if (!isNumber(expItems.get(2))) {
                throw new CalcException("ОШИБКА. Введенное число '" + expItems.get(2) + "' не корректно.");
            }
            if (!checkOperator(expItems.get(1))) {
                throw new CalcException("ОШИБКА. Оператор '" + expItems.get(1) + "' не корректен, должен быть: + - * /...");
            }
        }
        else {
            throw new CalcException("ОШИБКА. Некорректное выражение.");
        }
    }

    // Определение типа выражения на основе его размера
    public static String ExpSize(List<String> expItems) throws CalcException {
        if (expItems.size() == 2) {
            if (!isNumber(expItems.get(1))) {
                throw new CalcException("ОШИБКА. Введенное число '" + expItems.get(1) + "' не корректно.");
            }
            if (!checkOperator(expItems.get(0))) {
                throw new CalcException("ОШИБКА. Оператор '" + expItems.get(0) + "' не корректен, должен быть: + - * /...");
            }
            return "IsUnary";
        }
        else if (expItems.size() == 3) {
            if (!isNumber(expItems.get(0))) {
                throw new CalcException("ОШИБКА. Введенное число '" + expItems.get(0) + "' не корректно.");
            }
            if (!isNumber(expItems.get(2))) {
                throw new CalcException("ОШИБКА. Введенное число '" + expItems.get(2) + "' не корректно.");
            }
            if (!checkOperator(expItems.get(1))) {
                throw new CalcException("ОШИБКА. Оператор '" + expItems.get(1) + "' не корректен, должен быть: + - * /...");
            }
            return "IsBinary";
        }
        // Если размер списка не равен ни 2, ни 3
        else {
            // Генерация исключения о некорректном выражении
            throw new CalcException("ОШИБКА. Некорректное выражение.");
        }
    }

}
