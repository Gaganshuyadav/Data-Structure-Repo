package BinaryTrees;

import java.util.ArrayList;

public class BinarySearchTreesPart1B {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {

        if(root==null){
            root = new Node(val);
            return root;
        }

        if( val < root.data ){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        } 

        return root;
    }

    public static boolean search(Node root, int key){

        if(root==null){
            return false;
        }

        if(key==root.data){
            return true;
        }

        if( key < root.data){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }

    public static void inOrderTraversal(Node root){

        if(root==null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(Node root){
        
        if(root==null){
            return;
        }
        
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static Node delete( Node root, int val){

        if( val < root.data  ){
            root.left = delete(root.left, val);
        }
        else if( val > root.data){
            root.right = delete(root.right, val);
        }
        else{
            //case 1: leaf node ( no children)
            if(root.left==null && root.right==null){
                return null;
            }

            //case 2:  single child
            else if( root.left == null){
                return root.right;
            }
            else if( root.right == null){
                return root.left;
            }
            else{
                //case 3: have two children
                Node IS = findInOrderSuccessor( root.right);
                root.data = IS.data;
                delete(root.left, IS.data);
            }

        }
        
        return root;
    }

    public static Node InOrderSuccessor(Node root){

        while(root.left!=null){
            root = root.left;
        }

        return root;
    }

    public static Node findInOrderSuccessor(Node root){

        while(root.left!=null){
            root = root.left;
        }

        return root;
    }


    public static void printAllRootToLeafPaths(Node root, ArrayList<Integer> arr){

        if(root==null){
            return;
        }

        arr.add(root.data);

        if(root.left==null && root.right==null){

            for(int i=0; i<arr.size(); i++){
                System.out.print(arr.get(i)+" -> ");
            }
            System.out.print("null");
            System.out.println();
            
        }
        
            printAllRootToLeafPaths(root.left, arr);
            printAllRootToLeafPaths(root.right, arr);
            arr.remove(arr.size()-1);
        
    }

    public static void rootToLeafPaths(Node root){

        ArrayList<Integer> arr = new ArrayList<>();
        printAllRootToLeafPaths( root, arr);

    }

    public static void printInRange(Node root, int k1, int k2){

        if(root==null){
            return;
        }

        if( k1 <=root.data  && root.data <= k2){

            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);

        }
        else if( k1 > root.data){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
        
    }

    public static boolean isValidBST(Node root, Node min, Node max){

        if(root==null){
            return true;
        }

        if( min!=null && root.data<=min.data){
            return false;
        }

        if( max!=null && max.data<= root.data){
            return false;
        }

        return isValidBST( root.left, min, root) && isValidBST( root.right, root, max);
    }

    public static Node mirror(Node root){

        if(root==null){
            return null;
        }

        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static Node sortedArrayToBalancedBST(int arr[], int st, int end){

        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node( arr[mid]);
        root.left = sortedArrayToBalancedBST( arr, st, mid-1);
        root.right = sortedArrayToBalancedBST( arr, mid+1, end);

        return root;

    }
    
    public static void convertBSTtoInOrderSequence(Node root, ArrayList<Integer> bstInOrder){

        if(root==null){
            return;
        }

        convertBSTtoInOrderSequence(root.left, bstInOrder);
        bstInOrder.add(root.data);
        convertBSTtoInOrderSequence(root.right, bstInOrder);
    }
    public static Node sortedALtoBalancedBST(ArrayList<Integer> bstInOrder, int st, int end){

        if(st>end){
            return null;
        }

        int mid = ( st+end)/2;
        Node root = new Node( bstInOrder.get(mid) );
        root.left = sortedALtoBalancedBST(bstInOrder, st, mid-1);
        root.right = sortedALtoBalancedBST(bstInOrder, mid+1, end);

        return root;
        
    }
    public static Node convertBSTtoBalancedBST(Node root){

        ArrayList<Integer> bstInOrder = new ArrayList<>();

        convertBSTtoInOrderSequence(root, bstInOrder);

        return sortedALtoBalancedBST(bstInOrder, 0, bstInOrder.size()-1);

    }
    
    static class SizeOfLargestBST_Info{
        boolean isBST;
        int size;
        int min;
        int max;

        SizeOfLargestBST_Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxSizeForLargestBST = 0;

    public static SizeOfLargestBST_Info sizeOfLargestBST(Node root){

        if(root==null){
            return new SizeOfLargestBST_Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        SizeOfLargestBST_Info leftInfo = sizeOfLargestBST(root.left);
        SizeOfLargestBST_Info rightInfo = sizeOfLargestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int max = Math.max( root.data , Math.max( leftInfo.max, rightInfo.max) );
        int min = Math.min( root.data , Math.min( leftInfo.min, rightInfo.min) );

        if( leftInfo.max > root.data || rightInfo.min < root.data ){
            return new SizeOfLargestBST_Info(false, size, min, max);
        }

        if( leftInfo.isBST && rightInfo.isBST){
            maxSizeForLargestBST = Math.max(maxSizeForLargestBST, size);
            return new SizeOfLargestBST_Info(true, size, min, max);
        }

        return new SizeOfLargestBST_Info(false, size, min, max);


    }

    public static Node merge2BST(Node root1, Node root2){

        ArrayList<Integer> firstBST = new ArrayList<>();
        ArrayList<Integer> secondBST = new ArrayList<>();
        convertBSTtoInOrderSequence( root1, firstBST);
        convertBSTtoInOrderSequence( root2, secondBST);

        int i=0;
        int j=0;
        ArrayList<Integer> mergedBST = new ArrayList<>();

        while( i<firstBST.size() && j<secondBST.size()){

            if( firstBST.get(i) <= secondBST.get(j)){
                mergedBST.add(firstBST.get(i));
                i++;
            }
            else{
                mergedBST.add(secondBST.get(j));
                j++;
            }
        }

        while(i<firstBST.size()){
            mergedBST.add(firstBST.get(i));
            i++;
        }

        while(j<secondBST.size()){
            mergedBST.add(secondBST.get(j));
            j++;
        }

        
        return sortedALtoBalancedBST(mergedBST, 0, mergedBST.size()-1);

    }
    public static void main(String[] args) {
    

        /*(1). Build BST */ 
        
        // int values[] = { 5, 1, 3, 32, 42, 2, 15, 19, 7, 10};
        int values[] = { 8, 4, 2, 1, 3, 6, 5, 7, 9, 10, 11, 12, 13, 43, 22, 56};
        // int values[] = { 8, 3, 1, 6, 4, 7, 10, 14, 13};
        // int values[] = { 8, 5, 3, 1, 6 , 4 , 10, 11, 14};
        // int values[] = { 8, 6, 5, 3, 10, 11, 12};
        Node root = null;


        for(int i=0; i<values.length; i++){
            root = insert( root, values[i]);
        }

        /*(2). InOrder Traversal for BST  */

        /*
        inOrderTraversal(root);
        */

        /*(3). Search in BST  */
        /* 
        if(search(root, 42)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");
        }
        */

       /*(4). Delete in BST  */
        
       /* 
       inOrderTraversal(root);
       System.out.println();

       delete(root, 10);

       inOrderTraversal(root);
       System.out.println();
       */

       /*(5). Root to Leaf Paths in BST  */
       /*
       rootToLeafPaths(root); 
        */
       
       /*(6). Print in Range */
       /*
        printInRange(root, 5, 12);
        */
       
       /*(7). is Valid BST */

       /* 
       if(isValidBST(root, null, null)){
            System.out.println("it is valid BST");
       }
       else{
            System.out.println("it is not valid BST");
       }

       */

       /*(8). Mirror of BST O(n) */

       /* 
       mirror(root);
       */
   
       /*(9). Sorted array to Balanced BST ( Create Minimum length BST) ( O(n))*/

       /* 
       int arr[] = { 3, 5, 6, 8, 10, 11, 12};
       Node  root1 = sortedArrayToBalancedBST(arr, 0, arr.length-1);
       preOrderTraversal(root1);
       */

       /*(10). Convert BST to Balanced BST ( O(n))*/

       /* 
       Node root1 = convertBSTtoBalancedBST(root);
       preOrderTraversal(root1);
       */

       /*(11). find the size of largest BST in BT ( O(n))*/

       /* 

       //test case
       Node newRoot = new Node(50);
       newRoot.left = new Node(30);
       newRoot.left.left = new Node(5);
       newRoot.left.right = new Node(20);
       newRoot.right = new Node(60);
       newRoot.right.left = new Node(45);
       newRoot.right.right = new Node(70);
       newRoot.right.right.left = new Node(65);
       newRoot.right.right.right = new Node(80);

       sizeOfLargestBST(newRoot);
       
       System.out.println("the size of largest BST in BT is "+maxSizeForLargestBST);

       */
    
       /*(12). Merge 2 BSTs to Balanced BST*/

       Node root1 = new Node(2);
       root1.left = new Node(1);
       root1.right = new Node(4);

       Node root2 = new Node(9);
       root2.left = new Node(3);
       root2.right = new Node(12);

       Node newRoot = merge2BST(root1, root2);
       inOrderTraversal(newRoot);
       



    }
}
