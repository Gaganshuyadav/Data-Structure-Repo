package DynamicProgramming;

public class dynamic_programming_1{

    /*(1). find fibonacci using Memoization*/
    public  static int findFibo(int n, int[] fibo){

        if(n==1){
            return 0;
        }
        if(n==2){
            return 1; 
        }

        if(fibo[n-1]!=0){
            return fibo[n-1];
        }

        fibo[n-1] = findFibo( n-1, fibo) + findFibo(n-2, fibo);
        return fibo[n-1];
    }




    /*(2). Climbing Stairs */

    /*(i). find using simple recursion*/
    public static int climbingStairsWays1( int start, int target){

        if( start > target){
            return 0;
        }

        if( start==target){
            return 1;
        }

        return climbingStairsWays1( start+1, target) + climbingStairsWays1( start+2, target);
    }

    public static int climbingStairsWays2( int n){

        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }

        return climbingStairsWays2(n-1) + climbingStairsWays2(n-2);
    }

    /*(ii). using recursion memoization*/
    public static int climbingStairsWays3( int n, int[] memo){

        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }

        if(memo[n-1]!=0){
            return memo[n-1];
        }

        return memo[n-1] = climbingStairsWays3( n-1, memo) + climbingStairsWays3( n-2, memo);

    }





    /*(3). Jump Game I */

        /*(i). using recursion time limit exceeded */
        public static boolean checkIfIsJumpPossibleInJumpGameUsingSimple( int[] nums, int i, int j){
        
            if(i==j){
                return true;
            }
    
            for(int x=1; x<=nums[i]; x++){
                
                if( checkIfIsJumpPossibleInJumpGameUsingSimple(nums, i+x, j)){
                    return true;
                }
            }
    
            return false;
        }

        /*(ii). using recursion with memoization ( time:- 2^n)*/
        public static int checkIfIsJumpPossibleInJumpGame( int[] nums, int i, int j, int[] memo){
        
            if(i==j){
                return 1; //return true
            }
    
            //memoization
            if( memo[i]!=-1){
                return memo[i];
            }
    
            for(int x=1; x<=nums[i]; x++){
                
                int isTrue =  checkIfIsJumpPossibleInJumpGame(nums, i+x, j, memo);
    
                memo[i+x] = isTrue;
    
                if(isTrue==1){
                    return 1; //return true
                }
                
                
            }
    
            return 0; //return false
        }

        /*(iii). using recursion with bottom up or tabulation ( time:- n^2) */
        public static boolean checkForPreviousTrueExistInJumpGame( int[] nums, int j, int i, boolean[] tabu){
    
            for(int x=j; x>=0; x--){
                
                //and j is also true, which means that j is reachable
                if( tabu[x]==true && (nums[x]+x >=i) ){
                    return true;
                }
            }
    
            return false;
        }




        /*(4). Jump Game II */

        /*(i). using recursion  */
        public static int minimumJumpInJumpGame2=Integer.MAX_VALUE;
        public static void findMinimumJumpInJumpGame2( int[] nums, int i, int j, int count){

            if(i==j){ 
                minimumJumpInJumpGame2 = Math.min( minimumJumpInJumpGame2, count);
                return;
            }
    
            for(int x=1; x<=nums[i]; x++){
                findMinimumJumpInJumpGame2( nums, i+x, j, count+1);
            }

    
        }




        /*(5). 0-1 Knapsack */

        /* (i). using recursion*/
        public static int knapsack_0_1_Using_Recursion( int[] val, int[] wt, int W, int idx ){

            //edge cases 
            if( W==0 || idx==val.length){
                return 0;
            }

            //valid, if under the weight capacity
            if( wt[idx]<=W){
                
                //if we taken the val to get max profit( include)
                int ans1 =  val[idx] + knapsack_0_1_Using_Recursion( val, wt, W-wt[idx], idx+1);

                //if we not take the val to get max profit(exclude)
                int ans2 = knapsack_0_1_Using_Recursion( val, wt, W, idx+1);

                return Math.max( ans1, ans2);
            }
            //not-valid, if not under the weight capacity
            else{
                return knapsack_0_1_Using_Recursion( val, wt, W, idx+1);
            }
        }

        /* (ii). using recursion memozation*/
        public static int knapsack_0_1_Using_Memoization( int[] val, int[] wt, int W, int idx, int[][] dp){

            //edge cases 
            if( W==0 || idx==val.length){
                return 0;
            }
            
            if(dp[W][idx]!=-1){
                return dp[W][idx];
            }

            //valid, if under the weight capacity
            if( wt[idx]<=W){
                
                //if we taken the val to get max profit( include)
                int ans1 =  val[idx] + knapsack_0_1_Using_Memoization( val, wt, W-wt[idx], idx+1, dp);

                //if we not take the val to get max profit(exclude)
                int ans2 = knapsack_0_1_Using_Memoization( val, wt, W, idx+1, dp);

                return dp[W][idx] = Math.max( ans1, ans2);
            }
            //not-valid, if not under the weight capacity
            else{
                return dp[W][idx] = knapsack_0_1_Using_Memoization( val, wt, W, idx+1, dp);
            }


        }

        /*(iii). using tabulation ( O(n*W)) */
        public static int knapsack_0_1_Using_Tabulation( int [] val, int wt[], int[][] dp,int W){

            for(int i=1; i<wt.length+1; i++){
                for(int j=1; j<W+1; j++){

                    //valid
                    if( j>=wt[i-1]){

                        int currTaken = val[i-1] + dp[i-1][ j-wt[i-1]];
                        int prevTaken = dp[i-1][j];

                        dp[i][j] = Math.max( currTaken, prevTaken);
                    }
                    //invalid
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            return dp[val.length][W];

        }

        /*(6). Target Sum Subset */
        /*(i). using recursion */
        public static boolean targetSumSubsetUsingRecursion( int[] numbers, int targetSum, int currSum, int idx){

            if(targetSum==currSum){
                return true;
            }

            if( idx>=numbers.length || targetSum < currSum){
                return false;
            }

            return targetSumSubsetUsingRecursion( numbers, targetSum, currSum+numbers[idx], idx+1 ) || targetSumSubsetUsingRecursion( numbers, targetSum, currSum, idx+1 );
            
        }

        /*(ii). using tabulation*/
        public static boolean targetSumSubsetUsingTabulation( boolean[][] dp, int[] numbers, int targetSum){

            //first column all elements are true, cause at 0 sum target, the empty subset is true always
            //first row is false from 1 , cause 0 target sum is true, but 0 cannot match with target

            //first column is true due to 0 target
            for(int i=0; i<numbers.length+1; i++){
                dp[i][0] = true;                
            }

            //first row is false, just first element of row is true( in java by default all are false, so, we dont need to do it)


            for(int i=1; i<numbers.length+1; i++){
                for(int j=1; j<targetSum+1; j++){
                    
                    if(numbers[i-1]<=j){
                        boolean currTake = dp[i-1][j-numbers[i-1]];
                        boolean notTakeCurr = dp[i-1][j];

                        dp[i][j] = currTake || notTakeCurr; //any one condition is true , then return true
                    }
                    else{

                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            //last element tell if subset will match target or not
            return dp[numbers.length][targetSum];
        }

    public static void main(String[] args){

        /*(1). find fibonacci */

            //(i).using Memoization(Top Down)  (recursion)
            /* 
            int n=8; //13
            int fibo[] = new int[n]; 
            System.out.println( findFibo( n, fibo));
            for(int i=0; i<n; i++){
                System.out.print(fibo[i]+" ");
            }
            */

            //(ii).using Tabulation(Bottom Up) ( iteration)
            /* 
            int n=8; //13
            int fibo[] = new int[n]; 
            fibo[0]=0;
            fibo[1]=1;
            for(int i=2; i<n; i++){
                fibo[i] = fibo[i-1]+fibo[i-2];
            }
            
            for(int i=0; i<n; i++){
                System.out.print(fibo[i]+" ");
            }
  
            */

        /*(2). Climbing Stairs  */
        
            /*(i). using simple recursion , time limit exceeded , time:- O(2^n)*/
            /* 
            int n=5;
            System.out.println("the total ways to reach target "+climbingStairsWays1( 0, n ));
            System.out.println("the total ways to reach target "+climbingStairsWays2( n));
            */

            /*(ii). using recursion memoization*/
            /* 
            int n=5;
            int[] memo= new int[n];
            memo[0]=1;
            memo[1]=2;
            System.out.println("the total ways to reach target "+climbingStairsWays3( n, memo ));
            */

            /*(iii). using tabulation*/
            /* 
            int n=5;
            int[] tabu= new int[n];
            tabu[0]=1;
            tabu[1]=2;
            for(int i=2; i<n; i++){
                tabu[i] = tabu[i-1] + tabu[i-2];
            }

            System.out.println("the total ways to reach target "+tabu[n-1]);

            */

        /*(3). Jump Game I */

            /*(i). using recursion */
            /* 
            int nums[] = { 2, 3, 1, 1, 4};
            System.out.println( " Is Jump Possible "+checkIfIsJumpPossibleInJumpGameUsingSimple( nums, 0, nums.length-1));
            */

            /*(ii). using recursion with memoization ( time:- 2^n)*/
            /* 

            int nums[] = { 2, 3, 1, 1, 4};

            // int nums[] = [ 3, 0, 8, 2, 0, 0, 1]; //edge case

            // 0 means false, 1 means true and -1 means not visited yet 
            int memo[] = new int[nums.length];

            //initialize all with -1
            for(int i=0; i<nums.length; i++){
                memo[i] = -1;
            }

            if(checkIfIsJumpPossibleInJumpGame( nums, 0, nums.length-1, memo)==1){
                // return true;
                System.out.println( " Is Jump Possible is true");
            }
            else{
                // return false;
                System.out.println( " Is Jump Possible is false");
            }
           
            */

            /*(iii). using recursion with bottom up or tabulation ( time:- n^2) */
            
            /* 
            int nums[] = { 2, 3, 1, 1, 4};

            boolean tabu[] = new boolean[nums.length];

            //initialize first which is true at start, cause it can jump from index first to any other 
            tabu[0] = true;

            //check for all
            for(int i=1; i<nums.length; i++){
    
                if(checkForPreviousTrueExistInJumpGame( nums, i-1, i, tabu)){
                    tabu[i] = true;
                }
                else{
                    tabu[i] = false;
                }
            }
    
            if(tabu[nums.length-1]){
                // return true;
                System.out.println( " Is Jump Possible is true");
            }
            else{
                // return false;
                System.out.println( " Is Jump Possible is false");
            }

            */


        /*(4). Jump Game II */

           /*(i). using recursion */
           /* 
            int nums[] = { 2, 3, 1, 1, 4};
            minimumJumpInJumpGame2=Integer.MAX_VALUE;
            findMinimumJumpInJumpGame2( nums, 0, nums.length-1, 0);
            System.out.println( " the minimum Jump required is "+ minimumJumpInJumpGame2);
            */

        /*(5). 0-1 KnapSack*/

        /*(i). using recursion ( O(2^n))*/
        /* 
        int val[] = { 15, 14, 10, 45, 30};
        int wt[] = { 2, 5, 1, 3, 5};
        int W = 7; //total weight allowed

        System.out.println( " 0-1 Knapsack maximum profit: " + knapsack_0_1_Using_Recursion( val, wt, W, 0));
        */

        /*(ii). using recursion memoization ( O(n*W)) */
        /* 
        int val[] = { 15, 14, 10, 45, 30};
        int wt[] = { 2, 5, 1, 3, 5};
        int W = 7; //total weight allowed
        int dp[][] = new int[W+1][val.length+1];

        //initialize with -1
        for(int i=0; i<W+1; i++){
            for(int j=0; j<val.length+1; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println( " 0-1 Knapsack maximum profit: " + knapsack_0_1_Using_Memoization( val, wt, W, 0, dp));
        
        for(int i=0; i<wt.length+1; i++){
            for(int j=0; j<val.length+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        */

        /*(iii). using tabulation ( O(n*W)) */

        /* 
        // int val[] = { 15, 14, 10, 45, 30};
        // int wt[] = { 2, 5, 1, 3, 5};
        // int W = 7; //total weight allowed


        int val[] = { 20, 30, 10, 50};
        int wt[] = { 1, 3 ,4, 6};
        int W = 10;
        
        int dp[][] = new int[val.length+1][W+1];

        // upper row and left column with 0 as initial values( that's why w+1 and val+1)

        System.out.println( " 0-1 Knapsack maximum profit: " + knapsack_0_1_Using_Tabulation( val, wt, dp, W));

        //print answer
        for(int i=0; i<wt.length+1; i++){
            for(int j=0; j<W+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        */

        /*(6). Target Sum Subset */

        

        /*(i). using recursion */
        /* 
        int numbers[] = { 4, 2, 7, 1, 3};
        int targetSum=10;
        System.out.println( " is target sum exist in subsets: "+targetSumSubsetUsingRecursion( numbers, targetSum, 0, 0));
        */

        /*(ii). using tabulation */
        // /* 
        int numbers[] = { 4, 5, 2, 1, 3};
        int targetSum=10;
        boolean dp[][] = new boolean[numbers.length+1][targetSum+1];
        System.out.println( " is target sum exist in subsets: "+targetSumSubsetUsingTabulation( dp, numbers, targetSum));
        
        // print answer
        for(int i=0; i<numbers.length+1; i++){
            for(int j=0; j<targetSum+1; j++){
                if(dp[i][j]){
                    System.out.print(dp[i][j]+"  ");
                }
                else{
                    System.out.print(dp[i][j]+" ");
                }
                
            }
            System.out.println();
        }

        // */

        

        






  }
}




    

