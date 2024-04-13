package calculatorm;

// Создаем пользовательское исключение CalcException, которое расширяет класс Exception
public class CalcException extends Exception {


    public CalcException(String message){

        System.out.println(message);
    }
}
