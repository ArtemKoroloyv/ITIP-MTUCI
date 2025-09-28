import java.util.Scanner;

public class Average {
    public static double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double avg = average(sc.nextInt(), sc.nextInt(), sc.nextInt());
        if (avg % 1 == 0) {
            System.out.println((int) avg);
        } else {
            System.out.println(avg);
        }
    }
}
