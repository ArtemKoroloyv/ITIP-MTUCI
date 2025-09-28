import java.util.Scanner;

public class Rectangle {

    // Метод для вычисления площади
    public static double rectangleArea(double length, double width) {
        return length * width;
    }

    // Главный метод
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // читаем два числа
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        // считаем площадь
        double area = rectangleArea(length, width);

        // если площадь целая — выводим без .0
        if (area == (int) area) {
            System.out.println((int) area);
        } else {
            System.out.println(area);
        }
    }
}
