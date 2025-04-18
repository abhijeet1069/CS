package knowJava.memoryLeak;

import java.util.ArrayList;
import java.util.List;

public class HeapOverflow {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        while (true) {
            list.add(new int[Integer.MAX_VALUE]);
        }
    }
}

