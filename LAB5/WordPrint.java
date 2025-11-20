import java.util.Scanner;
import java.util.regex.*;

public class WordPrint {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scan.nextLine();          // читаем весь текст

        System.out.println("Введите букву, с которой должны начинаться слова:");
        String letterToken = scan.next().trim(); // читаем одно «слово» (не всю строку)

        if (letterToken.isEmpty()) {
            System.out.println("Буква не введена.");
            return;
        }

        // Берём только первый символ
        char ch = letterToken.charAt(0);

        // Регекс для поиска слов, начинающихся на ch
        // \b  – граница слова
        // \w* – остальные символы слова
        String regex = "\\b" + Pattern.quote(String.valueOf(ch)) + "\\w*";

        Pattern pattern = Pattern.compile(
                regex,
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS
        );
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные слова:");

        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Слов не найдено.");
        }
    }
}
