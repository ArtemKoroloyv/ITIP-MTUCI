import java.util.Scanner;

public class SeasonCheck {
    public static String season(int month) {
        switch (month) {
            case 12: case 1: case 2:
                return "зима";
            case 3: case 4: case 5:
                return "весна";
            case 6: case 7: case 8:
                return "лето";
            case 9: case 10: case 11:
                return "осень";
            default:
                return "неверный номер месяца";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        sc.close();
        System.out.println(season(month));
    }
}
