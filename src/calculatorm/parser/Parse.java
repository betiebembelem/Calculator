package calculatorm.parser;

import java.util.Arrays;
import java.util.List;

public class Parse {

    //  Метод разделяет входную строку на отдельные элементы по пробелу и возвращает их в виде списка строк.
    public static List<String> getExpItems(String exp) {
        return Arrays.asList(exp.split(" "));
    }
}