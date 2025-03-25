package java_DataStructure.Queue;

/*(1).queue implementation with simple array (for add:- O(1) , for remove:- O(n) )*/
/* 
public class QueueImplementation{
    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        //is empty
        public static boolean isEmpty(){
            return rear==-1;
        }

        //add
        public static void add(int data){
            if(rear==size-1){
                System.out.println("queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        //remove
        public static int remove(){
            if(rear==-1){
                System.out.println("queue is empty");
                return -1;
            }

            int front = arr[0];

            for(int i=0;i<size-1;i++){
                arr[i] = arr[i+1];
            }

            rear = rear-1;
            return front;

        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            return arr[0];

        }


    }
        public static void main(String args[]){
            Queue q = new Queue(10);
            q.add(20);
            q.add(30);
            q.add(40);

            while(!q.isEmpty()){
                System.out.println(q.peek());  
                q.remove();
            }
            
        }
}

*/

/*(2). circular queue implementation with simple array (for add:- O(1) , for remove:- O(1) )*/
/*
public class QueueImplementation{
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        //is empty
        public static boolean isEmpty(){
            return rear==-1 && front==-1;
        }

        //isFull
        public static boolean isFull() {
            return front==(rear+1)%size;
        }

        //add
        public static void add(int data){
            if(front== (rear+1)%size){
                System.out.println("queue is full"+"front: "+front+"rear: "+rear);
                return;
            }

            //add first element
            if(front==-1){
                front=0;
            }

            rear = ( rear + 1)%size;
            arr[rear] = data;
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty"+"front: "+front+"rear: "+rear);
                return -1;
            }


            int result = arr[front];

            //last element delete
            if(rear==front){
                rear = front = -1;
            }
            else{
                front = ( front+1)%size;
            }

            return result;

        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty"+"front: "+front+"rear: "+rear);
                return -1;
            }

            return arr[front];

        }


    }
        public static void main(String args[]){
            Queue q = new Queue(5);

            q.add(10);
            System.out.println(q.remove());
            System.out.println("====44=========="+"front: "+q.front+"rear: "+q.rear);

            q.add(20);
            System.out.println(q.remove());
            System.out.println("=====44========="+"front: "+q.front+"rear: "+q.rear);

            q.add(100);
            System.out.println("====41=========="+"front: "+q.front+"rear: "+q.rear);
            q.add(200);
            System.out.println("====41=========="+"front: "+q.front+"rear: "+q.rear);
            q.add(300);
            System.out.println("====41=========="+"front: "+q.front+"rear: "+q.rear);
            q.add(400);
            System.out.println("====41=========="+"front: "+q.front+"rear: "+q.rear);
            q.add(500);
            System.out.println("====41=========="+"front: "+q.front+"rear: "+q.rear);
            q.add(600);
            System.out.println("====41=========="+"front: "+q.front+"rear: "+q.rear);

            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
                System.out.println("=============="+"front: "+q.front+"rear: "+q.rear);

            }
        
            
            
    }
}
    
*/

/*(3). queue implementation with linklist (for add:- O(1) , for remove:- O(1) )*/
/*
public class QueueImplementation{

    static class Node{
        int data;
        Node next;
    
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
        static Node head = null;
        static Node tail = null;


        //is empty
        public static boolean isEmpty(){
           return head==null && tail==null;
        }


        //add
        public static void add(int data){
            Node newNode = new Node(data);
            
            //first element
            if(head==null){
                head=tail=newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        //remove
        public static int remove(){
            
            if(head==null){
                System.out.println("queue is empty");
                return -1;
            }

            int front = head.data;

            //single element
            if(head==tail){
                head = tail = null;
            }
            else{
                head = head.next;
            }
           
            return front;
        }

        //peek
        public static int peek(){
            if( isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            return head.data;
        }

    }
        public static void main(String args[]){
            Queue q = new Queue();

            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);

            while(!q.isEmpty()){
                System.out.println(q.remove());
            }
        
            
            
    }
}
    
*/

/*(4). queue implementation with java collection framework (for add:- O(1) , for remove:- O(1) )*/

             /* -- In Java, the Queue interface is part of the Java Collections Framework and provides a way to handle a collection of elements in a first-in-first-out (FIFO) manner. However,
                   the Queue itself is an interface, meaning you cannot instantiate it directly. Instead, you can implement a queue using classes that implement the Queue interface, such as LinkedList or ArrayDeque.
                
                -- ArrayDeque generally offers better performance than LinkedList for queue operations because it does not have the overhead of node allocation and deallocation. 
                
                -- interface:- an interface is a reference type that defines a contract for classes that implement it. An interface specifies a set of abstract methods (methods without a body) that the implementing class must provide concrete implementations for. Interfaces can also contain constants, default methods, static methods, and nested types
            
                -- difference between arraydeque and linkedlist:- 
                    
                    -arraydeque:- 
                        uses resizable data structure.
                        when the array is full, it creates a new large array and copies the elements, which can be costly in terms of performance.
                        it is fast in operations, but can be O(n) when resizing.
                        memory efficient for small and moderarte sizes since it uses a [single contiguous block of memory]
                        it is cache-friendly because when one element is accessed, nearby elements are likely loaded into the cache as well, leading to fewer cache misses.
                        spatial locality:- Due to the contiguous nature of the underlying array, ArrayDeque benefits from spatial locality. When you iterate through the elements or access them sequentially, the likelihood of cache hits increases, making operations faster.
                    
                    -linkedlist:-
                        Uses a doubly linked list as its underlying data structure.
                        Each element (node) contains a reference to the next and previous node.
                        Each element (node) has additional memory overhead due to storing references to the next and previous nodes, which can add up for large lists.
                        Since it uses linked nodes, there’s no need for resizing, making it more predictable in terms of memory allocation.
                        Can be beneficial when the queue size is highly dynamic and unpredictable.
                        [ non-Contiguous Memory Allocation] each node contains the next and previous nodes,  which means that accessing elements may require jumping to different memory locations. This can lead to more cache misses because accessing one node does not guarantee that the next node is in the cache.
                        poor spatial locality:-The non-contiguous nature of the linked list results in poor spatial locality. When iterating through the list, each access may require fetching data from different memory locations, which can slow down performance due to increased cache misses.
                */
/* 
import java.util.*;

public class QueueImplementation{
        public static void main(String args[]){
            // Queue<Integer> q = new LinkedList<>();  
            Queue<Integer> q = new ArrayDeque<>(); 

            q.add(1);
            q.add(2);
            q.add(3);

            while(!q.isEmpty()){
                System.out.println(q.remove());
            }

           
            
            
    }
}
    
*/



