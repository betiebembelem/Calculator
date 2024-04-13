package calculatorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorM {

    public static void main(String[] args) {
        try{
            // ����� ���������
            System.out.println("����������� ��� ��������� ����: \"�����1 �������� �����2\". ��������: + - * /");
            System.out.print("������� ���������: ");
            // ������ ����� ������������
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            String calcString = bReader.readLine();

            // �������� ������� Calculator ��� ����������
            Calculator calculator = new Calculator();
            String result = calculator.result(calcString);
            // ����� ����������
            System.out.println("�����: " + result);
        }
        // ��������� ��������� ����������
        catch(CalcException | IOException ignored){
            // ������������� ����������
        }

    }

}
