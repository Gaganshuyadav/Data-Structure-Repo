package zjavaDSAtemp;

import java.util.ArrayList;

public class Temp {
    
    public static void main(String[] args) {
        
        /*(1). Maximum Frequency Character */

        /* 
        String str = new String("aabbbbcccccc");

        int count[] = new int[26];

        for(int i=0; i<str.length(); i++){
            
            count[str.charAt(i)-'a']++;
        }
      

        char ans=' ';
        int max = 0;
        for(int i=0; i<count.length; i++){
            if( max < count[i]){
                ans = (char)(i+'a');
                max = count[i];
            }
        }

        System.out.println(ans);

        */
        
        /*(2). Spirally traversing a matrix */

        /* 
        int arr[][] = { { 1, 2, 3, 4}, { 5, 6, 7, 8}, { 9, 10, 11, 12}, { 13, 14, 15, 16} };
        int top=0, bottom=arr.length-1;
        int left=0, right=arr[0].length-1;
        int directive=0;
        ArrayList<Integer> result = new ArrayList<>();

        while( top<=bottom && left<=right){

            if(directive==0){

                for(int i=left; i<=right; i++){
                    result.add( arr[top][i]); 
                }

                top++;
            }
            if(directive==1){

                for(int i=top; i<=bottom; i++){
                    result.add( arr[i][right]); 
                }

                right--;
            }
            if(directive==2){

                for(int i=right; i>=left; i--){
                    result.add( arr[bottom][i]); 
                }

                bottom--;
            }
            if(directive==3){

                for(int i=bottom; i>=top; i--){
                    result.add( arr[i][left]); 
                }

                left++;
            }

            if(directive==4){
                directive=0;
            }

            directive++;

            System.out.println(result);
            

        }

        System.out.println(result);

        */

        /*(3). Smallest number to make Array sum at most K by dividing each element */
        
        int arr[] = { 2, 3, 4, 9};
        int k=6;

        // int arr[] = { 5, 6, 7, 8};
        // int k=4;
        int maxSmallerKSum = 0;
        int maxSmallerK = 0;
        

        for( int i=0; i<arr.length; i++){

            int sum=0;
            for( int j=0; j<arr.length; j++){

                sum += arr[j]%arr[i]==0 ? arr[j]/arr[i] : ( arr[j]/arr[i]) + 1;
            }

            if( sum<=k && sum>maxSmallerKSum){
                maxSmallerKSum = sum;
                maxSmallerK = arr[i];
            }
        }

        System.out.println("Smallest number to make Array sum at most K by dividing each element is "+maxSmallerK);

    


    
    } 
    






}
