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

//        Trie code:
//        Trie dictionaryT = new Trie();
//        Trie misspelledT = new Trie();
//
//        ArrayList<String> mispelled = new ArrayList<>();
//
//        for(String word : dictionary){
//            dictionaryT.insertWord(word);
//        }
//
//        for(String word : text){
//            if(!dictionaryT.lookUp(word) && !misspelledT.lookUp(word)){
//                misspelledT.insertWord(word);
//                mispelled.add(word);
//            }
//        }
//        String[] result = new String[mispelled.size()];
//        for(int i = 0; i < mispelled.size(); i++){
//            result[i] = mispelled.get(i);
//        }
//        return result;

        // Create TST for the dictionary and one for misspelled words
        TST dictionaryTST = new TST();
        TST misspelledTST = new TST();

        ArrayList<String> misspelled = new ArrayList<>();

        // Fill the TST with dictionary
        for(String word : dictionary){
            dictionaryTST.insertWordHelper(word);
        }

        // Check each word in text
        for(String word : text){
            boolean inDictionary = dictionaryTST.lookup(word);
            boolean duplicate = misspelledTST.lookup(word);

            // If not int the dictionary and is not already a misspelled word then add it
            if(!inDictionary && !duplicate){
                misspelledTST.insertWordHelper(word);
                misspelled.add(word);
            }
        }

        // Convert arrayList into array before return array result
        String[] result = new String[misspelled.size()];

        for(int i = 0; i < misspelled.size(); i++){
            result[i] = misspelled.get(i);
        }

        return result;
    }


}
