public class ArrayAverage {
    public static void main(String[] args) {
        Object[] arr = {1, 2, 3, "восемь", 6, 7, 8};
        int sum = 0;

        try {
            for (int i = 0; i <= arr.length; i++) {
                sum += (Integer) arr[i];
            }
            double average =  sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за пределы массива.");
        } catch (ClassCastException e) {
            System.out.println("Ошибка: неверные данные в массиве.");
        }
    }
}
