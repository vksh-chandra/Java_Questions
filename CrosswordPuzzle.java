import java.io.*;
import java.util.*;

public class CrosswordPuzzle {

  public static void solution(char[][] arr, String[] words, int vidx) {
    if(vidx==words.length){
        print(arr);
        return;
    }
    
    String word = words[vidx];
    for(int i=0; i<arr.length;i++){
        for(int j=0; j<arr[0].length;j++){
            if(arr[i][j]=='-' || arr[i][j]==word.charAt(0)){
                if(isValidH(arr, word, i,j)){
                    boolean[] place= placewordH(arr, word, i,j);
                    solution(arr, words, vidx+1);
                    unplacewordH(arr, place, i,j);
                }
                
                if(isValidV(arr, word, i,j)){
                    boolean[] place = placewordV(arr, word, i, j);
                    solution(arr, words, vidx+1);
                    unplacewordV(arr, place, i,j);
                }
            }
        }
    }

  }
  
  public static void unplacewordH(char[][] arr, boolean[] place, int i, int j){
      for(int jj=0; jj<place.length; jj++){
          if(place[jj]==true){
              arr[i][j+jj] = '-';
          }
      }
  }
  
  public static void unplacewordV(char[][] arr, boolean[] place, int i, int j){
      for(int ii=0; ii<place.length; ii++){
          if(place[ii]==true){
              arr[i+ii][j] = '-';
          }
      }
  }
  
  public static boolean[] placewordH(char[][] arr, String word, int i, int j){
      boolean[] place = new boolean[word.length()];
      for(int jj=0; jj<word.length();jj++){
          if(arr[i][j+jj]=='-'){
            place[jj]=true;
            arr[i][j+jj] = word.charAt(jj);
          }
      }
      return place;
      
  }
  
  public static boolean[] placewordV(char[][] arr, String word, int i, int j){
      boolean[] place = new boolean[word.length()];
      for(int ii=0; ii<word.length();ii++){
          if(arr[i+ii][j]=='-'){
            place[ii]=true;
            arr[i+ii][j] = word.charAt(ii);  
        }
      }
      return place;
      
  }
  
  public static boolean isValidH(char[][] arr, String word, int i, int j){
      if(j-1>=0 && arr[i][j-1]!='+'){
          return false;
      }else if(j+word.length() < arr[0].length && arr[i][j+word.length()] != '+'){
          return false;
      }
      
      for(int jj=0; jj<word.length();jj++){
          if(j+jj>=arr[0].length){
              return false;
          }
          
          if(arr[i][j+jj]=='-' || arr[i][j+jj]==word.charAt(jj)){
              continue;
          }else{
              return false;
          }
      }
      return true;
  }
  
  public static boolean isValidV(char[][] arr, String word, int i, int j){
      if(i-1>=0 && arr[i-1][j]!='+'){
          return false;
      }else if(i+word.length() < arr.length && arr[i+word.length()][j] != '+'){
          return false;
      }
      
      for(int ii=0; ii<word.length();ii++){
          if(i+ii>=arr.length){
              return false;
          }
          
          if(arr[i+ii][j]=='-' || arr[i+ii][j]==word.charAt(ii)){
              continue;
          }else{
              return false;
          }
      }
      return true;
  }


  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}