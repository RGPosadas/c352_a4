import assignment2.MyArrayList;

public class SeperateChainingHashTable extends HashTable 
{
	
	  	public HashTable[] table;
	  	
	    public SeperateChainingHashTable()
	    {
	        super();
	    }
	    
	    public SeperateChainingHashTable(int capacity)
	    {
	        super(capacity);
	    }
	    
	    protected void createTable()
	    {
	        table = new HashTable[capacity];
	    }
	    
	    public String bucketGet(int h, Integer key)
	    {
	        HashTable bucket = table[h];
	        if(bucket ==null)
	            return null;
	        return bucket.get(key);
	    }
	    
	    public String bucketPut(int h, Integer key,String value)
	    {
	        HashTable bucket = table[h];
	        if(bucket ==null)
	            bucket = table[h] = new HashTable();
	        int oldSize = bucket.size();
	        String answer = bucket.put(key, value);
	        size += (bucket.size()- oldSize);
	        return answer;
	    }

	    public String bucketRemove(int h, Integer key)
	    {
	        HashTable bucket = table[h];
	        if(bucket == null)
	            return null;
	        int oldSize = bucket.size();
	        String answer = bucket.remove(key);
	        size -= (oldSize - bucket.size());
	        return answer;
	    }

}
