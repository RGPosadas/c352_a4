import java.util.Random;

public class MyMapElement {
    /**
     * Attributes
     */
    private int key;
    private String value;
    Random randomizer = new Random();

    /**
     * Default constructor
     */
    public MyMapElement() {}

    /**
     * Parameterized constructor
     * @param k
     * @param v
     */
    public MyMapElement(int k, String v) {
        key = k;
        value = v;
    }

    /**
     * Parameterized constructor with value v of random key k
     * @param v
     */
    public MyMapElement(String v) {
        value = v;
        key = randomizer.nextInt();
    }

    //Setters and Getters
    public int getKey() { return key; }

    public void setKey(int k) { key = k; }

    public String getValue() { return value; }

    public void setValue(String v) { value = v; }

    /**
     * Method that creates a hashcode out of value
     * @return
     */
    public int hashCode() {
        return 0;
    }

}
