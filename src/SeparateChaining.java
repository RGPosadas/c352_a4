public class SeparateChaining extends HashTable {
    private MyMapElement[] LPTable;
    private MyMapElement AVAILABLE = new MyMapElement(0, "AVAILABLE");
    private static int totalCollisions = 0;

    private class Node {
        private MyMapElement m;
        private Node next;

        public Node(Integer k, String v) {
            this.m = new MyMapElement(k, v);
            next = null;
        }
    }

    public SeparateChaining() {}

    public SeparateChaining() {
        
    }

}