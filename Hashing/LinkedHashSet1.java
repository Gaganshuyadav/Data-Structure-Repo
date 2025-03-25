package Hashing;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet1 {
    public static void main(String[] args) {
        
        //ordered , implement using doubly linked list, performance lesser than linkedHashMap
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("apple");
        lhs.add("banana");
        lhs.add("chrry");
        lhs.add("guava");
        lhs.add("cherry");
        lhs.add("lemon");

        System.out.println(lhs);

        Iterator it = lhs.iterator();
        while ( it.hasNext()) {
            System.out.println(it.next());
        }


    }
}
