public class Trie {
    private Node root;

    public Trie(){
        root = new Node();
    }

    // Insert word into the Trie
    public void insertWord(String word){
        // Start at root node and with index 0
        root = insertWordHelper(root,word,0);
    }


    // Recurisve helper method
    public Node insertWordHelper(Node node, String word, int depth){
        // If the current node doesn't exist, then make a new one
        if(node == null){
            node = new Node();
        }

        // Recusive method base case
        if(depth == word.length()){
            // Make the node show as a completed word
            node.isWord = true;
            return node;
        }

        char letter = word.charAt(depth);
        // Move to the next node that corresponds with the character and continue recursively
        node.next[letter] = insertWordHelper(node.next[letter], word, depth  + 1);
        return node;
    }

    // Look up word in trie
    public boolean lookUp(String word){
        // Start from the root and continue recusively
        Node node = lookUpHelper(this.root,word, 0);
        // If the node isn't null and is the end of a word then the word does exist
        return node != null && node.isWord;
    }


    public Node lookUpHelper(Node node, String word, int depth){
        // If a null node is reached then the word doesn't exists
        if(node == null){
            node = new Node();
        }
        // If all letters have been checked, then return the node
        if(depth == word.length()){
            return node;
        }

        // Get the character and move to the corresponding node
        char c = word.charAt(depth);
        return lookUpHelper(node.next[c], word, depth + 1);
    }
}
