import assignment2.MyArrayList;

public class QuadraticProbingHashTable extends HashTable
{
    public MyMapElement[] table;
    private MyMapElement AVAILABLE = new MyMapElement(0,"");

    public QuadraticProbingHashTable()
    {
        super();
    }
    
    public QuadraticProbingHashTable(int capacity)
    {
        super(capacity);
    }
    
    protected void createTable()
    {
        table = new MyMapElement[capacity];
    }
    
    private boolean isAvailable(int j)
    {
        return (table[j] == null||table[j] == AVAILABLE);
    }
    
    private int findSlot(int h,Integer k)
    {
        int avail = -1;
        int j=h;
        int increment =0;
        do{
            if(isAvailable(j)){
                if(avail== -1)
                    avail =j;
                if(table[j]==null)
                    break;
            } else if((new Integer(table[j].getKey())).equals(k))
                return j;
            j = (j+((increment+1)*(increment+1)-(increment*increment))) % capacity;
            increment++;

        } while(j!=h);
        return -(avail+1);
    }

    public String bucketPut(int h,Integer key, String value)
    {
        int j = findSlot(h,key);
        if(j>=0)
        {
            table[j].setValue(value);
            return table[j].getValue();
        }
        table[-(j+1)] = new MyMapElement(key, value);
        size++;
        return null;
    }
    
    public String bucketGet(int h,Integer key)
    {
        int j = findSlot(h,key);
        if (j<0)
            return null;
        return table[j].getValue();
    }

    public String bucketRemove(int h,Integer key)
    {
        int j = findSlot(h,key);
        if(j<0)
            return null;
        String answer = table[j].getValue();
        table[j] = AVAILABLE;
        size--;
        return answer;
    }
}
