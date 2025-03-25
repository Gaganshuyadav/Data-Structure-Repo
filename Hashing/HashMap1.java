

/*Implementation of HashMap :-  */

/* 

package Hashing;
import java.util.*;

public class HashMap1{
    //K,V are generics
    static class MyHashMap<K,V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int N;     //N : bucket size
        private int n;     //n : buckte total nodes size
        private LinkedList<Node> buckets[];   //N

        @SuppressWarnings("unchecked")
        public  MyHashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = Math.abs( key.hashCode());   //hast code

            int bi = hc % N ;     //bucket index 
            return bi;
        } 

        private int SearchInLL( K key, int bi){
            LinkedList<Node> li = buckets[bi];
            int di = 0;                          //data index

            for(int i=0; i<li.size(); i++){
                Node node = li.get(i);
                if(node.key.equals( key)){
                    return di;
                }

                di++;
            }

            return -1;

        }

        @SuppressWarnings("unchecked")
        private void rehash(){

            //initialization
            LinkedList<Node> oldBuck[] = buckets; //copy previous buckets
            buckets = new LinkedList[N*2];      //double the linklist
            N = 2*N;                            //double the N
            
            //reinitialize with linklists
            for(int i=0; i<N; i++){
                buckets[i] = new LinkedList<>();
            }


            //previous nodes -> add to new bucket
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> li = oldBuck[i];
                for(int j=0; j<li.size(); j++){
                    Node node = li.get(j);
                    put( node.key, node.value);
                }
            }

        }

        public void put(K key, V value){      //O(lambda) --> O(1)

            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di==-1){
                //create new 
                Node newNode = new Node(key, value);
                buckets[bi].add(newNode);
                n++;
            }
            else{
                //set new value in existing key
                Node node = buckets[bi].get(di);
                node.value = value;

            }


            //check lambda for rehashing
            double lambda = (double)n/N;

            if(lambda > 2.0){
                rehash();
            }
        }


        public boolean containsKey(K key){       //O(lambda) --> O(1)
            int bi = hashFunction( key);
            int di = SearchInLL( key, bi);

            if(di==-1){
                return false;
            }
            else{
                return true;
            }
        }


        public V get(K key){               //O(lambda) --> O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di==-1){
                return null;
            }
            else{
                return buckets[bi].get(di).value;
            }
        }


        public V remove(K key){           //O(lambda) --> O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di!=-1){
                Node node = buckets[bi].remove(di);
                return node.value;   
            }
            else{
                return null;
            }

        }

        public ArrayList<K> keySet(){

            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++){
                    keys.add( ll.get(j).key);
                }
            }

            return keys;
        }

        public boolean isEmpty(){

            return n == 0;
        }

        


    }
    public static void main(String[] args) {


        MyHashMap<String, Integer> hp = new MyHashMap<String, Integer>();

        hp.put("a",100);
        hp.put("b",200);
        hp.put("u",300);
        hp.put("d",400);
        hp.put("e",500);
        hp.put("f",600);
        hp.put("g",700);
        hp.put("h",800);

        System.out.println(hp.containsKey("e"));
        System.out.println(hp.containsKey("u"));


        System.out.println(hp.get("e"));
        System.out.println(hp.get("u"));

        hp.remove("e");

        System.out.println(hp.get("e"));
        System.out.println(hp.get("u"));

        System.out.println(hp.keySet());

        System.out.println(hp.isEmpty());



        

        
    }
}

*/


/* Coding in Hashmap  */
// /*

package Hashing;
import java.util.*;

public class HashMap1{

    public static void main(String[] args) {


        /* 

        HashMap<String, Integer> hp = new HashMap<String, Integer>();

        hp.put("a",100);
        hp.put("b",200);
        hp.put("c",300);
        hp.put("d",400);
        hp.put("e",500);
        hp.put("f",600);
        hp.put("g",700);
        hp.put("h",800);

        // (1). Iterate HashMap ( keySet():- keys array)
        // Set<String> keys = hp.keySet();

        // for(String key : keys){
        //     System.out.println("keys "+key+" value "+hp.get(key));
        // }

        // (2). entrySet() ( give key-value pair):- 
        // Set<Map.Entry<String,Integer>> keyValueES = hp.entrySet();

        // for(Map.Entry<String,Integer> me: keyValueES){
        //     System.out.println("key: "+me.getKey()+" value: "+me.getValue());
        // }
        

        */

        /*(1). Majority Element O(n) */

        /* 
        int nums[] = { 1, 3, 2 ,5, 1, 3, 1, 5, 3, 1};
        int condition = (nums.length)/3;
        HashMap< Integer, Integer> hp = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<nums.length; i++){

            if( hp.containsKey(nums[i])){
                hp.put( nums[i], hp.get(nums[i])+1);
            }
            else{
                hp.put( nums[i], 1);
            }
            
        }

        //check condition
        for(int key : hp.keySet()){
            
            if(hp.get(key) >= condition){
                arr.add( key);
            }
        }

        System.out.println(arr);

        */
        
        /*(2). Valid Anagram */


        /*(i). 2 Hashmaps use , but this is not efficient way and exceed for large string. Time Complexity:- O(2n) */

        /* 
        String s = "anagram"; 
        String t = "nagaram";

        HashMap<Character,Integer> hpS = new HashMap<>();
        HashMap<Character,Integer> hpT = new HashMap<>();

        //firstly check if length is unequal
        if(s.length()!=t.length()){
            System.out.println("false ");
            // return;
        }

        for(int i=0; i<s.length(); i++){
            
            //count s
            if(hpS.containsKey( s.charAt(i))){
                hpS.put( s.charAt(i), hpS.get( s.charAt(i)) + 1);
            }
            else{
                hpS.put( s.charAt(i), 1);
            }

            //count t
            if(hpT.containsKey( t.charAt(i))){
                hpT.put( t.charAt(i), hpT.get( t.charAt(i)) + 1);
            }
            else{
                hpT.put( t.charAt(i), 1);
            }
        }


        //now check condition
        for(Character key : hpS.keySet()){
 
            if( !( hpT.containsKey(key) && hpS.get(key)==hpT.get(key)) ){
                System.out.println("false ");
                break;
                //return
            }


        }

        System.out.println("true");

        */
        
        /*(ii). only 1 hashmap is used. Time Complexity:- O(n) */

        /* 

        String s = "anagram"; 
        String t = "nagaram";

        HashMap<Character,Integer> hp = new HashMap<>();

        //count first string s
        for(int i=0; i<s.length(); i++){
            
            //count s
            if(hp.containsKey( s.charAt(i))){
                hp.put( s.charAt(i), hp.get( s.charAt(i)) + 1);
            }
            else{
                hp.put( s.charAt(i), 1);
            }
        }

        for(int i=0; i<t.length(); i++){

            if(!hp.containsKey(t.charAt(i)) || hp.get(t.charAt(i)) <=0 ){
                System.out.println("false ");
                break;
                //return
            }

            hp.put( t.charAt(i), hp.get(t.charAt(i))-1);


        }

        System.out.println("true"); 
        // return true;

        */


        /*(3). Count Distinct Elements( unique element)*/
        

        /*(i). efficient approach O(n) ( with hashset)*/
        /* 
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<num.length; i++){
            hs.add( num[i]);
        }

        System.out.println(hs);

        */

        /*(ii). efficient approach O(n) ( with hashmap)*/
        /* 
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };

        HashMap<Integer, Integer> hp = new HashMap<>();

        for(int i=0; i<num.length; i++){
            
            if(!hp.containsKey(hp)){
                hp.put(num[i], 1);
            }
            
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(Integer key: hp.keySet()){
            arr.add(key);
        }

        System.out.println(arr);

        */


        /*(iii). Brute force approach O(n^2) */
        /* 
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };

        ArrayList<Integer> result = new ArrayList<>();
        boolean isPresent = true;
        
        for(int i=0; i<num.length; i++){

            isPresent = true;
            for(int j=i+1; j<num.length; j++){
                
                if( num[i]==num[j]){
                    isPresent=false;
                }
            }

            if(isPresent){
                result.add(num[i]);
            }
        }

        System.out.println(result);

        */

        /*(4). Union and Intersection of 2 arrays */

        /* 
        Integer arr1[] = { 7, 3, 9};
        Integer arr2[] = { 6, 3, 9, 2, 9 ,4};

        HashSet<Integer> hs = new HashSet<>();

        ArrayList<Integer> union = new ArrayList<>();
        ArrayList<Integer> intersection = new ArrayList<>();
        
        //find intersection 
        for(int i=0; i<arr2.length; i++){
            hs.add(arr2[i]);
        }

        // find unique and same by comparing it with arr1, and store in interaction and hastset for unique
        for(int i=0; i<arr1.length; i++){
            
            if(hs.contains(arr1[i])){
                intersection.add(arr1[i]);
            }
            else{
                hs.add(arr1[i]);
            }
        }

        //copy all elements from hashset
        for(Integer num : hs){
            union.add(num);
        }
        

        System.out.println(intersection);
        System.out.println(union);

        */

        /*(5). Find Itinerary from Tickets */
        /*

        HashMap< String, String> hm = new HashMap<>();
        hm.put( "Chennai", "Bengaluru");
        hm.put( "Mumbai", "Delhi");
        hm.put( "Goa", "Chennai");
        hm.put( "Delhi", "Goa");

        //find start point
        String start = new String("");

        HashSet<String> hs = new HashSet<>();

        //copy all values of hashmap in hashSet
        for(String str : hm.keySet()){
            hs.add( hm.get( str));
        }

        System.out.println(hs);

        //find start point
        for(String str : hm.keySet()){
            
            if(!hs.contains(str)){
                start = str;
            }
        }

        //print the relationship
        System.out.print(start);
        for(String str : hm.keySet()){
            System.out.print( " -> "+hm.get(start));
            start = hm.get(start);
        }

        */

        /*(6). Find Largest Subarray with 0 sum */

        /*(i).  Brute force approach O(n^2) */

        /* 

        int arr[] = { 15, -2, 2, -8, 1, 7, 10};

        int sum = 0;
        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){

            for(int j=i; j<arr.length; j++){

                sum += arr[j];

                if(sum==0){
                    if( maxLen < (j-i+1) ){
                        maxLen = j-i+1;
                    }
                }
            }

            sum=0;
        }

        System.out.println(maxLen);

        */

        /*(ii). efficient approach O(n)*/

        /* 
        int sum = 0;
        int maxLen = 0;

        HashMap<Integer,Integer> hp = new HashMap<>();
        hp.put( 0 , -1);
        
        
        for(int i=0; i<arr.length; i++){

            sum += arr[i];

            if( hp.containsKey( sum)){
                if(maxLen < i - hp.get( sum) ){
                    maxLen = i-hp.get( sum);
                }
            }
            else{
                hp.put( sum, i);
            }
            
            
        }

        System.out.println(maxLen);

        */
        

        /*(7). Subarray Sum Equals K*/

        /*(i). Brute Force O(n^2) */

        /* 

        // int nums[] = { 1, 2, 3};
        // int k=3;
        int nums[] = { 1, -1, 0 };
        int k=0;


        int count = 0;


        for(int i=0; i<nums.length; i++){
            
            int sum=0;

            for(int j=i; j<nums.length; j++){

                sum += nums[j];

                if(sum==k){
                    System.out.println("sum :"+sum+" i "+i+" j "+j);
                    count++;
                }

            }
        }

        System.out.println(count);

        */

        /*(ii).  O(n) */

        /* 

        int nums[] = { 1, 2, 3};
        int k=3;
        // int nums[] = { 1, -1, 0 };
        // int k=0;

        int sum=0;
        int count = 0;

        HashMap<Integer,Integer> hm = new HashMap<>();
        //initially hashmap value is 0, if our first sum eqeals to k is exist at start
        hm.put( 0, 1);

        for(int i=0; i<nums.length; i++){

            sum += nums[i];

            if( hm.containsKey( sum-k)){
                count = count + hm.get(sum-k);
                
            }
            
            //previous all sums 
            hm.put( sum, ( hm.get( sum)==null ? 0 : hm.get(sum) ) + 1);
            
            

        }

        System.out.println(count);

        */


        

    }
}
    

// */