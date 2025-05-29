package ds.dictionary;

import java.util.LinkedList;

public class Dictionary<K, V> {
    private static class Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    public Dictionary() {
        buckets = createBucketArray(16);
        size = 0;
    }
    
    @SuppressWarnings("unchecked")
    private LinkedList<Entry<K, V>>[] createBucketArray(int capacity) {
        return (LinkedList<Entry<K, V>>[]) new LinkedList[capacity];
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;

        if ((double) size / buckets.length > LOAD_FACTOR_THRESHOLD) {
            resize();
        }
    }
    
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }
    
    private void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = createBucketArray(oldBuckets.length * 2);
        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket == null) 
            	continue;

            for (Entry<K, V> entry : bucket) 
                put(entry.key, entry.value);
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) 
        	return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;

        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (int i = 0; i < bucket.size(); i++) {
            Entry<K, V> entry = bucket.get(i);
            if (entry.key.equals(key)) {
                bucket.remove(i);
                size--;
                return entry.value;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (Entry<K, V> entry : bucket) {
                if (!first)
                    sb.append(", ");
                sb.append(entry.key).append("=").append(entry.value);
                first = false;
            }
        }

        sb.append("}");
        return sb.toString();
    }
    
}


/**
The load factor is a measure of how full a hash table is.
Load Factor= Number of buckets (capacity) / Number of entries (size)
​
If the load factor is too high:
	- More keys are stored in the same bucket (because of limited bucket count).	
	- This causes more collisions.
	- In chaining (like we're using), it means longer linked lists, which slows down:
	- get(key) from ideal O(1) to O(n) in worst case.
	- put(key, value) takes longer too.
 **/
