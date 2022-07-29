package Graph;
//Use of Union and join In STRING**

import java.io.*;
import java.util.*;

public class SentenaceSimilar {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] sentence1 = br.readLine().split(" ");
    String[] sentence2 = br.readLine().split(" ");

    int m = Integer.parseInt(br.readLine());

    String[][] pairs = new String[m][2];
    for (int i = 0; i < m; i++) {
      pairs[i] = br.readLine().split(" ");
    }

    System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

  }

  static HashMap<String, String> parent;
  static HashMap<String, Integer> rank;
  public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
      parent = new HashMap<>();
      rank = new HashMap<>();

      if(Sentence1.length != Sentence2.length){
        return false;
      }

      for(int i=0; i<pairs.length; i++){
        String x = pairs[i][0];
        String y = pairs[i][1];
        union(x, y);
      }

      for(int i=0; i<Sentence1.length; i++){
        String s1 = Sentence1[i];
        String s2 = Sentence2[i];

        //if both string not equal
        //and their parent are not equal. -> they are not similar
        if(s1.equals(s2)==false && find(s1).equals(find(s2))==false){
          return false;
        }
      }

      return true;

  }

  public static void union(String x, String y){
    String lx = find(x);
    String ly = find(y);

    if(lx.equals(ly)==false){

      if(rank.get(lx)>rank.get(ly)){
        parent.put(ly, lx);
      }else if(rank.get(lx)<rank.get(ly)){
        parent.put(lx, ly);
      }else{
        parent.put(ly, lx);
        rank.put(lx, rank.get(lx)+1);
      }

    }

  }

  public static String find(String s){

    //add parent if not present 
    //similar to initializing parent array in case of integer.
    if(parent.containsKey(s)==false){
      parent.put(s,s);
      rank.put(s, 1);
    }

    if(s.equals(parent.get(s))){
      return s;
    }

    String temp = find(parent.get(s));
    parent.put(s, temp);
    return temp;

  }


}

