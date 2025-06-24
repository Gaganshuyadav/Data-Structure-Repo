package Stack;
import java.util.*;

//implementations for Stack
/*
public class Stack1 {
    //(1).implemention with stack
    static class StackArrayList{
        static ArrayList<Integer> list = new ArrayList<>();

        //isEmpty
        public static Boolean isEmpty(){
            return list.size() == 0;
        } 

        //push
        public static void push(int data){
            list.add(data);
        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove( list.size()-1);
            return top;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
     
    //(2).implemention with Linklist
     static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
     }
    static class StackNode{
       static Node head = null;
        //isEmpty
        public static boolean isEmpty(){
            return head==null;
        } 

        //push
        public static void push(int data){
            if(head==null){
                Node newNode = new Node(data);
                head = newNode;
                return;
            }
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;

        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next; 
            return top;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    
    public static void main(String args[]) {
        //(1).implementaion with Stack
      
        // System.out.println("Stack with ArrayList");
        // StackArrayList s= new StackArrayList();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // //print all
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
       

        //(2).implementation with Node

        // System.out.println("Stack with LinkList");
        // StackNode n = new StackNode();
        // n.push(1);
        // n.push(2);
        // n.push(3);
        // n.push(4);
        // while(!n.isEmpty()){
        //     System.out.println(n.peek());
        //     n.pop();
        // }
        
    
        //(3).implementation with java collections framework
        
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // while(!s.empty()){
        //     System.out.println(s.peek());
        //     s.pop();
            
        // }
        

    }
}
*/


//Questions with stack
public class Stack1 {
    //(1). Push at the Bottom of the stack
    public static void pushAtBottom(Stack<Integer> stk, int data){
        if(stk.empty()){
            stk.push(data);
            return;
        }
        int top = stk.pop();
        pushAtBottom(stk, data);
        stk.push(top);
    }
    //(2). reverse a String using a Stack
    public static void reverseString(String str){
        //use stack
        Stack<String> stk = new Stack<>();

        //push string one by one to stack
        for(int i=0;i<str.length();i++){
            stk.push( str.substring(i, i+1));
        }

        //pop string one by one from stack
        StringBuilder strb = new StringBuilder("");
        while(!stk.empty()){
            strb.append(stk.peek());
            stk.pop();
        }
        System.out.println(strb);
    }
    //(3). reverse a Stack 
    public static void reverseStack(Stack<Integer> stk){
        if(stk.empty()){
            return;
        }
        int top = stk.pop();
        reverseStack(stk);
        pushAtBottom(stk,top);
        
    }
    public static void print(Stack<Integer> stk) {
        while(!stk.empty()){
            System.out.println(stk.pop());
        }
    }
    //(4). Valid Parentheses
    public static boolean isValidParenthesis(Stack<Character> stk, String str){

        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            
            //opening
            if(ch=='(' || ch=='{' || ch=='['){
                stk.push(ch);
            }
            else{
                //means it starts with },),] or any other value or character which are not allowed
                if(stk.empty()){
                    return false;
                }
                
                //closing [],(),{}
                if( (stk.peek()=='(' && ch==')') || (stk.peek()=='[' && ch==']') || ( stk.peek()=='{' && ch=='}') ){
                    stk.pop();
                }
                //means their is any  other character which is not allowed
                else{
                    return false;
                }
            
            }
            
        }

        if(stk.empty()){
            return true;
        }
        else{
            return false;
        }
    }
    //(5). Deplicate Parentheses 
    public static boolean isDuplicateParenthesis(Stack<Character> stk, String str){
        
        for(int i=0; i<str.length(); i++){

            char ch = str.charAt(i);

            //closing pair find
            if( ch==')' ){
                int count=0;
                while( stk.peek()!='(' ){
                    count++;
                    stk.pop();
                }
                if(count<1){
                    //duplicate
                    return true;
                }
                else{
                    //opening pair remove
                    stk.pop();
                }
            }
            else{
                //opening ( adding all characters)
                stk.push(ch);
            }
        }
        return false;
    
    }
    
    //(32). Parsing A Boolean Expression
    public static Character giveLogicallySolvedBoolean(Character ch, StringBuilder strO){

        //and logic
        if(ch=='&'){

            for(int i=0; i<strO.length(); i++){

                if(strO.charAt(i)=='f'){
                    return 'f';
                }
            }

            return 't';
        }
        //or logic
        else if(ch=='|'){

            for(int i=0; i<strO.length(); i++){

                if(strO.charAt(i)=='t'){
                    return 't';
                }
            }

            return 'f';
        }
        // not logic
        else{
            if(strO.charAt(0)=='f'){
                return 't';
            }
            else{
                return 'f';
            }
        }
    }
    public static void main(String args[]) {
        //(1). Push at the Bottom of the stack
        /* 
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);

        pushAtBottom(stk,8);

        while(!stk.empty()){
            System.out.println(stk.peek());
            stk.pop();
        }
        
        */

        //(2). reverse a String using a Stack

        // String str = new String();
        // reverseString( "apple"); 

        //(3). reverse a Stack             ---(without using extra stack)
    
        /*
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(1); stk.push(2); stk.push(3); stk.push(4);
        
        reverseStack(stk);
        */
        
        //(4). Stock Span problem

        //(i). [first approach with array] if i do it with an array( O(n2)):-
        /*
        int stock[] = { 100, 80, 60, 70, 60, 85, 100};

        int maxSpan=1;
        for( int i=0;i<stock.length; i++){
            for(int j=i-1; j>=-1; j--){

                //if their is no previous high, all are lower
                if(j==-1){
                    maxSpan = i+1;  
                    break;
                }

                if(stock[j] > stock[i]){
                    //span = high - prevHigh
                    maxSpan = i-j;
                  
                    break;
                    
                }

                
    
            }
            System.out.println("maxSpan "+maxSpan);
           
        }
        System.out.println(maxSpan);

        */
        
        //(ii). [second approach with stack]( O(n))
        /*
        Stack<Integer> stk = new Stack<Integer>();
        // int stock[] = { 10, 4, 5, 90, 120, 80};
        int stock[] = { 100, 80, 60, 70, 60, 75,85};

        int span[] = new int[stock.length];  

        
        for(int i=0; i< stock.length; i++){

            while( !stk.empty() && stock[stk.peek()] <= stock[i] ){
                stk.pop();
            }

            if(stk.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevMax = stk.peek();
                span[i] = i - prevMax;
            }

            stk.push(i);
        }
      
        //check answers
        for(int i=0;i<stock.length;i++){
            System.out.println(span[i]);
        }

        */

        //(5). Next Greater Element Problem:- the next greator element of some element x in an array is the first greater element that is to the right of x in the same array
        
         //(i). [first approach with array] if i do it with an array( O(n2)):-
         /* 
        int arr[] = { 6, 8, 0, 1, 3};
        int ans[] = new int[arr.length];

        for(int i=0;i<arr.length;i++){
          for(int j=i+1;j<arr.length;j++){
            if(arr[i]<arr[j]){
                ans[i]=arr[j];
                break;
            }
            ans[i]=-1;
          }
          
        }
        */

        //(ii). [second approach with stack]( O(n))
        /* THis logic can solve 4 types of questions:- next Greater Right, next Greater Left, next Smaller Right, next Smaller Left */
        
        /*next greater left */
        
        /* 
        int arr[] = { 6, 8, 0, 1, 3};
        int ans[] = new int[arr.length];

        Stack<Integer> stk = new Stack<>();
 
        for(int i= arr.length-1; i>=0; i--){

            //remove values which are lesser than current element from stack
            while( !stk.empty() && arr[stk.peek()]<arr[i]){
                stk.pop();
            }   

            //empty means no greater value than current value
            if(stk.empty()){
                ans[i] = -1;
            }
            else{
                //greater value than current but lesser than others
                ans[i] = arr[stk.peek()];
            }

            stk.push(i);
        }

        for(int i=0; i<arr.length;i++){
            System.out.println(ans[i]);
        }
        
        */
        

        //(6). Valid Parentheses -(O(n))
        /*
        String str= "{(){}[]}{}";
        Stack<Character> stk = new Stack<>();

        System.out.println(isValidParenthesis(stk,str));
        */

        //(7). Deplicate Parentheses -(O(n))
        /* 
        String str= "(((a+b)+(a+b)))";
        Stack<Character> stk = new Stack<>();
  
        System.out.println(isDuplicateParenthesis(stk,str));
        */

        //(8). Max Area in Histogram -(O(n))
        /*
        int heights[] = { 2, 1, 5, 6, 2, 3};
       
        int left[] = new int[heights.length];
        int right[] = new int[heights.length];

        Stack<Integer> rightSTK = new Stack<>();
        Stack<Integer> leftSTK = new Stack<>();

        //find next smaller left
        for(int i=0; i<heights.length; i++){

            while( !leftSTK.empty() &&  heights[leftSTK.peek()] >= heights[i]){ 
                leftSTK.pop();
            } 

            if(leftSTK.empty()){
                left[i] = -1;
            }
            else{
                left[i] = leftSTK.peek();
            }

            leftSTK.push(i);

        }
        for(int i=0;i<left.length;i++){
            System.out.print(left[i]+" ");
        }

        //find next smaller right
        for(int i=heights.length-1; i>=0; i--){

            while( !rightSTK.empty() && heights[rightSTK.peek()] > heights[i]){
                rightSTK.pop();
            }

            if(rightSTK.empty()){
                right[i] = heights.length;
            }
            else{
                right[i] = rightSTK.peek();
            }

            rightSTK.push(i);
        }

        System.out.println();
        for(int i=0;i<right.length;i++){
            System.out.print(right[i]+" ");
        }

        //find Max Area in Histogram
        int maxArea=0;
        for(int i=0; i<heights.length;i++){

            //width*height and width=(j-i-1) and height[index];
            int area = (heights[i]*(right[i]-left[i]-1));
            if(maxArea< area){
                maxArea = area;
            }

        }

        System.out.println("the max area is "+maxArea);
        */

        //(9). Trapping Rain Water using Stack -(O(n))

        /* 
        int height[] = { 9, 1, 4, 0, 2, 8, 6, 3, 5};
        Stack<Integer> stk = new Stack<>();


        int totalTrappingWater = 0;
        for(int i=0; i<height.length; i++){
            while( !stk.empty() &&  height[i] > height[stk.peek()] ){
                int top = height[stk.pop()];
                int width = i - stk.peek() - 1 ;
                int minHeight = Math.min( height[i] , height[stk.peek()]) - top ;
                System.out.println("the "+minHeight*width);
                totalTrappingWater += minHeight*width;
            }

            stk.push(i);

        }
        
        System.out.println("the total Trapping Water is "+totalTrappingWater);
        */
    
        //(10). Decode string

        /*
        String str = new String("2[ab4[c]3[r]]");
        Stack<Integer> numStk = new Stack<>();
        Stack<String> strStk = new Stack<>();

        for(int i=0; i<str.length(); i++){
            
            Character ch= str.charAt(i);
            if(ch==']'){
                
                StringBuilder strB = new StringBuilder();
                
                while( !strStk.empty() && strStk.peek().charAt(0)!='['){
                    strB.insert(0,strStk.peek());
                    strStk.pop();
                }

                StringBuilder strTemp = new StringBuilder();

                if(!numStk.empty()){
                    for(int j=0; j<numStk.peek(); j++){
                        strTemp.append(strB);
                    }  
    
                    numStk.pop();   // pop num from num stack
                    strStk.pop();   // remove '['
                    strStk.push(strTemp.toString());
                }
            
            }
            else{
                try{
                    numStk.push(Integer.parseInt(ch.toString()));   //agar number string hai to number stack main push ho jayegi warna error ki wajah sa string stack main push hogi
                    numStk.peek();
                }
                catch(NumberFormatException err){
                    strStk.push(ch.toString());
                }
                
            }
        }

        System.out.println(strStk);
        */
    
        //(11).  Simplify the directory Path( Unix like)
        
        /*

        //test cases:--
        
        // String str = new String("/a//b//c///////d");
        String str = new String("//a/./b/../../c/");
        // String str = new String("/../../../../../a");
        // String str = new String("/a/./b/./c/./d/");
        // String str = new String("/a/../.././../../.");
        // String str = new String("/a//b//c//////d");
        // String str = new String("/home/");

    

        Stack<String> strStk = new Stack<>();

        //split this string
        String newStr[] = str.split("/");


        for(int i=0;i<newStr.length;i++){

            if( newStr[i].equals("") || newStr[i].equals(".")){
                continue;
            }
            else if( newStr[i].equals("..")){
                if(!strStk.empty()){
                    strStk.pop();
                } 
                continue;
                    
            }
            else{
                strStk.push( newStr[i]);
            }

        }
            

        if(strStk.empty()){
            strB.append("/");
        }

        StringBuilder strB = new StringBuilder();
        while(!strStk.empty()){
            strB.insert(0, strStk.pop());
            strB.insert(0, "/");
        }

        System.out.println(strB);

        */


        //(12). if linkedlist is palindrome or not
        
        /* 
        Stack<Character> stkCh = new Stack<>();

        LinkedList<Character> ll = new LinkedList<Character>();
        ll.add('A');ll.add('B');ll.add('C');ll.add('B');ll.add('A');


        //push character in linklist
        for(Character llCh : ll){
            stkCh.push(llCh);
        }

        //compare stack and linklist
        Boolean check=true;
        for(Character llCh: ll){
            if(llCh!=stkCh.peek()){
                check=false;
            }
            stkCh.pop();
        }

        System.out.println(check);

        */

        //(13). Sum of Subarray Minimum

        //(i). [first approach with array] ( O(n2)):-
        /*
         
        int arr[] = { 3, 1, 2, 4};
        int min = 0;
        int answer = 0;
        
        for(int i=0; i<arr.length; i++){
            min = arr[i];
            answer += arr[i];
            for(int j=i+1; j<arr.length; j++){
                min = Math.min( min, arr[j]);
                answer += min;
            }
            
        }

        System.out.println(answer);

        */

        //(ii). [second approach with stack] ( O(n)):-

        /* 

        // int arr[] = { 71,55,82,55};
        int arr[] = { 2,1,3,1};
        int answer=0;

        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        int subArrayForEach[] = new int[arr.length];

        Stack<Integer> nsls = new Stack<>();
        Stack<Integer> nsrs = new Stack<>();

        //find next smaller left
        for(int i=0; i<arr.length; i++){
            while( !nsls.isEmpty() && arr[nsls.peek()] > arr[i]){
                nsls.pop();
            }

            if(nsls.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = nsls.peek();
            }

            nsls.push(i);
        } 


       
        //find next smaller right
        for(int i=arr.length-1; i>=0; i--){
            while( !nsrs.empty() && arr[nsrs.peek()] >= arr[i] ){
                nsrs.pop();
            }

            if(nsrs.empty()){
                nsr[i] = arr.length;
            }
            else{
                nsr[i] = nsrs.peek();
            }

            nsrs.push(i);
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(nsr[i]+" ");
        } 
        System.out.println();

        for(int i=0; i<arr.length; i++){
            System.out.print(nsl[i]+" ");
        }

    
        //find subarrays for each
        
        for(int i=0; i<arr.length; i++){
            subArrayForEach[i] = Math.abs((nsl[i]-i)*( nsr[i]-i));
        }
        System.out.println();

        for(int i=0; i<arr.length; i++){
            System.out.print(subArrayForEach[i]+" ");
        }

        for(int i=0; i<subArrayForEach.length; i++){
            answer += subArrayForEach[i]*arr[i];
        }

        System.out.println();
        System.out.println(answer);

        */

        //(14). Sum of Subarray ranges

        //(i). [first approach with array] ( O(n2)):-

        /* 
        int arr[] = { 1, 4, 3, 2};

        int max=0;
        int sum=0;

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                max = Math.max(max, arr[j]);
                sum += Math.abs(max-arr[i]);
            }

        }

        System.out.println(sum);

        */


        //(ii). [second approach with stack] ( O(n)):- 

        /* 
        int arr[] = { 1,2,3,4};
        
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        int nll[] = new int[arr.length];
        int nlr[] = new int[arr.length];

        Stack<Integer> tempStack = new Stack<>();

        //next smaller left
        for(int i=0; i<arr.length; i++){
            while(!tempStack.empty() && arr[tempStack.peek()] > arr[i]){
                tempStack.pop();
            }
            if(tempStack.empty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = tempStack.peek();
            }

            tempStack.push(i);
        }

        //clear stack
        while(!tempStack.empty()){
            tempStack.pop();
        }
        

        //next smaller right
        for(int i=arr.length-1; i>=0; i--){
            while(!tempStack.empty() && arr[tempStack.peek()] >= arr[i]){
                tempStack.pop();
            }
            if(tempStack.empty()){
                nsr[i] = arr.length;
            }
            else{
                nsr[i] = tempStack.peek();
            }

            tempStack.push(i);
        }

        //clear stack
        while(!tempStack.empty()){
            tempStack.pop();
        }


        //next larger left
        for(int i=0; i<arr.length; i++){
            while(!tempStack.empty() && arr[tempStack.peek()] < arr[i]){
                tempStack.pop();
            }
            if(tempStack.empty()){
                nll[i] = -1;
            }
            else{
                nll[i] = tempStack.peek();
            }

            tempStack.push(i);
        }

        //clear stack
        while(!tempStack.empty()){
            tempStack.pop();
        }


        //next larger right
        for(int i=arr.length-1; i>=0; i--){
            while(!tempStack.empty() && arr[tempStack.peek()] <= arr[i]){
                tempStack.pop();
            }
            if(tempStack.empty()){
                nlr[i] = arr.length;
            }
            else{
                nlr[i] = tempStack.peek();
            }

            tempStack.push(i);
        }

        //clear stack
        while(!tempStack.empty()){
            tempStack.pop();
        }


        //sum of subarray minimum and maximum
         int sumMin=0, sumMax=0;
         for(int i=0; i<arr.length; i++){
            sumMin += arr[i]*((i-nsl[i])*(nsr[i]-i));
            sumMax += arr[i]*((i-nll[i])*(nlr[i]-i));
         }

        //the ranges of subarray is
        System.out.println(sumMax-sumMin);

        */


        //(15). Remove K digits      :- return the smallest possible integer after removing k digits from num

        //(i). [first approach with stack] with stack, ( O(n)):-
 

        /* 
        String nums = new String("10");
        int k=2;
        Stack<Character> tempStk = new Stack<>();
        StringBuilder ans = new StringBuilder("");

        if(nums.length()==k){
            ans.append("0");
            return;
        }


        for(int i=0; i<nums.length(); i++){

            Character ch = nums.charAt(i);
        
            if(tempStk.empty()){
                tempStk.push(ch);
            }
            else{
                while(!tempStk.isEmpty() && ( tempStk.peek()-'0') > ( nums.charAt(i)-'0') ){
                    
                    if(k!=0){
                       tempStk.pop();
                        k--;
                        
                    }
                    else{
                        break;
                        
                    }
                    
                }

                tempStk.push( nums.charAt(i));

            }
        }

        //if numbers are in increasing order
        while(k!=0){
            k--;
            tempStk.pop();
        }

        
        //if no element is left
        if(tempStk.empty()){
            ans.append("0");
        }
        else{
            //take values from stack and reverse it
            while(!tempStk.isEmpty()){
                ans.insert( 0, tempStk.pop());
            }
        }


        //if 0 are at the start then remove it
        while(ans.length() > 1 && ans.charAt(0)=='0'){
            ans.deleteCharAt(0);
        }

        System.out.println(ans);

        */


        //(16). Remove All Adjacent Duplicates In String ( easy problem)

        /* 
        String s = new String("abbaca"); 
        Stack<Character> tempStk = new Stack<>();
        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(! tempStk.empty() && tempStk.peek()==ch){
                tempStk.pop();
            }
            else{
                tempStk.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder("");
        while(!tempStk.empty()){

            ans.insert(0, tempStk.pop());
        }

        System.out.println(ans);

        */
   
        //(17). Basic Calculator

        /* 

        String str = new String("10-(4+5+2)-3+(6+8)");
        // String str = new String("1-1");

        int num = 0;
        int result = 0;
        int sign = 1; 

        Stack<Integer> tempStk = new Stack<>();


        for(int i=0; i<str.length(); i++){

            char ch = str.charAt(i);

            if( Character.isDigit(ch) ){

                num = (num*10) + ( ch - '0');

            }
            else if( ch=='+'){

                result += (sign*num);
              
                num = 0;
                sign = 1;
               

            }
            else if( ch=='-' ){

                result += (sign*num);
             
                num = 0;
                sign = -1;

             
                
            }
            else if( ch=='(' ){

                //add value and sign in stack
                tempStk.push(result);
                tempStk.push(sign);
             

                result = 0;
                num = 0;
                sign = 1;
            

            }
            else if( ch==')' ){

                //last digit add , the number which comes before ) bracket     ( bracket ka andar ka result).
                result += (sign*num);

             

                //remove from stack
                sign = tempStk.pop();

                result *= sign;
                result += tempStk.pop();

                sign = 1;
                num=0;
              
            }


        }



        //if their is any number left in num variable
        result += (sign*num);

        System.out.println(result);
        
        */

        /*(18). Evaluate Reverse Polish Notation */

        // String tokens[] = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        /* 
        String tokens[] = {"2","1","+","3","*"};

        Stack<Integer> tempStk = new Stack<>();

        for(int i=0; i<tokens.length; i++){

            if(tokens[i].equals("+")){

                int ans = tempStk.pop() + tempStk.pop();
                tempStk.push(ans);

            }
            else if(tokens[i].equals("-")){


                int ans = tempStk.pop() - tempStk.pop();
                tempStk.push(ans);
             
            }
            else if(tokens[i].equals("*")){

                int ans = tempStk.pop()*tempStk.pop();
                tempStk.push(ans);

            }
            else if(tokens[i].equals("/")){

                int f = tempStk.pop();
                int s = tempStk.pop();
                int ans = s/f;
                tempStk.push(ans);  
            }
            else{

                try{
                    if( Integer.parseInt(tokens[i]) < 0 ){
                        tempStk.push( Integer.parseInt(tokens[i]));
                    }
                    else{
                        tempStk.push( Integer.parseInt( tokens[i]));
                    }
                }
                catch(NumberFormatException err){
                    System.out.println("error in parseInt");
                }
                
                
            }
        }



        System.out.println(tempStk.pop());

        */

        /*(19). Daily Temperatures */

        /* 
        int temp[] = { 73, 74, 75, 71, 69, 72, 76, 73};
        Stack<Integer> tempStk = new Stack<>();

        int answer[] = new int[temp.length];

        for(int i=temp.length-1; i>=0; i--){

            while(!tempStk.empty() && temp[tempStk.peek()] <= temp[i]){
                tempStk.pop();
            }

            if(tempStk.empty()){
                answer[i] = 0;
            }
            else{
                answer[i] = tempStk.peek() - i;
            }

            tempStk.push(i);
        }
        
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]+" ");
        }

        */
        
        /*(20). Astroids Collision */

        /*
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
        */

        /*(21). Removing Stars From String */

        /* 
        String s = new String("leet**cod*e");

        Stack<Character> tempStk = new Stack<>();

        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(ch=='*'){

                if(!tempStk.empty()){
                    tempStk.pop();
                }
            }
            else{
                tempStk.push(ch);
            }
        }

        
        StringBuilder str = new StringBuilder("");
        while ( !tempStk.empty()) {
            str.insert(0, tempStk.pop());
        }

        System.out.println(str.toString());
        */

        /*(22). Validate Stack Sequence */

        /* 
        int pushed[] = { 1, 2, 3, 4, 5};
        int popped[] = { 4, 3, 5, 2, 1};
        Stack<Integer> stk = new Stack<>();
        int j=0;

        for(int i=0; i<pushed.length; i++){

            stk.push( pushed[i]);

            while(!stk.empty() && stk.peek()==popped[j]){
                stk.pop();
                j++;
            }

        }

        if(stk.empty()){
            System.out.println("valid");
        }
        else{
            System.out.println("not valid");
        }
        
        */

        /* (23). 132 Pattern Problem */

            /*(i). O(n^3) */

            /* 
            class Solution {
                public boolean find132pattern(int[] nums) {
                    for(int i=0; i<nums.length; i++){
                        for(int j=i+1; j<nums.length ; j++){
                            
                            if(nums[i]<nums[j]){
                                for(int k=j+1; k<nums.length; k++){
                                    if( nums[i]<nums[k] && nums[k]<nums[j]){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                    return false;
                }
            }
        
            */
        
            /*(ii). O(n^2) */

            /*
            class Solution {
                public boolean find132pattern(int[] nums) {
                    
                    int min = nums[0];
                        for(int j=1; j<nums.length ; j++){
                            min = Math.min( min, nums[j-1]);
                            if( min<nums[j]){
                                for(int k=j+1; k<nums.length; k++){
                                    if( min<nums[k] && nums[k]<nums[j]){
                                        return true;
                                    }
                                }
                            }
                        }
                    return false;
                }
            }
        */
        
            /*(iii). O(n) */
            /* 
            class Solution {
                public boolean find132pattern(int[] nums) {
                    
                    int min = Integer.MIN_VALUE;
                    Stack<Integer> stk = new Stack<>();
            
                    for(int i=nums.length-1; i>=0; i--){
                        if(nums[i] < min){
                            return true;
                        }
            
                        while( !stk.empty() && stk.peek() < nums[i] ){
                            min = stk.pop();
                        }
            
                        stk.push(nums[i]);
                    }
            
                    return false;
                }
            }
        */


        /* (24) Minimum Remove to Make Valid Parentheses*/
        
        /*(i). time:- O(n) and space:- O(n)*/

        /* 
        // String s = "lee(t(c)o)de)";
        // String s = "a)b(c)d";
        String s = "))((";
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> removeIdx = new Stack<>();

        for(int i=0; i< s.length(); i++){

            if(s.charAt(i)=='('){
                stk.push(i);
            }
            else if(s.charAt(i)==')'){
                if(stk.empty()){
                    removeIdx.push(i);
                }
                else{
                    stk.pop();
                }
            }
        }


        HashSet<Integer> hs = new HashSet<>();
        
        while(!stk.isEmpty()){
            hs.add(stk.pop());
        }

        while(!removeIdx.isEmpty()){
            hs.add(removeIdx.pop());
        }


        StringBuilder newString = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(!hs.contains(i)){
                newString.append(s.charAt(i));
            }
        }

        System.out.println(newString);

        */

        /*(ii). time:- O(n) and space:- O(n) */

        /* 
        String s = "lee(t(c)o)de(";
        // String s = "a)b(c)d";
        // String s = "))((";

        StringBuilder firstResult = new StringBuilder();
        int open = 0;

        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i)=='('){
                open++;
                firstResult.append(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                if(open>0){
                    firstResult.append(s.charAt(i));
                    open--;
                }
                else{

                }
            }
            else{
                firstResult.apped(s.charAt(i));
            }
        }


        StringBuilder finalResult = new StringBuilder();
        int close=0;

        for(int i=firstResult.length()-1; i>=0; i--){

            if(firstResult.charAt(i)==')'){
                close++;
                finalResult.insert(0, firstResult.charAt(i));

            }
            else if(firstResult.charAt(i)=='('){
                if(close>0){
                    close--;
                    finalResult.insert(0, firstResult.charAt(i));
                    
                }
                else{
                    
                }
            }
            else{
                finalResult.insert(0, firstResult.charAt(i));
            }
        }


        if(finalResult.isEmpty()){
            finalResult.append("");
        }
        

        */

        /* (25). Reverse Substrings Between Each Pair of Parentheses*/

        /*Approach:1:- Brute Force */

        /* 

        // String s = new String("(abcd)");
        // String s = new String("(u(love)i)");
        String s = new String("(ed(et(oc))el)");
        Stack<Character> stk = new Stack<>();
        Stack<Character> tempStk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);

            if(ch==')'){
               
                while(!stk.empty() && stk.peek()!='('){
                    tempStk.push(stk.pop());
                }

                stk.pop();

                while(!tempStk.empty() ){
                    stk.push(tempStk.removeFirst());
                }

            }
            else{
                stk.push(ch);
            }
        }

        StringBuilder strB = new StringBuilder();

        while(!stk.empty()){
            strB.insert(0, stk.pop());
        }

        System.out.println(strB);
        
        */


        /*Approach:2:- Warmhole Teleportation */

        /* 
        String s = new String("(ed(et(oc))el)");

        Stack<Integer> stk = new Stack<>();
        HashMap<Integer,Integer> hp = new HashMap<>();

        //store indexes like anywhere door
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(ch==')'){
                int j = stk.pop();
                hp.put(i, j);
                hp.put(j, i);
            }
            else if(ch=='('){
                stk.push(i);
            }
        }


        
        StringBuilder strB = new StringBuilder();

        int flag = 1;
        for(int i=0; i<s.length(); i+= flag){

            System.out.println(i);

            char ch = s.charAt(i);

            if( ch=='(' || ch==')'){

                i = hp.get(i);
                flag = -flag;
            }
            else{
                strB.append(ch);
            }
        }

        System.out.println(strB);
      
        */


        /*(26). Maximum Score From Removing Substrings */

        /*Approach:1:-  */
        /* 
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;



        int result = 0;
        String maxStr = ( x > y) ? "ab" : "ba";
        String minStr = ( x > y) ? "ba" : "ab";


        Stack<Character> stk  = new Stack<>();
        StringBuilder firstStrB = new StringBuilder();


            for(int i=0; i<s.length(); i++){
    
                char ch = s.charAt(i);
                
                if(!stk.empty() && stk.peek() == maxStr.charAt(0) && ch == maxStr.charAt(1)){
                    result += Math.max(x, y);
                    stk.pop();
                }
                else{
                    stk.push(ch);
                }
            }
    
            
    
            while(!stk.empty()){
                firstStrB.insert(0, stk.pop());
            }
            
    
    
            //old stack is empty and we have modified string
            for(int i=0; i<firstStrB.length(); i++){
    
                char ch = firstStrB.charAt(i);
    
                if(!stk.empty() && stk.peek() == minStr.charAt(0) && ch == minStr.charAt(1)){
    
                    result += Math.min(x, y);
                    stk.pop();
                }
                else{
                    stk.push(ch);
                }
            }

            System.out.println(result);

            */

        /*Approach:2:-  */
        
        /* 
        String s = "cdbcbbaaabab";
        StringBuilder strB1 = new StringBuilder(s);
        
        int x = 4, y = 5;
        int result = 0;

        String maxStr = ( x > y) ? "ab" : "ba";
        String minStr = ( x > y) ? "ba" : "ab";
        int maxVal = ( x > y ) ? x : y;
        int minVal = ( x > y) ? y : x;

        int i=0;
        for(int j=0; j<s.length(); j++){

            strB1.replace( i, i+1, s.substring(j, j+1));         //a[i] = a[j]

            i++;

            if(i>=2 && maxStr.charAt(0)==strB1.charAt(i-2) && maxStr.charAt(1)==strB1.charAt(i-1)){
                i = i - 2;
            }
        }


        result += ((s.length() - strB1.substring(0, i).length())/2)*maxVal ;
        System.out.println(strB1.substring(0,i));

        
        
        int k=0;
        StringBuilder strB2 = new StringBuilder(strB1.substring(0, i));
        for(int j=0; j<strB1.substring(0, i).length(); j++){

            strB2.replace( k, k+1, strB1.substring(j,j+1));
            k++;

            if( k>=2 && strB2.charAt(k-2)==minStr.charAt(0) && strB2.charAt(k-1)==minStr.charAt(1)){
                k -= 2;
            }

        }

        result += ((strB1.substring(0, i).length() - strB2.substring(0, k).length())/2) *minVal ;

        System.out.println("result "+result);

        */
       
        /*(27). Robot Collisions */

        /* 
        // int positions[] = { 3, 5, 2, 6 };
        // int healths[] = { 10, 10, 15, 12};
        // String directions = "RLRL";
        
        int positions[] = { 5,4,3,2,1};
        int healths[] = { 2,17,9,15,10};
        String directions = "RRRRR";

        // int positions[] = { 3,40};
        // int healths[] = { 49,11};
        // String directions = "LL";

        Integer indexes[] = new Integer[positions.length];

        //------SORT positions for finding their
        for(int i=0; i<positions.length; i++){
            indexes[i] = i;
        }


        Arrays.sort( indexes, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return positions[a] - positions[b];
            }
        });

        

        //-----collisions
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<directions.length(); i++){

            if( directions.charAt( indexes[i]) =='R'){
                stk.push( indexes[i]);
            }
            else{

                int top = Integer.MIN_VALUE;
                while(!stk.empty() && directions.charAt(stk.peek())=='R' && healths[stk.peek()] <= healths[indexes[i]]){
                    
                    if(healths[stk.peek()] == healths[indexes[i]]){
                        top = stk.pop();
                        break;
                    }

                    stk.pop();
                    healths[indexes[i]]--;  //health -1
                    
                }

                if( Integer.MIN_VALUE!=top && healths[top]==healths[indexes[i]]){

                }
                else if(!stk.empty() && directions.charAt( stk.peek())=='R' && healths[stk.peek()]>healths[indexes[i]]){
                    healths[stk.peek()]--;
                }
                else if(stk.empty()){
                    stk.push( indexes[i]);
                }
                else if(!stk.empty() && directions.charAt(stk.peek())=='L'){
                    stk.push( indexes[i]);
                }

            }

        }

        Integer healthArray[] = new Integer[stk.size()];
        int i=0;


        while(!stk.empty()){
            healthArray[i] = stk.pop();
            i++;
        }


        //sort again in the specific given positions
        Arrays.sort( healthArray, ( a, b)->a - b);

        
        List<Integer> healthList = new ArrayList<Integer>();

        for(i=0; i<healthArray.length; i++){
            healthList.add( healths[healthArray[i]] );
        }

        System.out.println(healthList);

        */

        /*(28). Number of Atoms */
        
        /* 
        String formula = "K4(ON(SO3)2)2";
        Stack<HashMap<String,Integer>> stk = new Stack<HashMap<String,Integer>>();
        int n = formula.length();

        int index=0;
        stk.push( new HashMap<String,Integer>());

      
        while(index<n){

            char ch = formula.charAt(index);

            if(ch=='('){

                stk.push( new HashMap<String,Integer>() );
                index++;
                
            }
            else if(ch==')'){
                
                HashMap<String,Integer> currMap = stk.pop();
                index++;

                //find multiplier ( after ending the bracket, is their is any number, which is the multiplier)
                StringBuilder multiplier = new StringBuilder();
                while( index < n && Character.isDigit( formula.charAt(index))){
                    multiplier.append( formula.charAt(index));
                    index++;
                }

                int m=0;
                //parse it to number if length is greater than 0
                if( multiplier.length() > 0){
                    m = Integer.parseInt(multiplier.toString());
                }

                //if multiplier is greater than 1, other wise no multiply to current heap 
                if(m > 1){
                    for(String atom : currMap.keySet() ){
                        currMap.put( atom, currMap.get(atom)*m);
                    }
                }

                //add previous hashmap stack( which is deleted currently)  to the downed stack hashmap
                for(String atom: currMap.keySet()){
                    if( stk.peek().containsKey(atom)){
                        stk.peek().put( atom, stk.peek().get(atom) + currMap.get(atom));
                    }
                    else{
                        stk.peek().put( atom, currMap.get(atom));
                    }
                }

            }
            else{

                //-----------capital
                StringBuilder atomName = new StringBuilder();
                atomName.append(ch);

                index++;

                //check for lower case , after capital   -----------lower case
                while( index < n && Character.isLowerCase( formula.charAt(index))){
                    atomName.append( formula.charAt(index));
                    index++;
                }

                //check for number(count) after name of atom -----------number
                StringBuilder count = new StringBuilder();

                while( index < n && Character.isDigit( formula.charAt(index))){
                    count.append( formula.charAt(index));
                    index++;
                } 


                int c=0;
                //if string length is greater than 0 , then parse it to integer
                if(count.length() > 0){
                    c = Integer.parseInt( count.toString());
                }

                //if c is not exist( so, take default count as 1)
                if(c < 1){
                    c = 1;
                }

                //if element exist in this current Heap previously than add value to it( Ex: N23O2N21) , otherwise if not exist previously just add count
                if( stk.peek().containsKey(atomName.toString())){
                    stk.peek().put( atomName.toString() , c + stk.peek().get( atomName.toString()));
                }
                else{
                    stk.peek().put(atomName.toString(), c);
                }

                



            }
        }


        TreeMap<String,Integer> sortedMap = new TreeMap<>(stk.peek());
        StringBuilder strB = new StringBuilder();

        for(String atom: sortedMap.keySet()){

            strB.append(atom);

            if(sortedMap.get(atom) > 1){
                strB.append( sortedMap.get(atom));
            }
            
        }
        System.out.println(strB);

        */

        /*(29). Minimum Deletions to make string balanced */

            /*(i). first approach */
            /* 
            String s = "aababbab";                 //ya 'a' delete mar ya 'b' delete mar( or dono agar saath main delete honga to dusra wala apna aap banace kar dega, phir chaha ussa rakh ya mat rakh),  
            Stack<Character> stk = new Stack<>();
            int count = 0;
    
            for(int i=0; i<s.length(); i++){
    
                char ch = s.charAt(i);
    
                if(!stk.empty() && ch=='a' && stk.peek()=='b'){
                    stk.pop();
                    count++;
                }
                else{
                    stk.push(ch);
                }
                
            }
            
            System.out.println("count "+count);
    
            */

            /*(ii). second approach , use 2 arrays( space( O(2n)))*/
            /* 

        String s = "aababbab";
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        int countA = 0;
        for(int i=0; i<s.length(); i++){
        
            arr1.add(countA);

            if(s.charAt(i)=='b'){
                countA++;
            }
            
            

        }

        int countB= 0;
        for(int i=s.length()-1; i>=0; i--){

            arr2.addFirst(countB);

            if(s.charAt(i)=='a'){
                countB++;
            }

            

        }

        System.out.println(arr1);
        System.out.println(arr2);
        //find minimum deletion
        int minDel = Integer.MAX_VALUE;

        for(int i=0; i<s.length();i++){

            int sum = arr1.get(i) + arr2.get(i);

            if( minDel > sum){
                minDel = sum;
            }
        }
        
        System.out.println(minDel);

        */

            /*(iii). better than second approach , use only 1 array( space( O(n) ))*/
            /* 
            String s = "aababbab";
            ArrayList<Integer> arr2 = new ArrayList<>();
    
            //right counts of 'a'
            int countB= 0;
            for(int i=s.length()-1; i>=0; i--){
    
                arr2.addFirst(countB);
    
                if(s.charAt(i)=='a'){
                    countB++;
                }
            }
    
    
            int countA=0;
    
            //find minimum deletion
            int minDel = Integer.MAX_VALUE;
    
            for(int i=0; i<s.length();i++){
    
                int sum = countA + arr2.get(i);
    
                if( minDel > sum){
                    minDel = sum;
                }
    
    
                if( s.charAt(i)=='b'){
                    countA++;
                }
            }
            
            System.out.println(minDel);
            */
    
            /*(iv). it is most optimal approach and better than first approach ( space( O(1))) */

            //firstly count the total number of a in right side( just like store in array)
            
            /* 
            String s = "aababbab";

            //count A firstly
            int countA=0;
            for(int i=0; i< s.length(); i++){
                if(s.charAt(i)=='a'){
                    countA++;
                }
            }

            int countB=0;
            int minDel = Integer.MAX_VALUE;
            for(int i=0; i<s.length(); i++){

                if(s.charAt(i)=='a'){
                    countA--;
                }

                int sum = countA + countB;

                if( minDel > sum){
                    minDel = sum;
                }


                if(s.charAt(i)=='b'){
                    countB++;
                }
            }

            System.out.println(minDel);

            */


        /*(30). Minimum Number of Swaps to Make String  Balanced*/

            /*(i) Just count the unbalanced one side paranthesis and ( even: count/2 (or) odd: (count+1)/2 ) [ use stack or simple variable] */

            // String s = "]]][[[";

            /* 
            String s = "][][";

            int count = 0;
            for(int i=0; i<s.length(); i++){

                char ch = s.charAt(i);

                if(ch=='['){
                    count++;
                }
                else{
                    if(count > 0){
                        count--;
                    }
                }
            }

            //divide by 2, for odd and even case
            
            //even
            if(count%2==0){
                System.out.println( count/2);
            }
            //odd
            else{
                System.out.println( (count+1)/2);
            }
            
            */


        /*(31). Minimum Add to Make Parantheses Valid*/

            /*(i).  [ using stack ]*/

            /* 

            String s = "(((";
            // String s = "()";

            Stack<Character> stk = new Stack<>();

            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);

                if(ch=='('){
                    stk.push( ch);
                }
                else{
                    if(!stk.empty() && stk.peek()=='('){
                        stk.pop();
                    }
                    else{
                        stk.push(ch);
                    }

                }
            }

            System.out.println(stk.size());

            */

            /*(ii). [ using variables ( open and close )]*/
            // String s = "(((";

            /* 
            String s = "()";

            int open = 0;
            int size = 0;

            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);

                if( ch=='('){
                    open++;
                    size++;
                }
                else{
                    if( open>0){
                        open--;
                        size--;
                    }
                    else{
                        size++;
                    }
                }

            }

            System.out.println(size);

            */
    
        /*(32). Parsing A Boolean Expression*/

            /*(i).*/

            /* 

            // String expression = "!(&(f,t))";
            String expression = "|(&(t,f,t),!(t))";
            Stack<Character> stkE = new Stack<>();

            for(int i=0; i<expression.length(); i++){
                char ch = expression.charAt(i);

                if(ch==')'){

                    StringBuilder strO = new StringBuilder();

                    while(!stkE.empty() && stkE.peek()!='('){
                        strO.append( stkE.pop());
                    }

                    stkE.pop(); //remove '(' operator

                    //operator &,|,!
                    Character exp = giveLogicallySolvedBoolean( stkE.pop(), strO);

                    stkE.push( exp);


                }
                else if(ch==','){

                }
                else{
                    stkE.push(ch);
                }

            }


            if(stkE.peek()=='t'){
                System.out.println(true);
            }
            else{
                System.out.println(false);
            }
            
            */

        /*(33). Check if a Parentheses String Can Be Valid*/

            /*(i). first approach with stack*/
            /* 
            String s = "))()))";
            String locked = "010100";

            boolean check = true;


            Stack<Integer> lockStk = new Stack<>();
            Stack<Integer> stk = new Stack<>();

            for(int i=0; i<s.length(); i++){

                //open-close bracket
                if(locked.charAt(i)=='0'){
                    lockStk.push(i);
                }
                //fix bracket
                else{
                    //open bracket
                    if( s.charAt(i)=='('){
                        stk.push(i);
                    }
                    //close bracket
                    else{

                        //check close bracket with stk
                        if(!stk.empty() && s.charAt(stk.peek())=='(' ){
                            stk.pop();
                        }
                        //check close bracket with openclose stk, check with index is smaller in lockStk
                        else if(!lockStk.empty() && i > lockStk.peek()){
                            lockStk.pop();
                        }
                        //the bracket is close and not balanceable
                        else{
                            check = false;
                        }
            
                    }
                        
                }
            }


            //after that you have stk and lockStk , if they are not empty then write conditions for it
            if(check!=false){

                //compare indexes of both 
                while( !stk.empty() && !lockStk.empty() && stk.peek() < lockStk.peek()){
                    lockStk.pop();
                    stk.pop();
                }
                
                
                //now after all conditions stk is not empty then false , otherwise check condition for lockStk
                if(!stk.empty()){
                    check = false;
                }
                else{
                    //after all, if locked stk contain evens than it will balanced otherwise if odd it will not balanced
                    if(lockStk.empty() || lockStk.size()%2==0){
                        check = true;
                    }
                    else{
                        check = false;
                    }

                }

           }

           System.out.println("check is : "+check);

           */
    
            /*(ii). second approach without stack  ( just use open and close count) */

            /*
            String s = "())))(()())(()()(((()";
            String locked = "000000000000000000000";

            boolean check = true;


            //in case if string length is 1
            if(s.length()%2!=0){
                check = false;
            }
            
            if(check!=false){
                int open = 0;
                //iterate from left to right    ( if close bracket is greater than this string is not balanced) 
                for(int i=0; i<s.length(); i++){
    
                    if(s.charAt(i)=='(' || locked.charAt(i)=='0' ){
                        open++;
                    }
                    else{
                        if(open>0){
                            open--;
                        }
                        else{
                            check = false;
                            break;
                        }
                    }
    
                }

            }

            //iterate from right to left ( if not return false)    ( if open bracket is greater than this string is not balanced) 
            int close = 0;
            if(check!=false){

                for(int i=s.length()-1; i>=0; i--){

                    if(s.charAt(i)==')' || locked.charAt(i)=='0'){
                        close++;
                    }
                    else{

                        if(close>0){
                            close--;
                        }
                        else{
                            check = false;
                            break;
                        }
                    }
                }
            }

            System.out.println(check);

            */


        /*(34). Remove All Occurrences of a substring */

            /*(i). with using string */

            /* 
            String s = "daabcbaabcbc";
            String part = "abc";
            StringBuilder result = new StringBuilder("");

            for(int i=0; i<s.length(); i++){

                result.append( s.charAt(i));

                if( result.length() >= part.length() && result.substring( result.length() - part.length()).equals(part)){
                 
                       result.delete( result.length()-part.length(), result.length());
                }
                
            }


            System.out.println(result);

            */

            


    }    
}    
    