import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopyVariant1 {
    public static void main(String[] args) {
        FileInputStream input = null;
        FileOutputStream output = null;

        try {
            input = new FileInputStream("source.txt");
            output = new FileOutputStream("copy.txt");

            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }

            System.out.println("Копирование выполнено успешно.");

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: не удалось открыть файл!");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла!");
        } finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла!");
            }
        }
    }
}
