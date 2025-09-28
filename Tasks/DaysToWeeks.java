import java.util.Scanner;

public class DaysToWeeks {
    public static String daysToWeeks(int days) {
        int weeks = days / 7;
        int rest = days % 7;
        return weeks + " " + weekWord(weeks) + " и " + rest + " " + dayWord(rest);
    }

    private static String weekWord(int n) {
        if (n % 10 == 1 && n % 100 != 11) return "неделя";
        if (n % 10 >= 2 && n % 10 <= 4 && (n % 100 < 10 || n % 100 >= 20)) return "недели";
        return "недель";
    }

    private static String dayWord(int n) {
        if (n % 10 == 1 && n % 100 != 11) return "день";
        if (n % 10 >= 2 && n % 10 <= 4 && (n % 100 < 10 || n % 100 >= 20)) return "дня";
        return "дней";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        System.out.println(daysToWeeks(days));
    }
}
