import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

// Собственный класс исключения
class CustomDivisionException extends Exception {
    public CustomDivisionException(String message) {
        super(message);
    }
}

// Класс, выполняющий деление
class Divider {
    public static double divide(double a, double b) throws CustomDivisionException {
        if (b == 0) {
            throw new CustomDivisionException("Деление на ноль невозможно!");
        }
        return a / b;
    }
}

// Основная программа
public class DivisionApp {
    public static void main(String[] args) {

        double num1 = 10;
        double num2 = 0; // специально поставил 0 для вызова ошибки

        try {
            double result = Divider.divide(num1, num2);
            System.out.println("Результат деления: " + result);
        } catch (CustomDivisionException e) {
            System.out.println("Ошибка: " + e.getMessage());
            logError(e);
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
            logError(e);
        }

        System.out.println("Программа завершена.");
    }

    // Метод записи ошибок в лог-файл
    private static void logError(Exception e) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(LocalDateTime.now() + " — " + e.getClass().getSimpleName() + ": " + e.getMessage() + "\n");
        } catch (IOException io) {
            System.out.println("Не удалось записать ошибку в лог-файл!");
        }
    }
}

