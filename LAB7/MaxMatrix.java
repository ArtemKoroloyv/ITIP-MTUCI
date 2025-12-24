import java.util.*;
import java.util.concurrent.*;

public class MaxMatrix {
    public static void main(String[] args){
        Map<Integer, Integer> rowMaxes = new ConcurrentHashMap<>();
        List<Thread> threads = new ArrayList<>();
        int[][] nums = {{1,4,5,6,7,7},{1,10,20,330},{999,1,1}};
        for (int i = 0; i < nums.length; i++){
            int finalI = i;
            Thread t = new CustomThread(nums[i], rowMaxes, finalI);
            t.start();
            threads.add(t);
        }
        for (Thread t: threads){
            try{
                t.join();
            } catch (InterruptedException e){
                System.out.println("thread interrupted: " + e.getMessage());
                return;
            }
        }
        System.out.println(rowMaxes);
        System.out.println(Collections.max(rowMaxes.values()));
    }
}
