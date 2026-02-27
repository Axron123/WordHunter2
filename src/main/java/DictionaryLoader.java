import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DictionaryLoader {

   public static void loadDictionary(Trie trie, String filename) {
       List<String> words = dictionaryToList(filename);

       for (String word : words) {
           trie.insertWord(word);
       }
   }

    public static List<String> dictionaryToList(String filename) {
        List<String> words = new ArrayList<>();

        //Get the dictionary file
        InputStream inputStream = DictionaryLoader.class.getResourceAsStream("/" + filename);

        //check if inputstream found dictionary.txt, if not throw exception
        if (inputStream == null) {
            throw new IllegalArgumentException("Dictionary file not found: " + filename);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                //trim whitespace
                line = line.trim();

                if (line.length() < 3) {
                    continue;
                }

                //convert all characters to uppercase
                words.add(line.toUpperCase());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return words;
    }


    


}
