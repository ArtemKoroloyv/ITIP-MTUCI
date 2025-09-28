import java.util.Scanner;

public class DigitSum {

    // метод для нахождения суммы цифр
    public static int digitSum(int n) {
        int sum = 0;
        for (char c : String.valueOf(Math.abs(n)).toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(digitSum(n));
    }
}
