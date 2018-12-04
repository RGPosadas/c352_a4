import java.util.Random;
public class Driver{
    public static void main(String[] args) {
        Random rdm = new Random();
        LinearProbing LPTable = new LinearProbing(17);
        LPTable.put(1, "myOriginalValue");
        for (int i = 0; i < 19; i++) {
            LPTable.put(new Integer(rdm.nextInt(1000) + 65536), "myValue" + i);
        }

        LPTable.display();

        System.out.println("From Driver: " + LPTable.get(1));
        System.out.println("From Driver: " + LPTable.get(2));
        // LPTable.remove(1);
        
        LPTable.display();


        System.out.println("From Driver: " + LPTable.remove(1));
        LPTable.display();

    
        System.out.println("From Driver: " + LPTable.remove(2));

        LPTable.display();
        LPTable.put(2, "hello");
        LPTable.display();
    }
}