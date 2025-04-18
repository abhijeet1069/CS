package skiena;

import java.util.PriorityQueue;
import java.util.Queue;

public class Hello {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(3);
        queue.add(-1);
        queue.add(2);
        queue.add(100);
        queue.add(101);

        System.out.println(queue);
    }
}
