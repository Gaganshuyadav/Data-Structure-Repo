package Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie1 {
    static class Node{
        Node[] children;
        boolean eow;

        Node(){

            children = new Node[26]; //a to z
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }

            eow = false;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){

        Node curr = root;
        
        //O(L)
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';

            if( curr.children[idx]==null){
                //add new node
                curr.children[idx] = new Node();
            }

            if(i==word.length()-1){
                curr.children[idx].eow = true;
            }
           
            curr = curr.children[idx];

        }
    }

    public static boolean search(String word){

        //if you are not allow empty string, ( use case search in word break, if you want to start with empty string, and not stuck in infinite loop)

        // if(word.length()==0){
        //     return false;
        // }

        Node curr = root;

        for(int i=0; i<word.length(); i++){     // O(L); L= key length

            int idx = word.charAt(i) - 'a';
            
            if( curr.children[idx]==null){
                return false;
            }

            //this case is important , cause their can be subset of word which are not exists in words 
            if( i==word.length()-1 && curr.children[idx].eow == false){
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    public static boolean wordBreakSolve(String key){
        
        if(key.length()==0){
            return true;
        }

        //if we start with zero than the empty string call again and again cause it gives true again and again and string start with empty again.
        //but i you really want to start with i=0, then just uncomment the condition check , if string is empty then return false
        for(int i=1; i<=key.length(); i++){

            String sub1 = key.substring(0, i);
            String sub2 = key.substring( i);

            if( search( sub1) && wordBreakSolve( sub2)){
                return true;
            }
        }
        
        return false;

    }
    
    public static boolean startsWith(String prefix){

        Node curr = root;

        for(int i=0; i<prefix.length(); i++){

            int idx = prefix.charAt(i) - 'a';

            if( curr.children[idx]==null){
                return false;
            }

            curr = curr.children[idx];

        }

        return true;

    }

    public static int count;
    public static void countAllUniqueSubstrings(Node currNode){
        
        if(currNode==null){
            return;
        }
        

        for(int i=0; i< currNode.children.length; i++){

            if(currNode.children[i]!=null){
                count++;
                countAllUniqueSubstrings( currNode.children[i]);
            }
        }

    } 

    public static void countUniqueSubstrings(){

        Node curr = root;
        count++;  // empty string add as count

        countAllUniqueSubstrings(curr);
    } 
    
    public static String longLength="";
    public static void calculateLongestWordWithAllPrefixes( Node currNode, StringBuilder str){

        //end of word is false then return
        if(currNode==null){
            return;
        }

        for(int i=0; i<currNode.children.length; i++){
            
            //if null not check
            if( currNode.children[i]!=null && currNode.children[i].eow==true){

                str.append(  (char)(i+'a'));

                // > this greater than sign represent if both string have same length then store first length which is which is lexographically increasing
                if( str.length() > longLength.length()){
                    longLength = str.toString();
                }
                
                calculateLongestWordWithAllPrefixes( currNode.children[i], str);
                str.deleteCharAt( str.length()-1);
        
            }
        
          
        }

        
    }
    public static String longestWordWithAllPrefixes(){

        StringBuilder str =new StringBuilder("");
        Node curr = root;

        calculateLongestWordWithAllPrefixes( curr, str);

        return longLength;
    }
    public static void main(String[] args) {
        
        /*(1). Insert and Search  */
        /* 

        //insert in Trie
        String words[] = { "the", "a", "there", "their", "any"};
        for(int i=0; i<words.length; i++){

            //each word
            insert( words[i]);
        }

        //search in Trie
        System.out.println( search( "their")); //true
        System.out.println( search( "thor")); //false
        System.out.println( search( "an"));  //false

        */

        /*(2). Word Break Problem */
        /*
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice"};
        // String words[] = { "b"};
        
        //insert in Trie
        for(int i=0; i<words.length; i++){
            insert( words[i]);
        }

        //word break key
        System.out.println( " is Exist: "+wordBreakSolve("ilikesamsung"));
        System.out.println( " is Exist: "+wordBreakSolve("a"));
        */

        /*(3). Starts With Problem */
        /* 
        String words[] = { "apple", "app", "mango", "man", "woman"};
        
        //insert in Trie
        for(int i=0; i<words.length; i++){
            insert( words[i]);
        }

        //check if any word starts with
        System.out.println( startsWith("app"));
        System.out.println( startsWith("moon"));

        */

        /*(4). Count Unique Substrings */
        /* 
        // String str = "ababa";               //ans:10
        String str = "apple";                  //ans:15
 
        ArrayList<String> suffixes = new ArrayList<>();

        //find all suffixes
        for(int i=0; i<str.length(); i++){
            suffixes.add( str.substring(i));
        }
    
        //now insert suffixes in Trie
        for(int i=0; i<suffixes.size(); i++){
            insert( suffixes.get(i) );
        }

        //now count total nodes in trie
        countUniqueSubstrings();
        System.out.println("total nodes count is "+count);

        */

        /*(5). Longest Word with all Prefixes */
        /*
        String words[] = { "a", "banana", "app", "appl", "ap", "b", "apply", "apple", "b", "c", "cc" , "ccc", "ccca", "cccaa", "cccaaa"  };
        // String words[] = { "a", "ab", "abc", "p", "pb", "pbd", "pbde", "pbdh" };
        
        //insert in Trie
        for(int i=0; i<words.length; i++){
            insert( words[i]);
        }

        //it should contain all end of word true
        System.out.println( " the answer is "+ longestWordWithAllPrefixes());

        */


    }
}
