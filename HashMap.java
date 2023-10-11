package DataStructuresAndAlgorithms;

import java.util.LinkedList;

/**
 * This class implements a simple hash map using separate chaining to handle
 * collisions.
 * The hash map associates integer keys with string values.
 */
public class HashMap {
    /**
     * This class represents an entry in the hash map.
     */
    private class Entry {
        private int key; // The key of this entry
        private String value; // The value associated with the key

        /**
         * Constructs a new Entry with the specified key and value.
         *
         * @param key   the key of this entry
         * @param value the value associated with the key
         */
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5]; // An array of linked lists to store entries

    /**
     * Computes the hash of a key.
     *
     * @param key the key to be hashed
     * @return the hash value of the key
     */
    private int hash(int key) {
        return key % entries.length;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is
     * replaced.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).addLast(new Entry(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map
     *         contains no mapping for the key
     */
    public String get(int key) {
        var entry = getEntry(key);

        return (entry == null) ? null : entry.value;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key the key whose mapping is to be removed from the map
     * @throws IllegalStateException if the specified key is not present in the map
     */
    public void remove(int key) {
        var entry = getEntry(key);

        if (entry == null)
            throw new IllegalStateException("Invalid key removal");

        getBucket(key).remove(entry);
    }

    /**
     * Returns the Entry associated with the specified key, or null if no such entry
     * exists.
     *
     * @param key the key whose associated Entry is to be returned
     * @return the Entry associated with the specified key, or null if no such entry
     *         exists
     */
    private Entry getEntry(int key) {
        var bucket = getBucket(key);

        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }

        return null;
    }

    /**
     * Returns the bucket (LinkedList of Entries) associated with the specified key.
     *
     * @param key the key whose associated bucket is to be returned
     * @return the bucket associated with the specified key, or null if no such
     *         bucket exists
     */
    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    /**
     * Returns or creates the bucket (LinkedList of Entries) associated with the
     * specified key.
     *
     * @param key the key whose associated bucket is to be returned or created
     * @return the bucket associated with the specified key, creating a new bucket
     *         if necessary
     */
    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);

        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        return entries[index];
    }

    /**
     * Main method to test the HashMap implementation with sample operations.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(6, "A");
        map.put(8, "B");
        map.put(11, "C");
        map.put(6, "A+");

        System.out.println(map.get(6)); // Output: A+
        System.out.println(map.get(10)); // Output: null

        map.remove(6);

        // Attempt to remove a key that doesn't exist
        try {
            map.remove(60);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Output: Invalid key removal
        }
    }
}
