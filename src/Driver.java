import java.util.Random;
public class Driver{
    public static void main(String[] args) {
        Random rdm = new Random();
        for (int i = 0; i < 10000; i++) {
            System.out.println(rdm.nextInt());
        }
    }
}