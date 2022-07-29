package Trie;
import java.io.*;
import java.util.*;

public class AddSearchWord {
  public static class WordDictionary {
    
    private class Node{
        Node[] child;
        boolean isEnd;
        Node(){
            child = new Node[26];
        }
    }
    
    final private Node root;
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for(char ch : word.toCharArray()){
            if(cur.child[ch-'a']==null){
                cur.child[ch-'a'] = new Node();
            }
            cur = cur.child[ch-'a'];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return find(word, 0, root);
    }
    
    public boolean find(String word, int i, Node node){
            if(i==word.length()){
                return node.isEnd;
            }
            
            if(word.charAt(i)=='.'){
                
                for(Node n: node.child){
                    if(n!=null && find(word, i+1, n)){
                        return true;
                    }
                }
                return false;
                
            }else{
                if(node.child[word.charAt(i)-'a']==null){
                    return false;
                }else{
                    Node c = node.child[word.charAt(i)-'a'];
                    return find(word, i+1, c);   
                }
            }
        }
    
  }


  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    WordDictionary obj = new WordDictionary();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");

      if (inp[0].equals("addWord")) {
        obj.addWord(inp[1]);
      } else if (inp[0].equals("search")) {
        System.out.println(obj.search(inp[1]));
      }
    }

  }
}

