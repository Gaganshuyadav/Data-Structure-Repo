package Hashing;

import java.util.*;

public class HashSet1 {

    public static void main(String[] args) {

        /*(i). HashSet operations:- */  //no duplicates, unordered, NuLL is allowed
        /* 
        HashSet<Integer> hs = new HashSet<>();
        hs.add(3);
        hs.add(38);
        hs.add(2);
        hs.add(6);
        hs.add(38);
        hs.add(2);

        System.out.println(hs);

        if(hs.contains(38)){
            System.out.println("is contains 38");
        }

        if(hs.contains(8)){
            System.out.println("is contains 8");
        }

        hs.remove(3);
        hs.remove( 1);
        System.out.println(hs);
        System.out.println(hs.size());
        hs.clear();
        System.out.println(hs.size());
        System.out.println(hs);
        System.out.println(hs.isEmpty());

        */

        /*(ii). HashSet Iteration */
        /* 
        HashSet<String> hs = new HashSet<>();
        hs.add("apple");
        hs.add("banana");
        hs.add("chrry");
        hs.add("guava");
        hs.add("cherry");
        hs.add("lemon");

        // first method with iterator:------------
        // Iterator it = hs.iterator();
        // while ( it.hasNext()) {
        //     System.out.println(it.next());
        // }

        // first method with iterator:------------

        for(String city: hs){
            System.out.println(city);
        }

        */

        /*(iii). compare HashSet, LinkedHashSet, TreeMap */

        /* 

        // hashset
        HashSet<String> hs = new HashSet<>();

        hs.add("cherry");
        hs.add("apple");
        hs.add("banana");
        hs.add("guava");
        hs.add("lemon");
        hs.add("chrry");


        //linkedhashset
        //ordered , implement using doubly linked list, performance lesser than linkedHashMap
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("cherry");
        lhs.add("apple");
        lhs.add("banana");
        lhs.add("guava");
        lhs.add("lemon");
        lhs.add("chrry");


        //sorted order in ascending order, null values are not allowed, O(logn)
        TreeSet<String> ts = new TreeSet<>();

        ts.add("cherry");
        ts.add("apple");
        ts.add("banana");
        ts.add("guava");
        ts.add("lemon");
        ts.add("chrry");


        System.out.println(hs);
        System.out.println(lhs);
        System.out.println(ts);

        */




    }

}
