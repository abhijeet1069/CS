package ds.dynamicArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

    @Test
    void testGetSize(){
        DynamicArray<Integer> arr = new DynamicArray<>();
        for(int i = 0; i < 100; i++)
            arr.add(i);
        assertEquals(100,arr.getSize());
    }

    @Test
    void testSet() {
        DynamicArray<String> arr = new DynamicArray<>();
        arr.add("a");
        arr.add("b");
        assertEquals("b", arr.get(1));
    }

    @Test
    void testResizeBeyondInitialCapacity() {
        DynamicArray<Integer> arr = new DynamicArray<>();
        for (int i = 0; i < 20; i++)
            arr.add(i);
        assertEquals(20, arr.getSize());
        assertEquals(0, arr.get(0));
        assertEquals(19, arr.get(19));
    }

    @Test
    void testGetOutOfBounds() {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(1);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> arr.get(1));
        assertTrue(exception.getMessage().contains("Index: 1"));
    }

    @Test
    void testIllegalCapacityExceeded() {
        DynamicArray<Integer> arr = new DynamicArray<>();
        int maxCapacity = 1000000;  // same as in the class

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            for (int i = 0; i < maxCapacity; i++) {
                arr.add(0);
            }
        });
        assertTrue(exception.getMessage().contains("exceeded max capacity of"));
    }

    @Test
    void testNegativeCapacity() {
        int maxCapacity = -10;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DynamicArray<Integer> arr = new DynamicArray<>(maxCapacity);
        });
        assertTrue(exception.getMessage().contains("Capacity cannot be negative"));
    }
}
