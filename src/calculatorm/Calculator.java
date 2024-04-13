package calculatorm;

import calculatorm.parser.ResultFormatter;
import calculatorm.operations.Operation;
import calculatorm.parser.Parse;
import calculatorm.parser.Validator;

import java.util.List;

public class Calculator {
    // Метод для выполнения бинарной операции
    private static double calculateBinaryOperation(double sym1, String operator, double sym2) {
        return switch (operator) {
            // Выбор операции в зависимости от оператора
            case "+" -> Operation.add(sym1, sym2);
            case "-" -> Operation.subtract(sym1, sym2);
            case "*" -> Operation.multiply(sym1, sym2);
            case "/" -> Operation.divide(sym1, sym2);
            case "^" -> Operation.pow(sym1, sym2);
            default -> throw new AssertionError();
        };
    }

    // Метод для выполнения унарной операции
    private static double calculateUnaryOperation(double sym1, String operator) {
        return switch (operator) {
            // Выбор операции в зависимости от оператора
            case "sqrt" -> Operation.sqrt(sym1);
            case "ln" -> Operation.ln(sym1);
            case "log10" -> Operation.log10(sym1);
            case "abs" -> Operation.abs(sym1);
            case "ceil" -> Operation.ceil(sym1);
            case "floor" -> Operation.floor(sym1);
            case "sin" -> Operation.sin(sym1);
            case "cos" -> Operation.cos(sym1);
            case "tan" -> Operation.tan(sym1);
            case "cot" -> Operation.cot(sym1);
            case "sec" -> Operation.sec(sym1);
            case "csc" -> Operation.csc(sym1);
            case "asin" -> Operation.asin(sym1);
            case "acos" -> Operation.acos(sym1);
            case "atan" -> Operation.atan(sym1);
            case "acot" -> Operation.acot(sym1);
            case "asec" -> Operation.asec(sym1);
            case "acsc" -> Operation.acsc(sym1);
            default -> throw new AssertionError();
        };
    }

    // Метод для выполнения выражения
    public static double calculateExpression(List<String> expItems) throws CalcException {
        // Проверка корректности выражения
        Validator.validateExpression(expItems);
        double sym1, sym2;
        String operator;
        Validator.ExpSize(expItems);

        // Если размер выражения равен 3, значит это бинарная операция
        if (expItems.size() == 3) {
            sym1 = Double.parseDouble(expItems.get(0));
            operator = expItems.get(1);
            sym2 = Double.parseDouble(expItems.get(2));
            // Выполнение бинарной операции
            return calculateBinaryOperation(sym1, operator, sym2);
        }
        // Иначе это унарная операция
        else {
            sym1 = Double.parseDouble(expItems.get(1));
            operator = expItems.get(0);
            // Выполнение унарной операции
            return calculateUnaryOperation(sym1, operator);
        }
    }

    // Метод для получения результата выражения в виде строки
    public String result(String exp) throws CalcException {
        List<String> expItems = Parse.getExpItems(exp);
        double calculationResult = calculateExpression(expItems);
        // Форматирование результата
        return ResultFormatter.formatResult(calculationResult);
    }
}