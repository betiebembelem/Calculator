package calculatorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorM {

    public static void main(String[] args) {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in))) {
            // ������� �������������� ��������� � ��������� ������ �����
            System.out.println("����������� ��� ��������� ����: \"�����1 �������� �����2\". ��������: + - * /");
            // ����������� ���� ��� ����� � ��������� ���������
            while (true) {
                System.out.print("������� ��������� ��� 'exit' ��� ������: ");
                String calcString = bReader.readLine();
                if (calcString.equalsIgnoreCase("exit")) {
                    break; // ����� �� �����, ���� ������������ ���� 'exit'
                }
                Calculator calculator = new Calculator();
                String result = calculator.result(calcString);
                System.out.println("�����: " + result);
            }
        } catch (CalcException | IOException e) {
            System.out.println("��������� ������: " + e.getMessage());
        }
    }
}
