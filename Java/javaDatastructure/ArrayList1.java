import java.util.*;

public class ArrayList1 {
    public static void swap( int arr[], int x, int y){

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }
    public static void main( String args[]){

        /*------------------------------------ */
        /*(1). Introduction of all operations with implementation:- */
        /*

        //Java Collection Framework:- 
        // ClassName objectName = new ClassName();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<Integer> list1 = new ArrayList<Integer>(); //() call ArrayList constructor //<> used to specify the type parameter
        ArrayList<Boolean> list3 = new ArrayList<Boolean>();

        //1. add operation ( O(1))
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        System.out.println(list1);

        //2. get operation ( O(1))
        int li1 = list1.get(2);
        System.out.println(li1);

        //3. delete operation ( O(n))
        list1.remove(3); 
        System.out.println(list1);

        //4. set element at index ( O(n)) 
        list1.set(1,100);
        System.out.println(list1);


        //5. Contains Element ( O(n)) 
        System.out.println(list1.contains(30));
        System.out.println(list1.contains(100));
        System.out.println(list1.contains(70));

        //6. add element at index ( O(n))
        list1.add(1, 1000);
        System.out.println(list1);

        //7. Size of ArrayList
        System.out.println(list1.size());

        //8. print ArrayList manually 
        System.out.println("the ArrayList is");
        for(int i=0; i< list1.size(); i++){
           
            System.out.println(list1.get(i));
        }

        //9. Sorting ArrayList

        int arr[] = { 3, 54, 2,43, 98, 43};
        Arrays.sort(arr);
        for(int i=0 ; i< arr.length ; i++){
            
            System.out.println(arr[i]);
        
        }
          ArrayList<Integer> second = new ArrayList<>();
          second.add(2); second.add(35); second.add(9); second.add(33); second.add(6);
          
          //ascending order
          Collections.sort(second);
          System.out.println("second "+second);

          //descending order
          Collections.sort(second, Collections.reverseOrder()); //comparator - comparator is a function which defines the logic of sorting
          System.out.println("second "+second);

        
        

        //10. Multi-dimensional ArrayList

          (i). Example:1- [[1,2],[3,4]]
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> firstList= new ArrayList<>();
        ArrayList<Integer> secondList= new ArrayList<>();

        firstList.add(1);
        firstList.add(2);
        secondList.add(3);
        secondList.add(4);

        mainList.add(firstList);
        mainList.add(secondList);

        for(int i=0; i< mainList.size();i++){
            System.out.println(mainList.get(i));
            ArrayList<Integer> currList = mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.println(currList.get(j));
            }
        }

        System.out.println(mainList);

        //(ii). Example:2- [[1,2,3,4,5],[2,4,6,8,10],[3,6,9,12,15]]

        ArrayList<ArrayList<Integer>> mainList2 = new ArrayList<>();
''
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i=1; i<=5; i++){
            list1.add(i);
            list2.add(i*2);
            list3.add(i*3);
        }

        mainList2.add(list1);
        mainList2.add(list2);
        mainList2.add(list3);
        

        //print
        System.out.println(mainList2);

        //get all from mainList2
        for(int i=0; i<mainList2.size(); i++){
            ArrayList<Integer> currList = mainList2.get(i);
            for(int j=0; j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
        */
        
        /*------------------------------------ */
        /*(2). print Reverse of an ArrayList */
        /*
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11); arr.add(12); arr.add(13); arr.add(14); arr.add(15);
        for(int i=arr.size()-1 ; i>=0; i--){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
        */

        /*------------------------------------ */
        /*(3). find Max in an ArrayList */
        /*
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2); arr.add(5); arr.add(9); arr.add(3); arr.add(6);
        int max = Integer.MIN_VALUE ;
        for(int i=0 ; i< arr.size() ; i++){
            if( max < arr.get(i)){
                max = arr.get(i);
            }
        }
        System.out.println("the max element is "+max);
        */

        /*------------------------------------ */
         /*(4). Swap 2 numbers in ArrayList */
         /* 
         ArrayList<Integer> arr = new ArrayList<>();
         arr.add(2); arr.add(5); arr.add(9); arr.add(3); arr.add(6);
         int idx1=1, idx2=3;
           int temp = arr.get(idx1);
           arr.set(idx1, arr.get(idx2));
           arr.set(idx2, temp);
         System.out.println("the swapped arraylist is "+arr);
         */

         /*------------------------------------ */
        /*(5). contain water */
        //(i). Brute force approach --O(n2)

        /* 
        ArrayList<Integer> height = new ArrayList<>();
        ArrayList<Integer> container = new ArrayList<>();
        
        height.add(1);height.add(8);height.add(6);height.add(2);height.add(5);height.add(4);height.add(8);height.add(3);height.add(7);

        int maxWater=0,min=0,width=0,ht=0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                min = Math.min(height.get(i),height.get(j));
                ht = ( j - i);
                if(min*ht > maxWater){
                    maxWater = min*(j-1);
                }
            }

        }

        System.out.println(maxWater);
        */
        
        //(ii). 2 pointer Approach --O(n)
        /*
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1); height.add(8); height.add(6); height.add(2); height.add(5);height.add(4);height.add(8);height.add(3);height.add(7);

        int maxWater=0, ht, width, lp=0, rp=height.size()-1 ;
        while(lp<rp){

            //calculate Area
            width = rp-lp;
            ht = Math.min( height.get(lp), height.get(rp));
            
            if( ht*width > maxWater){
                maxWater = ht*width;
            }

            //2 pointers appro
            if( height.get(lp)< height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }

        }

        System.out.println(maxWater);
        */
  
        /*------------------------------------ */
        /*(6). Trapping Rain Water */
        //(i). first Approach ( Brute force( O(n2)))):-
        /*
        ArrayList<Integer> height = new ArrayList<>();
        height.add(10);height.add(9);height.add(0);height.add(5);

        int leftMax=0, rightMax=0, findMinFromBoth=0, containWater=0, totalTrappingWater = 0;
        for( int i=1; i<height.size()-1; i++){

            leftMax=0;rightMax=0;containWater=0;
            
            //find left max
            for(int j=i-1; j>=0; j--){

                if(height.get(j)>leftMax){
                    leftMax = height.get(j);
                }
            }

            //find right max
            for(int j=i+1; j<height.size(); j++){
                if(height.get(j)>rightMax){
                    rightMax = height.get(j);
                }
            }

            //find min height from leftMax and rightMax
            findMinFromBoth = Math.min( leftMax, rightMax);

            //now subtract current height from min height
            containWater = Math.abs(findMinFromBoth - height.get(i));

            //add water in total water
            totalTrappingWater += containWater;
        }

           System.out.println(totalTrappingWater);
        
        */

        //(ii). second Approach( optimized approach( O(n))):-  
        /* 
        ArrayList<Integer> height = new ArrayList<>();
        height.add(0);height.add(1);height.add(0);height.add(2);height.add(1);height.add(0);height.add(1);height.add(3);height.add(2);height.add(1);height.add(2);height.add(1);

        int lp =0 ,rp = height.size()-1, leftMax = height.get(0), rightMax = height.get( height.size() - 1 );
        int totalTrappingWater = 0;

        while(lp<rp){

            
            if( leftMax <= rightMax){
                lp++;
                System.out.println("leftIndex "+lp);

                if(height.get(lp) < leftMax){
                    totalTrappingWater += leftMax - height.get(lp);
                }
                else{
                    leftMax = height.get(lp);
                }
            }
            else{
                rp--;
                System.out.println("rightIndex "+rp);
                if(height.get(rp) < rightMax ){
                    totalTrappingWater += rightMax - height.get(rp);
                } 
                else{
                    rightMax = height.get(rp);
                }
            }

        }

        System.out.println(totalTrappingWater);

        */
        
        /*------------------------------------ */
        /*(7). Pair Sum-1 :- sorted array*/

            //(i). first Approach ( Brute force( O(n2) ))):-
            /*
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6);
            int target = 5;

            for( int i=0; i< list.size(); i++){
                for( int j=i+1; j< list.size(); j++){
                    if( ( list.get(i) + list.get(j)) == target ){
                        System.out.println(true);
                        return;
                    }
                }
            }


            System.out.println(false);
            return;

            */

            //(ii). second Approach  ( 2 pointers approach ( O(n)))
            /*
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6);
            int target = 5;

            int lp=0, rp= list.size()-1;
            while( lp!=rp){
                if( ( list.get(lp)+list.get(rp)) == target){
                    System.out.println(true);
                    return;
                }
                else if( list.get(lp)+list.get(rp) < target){
                    lp++;
                }
                else{
                    rp--;
                }
            }

            System.out.println(false);
            */
            
        /*------------------------------------ */
        /*(7). Pair Sum-2 :- sorted and rotated array*/

        //(i). 2 pointers approach( O(n)) using modular arithmetic
        /*
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5); list.add(6); list.add(1); list.add(2); list.add(3); list.add(4); 
        int target = 5;

        int breakPoint = 0;
        int n = list.size();
        for(int i=0; i< n ; i++){
            if(list.get(i)>list.get(i+1)){
                breakPoint = i;
                break;
            }
        }

        int lp = breakPoint+1 , rp = breakPoint; 
        while( lp!=rp){
            if( (list.get(lp)+ list.get(rp)) == target){
                System.out.println(true);
                System.out.println(list.get(lp)+" "+list.get(rp));
                return;
            }
            else if( ( list.get(lp)+list.get(rp)) < target){
                lp = (lp+1)% n;
            }
            else{
                rp = (rp+n-1)%n;
            }
            System.out.println(list.get(lp)+" "+list.get(rp));
        }
        */
    

        //-------------------------------------------------(INTERVIEW FAMOUS QUESTIONS)---------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------------------------------------------------
        
        /*(1) Two Sum I*/

            

            /* Approach:1 :- O(n^2) */
            /*

            int nums[] = { 2, 7, 11, 15};
            int target = 13;

            for(int i=0; i<nums.length; i++){
                int sum = nums[i];  
                for(int j=i+1;j<nums.length; j++){
                    if(sum+nums[j]==target){
                        System.out.println(i+" "+j);
                        break;
                    }
                }
            }
            */

            /* Approach:2 :- (hashmap approach) O(n) */

            /* 

            int nums[] = { 2, 7, 11, 15};
            int target = 13;

            HashMap<Integer, Integer> hp = new HashMap<>();

            for(int i=0; i<nums.length; i++){

                if(hp.containsKey( target-nums[i])){
                    System.out.println( hp.get(target-nums[i]) +" "+i );
                    break;
                }
                else{
                    hp.put(nums[i], i);
                }
            }
            */

        /*(2). Two Sum II  ( when array is sorted)*/

            /*Approach:1 :- O(n) */

            /* 
            int nums[] = { 2, 7, 11, 15};
            int target = 13;

            int i=0;
            int j=nums.length-1;

            while(i<j){
                
                if( (nums[i]+nums[j])==target){
                    System.out.print(i+" "+j);
                    break;
                }
                else if( (nums[i]+nums[j])<target){
                    i++;
                }
                else{
                    j--;
                }

            }

            */

        /*(3). Three Sum */

        /* 

        int nums[] = { -1, 0, 0 , 1, 2, 2, 7};
        // int nums[] = { -1,0,1,2,-1,-4};
        // int nums[] = { 0, 1, 1};
        // int nums[] = { 0, 0, 0}; 

        List<List<Integer>> result = new ArrayList<>();


        //codition if lenght is lesser than 3 or equal to 3
        if(nums.length < 3){
            System.out.println(result); //return 
        }

        if(nums.length==3){

            if((nums[0]+nums[1]+nums[2])!=0){
                System.out.println(result);  //return
            }
            else{
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add( nums[0]); arr.add( nums[1]); arr.add( nums[2]); 
                result.add( arr);

                System.out.println(result);  //return
            }
        }
        
        //firstly sort the array
        Arrays.sort( nums);


        for(int i=0; i<nums.length; i++){

            //not take duplicate elements
            if((i-1)>=0 && nums[i] == nums[i-1]){
                continue;
            }
 
            int target = nums[i];


            int j = i+1;
            int k = nums.length-1;

            while(j<k){

                if( (nums[j] + nums[k]) == -(target)){

                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add( nums[i]); arr.add( nums[j]); arr.add( nums[k]); 
                    result.add( arr);
                }

                if((nums[j] + nums[k]) < -(target)){
                    j++;
                }
                else{
                    k--;
                }
            }

        }
        

        System.out.println(result);

        */


        /*(4). Trapping Rain Water*/

            /*(i). Approach:1 :-  O(n^2)                 :-( time limit exceeded in test cases)*/

            /* 
            int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
            int trappedRainWater=0;

            for(int i=1; i<height.length-1; i++){

                int leftMax = 0;
                int rightMax = 0;
                
                //left max
                for(int j=i-1; j>=0; j--){  
                    if(leftMax < height[j]){
                        leftMax = height[j];
                    }
                }

                //right max
                for(int j=i+1; j<height.length; j++){  
                    if(rightMax < height[j]){
                        rightMax = height[j];
                    }
                }


                int sum = Math.min( leftMax, rightMax) - height[i];
                trappedRainWater += sum < 0 ? 0 : sum;                  //avoid negative ( height[i] should be lesser than left and right max, so then, just subtract it otherwise gave 0 )
                
            }

            System.out.println(trappedRainWater);

            */

            /*(ii). Approach:2 :-  O(n)  , using two arraylist for containing the leftMax and rightMax, i can optimize it for not taking leftMax and find it when i am calculating the total trapping water.*/

            /* 
            int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
            int trappedRainWater=0;

            ArrayList<Integer> leftMax = new ArrayList<>();
            ArrayList<Integer> rightMax = new ArrayList<>();


            //find leftMax elments
            int leftMaxValue = Integer.MIN_VALUE;
            for(int i=0; i<height.length; i++){

                if( leftMaxValue < height[i]){
                    leftMaxValue = height[i];
                    
                }
                leftMax.add( leftMaxValue);
            }

            System.out.println(leftMax);

            //find rightMax elments
            int rightMaxValue = Integer.MIN_VALUE;
            for(int i=height.length-1; i>=0; i--){

                rightMaxValue = Math.max( rightMaxValue, height[i]);
                rightMax.addFirst( rightMaxValue);
            }

            System.out.println(rightMax);


            for(int i=0; i<height.length-1; i++){

                int sum = Math.min( leftMax.get(i), rightMax.get(i)) - height[i];
                trappedRainWater += sum < 0 ? 0 : sum;
                
            }

            System.out.println(trappedRainWater);

            */

            /*(iii). Approach:3 :- O(n) , using stack */

            /* 
            Stack<Integer> stk = new Stack<>();

            int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

            int trappedRainWater = 0;

            for(int i=0; i<height.length ; i++){

            
                while( !stk.empty() && height[ stk.peek()] < height[i] ){
                    
                    int curr = height[stk.pop()];

                    if(stk.empty()){
                        break; // No left boundary, break out of the loop, after curr element remove
                    }
    
                    trappedRainWater += ( Math.min(height[i], height[ stk.peek()])- curr)*(i - stk.peek() -1) ;
                }

                stk.push(i);

            }

            System.out.println(trappedRainWater);

            */

            /*(iv). Approach:4 :- O(n) , 2 pointers approach , time:- O(n) and space:- O(1) */

            /* 
            int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

            int leftMax = height[0];
            int rightMax = height[ height.length - 1];

            int i=0;
            int j=height.length-1;

            int trappedRainWater = 0;

            while( i <= j){

                if( height[i] <= height[j] ){

                    if(height[i] < leftMax){
                        trappedRainWater += leftMax - height[i];
                    }
                    else{
                        leftMax = height[i];
                    }
                    i++;
                }
                else{

                    if(height[j] < rightMax){
                        trappedRainWater += rightMax - height[j];
                    }
                    else{
                        rightMax = height[j];
                    }
                    j--;
                }



            }

            System.out.println(trappedRainWater);

            */


            
        /*(5). 3 Sum Closest */

            /*(i). Approach:1 :- Brute force O(n^3) */

            /* 

            // int nums[] = { -1, 2, 1, -4};
            // int target = 1;

            int nums[] = { 1, 1, 1, 0};
            int target = -100;

            int result = Integer.MAX_VALUE;
            int resultValue = Integer.MAX_VALUE;

            for(int i=0; i<nums.length-2; i++){

                for(int j=i+1; j<nums.length-1; j++){

                    for(int k=j+1; k<nums.length; k++){

                        if( resultValue > Math.abs(target - (nums[i]+nums[j]+nums[k]) ) ){

                            result = nums[i]+nums[j]+nums[k];
                            resultValue = Math.abs(target - (nums[i]+nums[j]+nums[k])) ;
                        }

                    }
                }
            }

            */
            
            /*(ii). Approach:2 :- 2 pointers Approach O(n^2)  */

            /* 

            int nums[] = { -1, 2, 1, -4};
            int target = 1;

            int result = Integer.MAX_VALUE;

            //sort it first
            Arrays.sort( nums);

            for(int i=0; i<nums.length-2; i++){

                int j = i+1;
                int k = nums.length - 1;

                while( j<k){

                    if( Math.abs(target - result) > Math.abs( target - (nums[i]+nums[j]+nums[k]) )){
                        result = nums[i]+nums[j]+nums[k];
                    }
                    
                    if(nums[i]+nums[j]+nums[k] < target){
                        j++;
                    }
                    else{
                        k--;
                    }

                    
                }

            }


            System.out.println(result);

            */



        /*(6). Factorial of large number */
        
/*
        int n = 5;
        int fact=1;

        ArrayList<Integer> result = new ArrayList<>();

        while( n!=1) {
            fact *= n;
            n--;
        }


        while(fact>0){

            result.add( fact%10);
            fact = fact/10;
        }

        Collections.reverse( result);
        System.out.println(result);
            
        */
    

        /*(7). Next Permutation */

        /* 
        int nums[] = { 1, 3, 2};

        int golaIdx = -1;


        for(int i=nums.length-1; i>=0; i--){

            if( i-1>=0 && nums[i-1] < nums[i]){
                golaIdx = i-1;
                break;
            }
        }

        if(golaIdx!=-1){

            int swapIdx=golaIdx+1;

            for(int i=nums.length-1; i>=golaIdx+1; i--){
    
                if( nums[golaIdx] < nums[i] ){
                    swapIdx = i;
                    break;
                }
            }

            //swap it
            int temp = nums[golaIdx];
            nums[golaIdx] = nums[swapIdx];
            nums[swapIdx] = temp;

        }



        //reverse an array
        int i=golaIdx+1;
        int j=nums.length-1;
        while( i <= j){

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }


        //answer print
        for(int x=0; x<nums.length; x++){
            System.out.print(nums[x]+" ");
        }

        */

        /*(8). Rotate Image */

        /* 
        int matrix[][] = { { 1, 2, 3} , { 4 , 5 ,6} , { 7, 8, 9} };


        //Transpose
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    

        //reverse columns
        for(int i=0; i<matrix.length; i++){
            
            int j=0;
            int k=matrix.length-1;

            while( j<=k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }

        
        //answer print
        for(int i=0 ;i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        */


        /*(9). Container with Most Water */

        /*(i). Approach:1 :- Brute force  O(n^2) */

        /* 
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        int mostWater = 0;

        for(int i=0; i<height.length; i++){
            for(int j=i; j<height.length; j++){

                int width = j-i;
                int minHeight = Math.min( height[i], height[j]);

                mostWater = Math.max( mostWater, width*minHeight);
            }
        }

        System.out.println(mostWater);

        */

        /*(ii). Approach:2 :- 2-pointers approach  O(n)  */

        /* 
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        int mostWater = 0;

        int i=0;
        int j=height.length-1;
        
        while( i<j){

            mostWater = Math.max( mostWater, (j-i)*Math.min( height[i], height[j]) );

            if( height[i]<=height[j]){
                i++;
            }
            else{
                j--;
            }
        }

        System.out.println(mostWater);

        */


        /*(10). Spiral Matrix */

        /* 
        int matrix[][] = { { 1, 2, 3}, { 4, 5, 6}, { 7, 8, 9}};

        List<Integer> result = new ArrayList<>();

        int left=0;
        int right = matrix[0].length-1;

        int top = 0;
        int bottom = matrix.length-1;

        int direction = 0;

        while ( left<=right && top<=bottom ) {

            if(direction==0){

                for(int i=left; i<=right; i++){
                    result.add( matrix[top][i]);
                }

                top++;
            }

            if(direction==1){

                for(int i=top; i<=bottom; i++ ){
                    result.add( matrix[i][right]);
                }

                right--;
            }

            if(direction==2){

                for(int i=right; i>=left; i--){
                    result.add( matrix[bottom][i]);
                }

                bottom--;
            }

            if(direction==3){

                for(int i=bottom; i>=top; i--){
                    result.add( matrix[i][left]);
                }

                left++;
            }

            direction++;

            if(direction==4){
                direction=0;
            }

        }

        System.out.println(result);

        */


        /*(11). Group Anagrams */

        /*(i). with sorting          O(N*k*logK)  and space:O(n) */          /* N is array loop and k is string size and klogk is time it sort the array*/
        /* 
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };

        HashMap<String, List<String>> hm = new HashMap<>();

        //this is required for sorting the array of characters
        char tempArray[];

        for(int i=0; i<strs.length; i++){
            
            tempArray = strs[i].toCharArray();
            Arrays.sort(tempArray);

            //create sorted string
            String newStr = new String(tempArray);

            //keys are same for same string and values are added as list
            if( hm.containsKey( newStr)){
                hm.get( newStr).add( strs[i]);
            }
            else{
                hm.put( newStr, new ArrayList<>());
                hm.get( newStr).add( strs[i]);
            }
            
        }

        
        //convert hashmap to list
        List<List<String>> result = new ArrayList<>();
        for(String str: hm.keySet()){
            result.add( hm.get( str));
        }


        System.out.println(result);

        */
     
        /*(ii). without sorting just take an character array.  time complexity:- O(N*K) { N is array length and K is string length} and space complexity:- O(N)*/

        /* 
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };

        HashMap< String, List<String>> hm = new HashMap<>();

        //add counts of string element in an array
        for(int i=0; i<strs.length; i++){

            int alpha[] = new int[26];
            for(int j=0; j<strs[i].length(); j++){
                alpha[ strs[i].charAt(j) - 'a'] += 1;
            }
            

            StringBuilder tempStr = new StringBuilder();

            for(int j=0; j<alpha.length; j++){

                while( alpha[j]>0){
                    tempStr.append( (char)(j +'a'));
                    alpha[j]--;
                }
                
            }
            
            if(hm.containsKey( tempStr.toString())){
                hm.get( tempStr.toString()).add( strs[i]);
            }
            else{
                hm.put( tempStr.toString(), new ArrayList<String>());
                hm.get( tempStr.toString()).add( strs[i]);
            }
            
        }



        //convert hashmap to list
        List<List<String>> result = new ArrayList<>();

        for(String str: hm.keySet()){
            result.add( hm.get( str));
        }


        System.out.println(result);

        */

        /*(11). Sort the Matrix Diagonally */

        /* 
        int mat[][] = { { 3, 3, 1, 1 } , { 2, 2, 1, 2} , { 1, 1, 1, 2} };

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();

        // add values to the hashmap 
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                
                if( hm.containsKey( i-j)){
                    hm.get(i-j).add( mat[i][j]);
                }
                else{
                    hm.put( i-j, new ArrayList<Integer>());
                    hm.get(i-j).add( mat[i][j]);
                }
            }
        }

        //now sort each hashmap arraylist
        for(int key: hm.keySet()){
            Collections.sort( hm.get( key));
        }


        //add sorted values from hashmap to original 2D array
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){

                mat[i][j] = hm.get(i-j).removeFirst();
            }
        }

        //print the output
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        */

        /*(12). Diagonal Traverse */

        /* 
        int mat[][] = { { 1, 2, 3 } , { 4, 5, 6} , { 7, 8, 9 } };

        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                
                if(hm.containsKey( i+j)){
                    hm.get( i+j).add( mat[i][j]);
                }
                else{
                    hm.put( i+j, new ArrayList<Integer>());
                    hm.get( i+j).add( mat[i][j]);
                }
            }
        }

        //now reverse odd keys hashmap arraylist
        for(int key: hm.keySet()){
            if( key%2==0){
                Collections.reverse(( hm.get( key)));
            }
        }

        int result[] = new int[mat.length*mat[0].length];

        int x=0;
        //add values from hashmap to result array
        for(int key: hm.keySet()){
            
            while( hm.get( key).size() > 0){
                result[x] = hm.get( key).removeFirst();
                x++;
            }
        }

        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }

        */

        /*(13). Sort Colors  ( contain tree colors :- (0)(red) ,(1)(white) ,(2)(green) )   (without using sort functions) */
        
        /*(i). Approach:1 :-  O(2*N) (good approach) */
        /* 
        int nums[] = { 2, 0, 2, 1, 1, 0};

        int countArray[] = new int[3];

        //count each element and add count in 0, 1, 2 index
        for(int i=0; i<nums.length; i++){
            countArray[ nums[i]]++;
        }

        int x=0;
        for(int i=0; i<countArray.length; i++){
            
            while( countArray[i] > 0){
                nums[x] = i;
                countArray[i]--;
                x++; 
            }
        }

        for(int i=0; i<nums.length; i++){
            
           System.out.print(nums[i]+" ");
        }

        */

        /*(ii). Approach:2 :- O(N) ( best approach) */

        /* 
        int nums[] = { 2, 0, 2, 1, 1, 0};

        int i=0;  //denotes for 0
        int j=0;  //denotes for 1
        int k=nums.length-1;  //denotes for 2

        while( j<=k){

            if(nums[j]==2){
                swap( nums, j, k);
                k--;
            }
            else if(nums[j]==1){
                j++;
            }
            else{
                swap( nums, i, j);
                i++;
                j++;
            }
        }

        for(int x=0; x<nums.length; x++){
            System.out.print(nums[x]+" ");
         }

         */

        /*(14). Find Original Array From Doubled Array  */

        /* 
        // int changed[] = { 1, 2, 3, 4, 4, 6, 8, 8};
        // int changed[] = { 1, 3, 4, 2, 6, 8};
        // int changed[] = { 0, 0 ,0 , 0};
        // int changed[] = { 0, 0, 3};
        // int changed[] = { 6, 3, 0, 1};
        int changed[] = { 4, 4, 16, 20, 8, 8, 2, 10};

        HashMap<Integer,Integer> hm = new HashMap<>();
    
        //sort the array first
        Arrays.sort(changed);
        
        //count for each 
        for(int i=0; i<changed.length; i++){
            hm.put( changed[i], hm.get(changed[i])==null ? 1 : hm.get( changed[i]) + 1);
        }
    
    
        int result[] = new int[changed.length/2];
        int x=0;
    
        //check if odd length of 0, then return empty array
        if( hm.containsKey(0) && hm.get(0)%2!=0){
            // return new int[0];
            System.out.println(" return empty array");
        }
    
        // hashmap count check
        for(int i=0; i<changed.length; i++){
    
            //if zero
            if( ( changed[i]*2 == 0) && (changed[i] == 0) && (hm.get(changed[i]) > 1)  ){
                    hm.put( changed[i], hm.get( changed[i])==1 ? 0 : hm.get( changed[i])-2);
                    result[x++] = changed[i];
                }
            
            
            if( hm.containsKey( changed[i]*2)){
    
                if(hm.get( changed[i]*2) > 0 && hm.get( changed[i]) > 0){
                    hm.put( changed[i]*2, hm.get( changed[i]*2)==1 ? 0 : hm.get( changed[i]*2)-1);
                    hm.put( changed[i], hm.get( changed[i])==1 ? 0 : hm.get( changed[i])-1);
                    result[x++] = changed[i];
                }
            }
        }
    
        //if their is any count value greater than 0, then return empty array
        for( int key: hm.keySet()){
            
            if( hm.get( key) > 0){
                // return new int[0];
                System.out.println(" return empty array");
            }
        }
    
        //length should be half of an array
        if( x!= changed.length/2){
            // return new int[0];
            System.out.println(" return empty array");
        }
        else{
            // return result;

            //print answer
            for(int i=0; i<x; i++){
                System.out.print(result[i]+" ");
            }
        }

        */

        /*(15). Sum of Even Numbers After Queries */

        /*(i). Brute Force:- O(N^2) */
        /* 
        int nums[] = { 1, 2, 3, 4};
        int queries[][] = { { 1, 0}, { -3, 1}, { -4, 0}, { 2, 3}};

        int result[] = new int[nums.length];
        int x=0;
 
        for(int i=0; i<queries.length; i++){
            
            nums[ queries[i][1]] += queries[i][0];
            
            int sum=0;
            for(int j=0; j<nums.length; j++){
                
                if( nums[j]%2==0){
                    sum += nums[j];
                }
            }

            result[x++] = sum;
        }

        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }

        */
    
        /*(ii). Better approach O(N) */

        /* 
        int nums[] = { 1, 2, 3, 4};
        int queries[][] = { { 1, 0}, { -3, 1}, { -4, 0}, { 2, 3}};

        int result[] = new int[nums.length];
        int x=0;

        //find sum of all even numbers
        int sum=0;
        for(int i=0; i<nums.length; i++){

            if(nums[i]%2==0){
                sum += nums[i];
            }
            
        }

        
        for(int i=0; i<queries.length; i++){

            //before calculation remove current value from sum , if it is even
            if( nums[ queries[i][1]]%2==0){
                sum -= nums[ queries[i][1]];
            }


            nums[ queries[i][1]] += queries[i][0];

            //after calculation add if it is even number after calculation
            if( nums[queries[i][1]]%2==0){ 
                sum += nums[queries[i][1]]; 
            }

            //add sum to result after calculation
            result[x++] = sum;
            
        }

        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }

        */


        /*(16). Find Pivot Index*/
            
          /*(i). O(N^2) Brute Force */

          /* 
          int nums[] = { 1, 7, 3, 6, 5, 6};
          int pivotIdx = -1;

          for(int i=0; i<nums.length; i++){

            int leftSum=0, rightSum=0, j=0, k=nums.length-1;

            //find leftSum
            while(j<i){
                leftSum += nums[j];
                j++;
            }

            //find rightSum
            while(i<k){
                rightSum += nums[k];
                k--;
            }

            System.out.println(" i "+i+" left "+leftSum+" right "+rightSum);

            if( leftSum == rightSum){
                pivotIdx = i;
                break;
            }

          }

          System.out.println("the pivot index is "+pivotIdx);

        */

          /*(ii). Time:- O(N) and Space:- O(N)*/

          /* 

        //   int nums[] = { 1, 7, 3, 6, 5, 6};
        //   int nums[] = { 1, 2, 3};
          int nums[] = { -1, -1, 0, 1, 1, 0};
        //   int nums[] = { 2, 1, -1};
          int pivotIdx = -1;

          //find all sum count for each index in increasing order
          int temp[] = new int[nums.length];
          int totalSumFromIdx = 0;

          for(int i=0; i<nums.length; i++){
            totalSumFromIdx += nums[i];
            temp[i] = totalSumFromIdx;
          }

          //if right side sum is 0 and element at 0 index in left side 
          if( 0 == ( temp[nums.length-1]-nums[0]) ){
              pivotIdx = 0;
          }
          //if left side sum is 0 and element at nums.length-1 index in right side 
          else if( 0==( temp[nums.length-2])){
              pivotIdx = nums.length-1;
          }
          else{

              //now find for each
              for(int i=0; i<nums.length; i++){

                if( ( -1<i-1 ) && ( i+1<nums.length ) && temp[i-1] == (temp[nums.length-1]-temp[i-1]-nums[i])){
                    pivotIdx = i;
                    break;
                }
              }
          }

          System.out.println("the pivot index is "+pivotIdx);

          */


        /*(17). Increasing Triplet Subsequence */

        /* 
        int nums[] = { 2, 1, 5, 0, 4, 6};
        boolean isTrue = false;

        int num1=Integer.MAX_VALUE, num2=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){

            if( num1>=nums[i]){
                num1 = nums[i];
            }
            else if( num2>=nums[i]){
                num2 = nums[i];
            }
            else{
                isTrue = true;
                break;
            }
        }

        System.out.println(" is it true "+isTrue);

        */


        /*(18). Largest Perimeter Triangle  ( a triangle is satisfy when a+b>c, a+c>b, b+c>a )*/

        /* 
        int nums[] = { 1, 2, 1, 10};

        int maxPer = 0;
        
        //if we sort the array then we just need to check one condition, others are satisfied
        Arrays.sort( nums);
        
        for(int i=nums.length-1; i>=2; i--){

            if( ( nums[i-2]+nums[i-1])  > nums[i]){    // a+b>c
                maxPer = Math.max( maxPer, nums[i-2]+nums[i-1]+nums[i]);
            }
        }

        System.out.println("the max perimeter is "+maxPer);

        */



    }
}
