import java.util.Scanner;

public class AgeChecker {
    public static void main(String[] args) {
        int age = new Scanner(System.in).nextInt();
        System.out.println(age >= 18 ? "совершеннолетний" : "несовершеннолетний");
    }
}
