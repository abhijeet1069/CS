package knowJava.enums;

import java.util.HashMap;
import java.util.Map;

public class KnowEnum {
    public static void main(String[] args) {
        Map<String,Integer> hostMap = new HashMap<>();
        hostMap.put(Host.CONNECTTIMEOUT.name(),8000);
        hostMap.put(Host.FETCHTIMEOUT.name(),5000);
        System.out.println(hostMap);
    }
}
