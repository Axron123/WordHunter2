import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode {

        private boolean isWord = false;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    private final TrieNode root = new TrieNode();


    //takes string as argument, inserts word into trie
    public void insertWord(String word) {

        TrieNode currentNode = root;

        //iterate through word, check if current character is contained in hashmap as a key
        for (char c : word.toCharArray()) {



            //if the hashmap does not contain the char, insert char -> new trieNode
            if (!currentNode.children.containsKey(c)) {
                currentNode.children.put(c, new TrieNode());

                //once the new node is created, set current node to the new node

            }

                //if the hashmap does contain the char, set current node to char map key value
                currentNode = currentNode.children.get(c);

        }

        //once the last character is checked, mark current node as the end of word
        currentNode.isWord = true;
    }

    //checks if word exists, if word exists delete it
    public void deleteWord(String word) {

    }

    //checks if word exists, returns true if it does
    public boolean containsWord(String word) {

        TrieNode currentNode = root;

        for (char c : word.toCharArray()) {

            //if the current node does not contain the current character, return false
            if (!currentNode.children.containsKey(c)) {

                return false;
            } else {

                //if the current node contains the current character, move to the next node
                currentNode = currentNode.children.get(c);
            }
        }
        return currentNode.isWord;
    }

    //checks if prefix exists, returns true if it does
    public boolean containsPrefix(String prefix) {

        TrieNode currentNode = root;

        for (char c : prefix.toCharArray()) {

            //if the current node does not contain the current character, return false
            if (!currentNode.children.containsKey(c)) {

                return false;
            } else {

                //if the current node contains the current character, move to the next node
                currentNode = currentNode.children.get(c);
            }
        }

        return true;
    }




}
