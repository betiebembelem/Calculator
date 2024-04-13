package calculatorm.parser;

public class ResultFormatter {
    //  принимает вещественное число и, если оно является целым числом,
    //  возвращает его в формате целого числа, в противном случае возвращает его в исходном формате.
    public static String formatResult(double result) {
        if (Validator.isInteger(String.valueOf(result))) {
            return String.format("%d", (int) result);
        } else {
            return String.valueOf(result);
        }
    }
}