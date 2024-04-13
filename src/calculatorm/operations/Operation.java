package calculatorm.operations;

public class Operation {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    public static double ln(double a) {
        return Math.log(a);
    }

    public static double log10(double a) {
        return Math.log10(a);
    }

    public static double sin(double a) {
        return Math.sin(a);
    }

    public static double cos(double a) {
        return Math.cos(a);
    }

    public static double tan(double a) {
        return Math.tan(a);
    }

    public static double cot(double a) {
        return 1 / Math.tan(a);
    }

    public static double sec(double a) {
        return 1 / Math.cos(a);
    }

    public static double csc(double a) {
        return 1 / Math.sin(a);
    }

    public static double asin(double a) {
        return Math.asin(a);
    }

    public static double acos(double a) {
        return Math.acos(a);
    }

    public static double atan(double a) {
        return Math.atan(a);
    }

    public static double acot(double a) {
        return Math.PI / 2 - Math.atan(a);
    }

    public static double asec(double a) {
        return Math.acos(1 / a);
    }

    public static double acsc(double a) {
        return Math.asin(1 / a);
    }

    public static double abs(double a) {
        return Math.abs(a);
    }

    public static double ceil(double a) {
        return Math.ceil(a);
    }

    public static double floor(double a) {
        return Math.floor(a);
    }
}