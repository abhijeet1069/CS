package knowJava.collections;

import java.util.Vector;

public class KnowVector {

    public static void vectorThreadSafety(){
        Vector<Integer> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                list.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Size of vector: " + list.size()); // Output: 2000
    }

    public static void arrayListThreadSafety(){
        Vector<Integer> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                list.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Size of array list: " + list.size()); // Output: 2000
    }

    public static void main(String[] args) {
        vectorThreadSafety();
        arrayListThreadSafety();
    }
}
