import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Vikram Saluja
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        Trie dictionaryT = new Trie();
        Trie misspelledT = new Trie();

        ArrayList<String> mispelled = new ArrayList<>();

        for(String word : dictionary){
            dictionaryT.insertWord(word);
        }

        for(String word : text){
            if(!dictionaryT.lookUp(word) && !misspelledT.lookUp(word)){
                misspelledT.insertWord(word);
                mispelled.add(word);
            }
        }
        String[] result = new String[mispelled.size()];
        for(int i = 0; i < mispelled.size(); i++){
            result[i] = mispelled.get(i);
        }
        return result;
    }


}
