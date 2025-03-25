package Hashing;

import java.util.*;

public class LinkedHashMap1 {
    public static void main(String[] args) {
        
        //unordered according to insertion
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put( "c", 1);
        hm.put( "by", 2);
        hm.put( "a", 3);
        hm.put( "ba", 4);
        hm.put( "e", 5);
        System.out.println(hm);

        //ordered according to insertion ( implement using doubly linked list)
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("c", 1);
        lhm.put("by", 2);
        lhm.put("a", 3);
        lhm.put("ba", 4);
        lhm.put("e", 5);
        System.out.println(lhm);
        
    }
}
