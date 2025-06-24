/*JavaBasics*/
/*
public class JavaBasics {
    public static void main(String[] args) {
      System.out.println("Hello, World!");
      System.out.print("Hello, World!");
      System.out.print("Hello, World");
      System.out.print("Hello, World!\n");
      System.out.println("Hello, World");
      
      int a=10;
      int b=55;
      System.out.println("a");
      System.out.println(a);
      System.out.println(b);
      
      String name="Tony Stark";
      System.out.println(name);
      
      b=a;
      System.out.println(a);
      System.out.println(b);
      
  }
}
*/

/*JavaBasics , Variables,conversion And Datatypes*/
/*
public class JavaBasicVariablesAndDatatypes {
  public static void main(String args[]) {
    //byte b=8;
    //System.out.println(b);
    //char ch='a';
    //System.out.println(ch);
    //boolean vari = false;
    //float price = 13.6;
    //int number = 25;
    //long
    //double
    //short n=566;
    
    //--------(datatypes)--------
    
    // byte_1 byte_[-128 to 127]
    //short_2 byte_
    //char_2 byte_['hj','7','gjg7']
    //boolean_1 byte_[true,false]
    //int_4 byte_[-2billion to +2billion]
    //long_8 byte_
    //float_4 byte_
    //double_8 byte_
    
    //--------(take input)--------
    
    //Scanner scgagan = new Scanner(System.in);  
    
    //String inputgagan = scgagan.next();       //Behavior: Reads the next token (word) from the input. A token is delimited by whitespace (space, tab, or newline). Stops Reading: Stops at the first whitespace it encounters.
    //System.out.println(inputgagan);
    
    //String inpful=scgagan.nextLine();         //Behavior: Reads the entire line of input, including spaces, until a newline character is encountered. Stops Reading: Stops only when the user presses Enter.
    //System.out.println(inpful);
    
    //int num = scgagan.nextInt();
    //System.out.println(num);
    
    //float price = scgagan.nextFloat();
    //System.out.println(price);
    
    //--------(take input types)--------
    
    //next
    //nextLine
    //nextInt
    //nextByte
    //nextFloat
    //nextDouble
    //nextBoolean
    //nextShort
    //nextLong
  
    //--------(datatypes Example)--------
    
    //multiply two numbers
    
    //Scanner sca = new Scanner(System.in);
    //int a = sca.nextInt();
    //int b = sca.nextInt();
    //int product;
    //product=a*b;
    //System.out.println(product);
    
    //Area of circle
    
    //float rad = sca.nextFloat();
    //float area;
    //area = 3.14f * rad * rad;
    //System.out.println(area);
    
    //--------(Type Conversion)--------
    
    //Conversion happens when:
    //a.type compatible
    //b.destination type > source type
    
    //byte->short->int->float->long->double
    
    //int a= 25;
    //long b=a;
    //no error
    
    //long a=78;
    //int b=a;
    // give error
    
    //Scanner s = new Scanner(System.in);
    
    //float flot = s.nextFloat();
    //give no error
    
    //int num = s.nextFloat();
    //give error
    
    
    
  }
}
*/

/*conditional statements */
/*
public class conditional{
  public static void main(String args[]){
    
    //--------(if-else if-else)--------
    //find age 
    
    int b=17;
    if(b>=18) {
      System.out.println("adult");
    }
    else if(13<=b && 18>b){
      System.out.println("teenager");
    }
    else{
      System.out.println("child");
    }
    
    //number odd or even
    
    Scanner s= new Scanner(System.in);
    int num = s.nextInt();
    
    if(num%2==0){
      System.out.println("even number");
    }
    else{
      System.out.println("odd number");
    }
    
    //--------(ternary Operator)--------
    
    String name = (54>65)?"physics":"mathematics";
    System.out.println(name);
    
    int number=56;
    String type = (number%2==0)?"even":"odd";
    System.out.println(type);
    
    //--------(switch case)--------
    
    int n=3;
    switch(n) {
      case 1:System.out.println("first number");
      break;
      case 2:System.out.println("second number");
      break;
      case 3:System.out.println("third number");
      break;
      default:System.out.println("I am default");
      
    }
    char c = 'B';
    switch(c) {
      case 'A':System.out.println("first number");
      break;
      case 'B':System.out.println("second number");
      break;
      case 'C':System.out.println("third number");
      break;
      default:System.out.println("I am default");
      
    }
    
    //Example on switch case to make a calculator
    
    int oa = s.nextInt();
    int ob = s.nextInt();
    char op = s.next().charAt(0);
    switch(op) {
      case '+' : System.out.println(oa+ob);
      break;
      case '-' : System.out.println(oa-ob);
      break;
      case '*' : System.out.println(oa*ob);
      break;
      case '/' : System.out.println(oa/ob);
      break;
      default : System.out.println("operation not occur");
      break;
    }
    
  }
}
*/

/*loops*/
/*
public class loops{
  public static void main(String[] args){
    
    //Questions on loops
    
    //find sum of n natural numbers
    Scanner sr = new Scanner(System.in );
    int n = sr.nextInt();
    int tsum=0;
    for(int i=1;i<=n;i++){
      tsum = tsum+i;
    }
    System.out.println(tsum);
    
    //reverse of a number
    
    int num = 123456;
    int rnum=0;
    while(num>0){
      rnum = rnum + num%10;
        if (10>num){
        break;
      }
      rnum = rnum*10;
      num = num/10;
    }
    System.out.println(rnum);
    
  //keep entering numbers till the number multiple of 10
  
  do{
    int tennum= sr.nextInt();
    if(tennum%10==0){
      break;
    }
    System.out.println(tennum);
  }while(true);
    
    
    
  }
}
*/

/* Take Input in java:-*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class loops{
  public static void main(String[] args){
  
    /*(i). first way(Scanner) :- */
    /* 
    Scanner sc = new Scanner( System.in);
    System.out.print("Enter no. of n ");
    int n = sc.nextInt();
    int[] arr = new int[n];

    System.out.println();


    int curr=0;
    for(int i=0; i<n; i++){
     
      System.out.println("Enter the value of " + (i+1)+ " : " ); 
      arr[i] = sc.nextInt();
      curr = curr+ arr[i];
    }

    System.out.println("the total sum is "+curr);

    */

    /*(ii). second way(System.in.read()) :- */
    /* 
    try{
    
    System.out.print("Enter no. of n ");
    int n = System.in.read();
    System.out.println(n);


 
  }
  catch(Exception err){
    System.out.println(err);
  }

  */

  /*(iii). third way(BufferReader) :- */


  try{

  
  BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
  
  System.out.println("Enter input: ");
  int num = Integer.parseInt( br.readLine());
  System.out.println(num);

  br.close();

  }
  catch(Exception err){
    System.out.println(err);
  }


  /*(iv). fourth way( Scanner) :- */

  //Scanner scgagan = new Scanner(System.in);  
    
    //String inputgagan = scgagan.next();       //Behavior: Reads the next token (word) from the input. A token is delimited by whitespace (space, tab, or newline). Stops Reading: Stops at the first whitespace it encounters.
    //System.out.println(inputgagan);
    
    //String inpful=scgagan.nextLine();         //Behavior: Reads the entire line of input, including spaces, until a newline character is encountered. Stops Reading: Stops only when the user presses Enter.
    //System.out.println(inpful);
    
    //int num = scgagan.nextInt();
    //System.out.println(num);
    
    //float price = scgagan.nextFloat();
    //System.out.println(price);
    
    //--------(take input types)--------
    
    //next
    //nextLine
    //nextInt
    //nextByte
    //nextFloat
    //nextDouble
    //nextBoolean
    //nextShort
    //nextLong

  


    


    
  }
}





