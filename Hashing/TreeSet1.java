package Hashing;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet1 {

    public static void main(String[] args) {
        
        //sorted order in ascending order, null values are not allowed, O(logn)
        TreeSet<String> ts = new TreeSet<>();

        ts.add("cherry");
        ts.add("apple");
        ts.add("banana");
        ts.add("guava");
        ts.add("lemon");
        ts.add("chrry");

        Iterator it = ts.iterator();
        while ( it.hasNext()) {
            System.out.println(it.next());
        }


    }
    
}
