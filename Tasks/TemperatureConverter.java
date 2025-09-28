import java.util.Scanner;

public class TemperatureConverter {


    public static int toFahrenheit(int celsius) {
        return celsius * 9 / 5 + 32;
    }

    // Метод main с вводом и выводом
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int celsius = scanner.nextInt();
        int fahrenheit = toFahrenheit(celsius);
        System.out.println(fahrenheit);
    }
}
