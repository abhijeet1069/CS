package annotation;

import java.lang.reflect.Method;

public class MeasureTimeRunner {
    public static void main(String[] args) throws Exception {
        MyService service = new MyService();

        // Get all methods
        for (Method method : MyService.class.getDeclaredMethods()) {
            // Check if the method has @MeasureTime
            if (method.isAnnotationPresent(MeasureTime.class)) {
                long start = System.currentTimeMillis();
                method.invoke(service);  // Call the method
                long end = System.currentTimeMillis();
                System.out.println( method.getName() + "() took " + (end - start) + " ms");
            }
        }
    }
}
