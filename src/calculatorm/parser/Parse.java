package calculatorm.parser;

import java.util.Arrays;
import java.util.List;

public class Parse {

    //  ����� ��������� ������� ������ �� ��������� �������� �� ������� � ���������� �� � ���� ������ �����.
    public static List<String> getExpItems(String exp) {
        return Arrays.asList(exp.split(" "));
    }
}