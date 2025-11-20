import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scan.nextLine();

        // ([a-z]) — строчная
        // ([A-Z]) — заглавная
        // заменяем на !строчнаяЗаглавная!
        String result = text.replaceAll("([a-z])([A-Z])", "$1!$2!");

        System.out.println("Результат:");
        System.out.println(result);
    }
}
