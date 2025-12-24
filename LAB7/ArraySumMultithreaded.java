public class ArraySumMultithreaded {
    public static void main(String[] args) {

        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int mid = array.length / 2;

        SumThread sumThread1 = new SumThread(array, 0, mid);
        SumThread sumThread2 = new SumThread(array, mid, array.length);

        Thread thread1 = new Thread(sumThread1);
        Thread thread2 = new Thread(sumThread2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Ожидание потоков было прервано");
        }

        long totalSum = sumThread1.getSum() + sumThread2.getSum();
        System.out.println("Сумма элементов массива: " + totalSum);
    }
}
