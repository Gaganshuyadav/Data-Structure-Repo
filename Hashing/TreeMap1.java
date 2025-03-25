package Hashing;

import java.util.*;

public class TreeMap1 {
    public static void main(String[] args) {
        
        //sorted order , get, put, remove are O(logn)
        //implement using red-black tree( self balancing trees)

        /* 
        TreeMap<String, Integer> tm = new TreeMap<>();
        
        tm.put( "c", 1);
        tm.put( "by", 2);
        tm.put( "a", 3);
        tm.put( "ba", 4);
        tm.put( "e", 5);
        tm.put( "1", 1);
        tm.put( "2y", 2);
        tm.put( "3", 3);
        tm.put( "ba", 4);
        tm.put( "e", 5);
        System.out.println(tm);
        */
        

        TreeMap<Integer, String> tm = new TreeMap<>();

        tm.put( 1, "a");
        tm.put( 10, "b");
        tm.put( 4, "c");
        tm.put( 6, "d");
        tm.put( 2, "e");
        tm.put( 8, "f");
        tm.put( 9, "g");
 
        System.out.println(tm);


    }
}
