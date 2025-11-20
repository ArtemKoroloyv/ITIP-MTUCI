import java.util.Scanner;

public class IpCheck {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите IP-адрес:");
        String ip = scan.nextLine();

        String regex = "^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$";

        if (ip.matches(regex)) {
            System.out.println("IP-адрес корректный!");
        } else {
            System.out.println("IP-адрес НЕ корректный!");
        }
    }
}

