package java_DataStructure.Queue;
import java.util.*;

/*(1). Queue using 2 stacks */
/*
public class QueueA{
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();


    //is empty
    public static boolean empty(){
        return s1.empty();
    }

    //add
    public static void add(int data){
        
        if(s1.empty()){
            s1.push(data);
        }
        else{
            while(!s1.empty()){
            s2.push(s1.pop());
            }
            
            s1.push(data);

            while(!s2.empty()){
                s1.push(s2.pop());
            }
        }
        
    }

    //remove
    public static int remove(){
        if(empty()){
            System.out.println("queue is empty");
            return -1;
        }

        return s1.pop();
    }

    //peek
    public static int peek(){
        if(empty()){
            System.out.println("queue is empty");
            return -1;
        }

        return s1.peek();
    }

}

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.empty()){
            System.out.println(q.remove());
        }
    }
}

*/


/*(2). stack using 2 queue */
/*
public class QueueA{
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        
    //which queue is empty---

    //queue 1 empty check
    public static boolean firstQueueIsEmpty(){
        return q1.isEmpty();
    }

     //queue 2 empty check
     public static boolean secondQueueIsEmpty(){
        return q2.isEmpty();
    }

    //is stack is empty
    public static boolean isEmpty(){
        return firstQueueIsEmpty() && secondQueueIsEmpty();
    }

    //push
    public static void push(int data){
        if(secondQueueIsEmpty()){
            q1.add(data);
        }
        else{
            q2.add(data);
        }
    }

    //remove
    public static int pop(){

        //check if both queue are empty
        if( firstQueueIsEmpty() && secondQueueIsEmpty()){
            System.out.println("queue is empty");
            return -1;
        }

        int top=-1;

       if(firstQueueIsEmpty()){
          
            while(!q2.isEmpty() && q2.size()!=1){
                q1.add( q2.remove());
            }

            top = q2.remove();
       }
       else{
           
           while(!q1.isEmpty() && q1.size()!=1){
               q2.add( q1.remove());
           }

           top = q1.remove();
       }

       return top;
    }

     //peek
     public static int peek(){

        //check if both queue are empty
        if( firstQueueIsEmpty() && secondQueueIsEmpty()){
            System.out.println("queue is empty");
            return -1;
        }

        int top=-1;

       if(firstQueueIsEmpty()){
          
            while(!q2.isEmpty() && q2.size()!=1){
                q1.add( q2.remove());
            }

            top = q2.peek();
            q1.add(q2.remove());
       }
       else{
           
           while(!q1.isEmpty() && q1.size()!=1){
               q2.add( q1.remove());
           }

           top = q1.peek();
           q2.add(q1.remove());
       }

       return top;
    }

  }

  public static void main(String[] args) {
       Stack stk = new Stack();
       stk.push(1);
       stk.push(2);
       stk.push(3);
       stk.push(4);

   
       while(!stk.isEmpty()){
            System.out.println(stk.peek());
            stk.pop();
       }
  }
}

*/

/*(3). First non-repeating Letter in a stream of characters( all letters are small)*/

/*streams of character ka matlab zaadatar queue sa hi solve hota hai*/

/*
public class QueueA{
    public static void main(String[] args) {

        String str = new String("aabcxb");
         
        Queue<Integer> que = new LinkedList<>();
        int arr[] = new int[26];

        //add all char in array and count each of char
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //count arr
            arr[ch-'a']++;                             //this technique set each char in sequence based on index

            //add in queue
            que.add(ch-'a');

        }

       
            while (!que.isEmpty() && arr[que.peek()]!=1) {
                que.remove();
            }

        //check for letter in queue
        if(que.isEmpty()){
            System.out.println("string contain only repeating characters ");
        }
        else{
            System.out.println("the first non-repeating character is "+ (char)(que.peek()+'a'));
        }

        
    }
}

*/

/*(4). Interleave 2 Halves of a Queue (even length) */

/*
public class QueueA {
    public static void main(String[] args) {
        Queue<Integer> originalQueue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();

        //initialize for case
        originalQueue.add(1); originalQueue.add(2); originalQueue.add(3); originalQueue.add(4); originalQueue.add(5); originalQueue.add(6); originalQueue.add(7); originalQueue.add(8); originalQueue.add(9); originalQueue.add(10); 

        //start approach
        int halfSize = originalQueue.size()/2;

        for(int i=1; i<=halfSize; i++){
            tempQueue.add(originalQueue.remove());
        }

        for(int i=1; i<=halfSize; i++){
            originalQueue.add(tempQueue.remove());
            originalQueue.add(originalQueue.remove());
        }






        //check output or answer or test case
        while(!originalQueue.isEmpty()){
            System.out.println(originalQueue.remove());
        }


    }
}

*/

/*(5). Queue Reversal */

/* 
public class QueueA {
    public static void main(String[] args) {

        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();

        //initialize for case
        que.add(1); que.add(2); que.add(3); que.add(4); que.add(5); 


        while(!que.isEmpty()){
            stk.push( que.remove());
        }

        while(!stk.isEmpty()){
            que.add(stk.pop());
        }


        //check output or answer or test case
        while(!que.isEmpty()){
            System.out.println(que.remove());
        }


    }
}
*/

/*(6). Deque ( double ended queue):-    methods:- addFirst(), addLast(), removeFirst(), removeLast(), getFirst(), getLast() */

/* 
public class QueueA{
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        System.out.println(dq);
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq);
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());

    }
}

*/

/*(7). Stack and Queue using Deque */

/*

public class QueueA{
    //stack class with deque 
    public static class StackDQ{
        static Deque<Integer> dq = new LinkedList<>();
    
        //is empty
        public static boolean isEmpty() {
            return dq.isEmpty();
        }
        //push
        public static void push(int data){
            dq.addLast(data);
        }
        //pop
        public static int pop(){
            if(dq.isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            return dq.removeLast();

        }
    }
    //queue class with deque 
    public static class QueueDQ{
        static Deque<Integer> dq = new LinkedList<>();
    
        //is empty
        public static boolean isEmpty() {
            return dq.isEmpty();
        }
        //add
        public static void add(int data){
            dq.addLast(data);
        }
        //remove
        public static int remove(){
            if(dq.isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            return dq.removeFirst();

        }
    }
    public static void main(String[] args) {
        StackDQ sdq = new StackDQ();
        QueueDQ qdq = new QueueDQ();

        sdq.push(1);
        sdq.push(2);
        sdq.push(3);
        sdq.push(4);

        qdq.add(1);
        qdq.add(2);
        qdq.add(3);
        qdq.add(4);
        
        while(!sdq.isEmpty()){
            System.out.println(sdq.pop());
        }

        System.out.println("---------");

        while(!qdq.isEmpty()){
            System.out.println(qdq.remove());
        }

    }
}
*/

/*(8). Generate Binary Numbers from 1 to n*/

/*
public class QueueA{
    public static void main(String[] args) {
       
        int n=5;
        String result[] = new String[n];
        Queue<String> que = new LinkedList<>();  
        String n1 = new String("");
        String n2 = new String("");

        //at start should have 1 in queue
        que.add("1");

        for(int i=0; i<n; i++){
            result[i] = que.remove();
            que.add( result[i] + "0");
            que.add( result[i] + "1");
        }

        System.out.println(result);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }


    }
}

*/

/*(9). Reverse the first K elements of Queue */

/* 
public class QueueA{
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(1); que.add(2); que.add(3); que.add(4); que.add(5); que.add(6); que.add(7); que.add(8); que.add(9); que.add(10); que.add(11);

        Stack<Integer> stk = new Stack<>();
        int n=6; //input

        for(int i=1; i<=n; i++){
            stk.push(que.remove());
        }

        while(!stk.empty()){
            que.add(stk.pop());
        }

        for(int i=1; i<=que.size()-n; i++){
            que.add(que.remove());
        }

        System.out.println(que);
    }
}

*/

/*(10). Maximum of all subarrays of size K( Sliding Window) */

/*
public class QueueA{
    public static void main(String[] args) {
        
    //(i). first approach using array

        
        // int arr[] = { 1,3,-1,-3,5,3,6,7};
        // // int arr[] = { 1,2,3,1,4,5,2,3,6};
        // int k=3;

        // int result[] = new int[arr.length-(k-1)];

        // for(int i=0; i<arr.length-(k-1); i++){
        //     int max=-1;
        //     for(int j=i; j<i+k; j++){
        //         max = Math.max(max, arr[j]);
        //     }
        //     result[i] = max;
        // }

        // for(int i=0; i<result.length; i++){
            
        //     System.out.print(result[i]+" ");
        // }

    

    //(ii). second approach using deque
        
        // int k=3; //window
        // int arr[] = { 1,3,-1,-3,5,3,6,7};
        // Deque<Integer> dq = new LinkedList<>();
        // int result[] = new int[ arr.length - (k-1)];
        // int res=0;
        

        // for(int i=0; i<arr.length; i++){

        //     if(!dq.isEmpty() && dq.peek()==i-k){
        //         dq.removeFirst();
        //     }

        //     while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
        //         dq.removeLast();
        //     }

        //     dq.addLast(i);

        //     if(i>=k-1){
        //         result[res++] = arr[dq.peekFirst()];
        //     }

        // }

        // for(int i=0; i<result.length; i++){
            
        //     System.out.print(result[i]+" ");
        // }

        
      
    }
}

*/


/*(11). the Celebrity Problem :- everyone know him , he dont know anyone*/

/*
public class QueueA{
    public static void main(String[] args) {
        
        //(i). first approach using array-------------------------------------------------

        
        // int arr[][] = { { 0, 1, 1, 0}, { 0, 0, 0, 0}, { 0, 1, 0, 0}, { 1, 1, 0, 0}};
        // int knowMe[] = new int[arr.length];
        // int iKnowThem[] = new int[arr.length];

        // for(int i=0; i<arr.length; i++){
        //     for(int j=0; j<arr.length; j++){

        //         if(arr[i][j]==1){
        //             iKnowThem[i]++;
        //             knowMe[j]++;
        //         }
        //     }
        // }

        // for(int i=0; i<arr.length; i++){
        //     System.out.println(knowMe[i] +"  "+iKnowThem[i]);
        //     if(knowMe[i]==arr.length-1 && iKnowThem[i]==0){
        //         System.out.println(i);
        //     }
        // }


        //(ii). second approach using array but 2 pointers approach---------------------------

        //  int arr[][] = { { 0, 1, 1, 0}, { 0, 0, 0, 0}, { 0, 1, 0, 0}, { 1, 1, 0, 0}};
        //  int top=0, bottom=arr.length-1;

        //  while(top<bottom){
            
        //     if(arr[top][bottom]==1){
        //         top=top+1;
        //     }
        //     else if(arr[bottom][top]==1){
        //         bottom = bottom-1;
        //     }
        //     else{
        //         top++;
        //         bottom--;
        //     }
        //  }


        // // their is no point 
        // if(top>bottom){
        //     return;  
        // }


        // //check answer
        // for(int i=0; i<arr.length; i++){
            
        //     //if not (1,1)
        //     if(i!=top){

        //         //check that all row is zero( which means that he not know anyone) and everyone know him 
        //                 if( arr[top][i]==1 || arr[i][top]==0 ){
        //                     return;
        //                 }
        //     }
           
        // }

        // System.out.println("the celebrity is "+top);


        //(iii). second approach using stack approach(same but just take stack)---------------------------

         int arr[][] = { { 0, 1, 1, 0}, { 0, 0, 0, 0}, { 0, 1, 0, 0}, { 1, 1, 0, 0}};
         
         Stack<Integer> stk = new Stack<>();
         for(int i=0; i<arr.length; i++){
            stk.push(i);
         }

         while( !(stk.size()==1)){
            int i = stk.pop();
            int j = stk.pop();

            if(arr[i][j]==1){
                stk.push(j);
            }
            else{
                stk.push(i);
            }
         }

         //check answer
         for(int i=0; i<arr.length; i++){
            if(i!=stk.peek()){
                if(arr[stk.peek()][i]==1 || arr[i][stk.peek()]==0){
                    return ;//false
                }
            }
         }

         //if not return then true
         System.out.print(stk.peek());



      
      
    }
}
*/


/*(12). Astroids Collision */

/*
public class QueueA{
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        // int asteroids[] = { 4, 7, 1, 1, 2, -3, -7, 17, 15, -16};
        // int asteroids[] = { 4, 7, 1, 13, 2, -3, -7, 17, 15, 108, -19, -56};
        // int asteroids[] = { 10, 2, -5, 4, -10, 20, 30, -40, 40};
        // int asteroids[] = { 8, -8};
        int asteroids[] = {-2,-2,1,-2};
        // int asteroids[] = {-2,2,1,-2};


        for(int i=0; i<asteroids.length; i++){

            //astroid go in right direction
            if(asteroids[i]>=0){
                stk.push(asteroids[i]);
            }
            else{
            
                
                //case:1:- //when stack is not empty    or    when same type of asteroids collide    or    smaller positive elements

                int top=0;
                 
                while(!stk.empty() && stk.peek()>0 && stk.peek()<=Math.abs(asteroids[i])){   
                    
                    //when same type of asteroids collide
                    if(stk.peek()==Math.abs(asteroids[i])){
                        top=stk.pop();
                        break;
                    }   

                    stk.pop();
                   
                }
                
                //[-2,2,1,-2]
                    if(top==Math.abs(asteroids[i])){

                    }
                
                    //case:2:- when all positive asteroids are destroyed by negative asteroids or their is no positive asteroids in starting
                    else if(stk.empty()){
                        stk.push(asteroids[i]);
                    }

                    //case:3:- when stack is not empty and negative astroid is smaller then positive asteroid 
                    else if(!stk.empty() && stk.peek()>0 && stk.peek()>Math.abs(asteroids[i])){

                    }

                    //case:4:- when stack is not empty and stk have negative asteroid then
                    else if(!stk.empty() && stk.peek()<0){
                        stk.push(asteroids[i]);
                    }
                    else{

                    }
                
            }

 
        }

        while(!stk.empty()){
            System.out.println(stk.pop());
        }
    }
}
*/


/*(13). LRU Cache ( least recently used cache with doubly linked list and hasMaps) */

/* 
public class QueueA{
    public static class Node{
        int data;
        Node next;
        Node prev;


        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    public static Node head;
    public static Node tail;
    public static int size;

    static class LRU_Cache{
        public static HashMap<Integer,Integer> hash  = new HashMap<>();
        public static int capacity;

        LRU_Cache(int capacity){
            this.capacity = capacity;

            //dummy tail
            Node newNode2 = new Node(-1);
            head = tail = newNode2;

            //dummy head
            Node newNode1 = new Node(-1);
            head.prev = newNode1;
            newNode1.next = head;
            head  = newNode1;

        }

        //(1). put function for LRU cache
        public static void put(int key, int value){
        if(hash.size()==capacity){
            
            //remove node at end
            tail.prev.prev.next =  tail;
            tail.prev = tail.prev.prev; 

            //add Node at start
            Node newNode = new Node(key);
            head.next.prev = newNode;
            newNode.next = head.next;
            newNode.prev = head;
            head.next = newNode;

            hash.put(key, value);
            return ;
        }

        if(hash.size()==0){
            //new node
            Node newNode = new Node(key);
            head.next.prev = newNode;
            newNode.next = head.next;
            head.next = newNode;
            newNode.prev = head;
        }

        //least recently used
        else{
            
            if(hash.containsKey(key)){
               //search node
               Node temp = head;

                while(temp.data!=key){
                    temp = temp.next;
                } 

                //remove node
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            

            //add node at first
            Node newNode = new Node(key);
            head.next.prev = newNode;
            newNode.next = head.next;
            newNode.prev = head;
            head.next = newNode;
        }


        //put hash value :- (if key present then update otherwise add)
        hash.put(key,value);
       
    
    }  
    
        //(2). get function for LRU cache
        public static int get(int key){
            if(!hash.containsKey(key)){
                return -1;
            }

                Node temp = head;
                while(temp.data!=key){
                    temp = temp.next;
                }

                //remove node
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

                //add node at start
                Node newNode = new Node(key);
                head.next.prev = newNode;
                newNode.next = head.next;
                newNode.prev = head.next;
                head.next = newNode; 

              
                return hash.get( head.next.data);
        }
        //(3). print function for dll
        public static void print( ){

        Node temp = head;
        while(temp!=null){
         
            System.out.print(temp.data+" ( "+hash.get(temp.data)+" ) "+" -> ");   
            temp = temp.next;
        }
        System.out.println("null ");
    }
    }

    

    public static void main(String[] args){
        LRU_Cache lruCache = new LRU_Cache(4);
    

        //first text case
        // lruCache.put(1, 1);                        lruCache.print(); 
        // lruCache.put(2, 2);                        lruCache.print();
        // System.out.println(lruCache.get(1));       lruCache.print(); System.out.println("--");
        // lruCache.put(3, 3);                        lruCache.print();
        // System.out.println(lruCache.get(2));       lruCache.print();
        // lruCache.put(4, 4);                        lruCache.print();
        // System.out.println(lruCache.get(1));       lruCache.print();
        // System.out.println(lruCache.get(3));       lruCache.print();
        // System.out.println(lruCache.get(4));       lruCache.print();

        //second case
        lruCache.put(2, 6);     lruCache.print();
        lruCache.put(4, 7);     lruCache.print();
        lruCache.put(8, 11);     lruCache.print();
        lruCache.put(7, 10);  lruCache.print();
        lruCache.get(2);lruCache.print();
        lruCache.get(8);lruCache.print();
        lruCache.put(5, 6);  lruCache.print();
        lruCache.get(7);lruCache.print();
        lruCache.put(5, 7);  lruCache.print();
        // lruCache.print();


        
        
    }
}


*/

/*(14).  */








