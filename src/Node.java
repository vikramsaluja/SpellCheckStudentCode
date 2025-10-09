public class Node {
    boolean isWord;
    Node[] next;

    public Node(){
        this.isWord = false;
        // Constant time lookup for all extended ASCII values
        this.next = new Node[256];

    }
}
