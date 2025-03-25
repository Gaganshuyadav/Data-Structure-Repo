package Heaps;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heaps1 {
      
    static class Student implements Comparable<Student>{ //overriding
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo( Student s2){
            return this.rank - s2.rank;    //increasing Order
            // return s2.rank - this.rank;    //decreasing Order
        }
    }

    static class MinHeap{
        
        ArrayList<Integer> arr = new ArrayList<>();

        //add in heap--------------------------------------------------------------------------------

        public void add(int data){
            //add at last idx
            arr.add(data);

            int x = arr.size()-1;  //x is child index
            int parentIdx = (x-1)/2;

            while( arr.get( parentIdx) > arr.get(x)  ){
                // Collections.swap(arr, arr.get(parentIdx), arr.get(data));
                int temp = arr.get( parentIdx);
                arr.set( parentIdx, arr.get(x));
                arr.set( x, temp);

                x = parentIdx;
                parentIdx = (x-1)/2;
            }

        }

        //peek in heap--------------------------------------------------------------------------------
        public int peek(){
            if(arr.isEmpty()){
                System.out.println("Heap is Empty");
                return -1;
            }

            return arr.get(0);
        }
    
        // in isEmpty heap--------------------------------------------------------------------------------
        public boolean isEmpty(){
            if(arr.isEmpty()){
                return true;
            }

            return false;
        }
    

        //deletion in heap--------------------------------------------------------------------------------
        public void heapify(int i){

            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if( arr.size() > left && arr.get(left) < arr.get( minIdx)){
                minIdx = left;
            }

            if(arr.size() > right && arr.get(right) < arr.get( minIdx)){
                minIdx = right;
            }

            //safe condition for index 0 ( cause last element is gone and arraylist is empty now) and also for balance heap( minIdx!=i)
            
            if(minIdx!=i){
                //swap minIdx and top size
                int temp = arr.get( i);
                arr.set( i, arr.get( minIdx));
                arr.set( minIdx, temp);
                
                heapify(minIdx);
            }


        }

        public int remove(){

            int data = arr.get(0);

            //step1:- Swap first and last 
            int temp = arr.get( 0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set( arr.size()-1, temp);

            //step2:- delete last 
            arr.remove(arr.size()-1);

            //step3:- heapify ( this funtion fix the heap)
            heapify(0);

            return data;

        }

        
    }

    
    static class MaxHeap{
        
        ArrayList<Integer> arr = new ArrayList<>();

        //add in heap--------------------------------------------------------------------------------

        public void add(int data){
            
            //add at last idx
            arr.add(data);

            int x = arr.size()-1;  //x is child index
            int parentIdx = (x-1)/2;

            while( arr.get( parentIdx) < arr.get(x)  ){
                // Collections.swap(arr, arr.get(parentIdx), arr.get(data));
                int temp = arr.get( parentIdx);
                arr.set( parentIdx, arr.get(x));
                arr.set( x, temp);

                x = parentIdx;
                parentIdx = (x-1)/2;
            }

        }

        //peek in heap--------------------------------------------------------------------------------
        public int peek(){
            if(arr.isEmpty()){
                System.out.println("Heap is Empty");
                return -1;
            }

            return arr.get(0);
        }
    
        // in isEmpty heap--------------------------------------------------------------------------------
        public boolean isEmpty(){
            if(arr.isEmpty()){
                return true;
            }

            return false;
        }
    

        //deletion in heap--------------------------------------------------------------------------------
        public void heapify(int i){

            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if( arr.size() > left && arr.get(left) > arr.get( minIdx)){
                minIdx = left;
            }

            if(arr.size() > right && arr.get(right) > arr.get( minIdx)){
                minIdx = right;
            }

            //safe condition for index 0 ( cause last element is gone and arraylist is empty now) and also for balance heap( minIdx!=i)
            
            if(minIdx!=i){
                //swap minIdx and top size
                int temp = arr.get( i);
                arr.set( i, arr.get( minIdx));
                arr.set( minIdx, temp);
                
                heapify(minIdx);
            }


        }

        public int remove(){

            int data = arr.get(0);

            //step1:- Swap first and last 
            int temp = arr.get( 0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set( arr.size()-1, temp);

            //step2:- delete last 
            arr.remove(arr.size()-1);

            //step3:- heapify ( this funtion fix the heap)
            heapify(0);

            return data;

        }

        
    }

    static class HeapSortClass{

        public static void heapify( int[] arr, int i, int size){

            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if( left < size && arr[minIdx] < arr[left] ){
                minIdx = left;
            }

            if( right < size && arr[minIdx] < arr[right]){
                minIdx = right;
            }

            if(minIdx!=i){
                //swap
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;

                heapify(arr, minIdx, size);
            }
        }

        public static void heapsort( int[] arr){
            
            int n = arr.length;

            //step:-1 build max heap ( O(n*logn))
            for(int i=n/2; i>=0; i--){
                
                heapify( arr, i, n);
            }


            //step:-2 push largest at end ( O(n*logn))
            for(int i=n-1; i>=0; i--){

                //swap first with last
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;

                //heapify
                heapify(arr, 0, i);
            }
        }
    }
    
    /*Questions on heaps -------------------------------------*/
    
    /*(1). Nearly Cars */

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSqr;
        int idx;

        public Point(int x, int y, int distSqr, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.distSqr = distSqr;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSqr - p2.distSqr;
        }   
    }
    
    /*(3). K Weakest Soldier */
    static class ArmyRow implements Comparable<ArmyRow>{
        int soldiers;
        int idx;

        public ArmyRow(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(ArmyRow a2){
            if( this.soldiers==a2.soldiers){
                return this.idx - a2.idx;
            }
            return this.soldiers - a2.soldiers;
        }
    }

    /*(4). Sliding Window Maximum */
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.val - this.val;
        }
    }


    public static void main(String[] args) {

        /* Increasing Ordered */
        /* 
        PriorityQueue<Integer> pq  = new PriorityQueue<>();

        pq.add(5);  //O(logn)
        pq.add(2); pq.add(8);pq.add(1); pq.add(10);

        while(!pq.isEmpty()){
            // System.out.println(pq.peek());  //O(1)
            pq.remove();  //O(logn)
        }
        
        */


        /* Decreasing Order */
        /* 
        PriorityQueue<Integer> pq2  = new PriorityQueue<>(Comparator.reverseOrder());

        pq2.add(5);  //O(logn)
        pq2.add(2); pq2.add(8); pq2.add(1); pq2.add(10);

        while(!pq2.isEmpty()){
            // System.out.println(pq2.peek());  //O(1)
            pq2.remove();  //O(logn)
        }
        */

        /* Object Increasing Order */
        /* 
        PriorityQueue<Student> li = new PriorityQueue<>();

        li.add( new Student("A", 4));
        li.add( new Student("B", 10));
        li.add( new Student("C", 14));
        li.add( new Student("D", 1));
        li.add( new Student("D", 30));

        while(!li.isEmpty()){
            System.out.println(" name: "+li.peek().name+" rank: "+li.peek().rank);
            li.remove();
        }
        
        */

        /* Min Heap */
        
        /* 
            MinHeap minhp = new MinHeap();
            minhp.add(34);
            minhp.add(14);
            minhp.add(76);
            minhp.add(45);
            minhp.add(364);
            minhp.add(3);
            minhp.add(1);
    
            System.out.println(minhp.arr);
    
            // Deletion in Heap 
            System.out.println(minhp.peek());
    
            while(!minhp.isEmpty()){
                System.out.println(minhp.remove());
            }
        */

        /* Max Heap */
        
        /* 
            MaxHeap maxhp = new MaxHeap();
            maxhp.add(34);
            maxhp.add(14);
            maxhp.add(76);
            maxhp.add(45);
            maxhp.add(364);
            maxhp.add(3);
            maxhp.add(1);
    
            System.out.println(maxhp.arr);
    
            // Deletion in Heap 
            System.out.println(maxhp.peek());
    
            while(!maxhp.isEmpty()){
                System.out.println(maxhp.remove());
            }

        */

    
        /* Heap Sort ( O(n*logn) )*/
        /* 
        HeapSortClass hs = new HeapSortClass();

        int arr[] = { 1, 20, 3, 5, 2};
        hs.heapsort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        
        */
        
        /*Questions on heaps */
        /*(1). Nearly Cars ( d^2 = x^2 + y^2)*/

        /* 
        int points[][] = { {3, 3}, { 5, -1}, { -2, 4}};
        int k=2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<points.length; i++){
            int distSqr = points[i][0]*points[i][0] + points[i][1]*points[i][1] ;

            pq.add( new Point( points[i][0], points[i][1], distSqr, i));
        }

        // nearest k cars
        for(int i=0; i<k; i++){
            System.out.println("C"+pq.remove().idx);
        }

        */

        /*(2). Connect N Ropes */

        /* 
        // int ropes[] = { 2, 3, 3, 4, 6};
        int ropes[] = { 4, 3, 2, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<ropes.length; i++){
            pq.add( ropes[i]);
        }

        int minCost = 0;
        int twoRopesCost = 0;

        System.out.println(pq);

        while(pq.size()>1){

            twoRopesCost = pq.remove() + pq.remove();
            System.out.println(twoRopesCost);
            pq.add( twoRopesCost);
            minCost += twoRopesCost;
        }

        System.out.println(minCost);

        */

        /*(3). K Weakest Soldier */

        /* 
        int k=2;
        int army[][] = {{ 1, 0, 0, 0},
                        { 1, 1, 1, 1},
                        { 1, 0, 0, 0},
                        { 1, 0, 0, 0}
                    };

        PriorityQueue<ArmyRow> pq = new PriorityQueue<>();

        for(int i=0; i<army.length; i++){

            int rowSoldiersSum = 0;
            for(int j=0; j<army.length; j++){
                rowSoldiersSum += army[i][j];
            }
            
            pq.add( new ArmyRow( rowSoldiersSum, i));
        }

        for(int i=0; i<k; i++){
            System.out.println(pq.remove().idx);
        }
        */


        /*(4). Sliding Window Maximum */
/* 

        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;

        int ans[] = new int[arr.length-k+1];


        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++){
            pq.add( new Pair( arr[i], i));
        }

        int x=0;
        //first answer
        ans[0] = pq.peek().val;
        x++;



        for(int i=k; i<arr.length; i++){

            while( pq.size() > 0 && (pq.peek().idx <= ( i-k)) ){

                pq.remove();
            
            }

            pq.add( new Pair( arr[i], i));

            ans[x] = pq.peek().val;
            x++;
            
        
        }
        */











   }

}
