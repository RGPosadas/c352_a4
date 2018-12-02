public class LinearProbing extends HashTable {
    /**
     * Attributes
     */
    private MyMapElement[] LPTable;
    private MyMapElement AVAILABLE = new MyMapElement(0, null);
    private static int totalCollisions = 0;

    /**
     * Default constructor
     */
    public LinearProbing() {
        super();
        LPTable = new MyMapElement[128];
    }

    /**
     * Parameterized constructor
     */
    public LinearProbing(int cap) {
        super(cap);
        LPTable = new MyMapElement[cap];
    }

    /**
     * O(n) since the key to get may not be in the full index.
     */
    public String get(Integer k) {
        long start = System.nanoTime();
        System.out.println("Now executing LinearProbing get()...");
        int hashValue = getHashValue(k);
        // Loop through the whole LPTableay in a circular manner
        int i = 0;
        while (i < capacity) {
            // If index probed is empty
            if (LPTable[hashValue] == null) {
                long end = System.nanoTime();
                System.out.println("It took " + ((end-start)/1000000) + "ms to run LinearProbing get(" + k + ").");
                return null;
            }
            // If index probed has the right key
            else if (LPTable[hashValue].getKey() == k) {
                long end = System.nanoTime();
                System.out.println("It took " + ((end-start)/1000000) + "ms to run LinearProbing get(" + k + ").");
                return LPTable[hashValue].getValue();
            }
            // Move on
            else {
                hashValue = (hashValue + 1) % capacity;
                i++;
            }
        }
       // If you get here, you did not find the entry
       long end = System.nanoTime();
       System.out.println("It took " + ((end-start)/1000000) + "ms to run LinearProbing get(" + k + ").");
       return null;
    } 

    /**
     * This method is O(n) because it's possible that the data structure is full and you probe every index in the array.
     */
    public String put(Integer k, String v) {
        long start = System.nanoTime();
        System.out.println("Now executing LinearProbing put("+ k +", " + v + ")...");
        System.out.println("The current size of the LinearProbing table is " + size + ".");
        int hashValue = getHashValue(k);
        // Loop through the whole LPTableay in a circular manner
        int i = 0;
        while (i < capacity) {
            // If index is null or available
            if (null == LPTable[hashValue] || LPTable[hashValue] == AVAILABLE) {
                LPTable[hashValue] = new MyMapElement(k,v);
                size++;
                sayPut(totalCollisions, i);
                long end = System.nanoTime();
                System.out.println("It took " + (end-start) + "ns to run LinearProbing put(" + k + ", " + v + ").\n");
                return null;
            }
            // If index has the same key, update the value
            else if (LPTable[hashValue].getKey() == k) {
                String oldValue = LPTable[hashValue].getValue();
                LPTable[hashValue].setValue(v);
                sayPut(totalCollisions, i);
                long end = System.nanoTime();
                System.out.println("It took " + (end-start) + "ns to run LinearProbing put(" + k + ", " + v + ").\n");
                return oldValue;
            }
            // Move on
            else {
                hashValue = (hashValue + 1) % capacity;
                i++;
            }
        }
        totalCollisions++;
        // If you get here, there was no place to put the entry in
        sayPut(totalCollisions, i);
        long end = System.nanoTime();
        System.out.println("It took " + (end-start) + "ns to run LinearProbing put(" + k + ", " + v + ").\n");
        return null;
    }

    /**
     * O(n) since the key to be removed may not be in the full array.
     */
    public String remove(Integer k) {
        long start = System.nanoTime();
        System.out.println("Now executing LinearProbing remove()...");
        int hashValue = getHashValue(k);
        int i = 0;
        // Loop through the whole LPTableay in a circular manner
        while (i < capacity) {
            // If index is null
            if (LPTable[hashValue] == null)
                return null;
            // If you found what you wanted to remove
            else if (LPTable[hashValue].getKey() == k) {
                String temp = LPTable[hashValue].getValue();
                LPTable[hashValue] = AVAILABLE;
                size--;
                return temp;
            }
            // Move on to next index
            else {
                hashValue = (hashValue + 1) % capacity;
                i++;
            }
        }
        // If you get here, the key to be removed was not found
        long end = System.nanoTime();
        System.out.println("It took " + ((end-start)/1000000) + "ms to run get(" + k + ").");
        return null;
    }
    
}