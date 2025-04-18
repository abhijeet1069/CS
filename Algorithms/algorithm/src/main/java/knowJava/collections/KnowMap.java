package knowJava.collections;

import java.util.HashMap;
import java.util.Objects;

/**
 * Characteristics of the Map interface:
 * - Key Value Pairs : Each entry in Map consists of a key and a value
 * - Unique Keys : No two entries can have the same key
 * - One value per key : Each key maps to a single value
 * - Order : Some implementations maintain insertion order(LinkedHashMap), natural order(TreeMap) or no order (HashMap)
 *
 * Basic components of HashMap
 * - Key : The identifier used to retrieve the value
 * - Value : The data associated with the value
 * - Bucket : A place to store key-value pairs as cells in a list (array).
 * - Hash Function : Converts a key into an index(bucket location) for storage.
 *
 * Characteristics of Hash function:
 * - Deterministic : The same input will always produce the same output
 * - Fixed Output size : Regardless of input size, the hashcode has a consistent size
 * - Efficient Computation : Hash function should compute the hash quickly
 *
 * 	HashMap works with hash codes and equals(): If we provide proper implementations then we can use key as objects
 * 	1.	Computes hashCode() to determine the bucket
 * 	2.	Uses equals() to check if a key already exists in the bucket
 * */

public class KnowMap {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("Alice", 1);

        map.put(p1, "Engineer");
        map.put(p2, "Designer");
        map.put(p3, "Manager");

        //OP if hashcode and equals not defined:{Person{name='Bob', id=2}=Designer, Person{name='Alice', id=1}=Manager,Person{name='Alice', id=1}=Engineer}
        // By default hashcode is generated using object's memory location
        //OP with hashcode and equals : {Person{name='Bob', id=2}=Designer, Person{name='Alice', id=1}=Manager}
        System.out.println(map);

    }
}

class Person{

    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return id == other.getId() && Objects.equals(name, other.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
