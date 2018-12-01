public class LinearProbing extends HashTable {
    /**
     * Attributes
     */
    private MyMapElement[] LPTable;
    private MyMapElement AVAILABLE = new MyMapElement(0, null);

    /**
     * Default constructor
     */
    public LinearProbing() {
        super();
    }

    /**
     * Parameterized constructor
     */
    public LinearProbing(int cap) {
        super(cap);
    }

    public String get(Integer k) {
        int hashValue = getHashValue(k);
        // Loop through the whole LPTableay in a circular manner
        int i = 0;
        while (i < capacity) {
            // If index probed is empty
            if (LPTable[hashValue] == null)
                return null;
            // If index probed has the right key
            else if (LPTable[hashValue].getKey() == k)
                return LPTable[hashValue].getValue();
            // Move on
            else {
                hashValue = (hashValue + 1) % capacity;
                i++;
            }
        }
       // If you get here, you did not find the entry 
        return null;
    } 

    public String put(Integer k, String v) {
        int hashValue = getHashValue(k);
        // Loop through the whole LPTableay in a circular manner
        int i = 0;
        while (i < capacity) {
            // If index is null or available
            if (LPTable[hashValue] == null || LPTable[hashValue] == AVAILABLE) {
                LPTable[hashValue] = new MyMapElement(k,v);
                return null;
            }
            // If index has the same key, update the value
            else if (LPTable[hashValue].getKey() == k) {
                String oldValue = LPTable[hashValue].getValue();
                LPTable[hashValue].setValue(v);
                return oldValue;
            }
            // Move on
            else {
                hashValue = (hashValue + 1) % capacity;
                i++;
            }
        }
        // If you get here, there was no place to put the entry in
        return null;
    }

    public String remove(Integer k) {
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
                return temp;
            }
            // Move on to next index
            else {
                hashValue = (hashValue + 1) % capacity;
                i++;
            }
        }
        // If you get here, the key to be removed was not found
        return null;
    }
    
}