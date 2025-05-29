package ds.dynamicArray;

import java.util.Arrays;

public class DynamicArray<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 100000;
    private int size;
    private Object[] elements;

    public DynamicArray(final int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative.");
        }
        this.size = 0;
        this.elements = new Object[capacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public void add(final E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public E get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public int getSize() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > MAX_CAPACITY) {
            throw new IllegalStateException(minCapacity+" exceeded max capacity of "+MAX_CAPACITY);
        }
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}