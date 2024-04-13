package calculatorm.parser;

import calculatorm.CalcException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    // ��������� ���������� ���������� � ���� ��������� �����
    private static final Set<String> VALID_OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/", "^",
            "ln", "log10", "sqrt", "abs", "ceil", "floor", "cos", "sin", "tan", "cot", "sec", "csc", "asin", "acos",
            "atan", "acot", "asec", "acsc"));

    // �������� ������������ ���������
    public static boolean checkOperator(String op) {
        return VALID_OPERATORS.contains(op);
    }

    // ��������, �������� �� ������ ������
    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ��������, �������� �� ������ ����� ������
    public static boolean isInteger(String str) {
        double value = Double.parseDouble(str);
        // ��������� ����� �� ����� ��������� ����� ���������� ����
        return value == Math.floor(value);
    }

    // ��������� ��������� (������ �����) �� ������ ��� �������
    public static void validateExpression(List<String> expItems) throws CalcException {
        if (expItems.size() == 2) {
            if (!isNumber(expItems.get(1))) {
                throw new CalcException("������. ��������� ����� '" + expItems.get(1) + "' �� ���������.");
            }
            if (!checkOperator(expItems.get(0))) {
                throw new CalcException("������. �������� '" + expItems.get(0) + "' �� ���������, ������ ����: + - * /...");
            }
        }
        else if (expItems.size() == 3) {
            if (!isNumber(expItems.get(0))) {
                throw new CalcException("������. ��������� ����� '" + expItems.get(0) + "' �� ���������.");
            }
            if (!isNumber(expItems.get(2))) {
                throw new CalcException("������. ��������� ����� '" + expItems.get(2) + "' �� ���������.");
            }
            if (!checkOperator(expItems.get(1))) {
                throw new CalcException("������. �������� '" + expItems.get(1) + "' �� ���������, ������ ����: + - * /...");
            }
        }
        else {
            throw new CalcException("������. ������������ ���������.");
        }
    }

    // ����������� ���� ��������� �� ������ ��� �������
    public static String ExpSize(List<String> expItems) throws CalcException {
        if (expItems.size() == 2) {
            if (!isNumber(expItems.get(1))) {
                throw new CalcException("������. ��������� ����� '" + expItems.get(1) + "' �� ���������.");
            }
            if (!checkOperator(expItems.get(0))) {
                throw new CalcException("������. �������� '" + expItems.get(0) + "' �� ���������, ������ ����: + - * /...");
            }
            return "IsUnary";
        }
        else if (expItems.size() == 3) {
            if (!isNumber(expItems.get(0))) {
                throw new CalcException("������. ��������� ����� '" + expItems.get(0) + "' �� ���������.");
            }
            if (!isNumber(expItems.get(2))) {
                throw new CalcException("������. ��������� ����� '" + expItems.get(2) + "' �� ���������.");
            }
            if (!checkOperator(expItems.get(1))) {
                throw new CalcException("������. �������� '" + expItems.get(1) + "' �� ���������, ������ ����: + - * /...");
            }
            return "IsBinary";
        }
        // ���� ������ ������ �� ����� �� 2, �� 3
        else {
            // ��������� ���������� � ������������ ���������
            throw new CalcException("������. ������������ ���������.");
        }
    }

}
