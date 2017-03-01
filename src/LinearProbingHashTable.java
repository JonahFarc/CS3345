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
public class LinearProbingHashTable<K, V>
{
    int size;
    Entry<K, V> table[];
    table = new Entry[size];
    public boolean insert(K key, V value)
    {
    }
    public V find(K key){}
    public boolean delete(K key)
    {
    }
    private void rehash(){}
    public int getHashValue(K key){}
    public int getLocation(K key){}
    public String toString(){}
    private static class Entry<K, v>
    {

    }
}
