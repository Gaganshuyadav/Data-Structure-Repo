package java_DataStructure.GreedyAlgorithm;

import java.util.*;

public class GreedyAlgorithmFirst {
    //(6). Job Sequencing  Problem
    static class Job{
        int deadline;
        int profit;
        int id;

        Job(int deadline, int profit, int id){
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }
    }

    //(11). split array largest sum
    public static int no_of_subarrays_with_min_as_mid(int arr[], int mid){
        int count=1;
        int sum=0;

        for(int i=0; i<arr.length; i++){
            if((sum+arr[i])>mid){
                sum=arr[i];
                count++;
            }
            else{
                sum = sum + arr[i];
            }
        }
        
        return count;
    }

    public static void main(String[] args){

        //(1). Activity Selection Problem
        /* 
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };    //it is end time basis sorted

        //sorting-----------------------
            //first sort question on basis of endtime( this question end[] is sorted, but most of the we have to sort it by ourselves)
            int activities[][] = new int[start.length][3];
        
             for(int i=0; i<start.length; i++){
                 activities[i][0] = i;
                 activities[i][1] = start[i];           

                 activities[i][2] = end[i];
             }

             //lambda function -> shortform
             Arrays.sort( activities, Comparator.comparingDouble(o -> o[2]));   //sort on basis of endtime

             //-----------------------------------


    
        int maxAct = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        //first activity
        maxAct = 1;
        arr.add(0);
        int endTime = activities[0][2];

        for(int i=1; i<end.length; i++){
            if(endTime<=activities[i][1]){
                //activity select
                endTime = activities[i][2];
                maxAct++;
                arr.add( activities[i][0]);
            }
        }

        System.out.println("the activities are "+arr);
        System.out.println("the maximum activities are "+maxAct);

        */
    
    
        //(2). Fractional Knapsack
           
        /*
           int capacity=50;
           int val[] = { 60, 100, 120 };
           int weight[] = { 10, 20, 30 };
           double ratio[] = new double[val.length];
           int maxProfit=0;
           int currentWeight = 0;
           
           for(int i=0; i< val.length; i++){
              ratio[i] = (val[i]/(double)weight[i]);
           }

           //sorting
           double fk[][] = new double[val.length][4];

           for(int i=0; i<val.length; i++){
              fk[i][0] = i; 
              fk[i][1] = val[i]; 
              fk[i][2] = weight[i]; 
              fk[i][3] = ratio[i]; 
           }
            
           //sort on basis of ratio[4,5,6]
           Arrays.sort( fk, Comparator.comparingDouble(o -> o[3]));    

           //reverse use cause (more ratio more profit) and we have to start from descending order
           //[6,5,4]

           for(int i=val.length-1; i>=0; i--){

              currentWeight += fk[i][2];                //weight

              if( capacity >= currentWeight ){
                  maxProfit += fk[i][1];                //value 
                  
              }
              else{
                maxProfit += (( fk[i][1]*( capacity-(currentWeight-fk[i][2])))/fk[i][2]);
                break;
              }
           }

           System.out.println("the max profit is "+maxProfit);

           */
        
        //(3). Min Absolute Difference Pairs

        /* 
        // int A[] = {1,2,3};
        // int B[] = {2,1,3};

        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};

        int minAbsDiff = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++){
            minAbsDiff += Math.abs(A[i]-B[i]);
        }

        System.out.println("the minimum absolute difference is "+minAbsDiff);

        */

        //(4). Max Length Chain of Pairs

        
        /* 
        int pairs[][] = { { 5, 24}, { 39, 60}, { 5, 28}, { 27, 40}, { 50, 90}};
        

        //sort on basis of second number
        Arrays.sort( pairs, Comparator.comparingDouble(o->o[1]));
        int chainCount=0;
        int currSecondNumber = pairs[0][1];
        
        for(int i=1;i<pairs.length; i++){
            if(currSecondNumber <= pairs[i][0]){
                chainCount++;
                currSecondNumber = pairs[i][0];

            }
        }

        System.out.println(chainCount);
        */

        //(5). Indian Coins (find min no. of coins/notes)

        /*
        Integer currency[] = { 2 , 10, 5, 20, 500, 50, 2000, 1, 100};
        ArrayList<Integer> arr = new ArrayList<>();

        int value = 1059;
        int minNumberOfCurrency = 0;

        //sort all currencies in descending order
        Arrays.sort(currency, Comparator.reverseOrder());

        for(int i=0; i<currency.length; i++){

            while(value>=currency[i]){

                arr.add(currency[i]);
                minNumberOfCurrency++;
                value = value - currency[i];
            }
        }

        System.out.println(arr);
        System.out.println("the minimum of notes/coins needed is "+minNumberOfCurrency);

        */

        //(6). Job Sequencing Problem
        /* 
        int jobsInfo[][] = { { 4, 20}, { 1, 10}, { 1, 40}, { 1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<jobsInfo.length; i++){
            jobs.add(new Job(jobsInfo[i][0], jobsInfo[i][1], i));
        }

        //sort object on basis of lambda function condition, sort on descending order of profit
        Collections.sort( jobs, (a,b)-> b.profit - a.profit);

        int time=0;
        int profit=0;
        for(int i=0; i< jobsInfo.length; i++){
            if( jobs.get(i).deadline > time){
                time++;
                profit += jobs.get(i).profit;
            }
        }

        System.out.println(" profit: "+profit);

        */

        //(7). Chocola Problem

        /* 

        int n=4, m=6; 
        
        Integer costHor[] = { 4, 1, 2}; 
        Integer costVer[] = { 2, 1, 3, 1, 4};
       
        //sort horizontal cost
        Arrays.sort(costHor, Comparator.reverseOrder());
        //sort vertical cost
        Arrays.sort(costVer, Comparator.reverseOrder());

        int hp=1, vp=1;
        int h=0, v=0;
        int minCost = 0;

        while( h < costHor.length && v < costVer.length){
            if(costHor[h] <= costVer[v]){
                minCost += (costVer[v]*hp);
                v++;
                vp++;
            }
            else{
                minCost += (costHor[h]*vp);
                h++;
                hp++;
            }
        }

        while(h < costHor.length){
            minCost += ( costHor[h]*vp);
            h++;
            hp++;
        }

        while(v < costVer.length){
            minCost += ( costVer[v]*hp);
            v++;
            vp++;
        }

        System.out.println("the minimum cost is "+minCost);

        */

        //(8). Maximum Balance String Partitions ( Split a String in Balance Strings)

        /* 
        // String str = new String("RLRRLLRLRL");
        // String str = new String("RLLLLRRRLR");
        // String str = new String("LLLLRRRR");
        String str = new String("RLRRRLLRLL");

        int r=0, l=0;
        int maxBalanceSubString=0;
        for(int i=0; i<str.length(); i++){

            if(str.charAt(i)=='R'){
                r++;
            }
            if(str.charAt(i)=='L'){
                l++;
            }

            if(l==r){
                maxBalanceSubString++;
                r=0;
                l=0;
            }
        }

        System.out.println("the max balance sub string is "+maxBalanceSubString);

        */
    
        //(9). Lexicographically smallest string of length N and sum K 

            // (i). first approach with an O(n2)
        /*
        Character arr[] = { 'a' ,'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        // int k=27, n=3;
        int n=5, k=73;

        ArrayList<Integer> answer  = new ArrayList<>();

        //initialise arr with 1 for each, give string length required
        for(int i=0; i<n; i++){
            answer.add(1);
        }
        System.out.println("start... "+answer);

        //initialize count with give length
        int count=n;
        for(int i=answer.size()-1; i>=0; i--){
            for(int j=2; j<=26; j++){

                if(count==k){
                    System.out.println("breaking........ ");
                    break;
                }
                else{
                    int getPrev = answer.get(i) + 1;
                    answer.set( i, getPrev );
                    count++;
                    System.out.println(answer);
                }

            }
        }

        //make required string
        StringBuilder strB = new StringBuilder("");
        for(int i=0; i<answer.size(); i++){
            strB.append( arr[answer.get(i)-1] ) ;  
        }


        System.out.println("end..... "+answer);
        System.out.println("answer..... "+strB);

        */

            //(ii). second approach with an O(n)

        /* 
        int k=27, n=3;
       
        Integer arr[] = new Integer[n];

        //initialise with 1
        for(int i=0 ; i<n; i++){
            arr[i] =1;
        }


        int N = n-1;
        k = k-n;
        
        while(k!=0) {
            if(k>25){
                arr[N] = 26;
                N--;
                k = k-25;
            }
            else{
                arr[N] = k+1;
                k = 0;
            }
        }

        StringBuilder strB = new StringBuilder();

        for(int i=0 ; i<n; i++){
            strB.append( (char)('a'+(arr[i]-1)));
        }

        System.out.println(strB);

        */

        //(10). Best Time to Buy and Sell Stock -I -( at most one transaction is allowed)

            // (i). first approach with an O(n2)
        /* 
        int arr[] = { 7, 1, 5, 3, 6, 4};
        int maxProfit = 0;

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                maxProfit = Math.max( maxProfit, arr[i]-arr[j]);
            }
        }

        System.out.println(maxProfit);

        */

            // (ii). second approach with O(n)  and space complexity n
        /* 
        int arr[] = { 3, 1, 4, 8, 7, 2, 5};
        // int arr[] = { 7, 1, 5, 3, 6, 4};
        
        int nextGreaterArray[] = new int[arr.length];
        
        //find next max greater for each from the left elements
        Stack<Integer> stk = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            
            if( !stk.empty() &&  stk.peek()<arr[i]){
                stk.pop();
                stk.push(arr[i]);
                nextGreaterArray[i]=arr[i];
            }
            else if(stk.empty()){
                nextGreaterArray[i] = arr[i];
                stk.push(arr[i]);
            }
            else{
                nextGreaterArray[i] = stk.peek(); 
            }
            
        }

        int maxProfit = 0;
        for(int i=0; i<arr.length; i++){
            
            maxProfit = Math.max( maxProfit, nextGreaterArray[i]-arr[i]);
        }

            System.out.print("max profit is "+maxProfit);

        */

            //(iii). third approach with O(n) 
        
        /*
        int arr[] = { 3, 1, 4, 8, 7, 2, 5};
        // int arr[] = { 7, 1, 5, 3, 6, 4};

        int minSoFar= arr[0];
        int maxProfit= 0;
        for(int i=1; i<arr.length; i++){

                minSoFar = Math.min( minSoFar, arr[i]);

                maxProfit = Math.max( maxProfit, arr[i]-minSoFar);

        }

        System.out.println("the max profit is "+maxProfit);

        */

        //(11). Split array largest sum

        
        // int arr[] = { 3, 6, 2, 8, 4};
        int arr[] = {7,2,5,10,8};
        int m=2;

        int lower=arr[0];
        int upper=arr[0];

        for(int i=1; i<arr.length; i++){
            lower = Math.max( lower, arr[i]);
            upper = upper + arr[i];
        }

        int ans=0;  
        while ( lower<=upper) {
            int mid = ( lower+upper)/2;
            int n = no_of_subarrays_with_min_as_mid( arr, mid);
          
            if(n>m){ 
                lower = mid+1;
            }
            else{
                ans = mid;              //minimize answer
                upper = mid - 1;
            }
        
        }
             

        System.out.println(ans);

        
        
        //(12). Kth largest odd number in a given range

        //(i). O(n)----

        /* 
        int L = -10;
        int R = 10;
        int K = 8;
 
        int count = 0;
        int ans = 0;
        for(int i=R; i>=L ; i--){

            if(!(i%2==0)){
                count++;
            }

            if(count==K){
                ans = i;
                count++;
            }
        }

        System.out.println("the kth largest odd number is "+ans); 
        */

        //(ii). O(n)----
        /* 
        int L = -10; 
        int R = 10;
        int K = 8;
 
        int ans = 0;

        if( R>=0){
            if(R%2==0){
                ans =  R - (2*(K-1)+1);
            }
            else{
                ans = R - (2*(K-1));
            }
        }
        else{
            ans = (2*(K-1)-1);
        }


        System.out.println("the kth largest odd number is "+ans); 

        */

        

        




        
    }
     
}


