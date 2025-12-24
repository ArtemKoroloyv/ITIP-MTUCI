import java.util.*;

class CustomThread extends Thread{
    private int[] nums;
    private int max;
    private Map<Integer, Integer> answers;
    private int i;
    public CustomThread(int[] nums, Map<Integer, Integer> answers, int i){
        this.answers = answers; // карта
        this.nums = nums; // строка матрицы
        this.i = i; // индекс строки
    }

    public void run(){
        for (int i: nums){
            max = Math.max(max, i);
        }
        answers.put(i, max);
    }
}
