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
     * Common put() sysout's
     */
    public void sayPut(int collisions, int probes) {
        // String thisClass = (this.getClass()).substring(7);
        String thisClass = this.getClass().toString().substring(6);
        System.out.println("There are now " + size + " elements in the " + thisClass + " table.");
        System.out.println("So far, " + collisions + " keys collided in this table.");
        if (thisClass.equals("LinearProbing") || thisClass.equals("QuadraticProbing")) {
            if (probes == size)
                System.out.println("It took " + probes + " probes, but the element was not inserted.");
            else
                System.out.println("It also took " + probes + " probes to insert the element.");
        }
        else {
            System.out.println("There are, blehbleh");
        }
    }

    /**
     * Methods the child classes must implement 
     */
    public abstract String get(Integer k);
    public abstract String put(Integer k, String v);
    public abstract String remove(Integer k);
}