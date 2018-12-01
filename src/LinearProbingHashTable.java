import assignment2.MyArrayList;

public class LinearProbingHashTable extends HashTable
{
    public MyMapElement[] table;
    private MyMapElement AVAILABLE = new MyMapElement(0,"");

    public LinearProbingHashTable()
    {
        super();
    }
    public LinearProbingHashTable(int capacity)
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
        do{
            if(isAvailable(j))
            {
                if(avail== -1)
                    avail =j;
                if(table[j]==null)
                    break;
            }
            else if((new Integer(table[j].getKey())).equals((k)))
                return j;
            j = (j+1) % capacity;
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
        if(size()>=capacity/2)
            resize(2*capacity);
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
    
    public void resize(int newCap)
    {
        MyMapElement[] temp = new MyMapElement[size()];
        int j=0;
        for(int i=0;i<table.length;i++){
            if(table[i] != AVAILABLE && table[i] != null)
                temp[j++] = table[i];
        }
        capacity = newCap;
        createTable();
        size = 0;
        for(int i=0;i<temp.length;i++){
            put(temp[i].getKey(),temp[i].getValue());
        }
    }

}
