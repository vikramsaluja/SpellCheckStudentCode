public class TSTNode {
    // Character stored at the node
    char letter;
    // Check if the node is the end of a word
    boolean isWordCompeleted;
    // Goes toward nodes with smaller letters
    TSTNode left;
    // Goes to the next letter in the current word
    TSTNode middle;
    // Goes to node with larger letters
    TSTNode right;

}
