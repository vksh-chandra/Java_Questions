package Trie;

import java.io.*;
import java.util.*;

//USED TO SOLVE PREFIX PROBLEMS OR DICTIONARY SEARCH OR ADD WORD PROBLEMS

public class ImplementTrie {
  public static class Trie {
      
    public class Node{
        Node[] child;
        boolean isEnd;
        
        Node(){
            child = new Node[26];
        }
    }
    
    final private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(); 
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        Node cur = root;
        for(char ch: word.toCharArray()){
            if(cur.child[ch-'a']==null){
                cur.child[ch-'a'] = new Node();
            }
            cur = cur.child[ch-'a'];
        }
        cur.isEnd = true;
        
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        Node cur = root;
        for(char ch: word.toCharArray()){
            if(cur.child[ch-'a']==null) return false;
            
            cur = cur.child[ch-'a'];
        }
        if(cur.isEnd==false){
            return false;
        }
        
        return true;
        
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        
        for(char ch: prefix.toCharArray()){
            if(cur.child[ch-'a']==null) return false;
            
            cur = cur.child[ch-'a'];
        }
        
        
        return true;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    Trie obj = new Trie();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");

      if (inp[0].equals("insert")) {
        obj.insert(inp[1]);
      } else if (inp[0].equals("search")) {
        System.out.println(obj.search(inp[1]));
      } else if (inp[0].equals("startsWith")) {
        System.out.println(obj.startsWith(inp[1]));
      }
    }

  }
}

