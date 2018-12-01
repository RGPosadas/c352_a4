abstract public class HashTable {
    /**
     * Attributes
     */
    protected int size;       // Num of entries in the HashTable
    protected int capacity;   // Capacity of HashTable 

    /**
     * Parameterized constructor
     */
    public HashTable(int cap) {
        capacity = cap;
        size = 0;
    }

    /**
     * Default constructor
     */
    public HashTable() {}

    /**
     * Compresses the hashcode to make a hashvalue 
     */
    public int getHashValue(Integer key) {
        return (key%capacity);
    }

    /**
     * Returns number of entries in M
     */
    public int size() {
        return size;
    }

    /**
     * Checks if HashTable is empty
     */
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    /**
     * Methods the child classes must implement 
     */
    public abstract String get(Integer k);
    public abstract String put(Integer k, String v);
    public abstract String remove(Integer k);
}