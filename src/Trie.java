public class Trie {
    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insertWord(String word){
        root = insertWordHelper(root,word,0);
    }

    public Node insertWordHelper(Node node, String word, int depth){
        if(node == null){
            node = new Node();
        }
        if(depth == word.length()){
            node.isWord = true;
            return node;
        }

        char letter = word.charAt(depth);
        node.next[letter] = insertWordHelper(node.next[letter], word, depth  + 1);
        return node;
    }

    // Look up word in trie
    public boolean lookUp(String word){
        Node node = lookUpHelper(this.root,word, 0);
        return node != null && node.isWord;
    }

    public Node lookUpHelper(Node node, String word, int depth){
        if(node == null){
            node = new Node();
        }
        if(depth == word.length()){
            return node;
        }
        char c = word.charAt(depth);
        return lookUpHelper(node.next[c], word, depth + 1);
    }
}
