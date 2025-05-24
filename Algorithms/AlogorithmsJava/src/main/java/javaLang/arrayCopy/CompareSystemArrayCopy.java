package javaLang.arrayCopy;

public class CompareSystemArrayCopy {

    public static int[] copyManual(int[] source) {
        int[] dest = new int[source.length];
        for (int i = 0; i < source.length; i++)
            dest[i] = source[i];
        return dest;
    }

    public static int[] copyUsingLibrary(int[] source) {
        int[] dest = new int[source.length];
        System.arraycopy(source, 0, dest, 0, source.length);
        return dest;
    }

    public static void measure(String label, Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;
        System.out.println(label + " took " + durationInNs + " ns (" + (durationInNs / 1_000_000.0) + " ms)");
    }

    public static void main(String[] args) {
        int[] src = new int[100000000];
        measure("System.arraycopy", () -> copyUsingLibrary(src));
        measure("for loop copy", () -> copyManual(src));
    }
}
