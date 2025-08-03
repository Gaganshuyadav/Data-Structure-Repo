package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import DynamicProgramming.dynamic_programming_1.PairForPrintAllLIS;

public class dynamic_programming_1{

    public static void printDPAnswer(int[][] dp){
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp.length; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
    }

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
        public static int knapsack_0_1_Using_Tabulation( int [] val, int wt[], int[][] dp, int W){

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
            //first row is false from 1 , cause 0 target sum is true

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


        /*(7). Unbounded KnapSack  */

        /*(i) using tabulation */
        public static int UnboundedKnapSackUsingTabulation( int [] val, int wt[], int[][] dp, int W){

            for(int i=1; i<val.length+1; i++){
                for(int j=1; j<W+1; j++){

                    if( wt[i-1]<=j){
                        dp[i][j] = Math.max( dp[i-1][j], val[i-1] + dp[i][j-wt[i-1]] );
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            return dp[val.length][W];
        }

        /*(8). Rod Cutting Problem */
        
        /*(i). using tabulation */
        public static int rodCuttingProblemUsingTabulation( int[] len, int price[], int[][] dp, int rodLength){

            for(int i=1; i<price.length+1; i++){
                for(int j=1; j<len.length+1; j++){

                    if( len[i-1] <= j){
                        int withCurr = price[i-1] + dp[i][j-len[i-1]];
                        int withPrev = dp[i-1][j];

                        dp[i][j] = Math.max( withCurr, withPrev);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            return dp[price.length][len.length];
        }

        /*(9). Longest Common Subsequence */

        /*(i). using recursion string length way*/
        public static int longestCommonSubsequence( String str1, String str2){

            if( str1.length() < 1  || str2.length() < 1){
                return 0;
            }

            if( str1.charAt(str1.length()-1) ==  str2.charAt(str2.length()-1)){
                return longestCommonSubsequence( str1.substring( 0, str1.length()-1) , str2.substring( 0, str2.length()-1) ) + 1;
            }
            else if( str1.charAt(str1.length()-1) != str2.charAt(str2.length()-1)){
                
                return  Math.max( longestCommonSubsequence( str1.substring( 0, str1.length()-1), str2 ) , longestCommonSubsequence( str1, str2.substring( 0, str2.length()-1) ) );

            }

            return 0;
                
        }

        /*(ii). using recursion simple way by 2 int lengths */
        public static int longestCommonSubsequenceWithSimpleWay( String str1, String str2, int m, int n){

            if( m < 0  || n < 0){
                return 0;
            }

            if( str1.charAt(m)==str2.charAt(n)){
                return longestCommonSubsequenceWithSimpleWay( str1, str2, m-1, n-1) + 1;
            }
            else if( str1.charAt(m)!=str2.charAt(n)){
                return  Math.max( longestCommonSubsequenceWithSimpleWay( str1, str2, m-1, n), longestCommonSubsequenceWithSimpleWay( str1, str2, m, n-1));

            }

            return 0;
                
        }

        /*(iii). using recursion simple way by 2 int lengths */
        public static int longestCommonSubsequenceWithMemo( String str1, String str2, int m, int n, int[][] dp){

            System.out.println(" m "+m+" n "+n);

            if( m < 0  || n < 0){
                return 0;
            }

            if( dp[m][n]!=-1){
                return dp[m][n];
            }

            if( str1.charAt(m)==str2.charAt(n)){
                return dp[m][n] = longestCommonSubsequenceWithMemo( str1, str2, m-1, n-1, dp) + 1;
            }
            else if( str1.charAt(m)!=str2.charAt(n)){
                return dp[m][n] = Math.max( longestCommonSubsequenceWithMemo( str1, str2, m-1, n, dp), longestCommonSubsequenceWithMemo( str1, str2, m, n-1, dp));

            }

            return 0;
        }

        /*(iv). using tabulation */

        public static int longestCommonSubsequenceWithTabulation( String str1, String str2, int[][] dp){

            for( int i=1; i<str1.length()+1; i++){
                for( int j=1; j<str2.length()+1; j++){

                    if( str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else if( str1.charAt(i-1)!=str2.charAt(j-1)){
                        dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            return dp[str1.length()][str2.length()];
        }

        /*(10). Longest Common Substring */

        /*(i). using tabulation */
        public static int longestCommonSubstringWithTabulation( String str1, String str2, int[][] dp){
            
            int maxCommon = 0;
            
            for(int i=1; i<str1.length()+1; i++){
                for(int j=1; j<str2.length()+1; j++){ 

                    if( str1.charAt(i-1)==str2.charAt(j-1)){

                        dp[i][j] = dp[i-1][j-1] + 1;

                        if( dp[i][j]>maxCommon){
                            maxCommon=dp[i][j];
                        }
                    }
                }
            } 

            return maxCommon;  
        }

        /*(12). Print All Longest Increasing Subsequence */

        /*(i). using tabulation */

        static class PairForPrintAllLIS{
            int len;
            int i;
            int val;
            String pls;

            PairForPrintAllLIS( int len, int i, int val, String pls){
                this.len = len;
                this.i = i;
                this.val = val;
                this.pls = pls;
            }

        }
        public static void printAllLongestIncreasingSubsequence( int[] nums){

            
            int dp[] = new int[nums.length];
            int maxLS=0;
            int max=0;
            int indexE = -1; 

            //firstly find the longest increasing subsequence
            for(int i=0; i<nums.length; i++){
                max=0;
                for(int j=0; j<i; j++){
    
                    if( nums[j] < nums[i]){
                        if( dp[j]>max){
                            max = dp[j];
                        }
                    }
                }
    
                if(max==0){
                    dp[i] = 1;
                }
                else{
                    dp[i] = max+1;
                }
    
                if( maxLS <= dp[i]){
                    maxLS = dp[i];
                    indexE = i; //this index contains the max dp count index value
                }
            }

            //now use queue to print all longest increasing subsequence
            Queue<PairForPrintAllLIS> que = new LinkedList<>();

            for(int i=indexE; i>=0; i--){
                if(maxLS==dp[i]){
                    que.add( new PairForPrintAllLIS( maxLS, i, nums[i], nums[i]+"") );
                }
            }

            while(!que.isEmpty()){

                PairForPrintAllLIS curr = que.remove();

                if(curr.len==1){
                    System.out.println(curr.pls);
                }

                for( int i=curr.i-1; i>=0; i--){ 
                    if( ( curr.len-1)==dp[i] && nums[i]<=curr.val ){
                        que.add( new PairForPrintAllLIS( curr.len-1, i, nums[i], nums[i]+" -> "+curr.pls));
                    }
                }  

            }


    
        }

        /*(14). Game of Execution:- Josephus Problem */

        public static int findGameOfExecutionJosephusProblem( int n, int k){

            if(n==1){ 
                return 0;
            }

            return ( findGameOfExecutionJosephusProblem( n-1, k) + k) % n ;
        }

        /*(15). Edit Distance*/

            /*(i). using recursion */ 

            public static int editDistanceUsingRecursion( String word1, String word2, int i, int j){

                if(i==word1.length()){
                    return word2.length()-j; //insertion
                }

                if(j==word2.length()){
                    return word1.length()-i; //deletion
                }

                //if both words are equal
                if(word1.charAt(i)==word2.charAt(j)){
                    return editDistanceUsingRecursion( word1, word2, i+1, j+1);
                }
                //if not equal
                else{

                    int insertOp = editDistanceUsingRecursion( word1, word2, i, j+1);
                    int deleteOp = editDistanceUsingRecursion( word1, word2, i+1, j);
                    int replaceOp = editDistanceUsingRecursion( word1, word2, i+1, j+1);

                    return Math.min( Math.min( deleteOp, insertOp), replaceOp) + 1 ;

                }

            }


            /*(ii). using memoization */ 

            public static int editDistanceUsingMemoization( String word1, String word2, int i, int j, int[][] dp){

                if(i==word1.length()){
                    return word2.length()-j; //insertion
                }

                if(j==word2.length()){
                    return word1.length()-i; //deletion
                }

                if(dp[i][j]!=-1){
                    return dp[i][j];
                }

                //if both words are equal
                if(word1.charAt(i)==word2.charAt(j)){
                    return dp[i][j] = editDistanceUsingMemoization( word1, word2, i+1, j+1, dp);
                }
                //if not equal
                else{

                    int insertOp = editDistanceUsingMemoization( word1, word2, i, j+1, dp);
                    int deleteOp = editDistanceUsingMemoization( word1, word2, i+1, j, dp);
                    int replaceOp = editDistanceUsingMemoization( word1, word2, i+1, j+1, dp);

                    return dp[i][j] = Math.min( Math.min( deleteOp, insertOp), replaceOp) + 1 ;

                }

            }
        
        /*(16). Partition into Subsets(Count number of ways to partition a set into k subsets */

            /*(i). using recursion */

            public static int partitionIntoSubsetsAndFindNumberOfWays( int k, int n){

                if( k>n || n==0 || k==0 ){
                    return 0;
                }

                if( k==1 || k==n){
                    return 1;
                }

                return k*partitionIntoSubsetsAndFindNumberOfWays( k, n-1) + partitionIntoSubsetsAndFindNumberOfWays( k-1, n-1);
            }

        /*(17). String Conversion ( only deletion and insertion allowed)*/

            public static void stringConversionLikeEditDistance( String word1, String word2, HashMap<String,Integer> hm){

                // find longest common subsequence
                int dp[][] = new int[word1.length()+1][word2.length()+1];

                int lcs = longestCommonSubsequenceWithTabulation( word1, word2, dp);

                hm.put("insertion", word2.length()-lcs);
                hm.put("deletion", word1.length()-lcs);


            }

        /*(18). Wildcard Matching */

            /*(i). first way( without optimization):- O(N^3) */

            public static boolean wildcardMatching1( String str, String ptrn){

                boolean dp[][] = new boolean[ptrn.length()+1][str.length()+1];

                // if both strings empty then they are equal
                dp[0][0] = true;

                // Only '*' can match empty string( at start it can have empty starting take example:- ( str="adced" and ptrn="*a*b" ))
                for(int i=1; i<ptrn.length()+1; i++){
        
                    if(ptrn.charAt(i-1)=='*'){
                        dp[i][0] = dp[i-1][0];
                    }
                }
        
                        
                for( int i=1; i<ptrn.length()+1; i++){
                    for( int j=1; j<str.length()+1; j++){
        
                        //star(*)
                        if( ptrn.charAt(i-1)=='*'){
                            
                            //this is the small change for optimization
                            if( dp[i][j-1] || dp[i-1][j]){
                                dp[i][j] = true;
                            }
                            else{
                                dp[i][j] = false;
                            }
                        }
                        //question mark(?)
                        else if( ptrn.charAt(i-1)=='?'){
        
                            dp[i][j] = dp[i-1][j-1]==true ? true : false;
                        }
                        else if( ptrn.charAt(i-1)==str.charAt(j-1) && dp[i-1][j-1]==true){
                            dp[i][j] = true;
                        }
                        else{
                            dp[i][j] = false;
                        }

                    }
                }
                
                return dp[ptrn.length()][str.length()];


            }

            /*(ii). second way( optimized ):- O(N^2) */

            public static boolean wildcardMatching2( String str, String ptrn){

                boolean dp[][] = new boolean[ptrn.length()+1][str.length()+1];

                // if both strings empty then they are equal
                dp[0][0] = true;

                // Only '*' can match empty string( at start it can have empty starting take example:- ( str="adced" and ptrn="*a*b" ))
                for(int i=1; i<ptrn.length()+1; i++){
        
                    if(ptrn.charAt(i-1)=='*'){
                        dp[i][0] = dp[i-1][0];
                    }
                }
        
                        
                for( int i=1; i<ptrn.length()+1; i++){
                    for( int j=1; j<str.length()+1; j++){
        
                        //star(*)
                        if( ptrn.charAt(i-1)=='*'){
                            
                            for(int x=j; x>=0; x--){
                                if(dp[i-1][x]==true){
                                    dp[i][j] = true;
                                    break;
                                }
                            }
                        }
                        //question mark(?)
                        else if( ptrn.charAt(i-1)=='?'){
        
                            dp[i][j] = dp[i-1][j-1]==true ? true : false;
                        }
                        else if( ptrn.charAt(i-1)==str.charAt(j-1) && dp[i-1][j-1]==true){
                            dp[i][j] = true;
                        }
                        else{
                            dp[i][j] = false;
                        }

                    }
                }
                
                return dp[ptrn.length()][str.length()];


            }

        /*(19). Catalan Number and BST  */

            /* (i). using tabulation */
            
            public static int findCatalanNumber(int n){
                
                int dp[] = new int[n+1];

                if( n==0 || n==1){
                    return 1;
                }
                
                dp[0] = 1;
                dp[1] = 1;
                
                for( int i=2; i<=n; i++){
                    int total=0;
                    for(int j=0; j<i; j++){    
                        total += dp[j]*dp[i-j-1];
                    }
                    dp[i] = total;
                }

                for(int i=0; i<=n; i++){
                    System.out.print(dp[i]+" ");
                }
                
                return dp[n];
            }
        
            /* (ii). using recursion */

            public static int findCatalanNumberUsingRecursion(int n){

                if( n==0 || n==1){
                    return 1;
                }

                int result=0;
                for(int i=0; i<n; i++){
                    result += findCatalanNumberUsingRecursion(i) * findCatalanNumberUsingRecursion(n-i-1);                   
                }

                return result;
            }

            /* (iii). using recursion memoization */

            public static int findCatalanNumberUsingRecursionMemo( int n, int dp[]){

                if( n==0 || n==1){
                    return 1;
                }

                if( dp[n]!=0){
                    return dp[n];
                }

                int result=0;
                for(int i=0; i<n; i++){
                    result += findCatalanNumberUsingRecursionMemo(i,dp) * findCatalanNumberUsingRecursionMemo(n-i-1,dp);                   
                }

                return dp[n] = result;
            }

        /*(20). Coin Change II */

        /*(i). using Recursion  ( time limit exceeded) */    
        public static int coinChange2UsingRecursion( int coins[], int i, int amount, int curr){

           
            if( curr==amount){
                return 1;
            }

            if( curr>amount || (coins.length-1)<i){
                return 0;
            }

            int take = coinChange2UsingRecursion( coins, i, amount, curr+coins[i]);

            int unTake = coinChange2UsingRecursion( coins, i+1, amount, curr);

            return take + unTake;

        }

        /*(ii). using Recursion Memoization */    
        public static int coinChange2UsingRecursionMemo( int coins[], int i, int amount, int curr, int dp[][]){

            if( curr==amount){
                return 1;
            }

            if( curr>amount || (coins.length-1)<i){
                return 0;
            }

            if( dp[i][curr]!=-1){
                return dp[i][curr];
            }

            int take = coinChange2UsingRecursionMemo( coins, i, amount, curr+coins[i], dp);

            int unTake = coinChange2UsingRecursionMemo( coins, i+1, amount, curr, dp);

            return dp[i][curr] = take + unTake;

        }

        /*(iii). output limit exceeded */

        

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
        /* 
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

        */


        /*(7). Unbounded KnapSack */

        /*(i). using tabulation */

        /* 
        int val[] = { 15, 14, 10, 45, 30};
        int wt[] = { 2, 5, 1, 3, 4};
        int W = 7; //total weight allowed


        // int val[] = { 20, 30, 10, 50};
        // int wt[] = { 1, 3 ,4, 6};
        // int W = 7;
        
        int dp[][] = new int[val.length+1][W+1];

        // upper row and left column with 0 as initial values( that's why w+1 and val+1) 

        System.out.println( " Unbounded Knapsack maximum profit: " + UnboundedKnapSackUsingTabulation( val, wt, dp, W));

        //print answer
        for(int i=0; i<wt.length+1; i++){
            for(int j=0; j<W+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        */

        /*(8). Rod Cutting Problem */

            /*(i). using tabulation */

            /* 
            int length[] = { 1, 2, 3, 4, 5, 6, 7, 8};
            int price[] = { 1, 5, 8, 9, 10, 17, 17, 20};
            int rodLength = 8;

            int dp[][] = new int[price.length+1][length.length+1];

            // upper row and left column with 0 as initial values( that's why w+1 and val+1) 
    

            System.out.println( " Rod Cutting Max Value : " + rodCuttingProblemUsingTabulation( length, price, dp, rodLength));

            */


        /*(9). Longest Common Subsequence */

            /*(i). using recursion string length way*/
            /* 
            String str1 = "abcde";
            String str2 = "ace";
    
            System.out.println( " the Longest Common Subsequence is "  + longestCommonSubsequence( str1, str2));
            
            */
            
            /*(ii). using recursion simple way by 2 int lengths*/
            /* 
            String str1 = "abcde";
            String str2 = "ace";

            System.out.println( " the Longest Common Subsequence is "  + longestCommonSubsequenceWithSimpleWay( str1, str2, str1.length()-1, str2.length()-1));

            */
            
            /*(iii). using memoization  */

            /* 
            String str1 = "abcdefg";
            String str2 = "aceg";

            int dp[][] = new int[ str1.length()][ str2.length()];

            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    dp[i][j] = -1;
                }
            }

            System.out.println( " the Longest Common Subsequence is "  + longestCommonSubsequenceWithMemo( str1, str2, str1.length()-1, str2.length()-1, dp));

            */

        
            /*(iv). using tabulation */

            /* 
            String str1 = "ace";
            String str2 = "abcde";  

            int dp[][] = new int[ str1.length()+1][ str2.length()+1];

            System.out.println( " the Longest Common Subsequence is "  + longestCommonSubsequenceWithTabulation( str1, str2, dp));

            for( int i=0; i<str1.length()+1; i++){
                for( int j=0; j<str2.length()+1; j++){
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }

            */

        /*(10). Longest Common Substring  */

        /*(i). using tabulation */

        /* 
        String str1 = "pqabcxy"; 
        String str2 = "xyzabcp";
  
        int dp[][] = new int[ str1.length()+1][ str2.length()+1]; 
                
        System.out.println( " the Longest Common Substring is "  + longestCommonSubstringWithTabulation( str1, str2, dp));

        for( int i=0; i<str1.length()+1; i++){
            for( int j=0; j<str2.length()+1; j++){ 
                System.out.print( dp[i][j]+" ");  
            }  
            System.out.println();
        } 

        */

        /*(11). Longest Increasing Subsequence */

        /*(i). first Way( just taking 1 if no previous smaller):- O(n^2) */
        
        /*
 
        // int nums[] = {10,9,2,5,3,7,101,18}
        int nums[] = {10,9,2,5,3,7,101,18};

        int dp[] = new int[nums.length];
        int maxLS=0;
        int max=0;


        for(int i=0; i<nums.length; i++){
            max=0;
            for(int j=0; j<i; j++){

                if( nums[j] < nums[i]){
                    if( dp[j]>max){
                        max = dp[j];
                    }
                }
            }

            if(max==0){
                dp[i] = 1;
            }
            else{
                dp[i] = max+1;
            }

            if( maxLS < dp[i]){
                maxLS = dp[i];
            }
        }

        System.out.println(" Longest Increasing Subsequence "+maxLS);

        
        */

        /*(ii). second Way ( same as first)(just little code)( just taking 0 if no previous smaller):- O(n^2) */

        /*


        // int nums[] = {10,9,2,5,3,7,101,18}
        int nums[] = {10,9,2,5,3,7,101,18};

        int dp[] = new int[nums.length];
        int maxLS=0;
        int max=0;

        for(int i=0; i<nums.length; i++){
            max=Integer.MIN_VALUE;
            for(int j=0; j<i; j++){

                if( nums[j] < nums[i]){
                    if( dp[j]>max){
                        max = dp[j];
                        dp[i] = max+1;
                    }
                }
            }


            if( maxLS < dp[i]){
                maxLS = dp[i];
            }
        }

        System.out.println(" Longest Increasing Subsequence "+(maxLS+1));

        

        */


        /*(12). Print All Longest Increasing Subsequence */

        /*(i).  */
        /* 
        
        // int nums[] = {10,9,2,5,3,7,101,18};
        int nums[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 3 };


        printAllLongestIncreasingSubsequence( nums);


        */

        /*(13). Longest Palindromic Subsequence  */

        /* 
        String str = new String( "abkccbc");
        int dp[][] = new int[str.length()][str.length()];

        for(int g=0; g<str.length(); g++){

            for(int i=0, j=g; j<str.length(); i++, j++){

                if(g==0){                         
                    dp[i][j] = 1;
                }
                else if(g==1){
                    dp[i][j] = str.charAt(i)==str.charAt(j) ? 2 : 1;
                }
                else{ 

                    if( str.charAt(i)==str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                    else{
                        dp[i][j] = Math.max( dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }

        printDPAnswer(dp);

        System.out.println("Longest Palindromic Subsequence is "+dp[0][str.length()-1]);

        */

        
        /*(14). Game of Execution:- Josephus Problem ( start with 0)*/

        /* 

        int n=7,k=4;
        // int n=5,k=3;

        System.out.println( " the solution of josephus problem is " + findGameOfExecutionJosephusProblem( n, k) );

        */


        /*(15). Edit Distance*/

            /*(i). using recursion */ 

            /*
             
            String word1 = "horse";
            String word2 = "ros";

            System.out.println( " minimum number of operations required to convert word1 to word2 is " + editDistanceUsingRecursion( word1, word2, 0, 0));
            
            */

            /*(ii). using memoization */ 

            /* 

            String word1 = "horse";
            String word2 = "ros";

            int dp[][] = new int[word1.length()][word2.length()]; 
  
            for(int i=0; i<word1.length(); i++){
                for(int j=0; j<word2.length(); j++){ 
                    dp[i][j] = -1;
                }
            }

            System.out.println( " minimum number of operations required to convert word1 to word2 is " + editDistanceUsingMemoization( word1, word2, 0, 0, dp));
            
            */

        /*(16). Partition into Subsets (Count number of ways to partition a set into k subsets( geeks for geeks)) */

            /*(i). using recursion */
            /* 
            int n=4, k=3;

            System.out.println( " total number of ways: " + partitionIntoSubsetsAndFindNumberOfWays( k, n) );

            */

            /*(ii). use the dynamic array ( no need to implement just remember in the brain)*/

        /*(17). Edit distance and find both insertion and deletion operation count ( only deletion and insertion allowed)*/

        /*             
            // String word1 = "abcdef";
            // String word2 = "aceg";

            String word1 = "pear";
            String word2 = "sea";

            HashMap<String,Integer> hm = new HashMap<>();
            hm.put("insertion", 0);
            hm.put("deletion", 0);

            stringConversionLikeEditDistance( word1, word2, hm );
            System.out.println( " the ins and del operations are "+ hm );

        */

        /*(18). Wildcard Matching */

            /*(i). first way( without optimization):- O(N^3) */
            /* 
            String str = "baaabab";
            String ptrn = "ba*a?";
            System.out.println( "this matching " +wildcardMatching1( str, ptrn));
            */


            /*(ii). second way( optimized ):- O(N^2) */
            
            /* 
            // String str = "baaabab";
            // String ptrn = "ba*a?";

            // String str = "adced";
            // String ptrn = "*a*b";                                                                         

            // String str = "baba";
            // String ptrn = "*****ba?a";
            
            String str = "babaaab";
            String ptrn = "?a*ab";
            
            System.out.println( "this matching " +wildcardMatching2( str, ptrn));

            */
            
        /*(19). Catalan Number (Counting BST Trees) ( Mountain Ranges) */

            /* (i). using tabulation */
            /* 
            int n=10;
            System.out.println( " the Catalan Number is " + findCatalanNumber(n) );
            */

            /* (ii). using recursion */
            /* 
            
            int n=14;
            System.out.println( " the Catalan Number is " + findCatalanNumberUsingRecursion(n) );

            */

            /* (iii). using recursion memoization */
            /* 
            int n=4;
            int dp[] = new int[n+1];
            System.out.println( " the Catalan Number is " + findCatalanNumberUsingRecursionMemo( n, dp) );
            */

        /*(20). Coin Change II */

            /*(i). using Recursion  ( time limit exceeded)  */

            /* 
            int coins[] = { 1, 2, 5};
            int amount=5;

            System.out.println( " the coin II combinations are " + coinChange2UsingRecursion( coins, 0, amount, 0) );

            */

            /*(ii). using Recursion Memoization */  

            int coins[] = { 1, 2, 5};
            int amount=5;

            int dp[][] = new int[coins.length][amount];

            for(int i=0; i<coins.length; i++){
                for(int j=0; j<amount; j++){
                    dp[i][j] = -1;
                }
            }

            System.out.println( " the coin II combinations are " + coinChange2UsingRecursionMemo( coins, 0, amount, 0, dp) );

            

            /*(iii). using tabulation */
            /* 

            int coins[] = { 1, 2, 5};
            int amount=5;

            int dp[] = new int[amount+1];
            dp[0] = 1;
    
            for(int i=0; i<coins.length; i++){
                for(int j=1; j<amount+1; j++){
    
                    if( (j-coins[i])>=0 && dp[j-coins[i]] > 0 ){
                        dp[j] = dp[j] + dp[j-coins[i]];
                    }

                }
            }
    
            System.out.println( " the coin II combinations are " + dp[amount] );

            */



        
        





    




        






























        /*(155). find the Winner of the Circle Game ( start with 1)*/

        /*(i). Approach:1 */

        /* 

        int n=5, k=2;
        System.out.println( " the Winner of the Circular Game is " + findWinnerOfCircularGame( n, k) );

        */

        
        

        

        








  }
}




    

