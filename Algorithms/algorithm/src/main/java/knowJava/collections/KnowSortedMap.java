package knowJava.collections;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Sorted map internally uses Red-Black tree
 * NavigableMap extends SortedMap, providing more powerful navigation options such as finding the closest
 * matching key aor retrieving the map in reverse order.
 * */
public class KnowSortedMap {

    public static void testSortedMap(){
        SortedMap<Integer,String> map = new TreeMap<>();
        map.put(91,"Vivek");
        map.put(99,"Subham");
        map.put(78,"Mohit");
        map.put(77,"Vipul");
        System.out.println(map);

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.headMap(91));
        System.out.println(map.tailMap(91));

    }

    public static void main(String[] args) {
        testSortedMap();
    }
}
