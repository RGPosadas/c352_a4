
public abstract class HashTable 
{
    protected int size;
    protected int capacity;

    public HashTable(int capacity)
    {
        this.capacity = capacity;
        createTable();
    }

    public HashTable()
    {
        this(128);
    }

    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return (size==0);
    }
    
    protected abstract void createTable();

    public String get(Integer key)
    {
        return bucketGet(hashValue(key),key);
    }
    public String remove(Integer key){
        return bucketRemove(hashValue(key),key);
    }
    public String put(Integer key, String value){
        String answer = bucketPut(hashValue(key),key,value);
        return answer;
    }

    public abstract String bucketGet(int h,Integer key);
    public abstract String bucketPut(int h,Integer key, String value);
    public abstract String bucketRemove(int h,Integer key);


    private int hashValue(Integer key)
    {
        return (int) key%capacity;
    }

}
