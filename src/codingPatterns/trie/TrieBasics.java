package codingPatterns.trie;

import java.util.HashMap;
import java.util.Map;

/*

Insert in try
abc
abcd
agl
lmno
lmtr
cdef

Remove from try - based on prefix
lm

remove from try - complete word
abc
abcd
agl

Search complete word
abc
lmtr

 */
public class TrieBasics {

    static class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;
        public TrieNode(){
            map = new HashMap<>();
            isEnd = false;
        }
    }

    public static void main(String[] args) {

        TrieNode trieNode = new TrieNode();
        String[] array = {"abc","abcd","agl","lmno","lmtr","cdef"};
        for(String str: array){
            insert(trieNode, str);
        }

        String[] searchArr = {"abc","abcd","stre", "abl","lmno","lmtr","cdef","abcde"};
        for(String str: searchArr){
            boolean isPresent = searchNode(trieNode, str);
            System.out.println(str + " -> " + isPresent);
        }

        deleteString(trieNode, "abc", 0);
        deleteString(trieNode, "lmno", 0);
        System.out.println("---------After delete---------");

        for(String str: searchArr){
            boolean isPresent = searchNode(trieNode, str);
            System.out.println(str + " -> " + isPresent);
        }
    }

    private static boolean deleteString(TrieNode root, String str, int index) {
        if(index == str.length()){
            if(!root.isEnd){
                return false;
            }
            root.isEnd = false;
            return root.map.size() == 0;

        }

        char ch = str.charAt(index);
        TrieNode node = root.map.get(ch);
        if(node == null){
            return false;
        }
        boolean shouldDelete = deleteString(node, str, index+1);
        if(shouldDelete){
            node.map.remove(ch);
            return node.map.size() == 0;
        }
        return false;


    }

    private static boolean searchNode(TrieNode root, String str) {
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            TrieNode node = root.map.get(ch);
            if(node == null){
                return false;
            }
            root = node;
        }
        return root.isEnd;
    }

    private static void insert(TrieNode root, String str) {
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            TrieNode node = root.map.get(ch);
            if(node == null){
                node = new TrieNode();
                root.map.put(ch, node);
            }
            root = node;
        }
        root.isEnd = true;
    }
}
