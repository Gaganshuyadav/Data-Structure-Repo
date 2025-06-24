import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        
        int[] arr = { 3, 43, 432, 234, 45, 34};
        int sum=0;

        // imperative approach( means to achieve a goal by providing a step-by-step sequence of instructions)
        for(int i=0; i<arr.length; i++){
            
            if( arr[i]%2==0){
                sum += arr[i];
            }
        }

        // System.out.println(" the answer "+sum);



        /* streams approach :- ( advantages:-   
            (i).readability, 
            (ii).flexibility( filtering, mapping, reducing), 
            (iii).parallelism( streams can be processed in parallel, which can provide a significant performance boost a large collections, with a far loop, you would have to write your own multi-threaded code to achieve parallelism, 
            (iv).Encapsulation( streams encourage encapsulation, as you can perform series of operations on a collection without modifying the original data. this can be help to prevent bugs and improve code reliability  )  )  
        */
        
        /*how to create stream */
            //convert list to stream
            List<String> list = Arrays.asList("apple","banana","cherry","guava");
            Stream<String> mylistStream = list.stream(); 
    
            //convert string array to stream
            String[] strArray = { "a", "b", "c", "d", "d"};
            Stream<String> myStrStream = Arrays.stream( strArray);
    
            //convert int array to stream ( first it converts Arrays.stream(arr) to IntStream and then boxed converts it to Stream<Integer>) 
            int[] intArray = { 32, 243, 43, 21, 12};
            Stream<Integer> myIntStream = Arrays.stream( intArray).boxed();
    
            //we can create a loop and give limit with stream
            Stream<Integer> limit = Stream.iterate( 0, n -> n + 1).limit(100);
    
            //we can generate numbers with limit
            Stream<Integer> limit2 = Stream.generate( () -> (int) Math.random()*100 ).limit(100);
    
            Stream<Integer> myStreamInt2 = Arrays.stream( arr).boxed();
             
        /*how to use stream */

        /*Example:1 methods */
        List<Integer> tempIntList = Arrays.asList( 2, 23, 3, 23, 0, 2, 5, 6, 1, 32, 0, 42, 47, 0, 5, 423, 54, 65 );
        //in this , firstly list is comvert to stream and then we use collect to convert stream to a list again 
        List<Integer> filteredList = tempIntList.stream().filter( x-> x % 2 == 0).collect( Collectors.toList());
        List<Integer> MapFilteredList = filteredList.stream().map( x-> x*x ).collect( Collectors.toList());
        List<Integer> MapFilteredDistinctList = MapFilteredList.stream().distinct().collect( Collectors.toList());
        // System.out.println( tempIntList);
        // System.out.println(filteredList);
        // System.out.println(MapFilteredList);
        // System.out.println(MapFilteredDistinctList);
        

        /*Example:2 multiple in single*/
        List<Integer> MapFtrDisSLSAllInOne = tempIntList
                                                .stream()
                                                .filter( x->x%2==0)
                                                .map( x->x*x)
                                                .distinct()
                                                .sorted((a,b)->b-a)
                                                .limit(4)
                                                .skip(1)
                                                .collect( Collectors.toList());
        // System.out.println(MapFtrDisSLSAllInOne);

 
        /*Example:3 iterate*/
        List<Integer> iterateList = Stream
                                        .iterate( 0, x-> x + 1)
                                        .limit(101)
                                        .skip(10).
                                        map(x->x/2)
                                        // .peek( x->System.out.print(x+" "))
                                        .distinct()
                                        .sorted()
                                        // .peek(x->System.out.print(x+" "))
                                        .collect( Collectors.toList());
        // System.out.println(iterateList);



        /*Example:4 max*/
        Integer iterateFindMax = Stream
                                    .iterate( 0, x-> x + 1)
                                    .limit(101)
                                    .skip(10)
                                    .map(x->x/2)
                                    .distinct()
                                    .max( ( a, b)->( a-b ))
                                    .get();
                                        
        // System.out.println(iterateFindMax);


        /*Example:4 count*/
        Long iterateFindCount = Stream
                                    .iterate( 0, x-> x + 1)
                                    .limit(101)
                                    .skip(10)
                                    .map(x->x/2)
                                    .distinct()
                                    .count();
                                        
        System.out.println(iterateFindCount);

        /*Example:5 parallel stream */
        List<Integer> pList = Arrays.asList(1,2,3,4,5);

        System.out.println( pList.parallelStream().map(x->x*4).collect( Collectors.toList()) );


        



    }   
}



