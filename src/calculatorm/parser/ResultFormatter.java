package calculatorm.parser;

public class ResultFormatter {
    //  ��������� ������������ ����� �, ���� ��� �������� ����� ������,
    //  ���������� ��� � ������� ������ �����, � ��������� ������ ���������� ��� � �������� �������.
    public static String formatResult(double result) {
        if (Validator.isInteger(String.valueOf(result))) {
            return String.format("%d", (int) result);
        } else {
            return String.valueOf(result);
        }
    }
}