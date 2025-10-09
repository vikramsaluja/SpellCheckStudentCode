public class TST {
    private TSTNode rootNode;

    // Insert word into TST
    public void insert(String word){
        if(word == null || word.isEmpty()){
            return;
        }
        rootNode = insert(this.rootNode, word, 0);
    }

    public TSTNode insert(TSTNode node, String word, int index){
        char current = word.charAt(index);

        if(node == null){
            node = new TSTNode();
            node.letter = current;

        }
    }

}
