package Project3;

/**
 * Created by M3800 on 3/1/2017.
 */

/*
15 points
   a) public boolean insert(K key, V value)
         inserts entry, rehashes if half full,
         can re-use deleted entries, throws
         exception if key is null, returns
         true if inserted, false if duplicate.

   15 points
   b) public V find(K key)
          returns value for key, or null if not found

   15 points
   c) public boolean delete(K key)
          marks the entry deleted but leaves it there,
          returns true if deleted, false if not found

   15 points
   d) private void rehash( )
          doubles the table size, hashes everything to
          the new table, omitting items marked deleted

   10 points
   e) public int getHashValue(K key)
          returns the hash value for the given key,
          or -1 if not found.
          (this is the value before probing occurs)

   10 points
   f) public int getLocation(K key)
          returns the location for the given key,
          or -1 if not found.
          (this is the value after probing occurs)

   10 points
   g) public String toString()
          returns a formatted string of the hash table:
               0  null
               1  xxxxx
               2  yyyyy
               ...

   10 points
   h) public static void main(String args[])
          demonstrate each of your methods


Submit to eLearning:
     LinearProbingHashTable.java

 */
public class LinearProbingHashTable<K, V> {
    int size, entries;
    Entry<K, V> table[];

    public LinearProbingHashTable(int size) {
        this.size = size;
        table = new Entry[size];
    }

    public boolean insert(K key, V value) {
        // Insert x as active
        int currentPos = probing(key);
        if (table[currentPos].isActive)
            return false;

        ++entries;
        table[currentPos] = new Entry<>(key, value);

        // Rehash; see Section 5.5
        if (entries > size / 2)
            rehash();

        return true;
    }

    public int probing(K key) {
        int position = getHashValue(key);
        while (table[position] != null && !table[position].key.equals(key)) {
            if (!table[position].isActive)
                return position;
            position += 1;
            if (position >= size)
                position -= size;
        }
        return position;
    }

    public V find(K key) {
        for (int i = 0; i < size; i++) {
            if (table[i].key == key && table[i].isActive) {
                return table[i].val;
            }
        }
        return null;
    }

    public boolean delete(K key) {
        int currentPos = probing(key);
        if (table[currentPos].isActive) {
            table[currentPos].isActive = false;
            entries--;
            return true;
        }
            return false;
    }

    private void rehash() {
        size *= 2;
        Entry<K, V> table2[] = table;
        table = new Entry[size];
        for (Entry<K, V> entry : table2)
            if (entry != null && entry.isActive)
                insert(entry.key, entry.val);
    }

    // returns the hash value for the given key
    public int getHashValue(K key) {
        int hash = key.hashcode();
        hash %= size;
        if (hash < 0)
            hash += size;

        return hash;
    }

    //  returns the location for the given key or -1 if not found.
    public int getLocation(K key) {
        for(int i = 0; i < size; i++)
            if(table[i].key == key)
                return i;
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++)
            sb.append(String.format("%-4d %s\n", i, table[i].val));
        return sb.toString();
    }

    private static class Entry<K, V> {
        public K key;
        public V val;
        public boolean isActive;

        public Entry(K key, V val) {
            this(key, val, true);
        }

        public Entry(K key, V val, boolean i) {
            this.key = key;
            this.val = val;
            isActive = i;
        }
    }
}
