import java.util.Scanner;

public class PasswordValid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите пароль:");
        String password = scan.nextLine();
        String regex = "^(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{8,16}$";

        if (password.matches(regex)) {
            System.out.println("Пароль корректный");
        } else {
            System.out.println("Пароль НЕ корректный");
        }
    }
}
