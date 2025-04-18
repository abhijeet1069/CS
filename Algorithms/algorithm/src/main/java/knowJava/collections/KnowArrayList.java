package knowJava.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Key features of List interface:
 * - Order preservation
 * - Index based access
 * - Allows Duplicates
 * - Not thread safe
 *
 * An arraylist is a resizable array implementation of the List interface. Unlike arrays in Java, which have a fixed
 * size, an ArrayList can change its size dynamically as elements are added or removed. This flexibility makes it
 * popular choice when the number of elements in a list isn't known in advance.
 *
 * */

public class KnowArrayList {
    public static void main(String[] args) {
        String msg = "fe fi fo fum I smell the blood of a little boy";
        List<String> arr = Arrays.asList(msg.split(" "));
        System.out.println(arr);
        arr.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println(arr);

    }
}
