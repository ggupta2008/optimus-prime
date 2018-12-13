package ds;


class Entry<T,V> {
    final T key;
    V value;
    // add linked list logic later to this
    // since entry can be reperesente by linked list node although they may belong to different linked list at different indexses, they are still node
    // under teh heavy load, the implemtation of link list will be changed to balanced which give improve the worst retrieval time from O(n) to O(logn)
    Entry<T,V> next;

    public Entry(T t, V v) {
        key = t;
        value = v;
    }

    public void setValue(V v) {
        value = v;
    }

    public V getValue() {
        return value;
    }

    public T getKey() {
        return key;
    }
}



public class HashMap<T,V> {
    // this is s00000000ize of hashmap or rather limit of indexes where we will map the hashes
    private static final int SIZE=10;
    private Entry[] indexTable = new Entry[SIZE];

    public V get(T key) {
        int hash = hashFunction(key);
        Entry<T,V> entry = indexTable[hash];
        while(entry != null) {
            if(entry.getKey().equals(key)) {
                return entry.getValue();
            } else {
                // this means that we got a collision and we need to go further in the linklist
                entry = entry.next;
            }
        }
        return null;
    }


    public void put(T key, V value) { // this method will be synchronized as multiple threads will contend to change state of index table and we ca deep synchronize with synchronizing the possesion of entries as well
        int hash = hashFunction(key);
        Entry entry = indexTable[hash];
        boolean foundKey = false;
        if(entry==null) {
            entry = new Entry(key, value);
            indexTable[hash] = entry;
        } else {
            // collision occured
            // traverse to end of linkedlist to add element at the last
            while(entry != null) {
                entry = entry.next;
                if(entry.getKey().equals(key)) {
                    entry.setValue(value);
                    foundKey = true;
                }
            }
            if(!foundKey) {
                Entry newEntry = new Entry(key, value);
                entry.next = newEntry;
            }
        }
    }

    private int hashFunction(T key) {
        return key.hashCode() % SIZE;
    }

}
